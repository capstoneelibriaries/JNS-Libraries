## Introduction
Good evening ladies and gentlemen, my name is Sam Rodriguez and joining me today are my partners, James Meyer, and Nathaniel Gumbs. Today we are 
going to present to you our application *E-Libraries*.

#### About
What e-libraries is, is an online book 
#### Registration

#### Logging In

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

#### Offering a Trade

#### Viewing Pending Trade Requests

#### Completing the Trades