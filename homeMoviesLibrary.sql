DROP database IF EXISTS home_movie_collection;

CREATE database IF NOT EXISTS home_movie_collection;

use home_movie_collection;

DROP TABLE IF EXISTS movies;

CREATE TABLE movies(
	movie_id int(11) NOT NULL auto_increment PRIMARY KEY,
	title varchar(60) NOT NULL,
	director varchar(60),
	release_year int(4) DEFAULT 9999,
	rating varchar(5),
	genre varchar(25),
	length_in_mins int(4) DEFAULT 999
);

