
USE elibs_db;
INSERT into users (email, is_admin, password, phone, rating, username)
VALUES ('fancyreader117@gmail.com',false, '$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu', '',0,'fancyreader117'),
       ('mike@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'mike'),
       ('admin@adm.in',true,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'admin'),
       ('comicmeister@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'comicmeister'),
       ('harrypotterfan@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'hp_fan');