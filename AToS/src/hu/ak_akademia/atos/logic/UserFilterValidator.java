package hu.ak_akademia.atos.logic;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import hu.ak_akademia.atos.AtosRuntimeException;
import hu.ak_akademia.atos.db.dao.SearchUserFilterDao;
import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter.SelectAllByIdSearchUserFilterPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.searchuserfilter.SelectAllSearchUserFilterResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter.SelectAllByIdSearchUserFilterSqlBuilder;

public class UserFilterValidator {

	private LengthValidator lengthValidator = new LengthValidator();

	public String getPreviousValues(String filterName, String interestIdAsString, String cityIdAsString, String genderIdAsString, String ageFromAsString, String ageToAsString) {
		try {
			StringJoiner joiner = new StringJoiner("&");
			joiner.add("filterName=" + URLEncoder.encode(filterName, "UTF-8"));
			joiner.add("interest=" + URLEncoder.encode(interestIdAsString, "UTF-8"));
			joiner.add("city=" + URLEncoder.encode(cityIdAsString, "UTF-8"));
			joiner.add("gender=" + URLEncoder.encode(genderIdAsString, "UTF-8"));
			joiner.add("ageFrom=" + URLEncoder.encode(ageFromAsString, "UTF-8"));
			joiner.add("ageTo=" + URLEncoder.encode(ageToAsString, "UTF-8"));
			return joiner.toString();
		} catch (UnsupportedEncodingException e) {
			throw new AtosRuntimeException("Unable to encode parameters.", e);
		}
	}

	public void validateFilterName(String filterName, Set<String> invalidFields) {
		if (filterName == null || filterName.trim()
				.isEmpty() || filterName.length() < 3 || filterName.length() > 100) {
			invalidFields.add("filterNameInvalid");
			return;
		}
		SearchUserFilterDao searchUserFilterDao = new SearchUserFilterDao();
		searchUserFilterDao.openConnection();
		List<SearchUserFilter> searchUserFilters = searchUserFilterDao.read(new SelectAllByIdSearchUserFilterSqlBuilder(), new SelectAllByIdSearchUserFilterPreparedStatementWriter(filterName), new SelectAllSearchUserFilterResultSetReader());
		searchUserFilterDao.closeConnection();
		if (!searchUserFilters.isEmpty()) {
			invalidFields.add("filterNameInvalid");
			return;
		}
	}

	private boolean isInvalidLength(String field) {
		return field == null || field.trim()
				.isEmpty();
	}

	private boolean isInvalidLength(String field, int maxLength) {
		return isInvalidLength(field) || field.length() > maxLength;
	}

	private boolean isInvalidLength(String field, int minLength, int maxLength) {
		return isInvalidLength(field, maxLength) || field.length() < minLength;
	}

	public void validateAgeFrom(String ageFromAsString, Set<String> invalidFields) {
		validateAge(ageFromAsString, invalidFields, "ageFromInvalid");
	}

	public void validateAgeTo(String ageToAsString, Set<String> invalidFields) {
		validateAge(ageToAsString, invalidFields, "ageToInvalid");
	}

	private void validateAge(String ageAsString, Set<String> invalidFields, String invalidFieldName) {
		if (lengthValidator.isInvalidLength(ageAsString)) {
			invalidFields.add(invalidFieldName);
			return;
		}
		long age = -1;
		try {
			age = Integer.parseInt(ageAsString);
		} catch (NumberFormatException e) {
			invalidFields.add(invalidFieldName);
			return;
		}
		if (age < 18 || age > 150) {
			invalidFields.add(invalidFieldName);
			return;
		}
	}

	public void validateAgeInterval(String ageFromAsString, String ageToAsString, Set<String> invalidFields) {
		long ageFrom = -1;
		long ageTo = -1;
		try {
			ageFrom = Integer.parseInt(ageFromAsString);
			ageTo = Integer.parseInt(ageToAsString);
		} catch (NumberFormatException e) {
			invalidFields.add("invalidAgeInterval");
			return;
		}
		if (ageFrom > ageTo) {
			invalidFields.add("invalidAgeInterval");
			return;
		}
	}

}