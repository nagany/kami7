
/* Drop Tables */

DROP TABLE IF EXISTS member_image;
DROP TABLE IF EXISTS rate;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS category;




/* Create Tables */

CREATE TABLE member
(
	member_id serial NOT NULL UNIQUE,
	member_name varchar NOT NULL,
	PRIMARY KEY (member_id)
) WITHOUT OIDS;


CREATE TABLE member_image
(
	image_id serial NOT NULL UNIQUE,
	member_id int,
	image_path varchar,
	PRIMARY KEY (image_id)
) WITHOUT OIDS;


CREATE TABLE category
(
	category_ID serial NOT NULL UNIQUE,
	category_name varchar,
	PRIMARY KEY (category_ID)
) WITHOUT OIDS;


CREATE TABLE rate
(
	member_id int NOT NULL,
	category_ID int NOT NULL,
	rate int,
	-- trueのものは対象外とする。
	delete_flag boolean,
	PRIMARY KEY (member_id, category_ID)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE member_image
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rate
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rate
	ADD FOREIGN KEY (category_ID)
	REFERENCES category (category_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON COLUMN rate.delete_flag IS 'trueのものは対象外とする。';



