package hu.ak_akademia.atos.db.entity;

public class MeetUpTagMap {

	private final Long meetupTagMapId;
	private final Long meetupId;
	private final String tag;

	private MeetUpTagMap(Builder builder) {
		this.meetupTagMapId = builder.meetupTagMapId;
		this.meetupId = builder.meetupId;
		this.tag = builder.tag;
	}

	public Long getMeetupTagMapId() {
		return meetupTagMapId;
	}

	public Long getMeetupId() {
		return meetupId;
	}

	public String getTag() {
		return tag;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long meetupTagMapId;
		private Long meetupId;
		private String tag;

		private Builder() {
		}

		public Builder withMeetupTagMapId(Long meetupTagMapId) {
			this.meetupTagMapId = meetupTagMapId;
			return this;
		}

		public Builder withMeetupId(Long meetupId) {
			this.meetupId = meetupId;
			return this;
		}

		public Builder withTag(String tag) {
			this.tag = tag;
			return this;
		}

		public MeetUpTagMap build() {
			return new MeetUpTagMap(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("MeetUpTagMap [meetupTagMapId=");
		builder2.append(meetupTagMapId);
		builder2.append(", meetupId=");
		builder2.append(meetupId);
		builder2.append(", tag=");
		builder2.append(tag);
		builder2.append("]");
		return builder2.toString();
	}

}