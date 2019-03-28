const OpenBook = {
  response: {},
  request: (isbn, bookform) => {
      console.log("DEBUG: OpenBook.request(...)");

      $.ajax({
          'url': `https://openlibrary.org/api/books?bibkeys=ISBN:${isbn}&jscmd=data&format=json`,
          'type': 'GET',
          'success': (data) => {
              OpenBook.response = data[`ISBN:${isbn}`];
              OpenBook.response.isbn = isbn;
              bookform.autoFill();
          },
          'error': (request, error) => {
              OpenBook.response = error;
          }
      });
  },
};