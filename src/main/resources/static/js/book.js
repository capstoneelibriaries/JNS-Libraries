// test isbn: 0672314800
const Book = {
  // the template object
  // self: {
  //   isbn: "",
  //   title: "",
  //   author: "",
  //   synopsis: "",
  // },
  // constructor that creates a book from the openbook api
  from: (obResponse) => {
    return new ImplBook(obResponse);
    // let self = Book.self;
    // self.isbn = openbook.isbn;
    // self.title = openbook.title;
    // self.author = Book.parseAuthor(openbook);
    // self.synopsis = Book.parseSynopsis(openbook);
    // return self;
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

function ImplBook(obResponse){

  this.isbn = obResponse.isbn;
  this.title = obResponse.title;
  this.author = Book.parseAuthor(obResponse);
  this.synopsis = Book.parseSynopsis(obResponse);

}