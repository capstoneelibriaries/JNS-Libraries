## Introduction

Good evening ladies and gentlemen, my name is Sam Rodriguez and joining me today are my partners, James Meyer, and Nathaniel Gumbs. Today we are 
going to present to you our application, *E-Libraries*. 

#### About

E-libraries is an online book store that enables users to trade used books. This application is constructed with **Spring
Boot**, **Thymeleaf**, **Modern Javascript**, and it is styled with **Bootstrap**. It leverages the **OpenLibrary API**,
and other technologies that we will explore throughout this presentation.

#### Registration

First, let's register as a new *Bob*. All of the forms in this application are locked down with **HTML5** attributes. Our 
use of **HTML5** balances both security and a low memory footprint. The fields you see, are bound to the many **Java**
*models* on the *backend*. When any of these forms are submitted, **Spring** automatically constructs the bound model.

#### Logging In

We will now login as our new user, *Bob*. After filling out and submitting the login form, we will be redirected to the 
profile page.

#### Profile Page

Upon navigating to the *profile page*, we will see all the users book listings. Right now, we don't have any listings 
because we're a new user. So, let's go ahead and create a new Ad and see how the transactions take place.

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

Thank you James, hello everyone, I'm Nathaniel and I will walk us through the process of performing a trade. We'll clikc 
the **offer trade button**, which is only visible because of our **Spring Security Model**. If we weren't logged in, this
button would not be available. 

We're now taken to the trade page. On the left side, we have the owner of the ad and on the right side we have our ads
that we can offer to trade. I did this by using SQL queries in **Hibernate framework** to retrieve information from both
users, then constructed models of the Ads and displayed them, *iteratively* through **Thymeleaf**.

We'll select the ad we just listed, and submit a trade offer. A *post* request is submitted, which builds a *trade reqeust
object*, containing *references* to both users and ads, and it is saved to the database via *Hibernate*.

Now we'll log out and log in as the trade recipient and see how the trade confirmation works.

#### Viewing Pending Trade Requests

Upon logging in, we'll navigate to *My Trade Reqeusts*, where we can see a list of *pending* trade requests. Like before,
I constructed this using **Hibernate** and *form-model-binding*.

Let's confirm the trade request. Behind the scenes the *pending* status of the trade request is terminated. A *transaction
object is genrated*, which contains references to the trade request, the users involved, and the time of the trade. The
transaction is saved to the database.

#### Completing the Trades

All transactions can be viewed in *My Past Transactions*. It is a list of all of the transactions belonging to this user
that have taken place.

<br>

## Conclusion

If you're looking for a place to exchange your used books and expand your literary horizons, you have until June 6th and
then our certificates expire.