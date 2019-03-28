
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
VALUES ('sam@gmail.com',false, '$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu', '1234567899',5,'sam'),
       ('james@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','2345678999',5,'james'),
       ('nathaniel@gmail.com',false,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','2345678999',5,'nathaniel'),
       ('admin@gmail.com',true,'$2a$10$jBnR8Hx2QCT77PzEnTLlxOOeNyWxhFNPIW89WKVAQYmkPkC2TVbtu','3456789999',5,'admin');

INSERT into books (author, isbn, synopsis, title, wear, image_url)

VALUES ("Harper Lee", "0060935464", "o Kill a Mockingbird takes place in the fictional town of Maycomb, Alabama, during the Great Depression. The protagonist is Jean Louise (“Scout”) Finch, an intelligent though unconventional girl who ages from six to nine years old during the course of the novel. She is raised with her brother, Jeremy Atticus (“Jem”), by their widowed father, Atticus Finch. He is a prominent lawyer who encourages his children to be empathetic and just. He notably tells them that it is “a sin to kill a mockingbird,” alluding to the fact that the birds are innocent and harmless.", "To Kill A Mocking Bird", 3, "https://covers.openlibrary.org/b/id/8410894-L.jpg"),

       ("Madeleine L''Engle", "0374386137",
        "Meg Murry and her little brother, Charles Wallace, have been without their scientist father, Mr. Murry, for five years, ever since he discovered a new planet and used the concept known as a tesseract to travel there. Joined by Meg''s classmate Calvin O''Keefe and guided by the three mysterious astral travelers known as Mrs. Whatsit, Mrs. Who and Mrs. Which, the children brave a dangerous journey to a planet that possesses all of the evil in the universe.", "A Wrinkle in Time", 2, "https://covers.openlibrary.org/b/id/7883940-L.jpg"),

       ("George Orwell", "0679417397",
        "A man loses his identity while living under a repressive regime. In a story based on George Orwell''s classic novel, Winston Smith (John
        Hurt) is a government employee whose job involves the rewriting of history in a manner that casts his fictional country''s leaders in a charitable light. His trysts with Julia (Suzanna Hamilton) provide his only measure of enjoyment, but lawmakers frown on the relationship -- and in this closely monitored society, there is no escape from Big Brother.", "Nineteen eighty-four", 4, "https://covers.openlibrary.org/b/id/417615-L.jpg"),

       ("John Steinbeck", "0140177396", "Of Mice and Men is a novella written by author John Steinbeck. Published in 1937, it tells the story of George Milton and Lennie Small, two displaced migrant ranch workers, who move from place to place in California in search of new job opportunities during the Great Depression in the United States.", "Of Mice and Men", 1, "https://covers.openlibrary.org/b/id/96845-L.jpg"),

       ("Yann Martel", "9780156027328",
        "First published in 2002, Martel''s breathtaking breakout novel became an international bestseller and went on to win the Man Booker Prize,
         and was also named Amazon.com''s Best Book of 2002. In 2005, after an international competition, Croatian artist Tomislav Torjanac was selected to illustrate a special edition of Life of Pi that features 40 stunning illustrations that present a new perspective on this modern classic. --Brad Thomas Parsons ", "Life of Pi : a novel", 3, "https://covers.openlibrary.org/b/id/8082619-L.jpg");


insert into ads (ad_title, description, price, shipping, tradable, user_id, pending)
VALUES
("Looking to trade", "I am interested in trading my copy of To Kill A mockingbird",8.99 ,2.78, true,1,true),
("Trade Please!", "I have had this book for too long, someone take it off my hands.",4.99 ,6.78, true,1,true),
("Interested in trading", "This is a George Orwell classic, one of my favorites.",9.99 ,3.78, true,1,true),
("Anyone want this?", "Found this really old book in my attic, I'm looking for life of pi if anyone has it?",10.99 ,3.78, true,1,true);

insert into ads_books (ad_id, book_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4,4);
