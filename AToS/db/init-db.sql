-- drop everything
DROP SEQUENCE IF EXISTS search_meetup_filter_tag_map_seq;
DROP SEQUENCE IF EXISTS search_meetup_filter_seq;
DROP SEQUENCE IF EXISTS search_user_filter_seq;
DROP SEQUENCE IF EXISTS picture_seq;
DROP SEQUENCE IF EXISTS message_seq;
DROP SEQUENCE IF EXISTS meetup_tag_map_seq;
DROP SEQUENCE IF EXISTS meetup_seq;
DROP SEQUENCE IF EXISTS user_interest_map_seq;
DROP SEQUENCE IF EXISTS interest_seq;
DROP SEQUENCE IF EXISTS city_seq;
DROP SEQUENCE IF EXISTS country_seq;
DROP SEQUENCE IF EXISTS gender_seq;
DROP TABLE IF EXISTS search_meetup_filter_tag_map;
DROP TABLE IF EXISTS search_meetup_filter;
DROP TABLE IF EXISTS search_user_filter;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS meetup_tag_map;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS meetup;
DROP TABLE IF EXISTS user_interest_map;
DROP TABLE IF EXISTS interests;
DROP TABLE IF EXISTS profile_picture;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS gender;

-- gender
CREATE SEQUENCE gender_seq;
CREATE TABLE gender (
	gender_id BIGINT NOT NULL,
	name VARCHAR(50) NOT NULL,
	CONSTRAINT gender_pk PRIMARY KEY (gender_id)
);

-- country
CREATE SEQUENCE country_seq;
CREATE TABLE country (
	country_id BIGINT NOT NULL,
	name VARCHAR(100) NOT NULL,
	CONSTRAINT country_pk PRIMARY KEY (country_id)
);

-- city
CREATE SEQUENCE city_seq;
CREATE TABLE city (
	city_id BIGINT NOT NULL,
	country_id BIGINT NOT NULL,
	name VARCHAR(100) NOT NULL,
	CONSTRAINT city_pk PRIMARY KEY (city_id),
	CONSTRAINT city_fk1 FOREIGN KEY (country_id) REFERENCES country(country_id)
);

-- user_info
CREATE TABLE user_info (
	username VARCHAR(20) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	password_hash VARCHAR(100) NOT NULL,
	city_id BIGINT NOT NULL,
	date_of_birth DATE NOT NULL,
	gender_id BIGINT NOT NULL,
	show_me_in_search BOOLEAN NOT NULL,
	show_all_details BOOLEAN NOT NULL,
	paid BOOLEAN NOT NULL,
	CONSTRAINT user_info_pk PRIMARY KEY (username),
	CONSTRAINT user_info_fk1 FOREIGN KEY (city_id) REFERENCES city(city_id),
	CONSTRAINT user_info_fk2 FOREIGN KEY (gender_id) REFERENCES gender(gender_id)
);

-- profile_picture
CREATE SEQUENCE picture_seq;
CREATE TABLE profile_picture (
	picture_id BIGINT NOT NULL,
	description VARCHAR(500),
	image_content BYTEA NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT profile_picture_pk PRIMARY KEY (picture_id),
	CONSTRAINT profile_picture_fk1 FOREIGN KEY (username) REFERENCES user_info(username)
);

-- interests
CREATE SEQUENCE interest_seq;
CREATE TABLE interests (
	interest_id BIGINT NOT NULL,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	CONSTRAINT interests_pk PRIMARY KEY (interest_id)
);

-- user_interest_map
CREATE SEQUENCE user_interest_map_seq;
CREATE TABLE user_interest_map (
	user_interest_map_id BIGINT NOT NULL,
	username VARCHAR(20) NOT NULL,
	interest_id BIGINT NOT NULL,
	CONSTRAINT user_interest_map_pk PRIMARY KEY (user_interest_map_id),
	CONSTRAINT user_interest_map_fk1 FOREIGN KEY (username) REFERENCES user_info(username),
	CONSTRAINT user_interest_map_fk2 FOREIGN KEY (interest_id) REFERENCES interests(interest_id)
);

-- meetup
CREATE SEQUENCE meetup_seq;
CREATE TABLE meetup (
	meetup_id BIGINT NOT NULL,
	username VARCHAR(20) NOT NULL,
	interest_id BIGINT NOT NULL,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	online BOOLEAN,
	city_id BIGINT,
	location VARCHAR(100),
	date_and_time TIMESTAMP NOT NULL,
	duration NUMERIC(5, 1),
	participant_limit INTEGER,
	CONSTRAINT meetup_pk PRIMARY KEY (meetup_id),
	CONSTRAINT meetup_fk1 FOREIGN KEY (username) REFERENCES user_info(username),
	CONSTRAINT meetup_fk2 FOREIGN KEY (interest_id) REFERENCES interests(interest_id),
	CONSTRAINT meetup_fk3 FOREIGN KEY (city_id) REFERENCES city(city_id)
);

