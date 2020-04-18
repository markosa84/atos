package hu.ak_akademia.atos.db.entity;

public class Tag {

	private final String tagId;

	private Tag(Builder builder) {
		this.tagId = builder.tagId;
	}

	public String getTagId() {
		return tagId;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String tagId;

		private Builder() {
		}

		public Builder withTagId(String tagId) {
			this.tagId = tagId;
			return this;
		}

		public Tag build() {
			return new Tag(this);
		}
	}

}
