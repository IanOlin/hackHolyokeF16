\c eightbyte m;

DROP SCHEMA IF EXISTS test CASCADE;

CREATE SCHEMA test AUTHORIZATION m;

SET search_path TO test;

CREATE TABLE soundbyte
(
	id serial PRIMARY KEY,
	uri text,
	ext text
);
