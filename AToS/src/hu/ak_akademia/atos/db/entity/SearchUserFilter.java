package hu.ak_akademia.atos.db.entity;

public class SearchUserFilter {

	private final Long searchUserFilterId;
	private final String username;
	private final String displayName;
	private final Long interestId;
	private final Long cityId;
	private final Long genderId;
	private final Integer ageFrom;
	private final Integer ageTo;

	private SearchUserFilter(Builder builder) {
		this.searchUserFilterId = builder.searchUserFilterId;
		this.username = builder.username;
		this.displayName = builder.displayName;
		this.interestId = builder.interestId;
		this.cityId = builder.cityId;
		this.genderId = builder.genderId;
		this.ageFrom = builder.ageFrom;
		this.ageTo = builder.ageTo;
	}

	public Long getSearchUserFilterId() {
		return searchUserFilterId;
	}

	public String getUsername() {
		return username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Long getInterestId() {
		return interestId;
	}

	public Long getCityId() {
		return cityId;
	}

	public Long getGenderId() {
		return genderId;
	}

	public Integer getAgeFrom() {
		return ageFrom;
	}

	public Integer getAgeTo() {
		return ageTo;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long searchUserFilterId;
		private String username;
		private String displayName;
		private Long interestId;
		private Long cityId;
		private Long genderId;
		private Integer ageFrom;
		private Integer ageTo;

		private Builder() {
		}

		public Builder withSearchUserFilterId(Long searchUserFilterId) {
			this.searchUserFilterId = searchUserFilterId;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public Builder withInterestId(Long interestId) {
			this.interestId = interestId;
			return this;
		}

		public Builder withCityId(Long cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withGenderId(Long genderId) {
			this.genderId = genderId;
			return this;
		}

		public Builder withAgeFrom(Integer ageFrom) {
			this.ageFrom = ageFrom;
			return this;
		}

		public Builder withAgeTo(Integer ageTo) {
			this.ageTo = ageTo;
			return this;
		}

		public SearchUserFilter build() {
			return new SearchUserFilter(this);
		}
	}

}