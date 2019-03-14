console.log("Running create ad.js");

const form = {
    create: "#create-ad",
    price: {
        label: "#ad-price",
        field: "#create-ad-price",
    },
    shipping: {
        label: "#ad-shipping",
        field: "#create-ad-shipping",
    },
    tradable: {
        label: "#ad-tradable",
        field: "#create-ad-tradable",
    },
    newBook: {
        label: "#ad-new-book",
        button: "#btn-ad-new-book",
        form: "#ad-new-book-form",
    },
    submit: {
        label: "#ad-submit-all",
        button: "#btn-ad-submit-all",
    }
};

const isbn_min = 10;
const isbn_max = 13;
let bookc = 0;

$(form.newBook.button).on("click", (event) => {

    let bookid = `new-book-${bookc}`;
    $(form.newBook.form).append(
       `<section id=${bookid}>` +
            `<label for="${bookid}-isbn">ISBN</label>` +
            `<input id="${bookid}-isbn" type="number" minlength="${isbn_min}" maxlength="${isbn_max}" name="${bookid}-isbn"/>` +
        `</section>`
    );
    bookc++;
});