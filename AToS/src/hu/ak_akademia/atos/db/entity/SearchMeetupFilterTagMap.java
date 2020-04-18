package hu.ak_akademia.atos.db.entity;

public class SearchMeetupFilterTagMap {
	
	
	private final Long searchMeetupFilterTagMapId;
	private final Long searchMeetupFilterId;
	private final Long tagId;
	
	private SearchMeetupFilterTagMap(Builder builder) {
		this.searchMeetupFilterTagMapId = builder.searchMeetupFilterTagMapId;
		this.searchMeetupFilterId = builder.searchMeetupFilterId;
		this.tagId = builder.tagId;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private Long searchMeetupFilterTagMapId;
		private Long searchMeetupFilterId;
		private Long tagId;

		private Builder() {
		}

		public Builder withSearchMeetupFilterTagMapId(Long searchMeetupFilterTagMapId) {
			this.searchMeetupFilterTagMapId = searchMeetupFilterTagMapId;
			return this;
		}

		public Builder withSearchMeetupFilterId(Long searchMeetupFilterId) {
			this.searchMeetupFilterId = searchMeetupFilterId;
			return this;
		}

		public Builder withTagId(Long tagId) {
			this.tagId = tagId;
			return this;
		}

		public SearchMeetupFilterTagMap build() {
			return new SearchMeetupFilterTagMap(this);
		}
	}
	
	
}

