
USE elibs_db;
SET FOREIGN_KEY_CHECKS = 0;
truncate genres_books;
truncate ads_books;
truncate genres;
truncate users;
truncate books;
truncate ads;
truncate addresses;
truncate trade_requests;
truncate transactions;
SET FOREIGN_KEY_CHECKS = 1;
INSERT into users (email, is_admin, password, phone, rating, username)
VALUES ('fancyreader117@gmail.com',false, '$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu', '',0,'fancyreader117'),
       ('mike@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'mike'),
       ('admin@adm.in',true,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'admin'),
       ('comicmeister@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'comicmeister'),
       ('harrypotterfan@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','',0,'hp_fan');

INSERT into books (author, isbn, synopsis, title, wear, image_url)
VALUES ("Zhizhong Cai", "0385472579", "", "Zen speaks", 3, "/images/bookexample.jpeg"),
       ("Wallace B. McClure ... [et al.].", "9780470112830", "", "Beginning asp.net 2.0 AJAX", 4.4, "/images/bookexample.jpeg"),
       ("Patrick Koetter, Ralf Hildebrandt", "9781593270018", "", "The Book of Postfix", 2, "/images/bookexample.jpeg"),
       ("Dave Taylor, James C. Armstrong, Jr.", "0672314800", "", "Sams teach yourself UNIX in 24 hours", 1, ""),
       ("John R. Levine, Margaret Levine Young, Carol Baroudi", "0764589962", "", "The Internet For Dummies (Internet for Dummies)", 3, ""),
       ("Jeanie Daniel Duck", "0609808818", "", "The change monster", 2, "");

insert into ads (price, shipping, tradable, user_id)
VALUES (14.99, 5.67, false, 1),
       (12.25, 0.0, true, 1),
       (28.00, 0.0, false, 2),
       (25.30, 9.40, true, 4),
       (7.99, 4.33, false, 2),
       (4.83, 12.6, false, 4),
       (44.44, 5.00, true, 5);

insert into ads_books (ad_id, book_id)
VALUES (1, 1),
       (1, 2),
       (2, 4),
       (3, 1),
       (3, 6),
       (4, 5),
       (5, 2),
       (5, 6),
       (6, 2),
       (7, 5),
       (7, 6);
