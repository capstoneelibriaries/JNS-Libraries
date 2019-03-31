
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

VALUES ("Harper Lee", "0060935464", "To Kill a Mockingbird takes place in the fictional town of Maycomb, Alabama, during the Great Depression. The
protagonist is Jean Louise (“Scout”) Finch, an intelligent though unconventional girl who ages from six to nine years old during the course of the novel. She is raised with her brother, Jeremy Atticus (“Jem”), by their widowed father, Atticus Finch. He is a prominent lawyer who encourages his children to be empathetic and just. He notably tells them that it is “a sin to kill a mockingbird,” alluding to the fact that the birds are innocent and harmless.", "To Kill A Mocking Bird", 3, "https://covers.openlibrary.org/b/id/8410894-L.jpg"),

       ("Madeleine L''Engle", "0374386137",
        "Meg Murry and her little brother, Charles Wallace, have been without their scientist father, Mr. Murry, for five years, ever since he discovered a new planet and used the concept known as a tesseract to travel there. Joined by Meg''s classmate Calvin O''Keefe and guided by the three mysterious astral travelers known as Mrs. Whatsit, Mrs. Who and Mrs. Which, the children brave a dangerous journey to a planet that possesses all of the evil in the universe.", "A Wrinkle in Time", 2, "https://covers.openlibrary.org/b/id/7883940-L.jpg"),

       ("George Orwell", "0679417397",
        "A man loses his identity while living under a repressive regime. In a story based on George Orwell''s classic novel, Winston Smith (John
        Hurt) is a government employee whose job involves the rewriting of history in a manner that casts his fictional country''s leaders in a charitable light. His trysts with Julia (Suzanna Hamilton) provide his only measure of enjoyment, but lawmakers frown on the relationship -- and in this closely monitored society, there is no escape from Big Brother.", "Nineteen eighty-four", 4, "https://covers.openlibrary.org/b/id/417615-L.jpg"),

       ("John Steinbeck", "0140177396", "Of Mice and Men is a novella written by author John Steinbeck. Published in 1937, it tells the story of George Milton and Lennie Small, two displaced migrant ranch workers, who move from place to place in California in search of new job opportunities during the Great Depression in the United States.", "Of Mice and Men", 1, "https://covers.openlibrary.org/b/id/96845-L.jpg"),

       ("Yann Martel", "9780156027328",
        "First published in 2002, Martel''s breathtaking breakout novel became an international bestseller and went on to win the Man Booker Prize,
         and was also named Amazon.com''s Best Book of 2002. In 2005, after an international competition, Croatian artist Tomislav Torjanac was
         selected to illustrate a special edition of Life of Pi that features 40 stunning illustrations that present a new perspective on this modern classic. --Brad Thomas Parsons ", "Life of Pi : a novel", 3, "https://covers.openlibrary.org/b/id/8082619-L.jpg"),

       ("Louise Maude","0199232768", "War and Peace broadly focuses on Napoleon’s invasion of Russia in 1812 and follows three of the most well-known characters in literature: Pierre Bezukhov, the illegitimate son of a count who is fighting for his inheritance and yearning for spiritual fulfillment; Prince Andrei Bolkonsky, who leaves his family behind to fight in the war against Napoleon; and Natasha Rostov, the beautiful young daughter of a nobleman who intrigues both men.
A s Napoleon’s army invades, Tolstoy brilliantly follows characters from diverse backgrounds—peasants and nobility, civilians and soldiers—as they struggle with the problems unique to their era, their history, and their culture. And as the novel progresses, these characters transcend their specificity, becoming some of the most moving—and human—figures in world literature." ,"War And Peace", 2 ,"https://covers.openlibrary.org/b/id/7663083-L.jpg"),

       ("Jon Krakauer","9780679428503","Christopher McCandless (Emile Hirsch), son of wealthy parents (Marcia Gay Harden, William Hurt), graduates
       from Emory University as a top student and athlete. However, instead of embarking on a prestigious and profitable career, he chooses to give
        his savings to charity, rid himself of his possessions, and set out on a journey to the Alaskan wilderness.","Into The Wild", 5, "https://covers.openlibrary.org/b/id/417895-L.jpg"),

       ("S. E. Hinton","9780140385724", "According to Ponyboy, there are two kinds of people in the world: greasers and socs. A soc (short for
       social) has money, can get away with just about anything, and has an attitude longer than a limousine. A greaser, on the other hand, always
       lives on the outside and needs to watch his back. Ponyboy is a greaser, and he''s always been proud of it, even willing to rumble against a
       gang of socs for the sake of his fellow greasers--until one terrible night when his friend Johnny kills a soc. The murder gets under
       Ponyboy''s skin, causing his bifurcated world to crumble and teaching him that pain feels the same whether a soc or a greaser. This classic,
        written by S. E. Hinton when she was 16 years old, is as profound today as it was when it was first published in 1967.","The Outsiders", 4,
        "https://covers.openlibrary.org/b/id/8351719-L.jpg"),

       ("J. K. Rowling","0439708184",
        "Harry Potter has no idea how famous he is. That''s because he''s being raised by his miserable aunt and uncle who are terrified Harry will learn that he''s really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright. From the surprising way he is greeted by a lovable giant, to the unique curriculum and colorful faculty at his unusual school, Harry finds himself drawn deep inside a mystical world he never knew existed and closer to his own noble destiny.",
        "Harry Potter and the Sorcerer''s Stone", 4, "https://covers.openlibrary.org/b/id/8345853-L.jpg"),

       ("J. K. Rowling","9780439064873", "The Dursleys were so mean that hideous that summer that all Harry Potter wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he''s packing his bags, Harry receives a warning from a strange, impish creature named Dobby who says that if Harry Potter returns to Hogwarts, disaster will strike.
And strike it does. For in Harry''s second year at Hogwarts, fresh torments and horrors arise, including an outrageously stuck-up new professor,
Gilderoy Lockheart, a spirit named Moaning Myrtle who haunts the girls'' bathroom, and the unwanted attentions of Ron Weasley''s younger sister, Ginny.But each of these seem minor annoyances when the real trouble begins, and someone--or something--starts turning Hogwarts students to stone. Could it be Draco Malfoy, a more poisonous rival than ever? Could it possibly be Hagrid, whose mysterious past is finally told? Or could it be the one everyone at Hogwarts most suspects...Harry Potter himself?","Harry Potter and the Chamber of Secrets", 3, "https://covers.openlibrary.org/b/id/8081272-L.jpg"),

       ("J. K. Rowling","0439136369","For twelve long years, the dread fortress of Azkaban held an infamous prisoner named Sirius Black. Convicted
       of killing thirteen people with a single curse, he was said to be the heir apparent to the Dark Lord, Voldemort.","Harry Potter and the Prisoner of Azkaban", 3, "https://covers.openlibrary.org/b/id/8465072-L.jpg"),

       ("J. K. Rowling","0439358078",
        "In his fifth year at Hogwart's, Harry faces challenges at every turn, from the dark threat of He-Who-Must-Not-Be-Named and the
        unreliability of the government of the magical world to the rise of Ron Weasley as the keeper of the Gryffindor Quidditch Team. Along the way he learns about the strength of his friends, the fierceness of his enemies, and the meaning of sacrifice.","Harry Potter and the Order of the Phoenix", 1, "https://covers.openlibrary.org/b/id/8253767-L.jpg"),

       ("Delia Owens", "0735219095", "Kya is known in her town as the 'Marsh Girl.' She grows up in a shack out in the marshes bordering a small village on the coast of North Carolina. Her mother and her four older siblings all leave to get away from their abusive father, leaving her behind to fend for herself.", "Where the Crawdads Sing", 3, "https://covers.openlibrary.org/b/id/8362947-L.jpg"),

       ("Michelle Obama", "1524763136", "Becoming is the memoir of former United States First Lady Michelle Obama published in 2018. Described by the author as a deeply personal experience, the book talks about her roots and how she found her voice, as well as her time in the White House, her public health campaign, and her role as a mother", "Becoming", 3, "https://covers.openlibrary.org/b/id/8260534-L.jpg"),

       ("Bessel van der Kolk, M.D", "0143127748", "Essential reading for anyone interested in understanding and treating traumatic stress and the scope of its impact on society", "The Body Keeps Score", 3, "https://covers.openlibrary.org/b/id/8315367-L.jpg"),

       ("Ray Bradbury", "1451673264", "Guy Montag is a fireman. In his world, where television rules and literature is on the brink of extinction, firemen start fires rather than put them out. His job is to destroy the most illegal of commodities, the printed book, along with the houses in which they are hidden.
Montag never questions the destruction and ruin his actions produce, returning each day to his bland life and wife, Mildred, who spends all day with her television “family.” But then he meets an eccentric young neighbor, Clarisse, who introduces him to a past where people didn’t live in fear and to a present where one sees the world through the ideas in books instead of the mindless chatter of television.
When Mildred attempts suicide and Clarisse suddenly disappears, Montag begins to question everything he has ever known. He starts hiding books in his home, and when his pilfering is discovered, the fireman has to run for his life.", "Fahrenheit 451", 3, "https://covers.openlibrary.org/b/id/8461186-L.jpg"),

       ("George Orwell", "0030554349",
        "Animal Farm, written by George Orwell, is an allegorical story about the Soviet Union's early years. At the beginning of the story, Old Major inspires his fellow farm animals to revolt against their human master, Mr. Jones, owner of Manor Farm. Leaders of the animal revolt include two pigs, Napoleon and Snowball", "Animal Farm", 3, "https://covers.openlibrary.org/b/id/4937526-L.jpg"),

       ("Albert Camus", "0679420266",
        "The Stranger Summary. The Stranger, written by Albert Camus is a fictional novel set in Algiers in the early 1940''s. The first-person narrator, Mr. Meursault, describes his life in a memoir-like fashion beginning the day after his mother died.", "The Stranger", 3, "https://covers.openlibrary.org/b/id/417680-L.jpg"),

       ("Joseph Heller", "0679437223", "Catch-22 Summary. Captain John Yossarian, a World War II bombardier, is stationed on the island of Pianosa.
        He is an individualist who seeks to protect his own life by fleeing to the hospital, since a catch-22 in the Air Force regulations prevents him from being grounded for illness or obtaining a leave", "Catch 22", 3, "https://covers.openlibrary.org/b/id/7877422-L.jpg"),

       ("William Golding", "0812416112", "Lord of the Flies Summary. During an unnamed time of war, a plane carrying a group of British schoolboys is shot down over the Pacific. The pilot of the plane is killed, but many of the boys survive the crash and find themselves deserted on an uninhabited island, where they are alone without adult supervision.", "Lord of the flies", 3, "https://covers.openlibrary.org/b/id/5120811-L.jpg"),

       ("Mark Twain", "0486400778", "Summary of the Plot. Tom Sawyer is a young boy living with his Aunt Polly on the banks of the Mississippi River. He seems to most enjoy getting into trouble. After missing school one day (and getting into a fight), Tom is punished with the task of whitewashing a fence.", "The adventures of Tom Sawyer", 3, "https://covers.openlibrary.org/b/id/312413-L.jpg"),

       ("Johann David Wyss", "0141325305", "A Swiss family must survive being shipwrecked on a deserted island. A family in route to New Guinea is shipwrecked on a deserted tropical island. They are forced to remain on the island because of the damage to the ship and the pirates that are roaming the islands.", "The Swiss Family Robinson", 3, "https://covers.openlibrary.org/b/id/6460037-L.jpg");


insert into ads (ad_title, description, price, shipping, tradable, user_id, pending)
VALUES
("Looking to trade", "I am interested in trading my copy of To Kill A mockingbird",8.99 ,2.78, true,1,true),

("Trade Please!", "I have had this book for too long, someone take it off my hands.",4.99 ,6.78, true,1,true),

("Interested in trading", "These are classics, some of my favorites.",9.99 ,3.78, true,1,true),

("Hello! Trade please!", "In search of an older copy of sherlock holmes, would be interested in trading more than one book for it.",9.99 ,5.78,
 true,2,true),

("Looking for: to Kill A Mocking bird", "I have this older book and I would like to trade it for an older book",18.99 ,2.78, true,2,
 true),

("Help", "I have all these books and no one to trade with.",8.89 ,1.78, true,2,true),

("Desperate for a trade", "Found this really old book in my attic, I'm looking for the original copy of spider-man if anyone has it?",10.99 ,3.78,
 true,3,true),

("Can anyone help?", "Found this really old book in my attic, I'm looking for life of pi if anyone has it?",7.99 ,1.38, true,3,true),

("Willing to trade 2 for 1", "Found this really old book in my attic, I'm looking for Of Mice and Men if anyone has it?",9.99 ,4.68, true,3,true),

("Lost", "I lost my favorite book two weeks ago, and I would love to trade some of my older books for the same book if anyone has a copy of The
Internet For Dummies",33.99 ,6.72, true,1,true),

("Don't want to trade, change my mind", "I have all these really nice old books but I'm not convinced I should trade them with anyone. Send me a
trade request if you have anything good",1.99 ,3.27, true,1,true);

insert into ads_books (ad_id, book_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4,4),
       (5,5),
       (6,6),
       (7,7),
       (8,8),
       (9,9),
       (10,10),
       (11,11),
       (1,12),
       (2,13),
       (3,14),
       (4,15),
       (5,16),
       (6,17),
       (7,18),
       (8,19),
       (9,20),
       (10,21),
       (11,22);