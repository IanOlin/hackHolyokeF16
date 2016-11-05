\c eightbyte sam;

DROP SCHEMA IF EXISTS test CASCADE;

CREATE SCHEMA test AUTHORIZATION sam;

SET search_path TO test;

CREATE TABLE soundbite
(
	id serial NOT NULL,
	data bytea,
	ext text
);
