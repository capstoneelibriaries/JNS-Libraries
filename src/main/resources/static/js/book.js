// test isbn: 0672314800
const Book = {
  // constructor that creates a book from the openbook api
  from: (openbook) => {
    let self = {
      isbn: openbook.isbn,
      title: openbook.title,
      author: Book.parseAuthor(openbook),
      synopsis: Book.parseSynopsis(openbook),
    };
    return self;
  },
  parseAuthor: (openbook) => {
    if(openbook.authors === "undefined"){
      return "none";
    }else{
      let authors = "";
      openbook.authors.forEach( (author) => {
        author += author.name + ", ";
      });
      // cut off the last comma and space
      authors = authors.substring(0, authors.length - 2);
      return authors;
    }
  },
  parseSynopsis: (openbook) => {
    if(openbook.excerpts === "undefined"){
      return "none";
    }else if(openbook.excerpts.length == 0){
      return "none";
    }else{
      return openbook.excerpts[0].text;
    }
  },
};
