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
	private final LocalDateTime date_and_time_to;
	private final LocalDateTime duration_from;
	private final LocalDateTime duration_to;
	private final Long participant_limit_from;
	private final Long participant_limit_to;
	private SearchMeetupFilter(Builder builder) {
		this.searchMeetupFilterId = builder.searchMeetupFilterId;
		this.interestId = builder.interestId;
		this.displayName = builder.displayName;
		this.description = builder.description;
		this.online = builder.online;
		this.cityId = builder.cityId;
		this.location = builder.location;
		this.dateAndTimeFrom = builder.dateAndTimeFrom;
		this.date_and_time_to = builder.date_and_time_to;
		this.duration_from = builder.duration_from;
		this.duration_to = builder.duration_to;
		this.participant_limit_from = builder.participant_limit_from;
		this.participant_limit_to = builder.participant_limit_to;
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
		private LocalDateTime date_and_time_to;
		private LocalDateTime duration_from;
		private LocalDateTime duration_to;
		private Long participant_limit_from;
		private Long participant_limit_to;

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

		public Builder withDate_and_time_to(LocalDateTime date_and_time_to) {
			this.date_and_time_to = date_and_time_to;
			return this;
		}

		public Builder withDuration_from(LocalDateTime duration_from) {
			this.duration_from = duration_from;
			return this;
		}

		public Builder withDuration_to(LocalDateTime duration_to) {
			this.duration_to = duration_to;
			return this;
		}

		public Builder withParticipant_limit_from(Long participant_limit_from) {
			this.participant_limit_from = participant_limit_from;
			return this;
		}

		public Builder withParticipant_limit_to(Long participant_limit_to) {
			this.participant_limit_to = participant_limit_to;
			return this;
		}

		public SearchMeetupFilter build() {
			return new SearchMeetupFilter(this);
		}
	}

	

}
	