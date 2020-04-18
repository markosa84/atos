package hu.ak_akademia.atos.db.entity;

import java.time.LocalDateTime;

public class Meetup {

	private final Long meetupId;
	private final String username;
	private final Long interestId;
	private final String name;
	private final String description;
	private final Boolean online;
	private final Long cityId;
	private final String location;
	private final LocalDateTime dateAndTime;
	private final Double duration;
	private final Integer participantLimit;

	private Meetup(Builder builder) {
		this.meetupId = builder.meetupId;
		this.username = builder.username;
		this.interestId = builder.interestId;
		this.name = builder.name;
		this.description = builder.description;
		this.online = builder.online;
		this.cityId = builder.cityId;
		this.location = builder.location;
		this.dateAndTime = builder.dateAndTime;
		this.duration = builder.duration;
		this.participantLimit = builder.participantLimit;
	}

	public Long getMeetupId() {
		return meetupId;
	}

	public String getUsername() {
		return username;
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

	public Boolean getOnline() {
		return online;
	}

	public Long getCityId() {
		return cityId;
	}

	public String getLocation() {
		return location;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public Double getDuration() {
		return duration;
	}

	public Integer getParticipantLimit() {
		return participantLimit;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long meetupId;
		private String username;
		private Long interestId;
		private String name;
		private String description;
		private Boolean online;
		private Long cityId;
		private String location;
		private LocalDateTime dateAndTime;
		private Double duration;
		private Integer participantLimit;

		private Builder() {
		}

		public Builder withMeetupId(Long meetupId) {
			this.meetupId = meetupId;
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

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withOnline(Boolean online) {
			this.online = online;
			return this;
		}

		public Builder withCityId(Long cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withLocation(String location) {
			this.location = location;
			return this;
		}

		public Builder withDateAndTime(LocalDateTime dateAndTime) {
			this.dateAndTime = dateAndTime;
			return this;
		}

		public Builder withDuration(Double duration) {
			this.duration = duration;
			return this;
		}

		public Builder withParticipantLimit(Integer participantLimit) {
			this.participantLimit = participantLimit;
			return this;
		}

		public Meetup build() {
			return new Meetup(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Meetup [meetupId=");
		builder2.append(meetupId);
		builder2.append(", username=");
		builder2.append(username);
		builder2.append(", interestId=");
		builder2.append(interestId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", description=");
		builder2.append(description);
		builder2.append(", online=");
		builder2.append(online);
		builder2.append(", cityId=");
		builder2.append(cityId);
		builder2.append(", location=");
		builder2.append(location);
		builder2.append(", dateAndTime=");
		builder2.append(dateAndTime);
		builder2.append(", duration=");
		builder2.append(duration);
		builder2.append(", participantLimit=");
		builder2.append(participantLimit);
		builder2.append("]");
		return builder2.toString();
	}

}