package hu.ak_akademia.atos.db.entity;

public class MeetUpTagMap {

	private final Long meetupTagMapId;
	private final Long meetupId;
	private final String tagId;
	private MeetUpTagMap(Builder builder) {
		this.meetupTagMapId = builder.meetupTagMapId;
		this.meetupId = builder.meetupId;
		this.tagId = builder.tagId;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private Long meetupTagMapId;
		private Long meetupId;
		private String tagId;

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

		public Long getMeetupTagMapId() {
			return meetupTagMapId;
		}


		public void setMeetupTagMapId(Long meetupTagMapId) {
			this.meetupTagMapId = meetupTagMapId;
		}

		public Long getMeetupId() {
			return meetupId;
		}

		public void setMeetupId(Long meetupId) {
			this.meetupId = meetupId;
		}

		public String getTagId() {
			return tagId;
		}

		public void setTagId(String tagId) {
			this.tagId = tagId;
		}

		public Builder withTagId(String tagId) {
			this.tagId = tagId;
			return this;
		}

		public MeetUpTagMap build() {
			return new MeetUpTagMap(this);
		}
	}

	@Override
	public String toString() {
		return "Builder [meetupTagMapId=" + meetupTagMapId + ", meetupId=" + meetupId + ", tagId=" + tagId + "]";
	}
}
