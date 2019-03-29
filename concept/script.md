## Introduction
Good evening ladies and gentlemen, my name is Sam Rodriguez and joining me today are my partners, James Meyer, and Nathaniel Gumbs. Today we are 
going to present to you our application *E-Libraries*.

#### About

What e-libraries is, is an online book store that allows users to trade books from one user to another. This way, instead of going to your local 
bookstore or checking on amazon for the book you're looking for, you can hop on E-libraries to list your old unwanted books in exchange for the 
book you are looking for. Then, if anyone has your desired book, you can make a trade to satisfy both parties. 
#### Registration

We are now going to register as a new user under James, we used bootstrap for styling our page and the image you are seeing is being pulled in from
 up splash. Once all the fields in the form are properly filled out, you will be redirected to the login.
#### Logging In

We will now login as our new user, James. After filling out the login form information correctly, we will be redirected to the profile page.

#### Profile Page

Upon entering the profile page, you will see all the users book listings that have been created. As a user, you can click on each individual book 
to edit the information, or delete the listing all together, and now, my partner James Meyer will walk you through a few more features. 

<br>

## Creating New Ads and Searching

#### Listing a Book

Upon logging in, we are greeted by the profile page where our ads are listed. First, let's list a new ad. In order to do
this we'll need a title for the ad, a description, a value we believe our books are worth, a shipping value, and finally
a book. 

For the book itself, we only need to enter the ISBN. The reason for this is because I was able to automate the form
creation by writing an autofill feature in JavaScript. The Javascript performs an AJAX request that queries the
OpenLibrary API and retrieves book information. With that information, I used jQuery to autofill the rest of the form.

We can add many more books but for the sake of time, we'll stick to the one. 

#### Searching For Books

After we've listed our ad, let's go looking for books. We can search for books in two ways: by the ad or by the book. A
search by Ads will scan an ad's title and description for keywords. A search by books will look at a book's title and
authors. Let's search for *The Life of Pi*.

#### Going to the Ad's Page

Now that we're viewing an ad for *The Life of Pi*, we have a few options. We can go back and keep looking around, or we
can attempt to trade some of our books for this one. Nathaniel will walk us through the transactions.

<br>

## Transactions

Thank you James, hello everyone, I'm Nathaniel and I will be walking through the process of performing a trade with 
another user. From the single ad view, the ad's title, description, list of books and their information are 
shown in detail. Using SQL queries in the Hibernate framework with Spring information is retrieved from our server's database.
 That information then is used to construct models of ads and books to send to the view. Let's *Offer Trade*. On this 
 page the user has the option of selecting any of the ads he or she posses to offer as a trade. Let's select an ad and 
 *Make Offer*. Now that an offer has been made let's log out of this user and log in as another to view the request.

#### Viewing Pending Trade Requests

Upon selecting *My Trade Requests* the server queries for all pending trade requests made to the currently logged in 
user. The action of processing a trade requests involves a user confirming or rejecting a proposed offer. If a trade is 
accepted, both ads will be altered in the database with a different status and a transaction object will be generated.

#### Completing the Trades

All transactions can be viewed in *My Past Transactions*. They store information on all trades that have taken place. 
Each transaction is constructed using trade requests and both user models involved. As a final step in the 
 trade process the other user's shipping address is displayed here