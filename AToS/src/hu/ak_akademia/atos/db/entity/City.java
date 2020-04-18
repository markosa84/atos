package hu.ak_akademia.atos.db.entity;

public class City {

	private final Long cityId;
	private final Long countryId;
	private final String name;

	private City(Builder builder) {
		this.cityId = builder.cityId;
		this.countryId = builder.countryId;
		this.name = builder.name;
	}

	public Long getCityId() {
		return cityId;
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
		private Long cityId;
		private Long countryId;
		private String name;

		private Builder() {
		}

		public Builder withCityId(Long cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withCountryId(Long countryId) {
			this.countryId = countryId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public City build() {
			return new City(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("City [cityId=");
		builder2.append(cityId);
		builder2.append(", countryId=");
		builder2.append(countryId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append("]");
		return builder2.toString();
	}

}