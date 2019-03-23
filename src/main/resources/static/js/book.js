const Book = {
  // constructor that creates a book from the openbook api
  from: (obResponse) => {
    return new ImplBook(obResponse);
  },
  parseAuthor: (openbook) => {
    if(typeof(openbook.authors) === "undefined"){
      return "none";
    }else{
      let authors = "";
      openbook.authors.forEach( (author) => {
        authors += author.name + ", ";
      });
      // cut off the last comma and space
      return authors.substring(0, authors.length - 2);
    }
  },
  parseSynopsis: (openbook) => {
    if(typeof(openbook.excerpts) === "undefined" || openbook.excerpts.length === 0){
      return "none";
    }else{
      return openbook.excerpts[0].text;
    }
  },
};

// obResponse is the response object of the OpenBook Api
function ImplBook(obResponse){

  this.isbn = obResponse.isbn;
  this.title = obResponse.title;
  this.author = Book.parseAuthor(obResponse);
  this.synopsis = Book.parseSynopsis(obResponse);
  this.pages = obResponse.number_of_pages;
  this.publishDate = obResponse.publish_date;
  this.image = obResponse.cover.large;
  this.wear = 1;

}