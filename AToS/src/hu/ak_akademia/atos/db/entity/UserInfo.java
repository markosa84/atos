package hu.ak_akademia.atos.db.entity;

import java.time.LocalDate;

public class UserInfo {

	private final String username;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String passwordHash;
	private final Long cityId;
	private final LocalDate dateOfBirth;
	private final Long genderId;
	private final Boolean showMeInSearch;
	private final Boolean showAllDetails;
	private final Boolean paid;

	private UserInfo(Builder builder) {
		this.username = builder.username;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.passwordHash = builder.passwordHash;
		this.cityId = builder.cityId;
		this.dateOfBirth = builder.dateOfBirth;
		this.genderId = builder.genderId;
		this.showMeInSearch = builder.showMeInSearch;
		this.showAllDetails = builder.showAllDetails;
		this.paid = builder.paid;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public Long getCityId() {
		return cityId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Long getGenderId() {
		return genderId;
	}

	public Boolean getShowMeInSearch() {
		return showMeInSearch;
	}

	public Boolean getShowAllDetails() {
		return showAllDetails;
	}

	public Boolean getPaid() {
		return paid;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String passwordHash;
		private Long cityId;
		private LocalDate dateOfBirth;
		private Long genderId;
		private Boolean showMeInSearch;
		private Boolean showAllDetails;
		private Boolean paid;

		private Builder() {
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}

		public Builder withCityId(Long cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withGenderId(Long genderId) {
			this.genderId = genderId;
			return this;
		}

		public Builder withShowMeInSearch(Boolean showMeInSearch) {
			this.showMeInSearch = showMeInSearch;
			return this;
		}

		public Builder withShowAllDetails(Boolean showAllDetails) {
			this.showAllDetails = showAllDetails;
			return this;
		}

		public Builder withPaid(Boolean paid) {
			this.paid = paid;
			return this;
		}

		public UserInfo build() {
			return new UserInfo(this);
		}
	}

}