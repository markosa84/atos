package hu.ak_akademia.atos.db.entity;

import java.time.LocalDateTime;

public class Message {

	private final Long messageId;
	private final String usernameFrom;
	private final String usernameTo;
	private final LocalDateTime dateAndTime;
	private final String messageText;

	private Message(Builder builder) {
		this.messageId = builder.messageId;
		this.usernameFrom = builder.usernameFrom;
		this.usernameTo = builder.usernameTo;
		this.dateAndTime = builder.dateAndTime;
		this.messageText = builder.messageText;
	}

	public Long getMessageId() {
		return messageId;
	}

	public String getUsernameFrom() {
		return usernameFrom;
	}

	public String getUsernameTo() {
		return usernameTo;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public String getMessageText() {
		return messageText;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long messageId;
		private String usernameFrom;
		private String usernameTo;
		private LocalDateTime dateAndTime;
		private String messageText;

		private Builder() {
		}

		public Builder withMessageId(Long messageId) {
			this.messageId = messageId;
			return this;
		}

		public Builder withUsernameFrom(String usernameFrom) {
			this.usernameFrom = usernameFrom;
			return this;
		}

		public Builder withUsernameTo(String usernameTo) {
			this.usernameTo = usernameTo;
			return this;
		}

		public Builder withDateAndTime(LocalDateTime dateAndTime) {
			this.dateAndTime = dateAndTime;
			return this;
		}

		public Builder withMessageText(String messageText) {
			this.messageText = messageText;
			return this;
		}

		public Message build() {
			return new Message(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Message [messageId=");
		builder2.append(messageId);
		builder2.append(", usernameFrom=");
		builder2.append(usernameFrom);
		builder2.append(", usernameTo=");
		builder2.append(usernameTo);
		builder2.append(", dateAndTime=");
		builder2.append(dateAndTime);
		builder2.append(", messageText=");
		builder2.append(messageText);
		builder2.append("]");
		return builder2.toString();
	}

}