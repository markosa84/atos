package hu.ak_akademia.atos.logic;

import java.util.List;
import java.util.Set;

import hu.ak_akademia.atos.db.dao.GenderDao;
import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.preparedstatementwriter.gender.SelectAllByIdGenderPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.gender.SelectAllGenderResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.gender.SelectAllByIdGenderSqlBuilder;

public class GenderValidator {

	private LengthValidator lengthValidator = new LengthValidator();

	public void validateGender(String genderIdAsString, Set<String> invalidFields) {
		if (lengthValidator.isInvalidLength(genderIdAsString)) {
			invalidFields.add("genderInvalid");
			return;
		}
		long genderId = -1;
		try {
			genderId = Long.parseLong(genderIdAsString);
		} catch (NumberFormatException e) {
			invalidFields.add("genderInvalid");
			return;
		}
		GenderDao genderDao = new GenderDao();
		genderDao.openConnection();
		List<Gender> genders = genderDao.read(new SelectAllByIdGenderSqlBuilder(), new SelectAllByIdGenderPreparedStatementWriter(genderId), new SelectAllGenderResultSetReader());
		genderDao.closeConnection();
		if (genders.isEmpty()) {
			invalidFields.add("genderInvalid");
			return;
		}
	}

}