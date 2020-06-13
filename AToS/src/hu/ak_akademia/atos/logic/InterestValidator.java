package hu.ak_akademia.atos.logic;

import java.util.List;
import java.util.Set;

import hu.ak_akademia.atos.db.dao.InterestDao;
import hu.ak_akademia.atos.db.entity.Interest;
import hu.ak_akademia.atos.db.preparedstatementwriter.interests.SelectAllByIdInterestsPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.interests.SelectAllInterestsResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.interests.SelectAllByIdInterestsSqlBuilder;

public class InterestValidator {

	private LengthValidator lengthValidator = new LengthValidator();

	public void validateInterest(String interestIdAsString, Set<String> invalidFields) {
		if (lengthValidator.isInvalidLength(interestIdAsString)) {
			invalidFields.add("interestInvalid");
			return;
		}
		long interestId = -1;
		try {
			interestId = Long.parseLong(interestIdAsString);
		} catch (NumberFormatException e) {
			invalidFields.add("interestInvalid");
			return;
		}
		InterestDao interestDao = new InterestDao();
		interestDao.openConnection();
		List<Interest> interests = interestDao.read(new SelectAllByIdInterestsSqlBuilder(), new SelectAllByIdInterestsPreparedStatementWriter(interestId), new SelectAllInterestsResultSetReader());
		interestDao.closeConnection();
		if (interests.isEmpty()) {
			invalidFields.add("interestInvalid");
			return;
		}
	}

}