package hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class DeleteByIdSearchUserFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "DELETE FROM search_user_filter WHERE search_user_filter_id = ?";
	}

}
