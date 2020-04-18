package hu.ak_akademia.atos.db.entity;

public class Tag {

	private final String tag;

	private Tag(Builder builder) {
		this.tag = builder.tag;
	}

	public String getTag() {
		return tag;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String tag;

		private Builder() {
		}

		public Builder withTag(String tag) {
			this.tag = tag;
			return this;
		}

		public Tag build() {
			return new Tag(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Tag [tag=");
		builder2.append(tag);
		builder2.append("]");
		return builder2.toString();
	}

}