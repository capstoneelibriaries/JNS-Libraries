# Elibraries

## Creators

- James Meyer
- Nathaniel Gumbs
- Sam Rodriguez

## Technologies We Utilized

### Server Side

#### Spring Boot

A Spring boot server was selected, where we took advantage of form model binding and automated SQL queries. Spring boot 
also enforced the *builder* pattern, the *singleton* pattern, and the *model-view-controller* pattern. This enforced
clear, consistent code with a logical distribution of tasks.

#### Thymeleaf

Thymeleaf was used for server side rendering of html pages. This enabled us to build many dynamic pages with only a few
lines of code. In particular, the **create ad** page can be referenced as an example of how we used lists to generate an
expanding html form.

#### Thymeleaf Extras: Springsecurity4

Springsecurity4 was used to protect registered user's information. All registered users have their passwords hashed upon creation. This allows ensures not even server admins have access to an individual's personal information. Springsecurity4 also gave us the ability to restrict access to certain pages and also specify what pagers are accessible by everyone. 

### Client Side

#### EMCA6 Javascript

For certain client side logic, EMCA6 Javascript was used because of the idiomatic nature of modern JavaScript
and it's capacity to represent collections of data as objects. While many proponents of server side computation argue
JavaScript is insecure, our use of EMCA6 JavaScript enabled us to tightly control the mutability of client side data. In
many cases, objects and functions were defined with the `const` keyword. When mutable objects were introduced to the
client, we took advantage of the `Object.freeze()` method to introduce some kind of type safety.

#### Open Library API

The OpenLibrary API was used to maintain the integrity of our database and also provide an auto-fill feature that enhanced
the user experience. The OpenLibrary API responds to ISBN numbers. In the client side JavaScript, a specific OpenLibrary
query is made requesting a `JSON` object. The `JSON` object is parsed into a book object, which we use to auto-fill
various forms for the user.

#### jQuery

In order to manipulate the `DOM`, we introduced jQuery.
