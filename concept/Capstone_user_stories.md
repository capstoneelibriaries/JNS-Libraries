# User Stories

###  Account Creation

0. A user navigates to the site.
1. A user clicks "create account".
2. The user is redirected to the account creation page:

    Username:   [_____]
    Email:      [_____]
    Phone:      [_____] *optional
    Password:   [_____]
    Confirm:    [_____]

3. The user fills out the form.
    3.A If the username, email, or phone already exists, the user is
        redirected to an error page.
4. The user is redirected to their account page.

### Book Posting

0. A user logs in.
1. The user clicks "list a book"
2. The is redirected to the list book form:

    ISBN:	[_____] after set interval make fetch request to api to retrieve information to populate title genre and author
    Title:          [_____]
    Genre:          [_____]
    Author:         [_____]
    Price:          [_____]
    Personal rating:[_____]
    Synopsis:       [_____] *optional
    Will trade for: [_____]

    2.A The book name is compared to a blacklist of innapropriate books.
3. The book is then listed.

### Book Post Deletion

0. A user logs in.
1. The user clicks on a link to their book listing.
2. The user selects "Delete"
3. The user is prompted with a message:

    "Are you sure you want to delete this listing?"
    [yes/no]

4. The user selects "yes"
    4.A The book listing is deleted if no one has purchased it.

### Book Post Editing

0. A user logs in.
1. The user clicks on a link to their book listing.
2. The user selects "Edit"
4. The user is redirected to the following form:

    Title:          [_____] *immutable
    Genere:         [_____] *immutable
    Author:         [_____] *immutable
    ISBN:	[_____] *immutable
    Price:          [_____]
    Personal rating:[_____]
    Synopsis:       [_____]
    Will trade for: [_____]

    [Save/Cancel]

5. The user selects "Save"
6. The book listing is updated

# Visitor/User Book Viewing

0. A visitor/user navigates to the site (landing page).
1. The page shows book listings of available books for sale and available to trade.
2. Visitor/user clicks on a book listing for sale and is shown details:

	Title, Genre, Author, Synopsis, Price, purchase button, Seller's information (username, rating, link to the seller's page)

	When the visitor clicks "Purchase" they will be directed to the purchase form where they will fill out information for paypal (the visitor doesn't need to log in) this form includes:
	Billing information
	Shipping information

	For visitors, the shipping information will be saved under a sudo account along with a valid email address for order confirmation.
	 This will allow the seller to contact the buyer and give them a place to ship to.

3. User clicks on a book listing for trade and is shown details:

	Title, Genre, Author, Synopsis, The book the Trader's want to trade, offer trade button, Trader's information (username, rating, link to the trader's page)

	When the visitor clicks offer trade they will be directed (to log in/register if not authenticated already) to the trade form fill out information on the book they are willing to trade similarly to the book posting form:

   ISBN:	[_____] after set interval make fetch request to api to retrieve information to populate title genre and author
    Title:          [_____]
    Genre:          [_____]
    Author:         [_____]

    [Confirm Offer/Cancel]


4. Visitor that is now a user can click "Confirm Offer"
5. after all forms are complete the transaction will be saved in the database for the seller/trader to view later to get the buyer's info to ship their book(s)
5b. If trading, the one who submitted the offer will receive the trader's shipping info in the form of a transaction on their user's page


# User transactions

0. From the profile page the user can view all his/her past transactions' information ( buying, selling or trading )

# Admin Creation

0. A rank 2 or 3 admin logs in
1. The admin selects "invite new admin" and is redirected to a form:

    Email:          [_____]
    
    [Send/Cancel]

    1.A An email is sent to the potential admin's email with an auto
    generated code.

2. The rank 2/3 admin logs out.
3. The potential admin receives the email and follows a link to an admin
    sign up page. There, they encounter a form:

    Please enter your invite code:  [_____]

    3.A If the invite code is valid, the admin is redirected to an account
    creation form:

        Username:   [_____]
        Email:      [_____]
        Password:   [_____]
        Confirm:    [_____]

    4. The admin is then created, with a rank of 1. Only rank 3 admins can
    alter the rank 1 and rank 2 admins.

# Admin Duties

0. A rank 1 admin logs in
1. They are directed to a feed of new ads.
3. Each ad has a [delete] button, which allows the admin to delete the ad.
