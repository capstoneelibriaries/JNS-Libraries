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

### Client Side

#### EMCA6 Javascript

For certain client side logic, EMCA6 Javascript was used. This is because of the idiomatic nature of modern JavaScript
and it's capacity to represent collections of data as objects. While many proponents of server side computation argue
JavaScript is insecure, our use of EMCA6 JavaScript enabled us to tightly control the mutability of client side data. In
many cases, objects and functions were defined with the `const` keyword. When mutable objects were introduced to the
client, we took advantage of the `Object.freeze()` method to introduce some kind of type safety.

#### Open Book API

The OpenBook API was used to maintain the integrity of our database and also provide an auto-fill feature that enhanced
the user experience. The OpenBook api responds to ISBN numbers. In the client side JavaScript, a specific OpenBook
query is made requesting a `JSON` object. The `JSON` object is parsed into a book object, which we use to auto-fill
various forms.

#### jQuery

In order to manipulate the `DOM`, we introduced jQuery.