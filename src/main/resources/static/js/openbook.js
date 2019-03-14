console.log("Running openbook.js");

let apiResponse = {};

const apiRequest = (isbn) => {

    $.ajax({
        'url': `https://openlibrary.org/api/books?bibkeys=ISBN:${isbn}&jscmd=data&format=json`,
        'type': 'GET',
        'success': (data) => {
            apiResponse = data[`ISBN:${isbn}`];
        },
        'error': (request, error) => {
            console.log("Request: " + JSON.stringify(request));
        }
    });
};

apiRequest("9780980200447");