package hu.ak_akademia.atos.db.entity;

import java.util.Arrays;

public class ProfilePicture {

	private final Long pictureId;
	private final String description;
	private final byte[] imageContent;
	private final String username;

	private ProfilePicture(Builder builder) {
		this.pictureId = builder.pictureId;
		this.description = builder.description;
		this.imageContent = builder.imageContent;
		this.username = builder.username;
	}

	public Long getPictureId() {
		return pictureId;
	}

	public String getDescription() {
		return description;
	}

	public byte[] getImageContent() {
		return imageContent;
	}

	public String getUsername() {
		return username;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long pictureId;
		private String description;
		private byte[] imageContent;
		private String username;

		private Builder() {
		}

		public Builder withPictureId(Long pictureId) {
			this.pictureId = pictureId;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withImageContent(byte[] imageContent) {
			this.imageContent = imageContent;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public ProfilePicture build() {
			return new ProfilePicture(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("ProfilePicture [pictureId=");
		builder2.append(pictureId);
		builder2.append(", description=");
		builder2.append(description);
		builder2.append(", imageContent=");
		builder2.append(Arrays.toString(imageContent));
		builder2.append(", username=");
		builder2.append(username);
		builder2.append("]");
		return builder2.toString();
	}

}