-- tag
CREATE TABLE tag (
	tag_id VARCHAR(30) NOT NULL,
	CONSTRAINT tag_pk PRIMARY KEY (tag_id)
);

-- meetup_tag_map
CREATE SEQUENCE meetup_tag_map_seq;
CREATE TABLE meetup_tag_map (
	meetup_tag_map_id BIGINT NOT NULL,
	meetup_id BIGINT NOT NULL,
	tag_id VARCHAR(30) NOT NULL,
	CONSTRAINT meetup_tag_map_pk PRIMARY KEY (meetup_tag_map_id),
	CONSTRAINT meetup_tag_map_fk1 FOREIGN KEY (meetup_id) REFERENCES meetup(meetup_id),
	CONSTRAINT meetup_tag_map_fk2 FOREIGN KEY (tag_id) REFERENCES tag(tag_id)
);

-- message
CREATE SEQUENCE message_seq;
CREATE TABLE message (
	message_id BIGINT NOT NULL,
	username_from VARCHAR(20) NOT NULL,
	username_to VARCHAR(20) NOT NULL,
	date_and_time TIMESTAMP NOT NULL,
	message_text TEXT NOT NULL,
	CONSTRAINT message_pk PRIMARY KEY (message_id),
	CONSTRAINT message_fk1 FOREIGN KEY (username_from) REFERENCES user_info(username),
	CONSTRAINT message_fk2 FOREIGN KEY (username_to) REFERENCES user_info(username)
);

-- search_user_filter
CREATE SEQUENCE search_user_filter_seq;
CREATE TABLE search_user_filter (
	search_user_filter_id BIGINT NOT NULL,
	display_name VARCHAR(100) NOT NULL,
	interest_id BIGINT NOT NULL,
	city_id BIGINT NOT NULL,
	gender_id BIGINT,
	from_age INTEGER,
	to_age INTEGER,
	CONSTRAINT search_user_filter_pk PRIMARY KEY (search_user_filter_id),
	CONSTRAINT search_user_filter_fk1 FOREIGN KEY (interest_id) REFERENCES interests(interest_id),
	CONSTRAINT search_user_filter_fk2 FOREIGN KEY (city_id) REFERENCES city(city_id),
	CONSTRAINT search_user_filter_fk3 FOREIGN KEY (gender_id) REFERENCES gender(gender_id)
);

-- search_meetup_filter
CREATE SEQUENCE search_meetup_filter_seq;
CREATE TABLE search_meetup_filter (
	search_meetup_filter_id BIGINT NOT NULL,
	interest_id BIGINT NOT NULL,
	display_name VARCHAR(50) NOT NULL,
	description TEXT,
	online BOOLEAN,
	city_id BIGINT,
	location VARCHAR(100),
	date_and_time_from TIMESTAMP,
	date_and_time_to TIMESTAMP,
	duration_from NUMERIC(5, 1),
	duration_to NUMERIC(5, 1),
	participant_limit_from INTEGER,
	participant_limit_to INTEGER,
	CONSTRAINT search_meetup_filter_pk PRIMARY KEY (search_meetup_filter_id),
	CONSTRAINT search_meetup_filter_fk1 FOREIGN KEY (interest_id) REFERENCES interests(interest_id),
	CONSTRAINT search_meetup_filter_fk2 FOREIGN KEY (city_id) REFERENCES city(city_id)
);

-- search_meetup_filter_tag_map
CREATE SEQUENCE search_meetup_filter_tag_map_seq;
CREATE TABLE search_meetup_filter_tag_map (
	search_meetup_filter_tag_map_id BIGINT NOT NULL,
	search_meetup_filter_id BIGINT NOT NULL,
	tag_id VARCHAR(30) NOT NULL,
	CONSTRAINT search_meetup_filter_tag_map_pk PRIMARY KEY (search_meetup_filter_tag_map_id),
	CONSTRAINT search_meetup_filter_tag_map_fk1 FOREIGN KEY (search_meetup_filter_id) REFERENCES search_meetup_filter(search_meetup_filter_id),
	CONSTRAINT search_meetup_filter_tag_map_fk2 FOREIGN KEY (tag_id) REFERENCES tag(tag_id)
);
