package hu.ak_akademia.atos.db.entity;

public class MeetupUserMap {

	private final Long meetupUserMapId;
	private final Long meetupId;
	private final String username;

	private MeetupUserMap(Builder builder) {
		this.meetupUserMapId = builder.meetupUserMapId;
		this.meetupId = builder.meetupId;
		this.username = builder.username;
	}

	public Long getMeetupUserMapId() {
		return meetupUserMapId;
	}

	public Long getMeetupId() {
		return meetupId;
	}

	public String getUsername() {
		return username;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long meetupUserMapId;
		private Long meetupId;
		private String username;

		private Builder() {
		}

		public Builder withMeetupUserMapId(Long meetupUserMapId) {
			this.meetupUserMapId = meetupUserMapId;
			return this;
		}

		public Builder withMeetupId(Long meetupId) {
			this.meetupId = meetupId;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public MeetupUserMap build() {
			return new MeetupUserMap(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("MeetupUserMap [meetupUserMapId=");
		builder2.append(meetupUserMapId);
		builder2.append(", meetupId=");
		builder2.append(meetupId);
		builder2.append(", username=");
		builder2.append(username);
		builder2.append("]");
		return builder2.toString();
	}

}