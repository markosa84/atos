package hu.ak_akademia.atos.db.entity;

public class SearchUserFilter {

	private final Long searchUserFilterId;
	private final String displayName;
	private final Long interestId;
	private final Long cityId;
	private final Long genderId;
	private final int fromAge;
	private final int toAge;

	private SearchUserFilter(Builder builder) {
		this.searchUserFilterId = builder.searchUserFilterId;
		this.displayName = builder.displayName;
		this.interestId = builder.interestId;
		this.cityId = builder.cityId;
		this.genderId = builder.genderId;
		this.fromAge = builder.fromAge;
		this.toAge = builder.toAge;

	}

	public Long getSearchUserFilterId() {
		return searchUserFilterId;
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

	public int getFromAge() {
		return fromAge;
	}

	public int getToAge() {
		return toAge;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long searchUserFilterId;
		private String displayName;
		private Long interestId;
		private Long cityId;
		private Long genderId;
		private int fromAge;
		private int toAge;

		private Builder() {
		}

		public Builder withSearchUserFilterId(Long searchUserFilterId) {
			this.searchUserFilterId = searchUserFilterId;
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

		public Builder withFromAge(int fromAge) {
			this.fromAge = fromAge;
			return this;
		}

		public Builder withToAge(int toAge) {
			this.toAge = toAge;
			return this;
		}

		public SearchUserFilter build() {
			return new SearchUserFilter(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("SearchUserFilter [searchUserFilterId=");
		builder2.append(searchUserFilterId);
		builder2.append(", displayName=");
		builder2.append(displayName);
		builder2.append(", interestId=");
		builder2.append(interestId);
		builder2.append(", cityId=");
		builder2.append(cityId);
		builder2.append(", genderId=");
		builder2.append(genderId);
		builder2.append(", fromAge=");
		builder2.append(fromAge);
		builder2.append(", toAge=");
		builder2.append(toAge);
		builder2.append("]");
		return builder2.toString();
	}
	
	

}
