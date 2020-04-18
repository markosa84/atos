package hu.ak_akademia.atos.db.entity;

public class Gender {

	private final Long genderId;
	private final String name;

	private Gender(Builder builder) {
		this.genderId = builder.genderId;
		this.name = builder.name;
	}

	public Long getGenderId() {
		return genderId;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long genderId;
		private String name;

		private Builder() {
		}

		public Builder withGenderId(Long genderId) {
			this.genderId = genderId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Gender build() {
			return new Gender(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Gender [genderId=");
		builder2.append(genderId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append("]");
		return builder2.toString();
	}

}