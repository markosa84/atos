package hu.ak_akademia.atos.db.entity;

public class SearchMeetupFilterTagMap {

	private final Long searchMeetupFilterTagMapId;
	private final Long searchMeetupFilterId;
	private final String tag;

	private SearchMeetupFilterTagMap(Builder builder) {
		this.searchMeetupFilterTagMapId = builder.searchMeetupFilterTagMapId;
		this.searchMeetupFilterId = builder.searchMeetupFilterId;
		this.tag = builder.tag;
	}

	public Long getSearchMeetupFilterTagMapId() {
		return searchMeetupFilterTagMapId;
	}

	public Long getSearchMeetupFilterId() {
		return searchMeetupFilterId;
	}

	public String getTag() {
		return tag;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long searchMeetupFilterTagMapId;
		private Long searchMeetupFilterId;
		private String tag;

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

		public Builder withTag(String tag) {
			this.tag = tag;
			return this;
		}

		public SearchMeetupFilterTagMap build() {
			return new SearchMeetupFilterTagMap(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("SearchMeetupFilterTagMap [searchMeetupFilterTagMapId=");
		builder2.append(searchMeetupFilterTagMapId);
		builder2.append(", searchMeetupFilterId=");
		builder2.append(searchMeetupFilterId);
		builder2.append(", tag=");
		builder2.append(tag);
		builder2.append("]");
		return builder2.toString();
	}

}