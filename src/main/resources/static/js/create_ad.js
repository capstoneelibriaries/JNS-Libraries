console.log("DEBUG: Running create ad.js");

const generateISBN = (event) => {

    // create a form object for each book
    let bookForm = newBookForm(bookForms.length);

    // append a new html section to the form
    $(form.newBook.form).append(isbnToHtml(bookForm));

    // alter the strings on section and isbn for jquery selection
    bookForm.section = `#${bookForm.section}`;
    bookForm.isbn = `#${bookForm.isbn}`;

    // ad the form to an array of forms
    bookForms.push(bookForm);

    // only append to the form once
    let generatedForms = 0;
    // create the isbn out here, so it isn't being re-instantiated
    let isbn = "";

    $(bookForm.isbn).on("keyup", (event) => {
       isbn = $(bookForm.isbn).val();
       if(isbn.length >= isbn_min && generatedForms < 1){
           $(bookForm.section).append(bookFormToHtml(bookForm));
           // convert the values of book form so they can be selected by jquery
           bookForm.title = `#${bookForm.title}`;
           bookForm.author = `#${bookForm.author}`;
           bookForm.synopsis = `#${bookForm.synopsis}`;
           bookForm.wear = `#${bookForm.wear}`;
           generatedForms++;
           OpenBook.request(autoFill(Object.freeze(bookForm), isbn));
       }
    });
};

$(form.newBook.button).on("click", (event) => generateISBN(event));;
