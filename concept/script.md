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

#### Offering a Trade

#### Viewing Pending Trade Requests

#### Completing the Trades