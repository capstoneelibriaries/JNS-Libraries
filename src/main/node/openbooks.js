// openbooks.js
//  This is a test file that can be run by invoking
//  nodejs or node <name of file>
const http = require('http');

const requestJSON = (isbn) => {

    http.get(`http://openlibrary.org/api/books?bibkeys=ISBN:${isbn}&format=json`, (resp) => {
        let data = '';
        // A chunk of data has been recieved.
        resp.on('data', (chunk) => {
            data += chunk;
        });

        resp.on('end', () => {
            console.log(JSON.parse(data));
        });

    }).on("error", (err) => {
        console.log("Error: " + err.message);
    });

};

requestJSON("0201558025");
requestJSON("0609808818");
requestJSON("0672314800");
requestJSON("1593270011");
requestJSON("9780470112830");
requestJSON("0764589962");