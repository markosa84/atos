package hu.ak_akademia.atos.db.entity;

import java.time.LocalDateTime;

public class SearchMeetupFilter {

	private final Long searchMeetupFilterId;
	private final Long interestId;
	private final String displayName;
	private final String description;
	private final Boolean online;
	private final Long cityId;
	private final String location;
	private final LocalDateTime dateAndTimeFrom;
	private final LocalDateTime dateAndTimeTo;
	private final Double durationFrom;
	private final Double durationTo;
	private final Integer participantLimitFrom;
	private final Integer participantLimitTo;

	private SearchMeetupFilter(Builder builder) {
		this.searchMeetupFilterId = builder.searchMeetupFilterId;
		this.interestId = builder.interestId;
		this.displayName = builder.displayName;
		this.description = builder.description;
		this.online = builder.online;
		this.cityId = builder.cityId;
		this.location = builder.location;
		this.dateAndTimeFrom = builder.dateAndTimeFrom;
		this.dateAndTimeTo = builder.dateAndTimeTo;
		this.durationFrom = builder.durationFrom;
		this.durationTo = builder.durationTo;
		this.participantLimitFrom = builder.participantLimitFrom;
		this.participantLimitTo = builder.participantLimitTo;
	}

	public Long getSearchMeetupFilterId() {
		return searchMeetupFilterId;
	}

	public Long getInterestId() {
		return interestId;
	}

	public String getDisplayName() {
		return displayName;
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

	public LocalDateTime getDateAndTimeFrom() {
		return dateAndTimeFrom;
	}

	public LocalDateTime getDateAndTimeTo() {
		return dateAndTimeTo;
	}

	public Double getDurationFrom() {
		return durationFrom;
	}

	public Double getDurationTo() {
		return durationTo;
	}

	public Integer getParticipantLimitFrom() {
		return participantLimitFrom;
	}

	public Integer getParticipantLimitTo() {
		return participantLimitTo;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long searchMeetupFilterId;
		private Long interestId;
		private String displayName;
		private String description;
		private Boolean online;
		private Long cityId;
		private String location;
		private LocalDateTime dateAndTimeFrom;
		private LocalDateTime dateAndTimeTo;
		private Double durationFrom;
		private Double durationTo;
		private Integer participantLimitFrom;
		private Integer participantLimitTo;

		private Builder() {
		}

		public Builder withSearchMeetupFilterId(Long searchMeetupFilterId) {
			this.searchMeetupFilterId = searchMeetupFilterId;
			return this;
		}

		public Builder withInterestId(Long interestId) {
			this.interestId = interestId;
			return this;
		}

		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
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

		public Builder withDateAndTimeFrom(LocalDateTime dateAndTimeFrom) {
			this.dateAndTimeFrom = dateAndTimeFrom;
			return this;
		}

		public Builder withDateAndTimeTo(LocalDateTime dateAndTimeTo) {
			this.dateAndTimeTo = dateAndTimeTo;
			return this;
		}

		public Builder withDurationFrom(Double durationFrom) {
			this.durationFrom = durationFrom;
			return this;
		}

		public Builder withDurationTo(Double durationTo) {
			this.durationTo = durationTo;
			return this;
		}

		public Builder withParticipantLimitFrom(Integer participantLimitFrom) {
			this.participantLimitFrom = participantLimitFrom;
			return this;
		}

		public Builder withParticipantLimitTo(Integer participantLimitTo) {
			this.participantLimitTo = participantLimitTo;
			return this;
		}

		public SearchMeetupFilter build() {
			return new SearchMeetupFilter(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("SearchMeetupFilter [searchMeetupFilterId=");
		builder2.append(searchMeetupFilterId);
		builder2.append(", interestId=");
		builder2.append(interestId);
		builder2.append(", displayName=");
		builder2.append(displayName);
		builder2.append(", description=");
		builder2.append(description);
		builder2.append(", online=");
		builder2.append(online);
		builder2.append(", cityId=");
		builder2.append(cityId);
		builder2.append(", location=");
		builder2.append(location);
		builder2.append(", dateAndTimeFrom=");
		builder2.append(dateAndTimeFrom);
		builder2.append(", dateAndTimeTo=");
		builder2.append(dateAndTimeTo);
		builder2.append(", durationFrom=");
		builder2.append(durationFrom);
		builder2.append(", durationTo=");
		builder2.append(durationTo);
		builder2.append(", participantLimitFrom=");
		builder2.append(participantLimitFrom);
		builder2.append(", participantLimitTo=");
		builder2.append(participantLimitTo);
		builder2.append("]");
		return builder2.toString();
	}

}