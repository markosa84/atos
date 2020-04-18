package hu.ak_akademia.atos.db.entity;

public class Country {

	private final Long countryId;
	private final String name;

	private Country(Builder builder) {
		this.countryId = builder.countryId;
		this.name = builder.name;
	}

	public Long getCountryId() {
		return countryId;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long countryId;
		private String name;

		private Builder() {
		}

		public Builder withCountryId(Long countryId) {
			this.countryId = countryId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Country build() {
			return new Country(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Country [countryId=");
		builder2.append(countryId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append("]");
		return builder2.toString();
	}

}