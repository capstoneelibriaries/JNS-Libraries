
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

insert into ads (ad_title, description, price, shipping, tradable, user_id)
VALUES ("Ipsum dolor", "Morbi dictum dui diam, ut luctus quam commodo sed. Morbi in porta lectus. Integer dapibus justo est.", 14.99, 5.67, true, 1),
       ("Lorem dolor", "Suspendisse fringilla sollicitudin arcu. Aenean egestas justo lacus, sit amet pretium neque ullamcorper eget. In in metus commodo, dapibus turpis in, ultrices tortor. Proin sodales at libero malesuada imperdiet.", 12.25, 0.0, true, 1),
       ("Mercator in foro", "Nullam et arcu lorem. Aenean sed orci dui. Suspendisse id enim eget massa ullamcorper aliquet. Aliquam vehicula tellus eu nisl semper porta. Sed a dolor nec lacus dapibus egestas. Proin lobortis congue maximus.", 28.00, 0.0, true, 2),
       ("Laborat", "Maecenas consectetur sed nunc pharetra varius. Ut imperdiet libero metus, sit amet rutrum mi egestas at. Ut et tortor vel nisl imperdiet dapibus varius ut ex. Suspendisse eu ligula enim. Phasellus rhoncus porta risus, sit amet lacinia leo maximus eu. Vivamus interdum.", 25.30, 9.40, true, 4),
       ("Morbi at lacus lorem", "Ut eget elit sed sapien malesuada tincidunt. Etiam maximus ligula vitae mauris varius, ut fringilla sem congue. Mauris et hendrerit est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum at volutpat ligula. Orci varius natoque penatibus.", 7.99, 4.33, true, 2),
       ("Nam id ex neque", "Quisque in lobortis dui. In sollicitudin augue et neque vehicula venenatis. Quisque eros lorem, fermentum aliquet arcu sit amet, dapibus dignissim nulla. Cras ultrices odio massa, a ullamcorper ligula fringilla non. Integer sed congue mauris. Aenean vitae lectus metus. Pellentesque euismod interdum.", 4.83, 12.6, true, 4),
       ("Curabitur imperdiet", "Curabitur maximus consequat efficitur. Praesent consequat faucibus diam sed blandit. In placerat urna dolor, vel aliquam odio blandit eget. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec vel varius justo. Nullam vel leo arcu. Duis at tortor et ante.", 44.44, 5.00, true, 5);

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
