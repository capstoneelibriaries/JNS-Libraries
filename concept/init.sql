-- Books
CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  isbn VARCHAR(32) NOT NULL,
  title VARCHAR(128) NOT NULL,
  author VARCHAR(128) NOT NULL,
  synopsis VARCHAR(1024),
  condition INT
);

-- Genres
CREATE TABLE genres (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(32)
);
-- Genres-Books
-- [C] genre-id    -> [B]
-- [D] book-id     -> [A]
CREATE TABLE genres_books (
  genre_id INT,
  book_id INT,
  FOREIGN KEY (genre_id) REFERENCES genres(id),
  FOREIGN KEY (book_id) REFERENCES books(id)
);
# Ad
# [E] id
#     price
#     shipping
#     tradable
CREATE TABLE ads (
  id INT AUTO_INCREMENT PRIMARY KEY,
  price DOUBLE,
  shipping DOUBLE,
  tradable BOOLEAN
);
# Ads-Books

# [F] ad-id       -> [E]
# [G] book-id     -> [A]
CREATE TABLE ads_books(
  ad_id INT,
  book_id INT,
  FOREIGN KEY (ad_id) REFERENCES ads(id),
  FOREIGN KEY (book_id) REFERENCES books(id)
);

# Trades

# [Q] id
# [H] sale-ad-id  -> [F]
# [I] wanted-ad-id-> [F]
CREATE TABLE trades (
  id INT AUTO_INCREMENT PRIMARY KEY,
  sale_ad_id INT,
  wanted_ad_id INT,
  FOREIGN KEY (sale_ad_id) REFERENCES ads(id),
  FOREIGN KEY (wanted_ad_id) REFERENCES ads(id)
);
# Users

# [J] id
#     username
#     email
#     password
#     phone
#     rating
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128),
  email VARCHAR(128),
  password VARCHAR(128),
  phone VARCHAR(16),
  rating DOUBLE
);

# Address

# [R] id
#     type (1=billing, 2=shipping, 3=billing and shipping)
#     address1
#     address2
#     country
#     city
#     state
#     zipcode
CREATE Table addresses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type INT,
  address1 VARCHAR(256),
  address2 VARCHAR(256),
  country VARCHAR(128),
  city VARCHAR(128),
  state VARCHAR(128),
  zipcode VARCHAR(16)
);
# Users-Addresses
#     user-id     -> [J]
#     address-id  -> [R]
CREATE TABLE users_addresses (
  user_id INT,
  address_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (address_id) REFERENCES addresses(id)
);
# Users-Books

# [K] book-id     -> [A]
# [L] user-id     -> [J]
CREATE TABLE users_books (
  book_id INT,
  user_id INT,
  FOREIGN KEY (book_id) REFERENCES books(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);
# Users-Ads

# [M] user-id     -> [J]
# [N] ad-id       -> [E]
CREATE TABLE users_ads (
  user_id INT,
  ad_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (ad_id) REFERENCES ad(id)
);
# Admins

# [O] id
#     username
#     email
#     password
CREATE TABLE admins (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128),
  email VARCHAR(128),
  password VARCHAR(128)
);
# Transaction

# [P] id
#     ad-id       -> [E]
#     seller-id   -> [J]
#     buyer-id    -> [J] or Anon
#     trade-id    -> [Q]
CREATE TABLE transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  ad_id INT ,
  seller_id INT,
  buyer_id INT,
  trade_id INT,
  FOREIGN KEY (seller_id) REFERENCES users(id),
  FOREIGN KEY (buyer_id) REFERENCES users(id),
  FOREIGN KEY (trade_id) REFERENCES trades(id)
);

