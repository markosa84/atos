package hu.ak_akademia.atos.db.sqlbuilder.userinterestmap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllUserInterestMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT user_interest_map_id, username, interest_id FROM user_interest_map";
	}

}