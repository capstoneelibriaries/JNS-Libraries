-- The following script completely removes the database
-- by dropping all of its tables. This should only be
-- use for developers who are making changes to the models.
-- In some cases, there could be error because spring
-- is relying on existing tables, rather than generating
-- new ones.
USE elibs_db;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE addresses;
DROP TABLE ads;
DROP TABLE ads_books;
DROP TABLE books;
DROP TABLE genres;
DROP TABLE genres_books;
DROP TABLE trade_requests;
DROP TABLE transactions;
DROP TABLE users;

SET FOREIGN_KEY_CHECKS = 1;