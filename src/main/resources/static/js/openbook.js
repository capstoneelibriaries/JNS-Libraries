const OpenBook = {
  response: {},
  request: (isbn, callback) => {
      $.ajax({
          'url': `https://openlibrary.org/api/books?bibkeys=ISBN:${isbn}&jscmd=data&format=json`,
          'type': 'GET',
          'success': (data) => {
              OpenBook.response = data[`ISBN:${isbn}`];
              OpenBook.response.isbn = isbn;
              callback(isbn);
          },
          'error': (request, error) => {
              OpenBook.response = error;
          }
      });
  },
};

// let apiResponse = {};
//
// const apiRequest = (isbn) => {
//
//     $.ajax({
//         'url': `https://openlibrary.org/api/books?bibkeys=ISBN:${isbn}&jscmd=data&format=json`,
//         'type': 'GET',
//         'success': (data) => {
//             apiResponse = data[`ISBN:${isbn}`];
//         },
//         'error': (request, error) => {
//             console.log("Request: " + JSON.stringify(request));
//         }
//     });
// };

//apiRequest("9780980200447");
