console.log("Running openbook.js");

const apiRequest = (isbn) => {
    $.ajax({
        'url' : `https://openlibrary.org/api/books?bibkeys=ISBN:${isbn}&jscmd=data&format=json`,
        'type' : 'GET',
        // 'success' : (data) => {
        //     return data;
        // },
        // 'error' : (request,error) => {
        //     console.log("Request: "+JSON.stringify(request));
        // },
    }).done((data) => {
        data = data.responseJSON;
        return data[`ISBN:${isbn}`];
    });
};

const jsonFromRequest = (request) => {
    return request.responseJSON;
};

const objFromISBN = (isbn, json) => {
    return json[`ISBN:${isbn}`];
};

const getBook = (isbn) => {
    return objFromISBN(isbn, jsonFromRequest(apiRequest(isbn)));
};