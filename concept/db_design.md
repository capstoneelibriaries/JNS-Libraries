# Books

[A] id
    isbn
    title
    author
    synopsis
    condition

# Genres

[B] id
    name

# Genres-Books

[C] genre-id    -> [B]
[D] book-id     -> [A]

# Ad

[E] id
    price
    shipping
    tradable

# Ads-Books

[F] ad-id       -> [E]
[G] book-id     -> [A]
    for-sale

# Trades

[Q] id
[H] sale-ad-id  -> [F]
[I] wanted-ad-id-> [F]

# Users

[J] id
    username
    email
    password
    phone
    rating

# Address

[R] id
    type (1=billing, 2=shipping, 3=billing and shipping)
    address1
    address2
    country
    city
    state
    zipcode

# Users-Addresses
    user-id     -> [J]
    address-id  -> [R]

# Users-Books

[K] book-id     -> [A]
[L] user-id     -> [J]

# Users-Ads

[M] user-id     -> [J]
[N] ad-id       -> [E]

# Admins

[O] id
    username
    email
    password
    rank

# Deleted-Ads

[U] id
    flagged-id  -> [T]
    admin-id    -> [O]

# Transaction

[P] id
    ad-id       -> [E]
    seller-id   -> [J]
    buyer-id    -> [J] or Anon
    trade-id    -> [Q]


