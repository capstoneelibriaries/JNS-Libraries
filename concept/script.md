## Introduction
Good evening ladies and gentlemen, my name is Sam Rodriguez and joining me today are my partners, James Meyer, and Nathaniel Gumbs. Today we are 
going to present to you our application *E-Libraries*.
#### About
E-libraries is a mobile responsive online book store that enables users to trade used books with one another. This application was constructed 
using the Spring Boot Framework on the back end; Thymeleaf, Modern Javascript and bootstrap on the front end. It leverages the Open Library API, 
and other technologies that we will explore throughout this presentation. Our use of Spring caused our code to conform to common object oriented 
design patters, such as the build pattern, the singleton pattern, and the model-view-controller pattern.  
#### Registration
Here we have the registration form, all fields in this form, and across the application are locked down with HTML5 attributes. Our use of such 
technologies balances both a low memory footprint as well as security. The fields you are seeing here are bound to the many java models on the 
backend. When any of these forms are submitted, spring automatically constructs the bound model.
#### Logging In
For the sake of time, we will be signing in as a pre-existing user. Upon logging in you will be redirected to the profile page.
#### Profile Page
Upon entering the profile page, you will see all the users book listings that have been created. As a user, you can click on each individual book 
to edit the information, or delete the listing all together, and now, my partner James Meyer will walk you through: 

## Creating New Trade and Searching

#### Listing a Book

Thank you Sam. Let's create a new trade. In order to do this we'll need a title for the trade, a description, a value we believe 
our books are worth, a shipping value, and finally a book. 

For the book itself, we only need to enter the *ISBN*. The reason for this is because I was able to automate the form
creation by writing an *autofill* feature in **JavaScript**. **The Javascript** performs an **AJAX** request that queries 
the **OpenLibrary API** and retrieves book information. With that information, I used **jQuery** to autofill the rest of 
the form.

We can add many more books but for the sake of time, we'll stick to the one. 

#### Searching For Books

After we've listed our trade, let's go looking for books. We can search for books in two ways: by the trade or by the book. A
search by trades will scan an trade's title and description for keywords. A search by books will look at a book's title and
authors. Let's search for *The Life of Pi*.

#### Going to the Trade's Page

Now that we're viewing an trade for *The Life of Pi*, we have a few options. We can go back and keep looking around, or we
can attempt to trade some of our books for this one. Nathaniel will walk us through the transactions.

<br>

## Transactions

Thank you James, I'll walk us through the process of performing a trade. We'll click the **offer trade button**, 
which is only visible because of our **Spring Security Component**. If we weren't logged in, this
option wouldn't be available. 

We're now taken to the trade page. On the left side, we have the owner's trade and on the right side we have our trades
that we can use to make an offer. I did this by using SQL queries in the **Hibernate ORM** to retrieve information from both
users and trades. Then constructed models of the trades and displayed them, *iteratively* through **Thymeleaf**.

We'll select the trade we just listed, and make an offer. When this button is clicked, a *post* request is submitted, which builds 
a *trade request object*, containing *references* to both users and trades, and is saved to the database via *Hibernate*.

Now we'll log out of this user and log in as the trade recipient to see how trade confirmation works.

#### Viewing Pending Trade Requests

Upon logging in, we'll navigate to *My Trade Reqeusts*, where we can see a list of *pending* trade offers. Like before,
I constructed this using **Hibernate** and *form-model-binding* through **Thymeleaf**.

Let's confirm the trade request. Behind the scenes, the *pending* status of the trade request and trades are terminated. 
A *transaction object is generated*, which contains *references* to the trade request, the users involved, and time of 
confirmation. Then, the transaction is saved to the database.

#### Completing the Trades

All transactions can be viewed in *My Past Transactions*. This page displays all of the transactions belonging to this user
and contains information on which books were exchanged with whom, as well as a shipping address to send the books to.

<br>

## Conclusion

Are you looking for a place to trade used books and expand your literary horizons, consider E-Libraries. If you'd like to know
more about our site's additional features or the build process, like how we implemented **JUnit** testing, come see us at table X.
