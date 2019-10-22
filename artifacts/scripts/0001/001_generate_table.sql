-- Generate table

CREATE TABLE IF NOT EXISTS game (
	id int4 NOT NULL,
	name varchar(255) NOT NULL,
	platform varchar(255) NULL,
	genre varchar(255) NOT NULL,
	erscheinungsdatum date NULL,
	CONSTRAINT game_pk PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS genre (
	id int4 NOT NULL,
	art varchar(255) NOT NULL,
	CONSTRAINT genre_pk PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS platform (
	id int4 NOT NULL,
	name varchar NOT NULL,
	CONSTRAINT platform_pk PRIMARY KEY (id)
);
