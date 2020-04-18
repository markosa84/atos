package hu.ak_akademia.atos.db.entity;

public class UserInterestMap {

	private final Long userInterestMapId;
	private final String username;
	private final Long interestId;

	private UserInterestMap(Builder builder) {
		this.userInterestMapId = builder.userInterestMapId;
		this.username = builder.username;
		this.interestId = builder.interestId;
	}

	public Long getUserInterestMapId() {
		return userInterestMapId;
	}

	public String getUsername() {
		return username;
	}

	public Long getInterestId() {
		return interestId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long userInterestMapId;
		private String username;
		private Long interestId;

		private Builder() {
		}

		public Builder withUserInterestMapId(Long userInterestMapId) {
			this.userInterestMapId = userInterestMapId;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withInterestId(Long interestId) {
			this.interestId = interestId;
			return this;
		}

		public UserInterestMap build() {
			return new UserInterestMap(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("UserInterestMap [userInterestMapId=");
		builder2.append(userInterestMapId);
		builder2.append(", username=");
		builder2.append(username);
		builder2.append(", interestId=");
		builder2.append(interestId);
		builder2.append("]");
		return builder2.toString();
	}

}