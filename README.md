# Elibraries



## Creators

- [James Meyer](https://www.linkedin.com/in/james-j-meyer/)
- [Nathaniel Gumbs](https://www.linkedin.com/in/nathaniel-gumbs/)
- [Sam Rodriguez](https://www.linkedin.com/in/oscar-sam-rodriguez/)

## Technologies We Utilized

### Server Side

#### Spring Boot

A **Spring boot** server was selected, where we took advantage of *form model* binding and automated SQL queries. 
**Spring boot** also enforced the *builder* pattern, the *singleton* pattern, and the *model-view-controller* pattern. 
This enforced clear, consistent code with a logical distribution of tasks.

#### Thymeleaf

**Thymeleaf** was used for server side rendering of html pages. This enabled us to build many dynamic pages with only a few
lines of code. In particular, the **create ad** page can be referenced as an example of how we used lists to generate an
expanding html form.

#### Thymeleaf Extras: Springsecurity4

**Springsecurity4** is used to protect the registered user's information. All registered users have their passwords hashed
upon creation. This ensures no attackers - even system administrators have access to an individual's passwords. 
**Springsecurity4** also provided access restriction on certain pages and also specify what pagers are accessible by everyone. 

#### JUnit4

**JUnit** is the de-facto standard for testing in Java. Unit tests were leveraged to ensure the integrity of our security
model, the mutability of our objects, and the synchronization of our workflow. In producing our application, over 100
individual tests were created for server side objects and *HTTP responses*.

### Client Side

#### EMCA6 Javascript

For certain client side logic, **EMCA6 Javascript** was used because of the idiomatic nature of modern JavaScript
and it's capacity to represent collections of data as objects. While many proponents of server side computation argue
JavaScript is insecure, our use of **EMCA6 JavaScript** enabled us to tightly control the mutability of client side data.
In many cases, objects and functions were defined with the `const` keyword. When mutable objects were introduced to the
client, we took advantage of the `Object.freeze()` method to introduce some kind of type safety.

#### Open Library API

The OpenLibrary API was used to maintain the integrity of our database and also provide an auto-fill feature that enhanced
the user experience. The OpenLibrary API responds to ISBN numbers. In the client side JavaScript, a specific OpenLibrary
query is made requesting a `JSON` object. The `JSON` object is parsed into a book object, which we use to auto-fill
various forms for the user.

#### jQuery

In order to manipulate the `DOM`, we introduced jQuery. Across the site, jquery is used to auto-fill forms with the we
retrieved from the OpenBook API. This allowed us to make many html fields `readonly`, such as book titles, book authors,
and book cover images.
