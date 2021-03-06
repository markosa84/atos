package hu.ak_akademia.atos.db.entity;

public class Interest {

	private final Long interestId;
	private final String name;
	private final String description;

	private Interest(Builder builder) {
		this.interestId = builder.interestId;
		this.name = builder.name;
		this.description = builder.description;
	}

	public Long getInterestId() {
		return interestId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long interestId;
		private String name;
		private String description;

		private Builder() {
		}

		public Builder withInterestId(Long interestId) {
			this.interestId = interestId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Interest build() {
			return new Interest(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Interest [interestId=");
		builder2.append(interestId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", description=");
		builder2.append(description);
		builder2.append("]");
		return builder2.toString();
	}

}