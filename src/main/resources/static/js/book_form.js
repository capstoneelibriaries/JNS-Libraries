const BookForm = {

    adform: {},

    new: (adform) => {
        return Object.freeze(new ImplBookForm(adform));
    },

    genHtml: (label, id, type, misc) => {
        return `` +
            `<div class="form-label-group">` +
            `<label for="${id}">${label}</label>` +
            `<input class="form-control" id="${id}" type="${type}" ${misc} name="${id}"/>` +
            `</div>`;
    },

    idToString: (id) => {
        return id.substring(1, id.length);
    },
};

function ImplBookForm(adform) {
    // BookForms require an AdForm
    const index = adform.bookCount();
    // inject dependency
    this.adform = adform;
    // json accessible values
    this.section = `#new-book-${index}`;
    this.isbn = `#new-book-${index}-isbn`;
    this.title = `#new-book-${index}-title`;
    this.author = `#new-book-${index}-author`;
    this.synopsis = `#new-book-${index}-synopsis`;
    this.wear = `#new-book-${index}-wear`;

    this.autoFill = () => {
        console.log("DEBUG: autoFill(...)");
        let book = Book.from(OpenBook.response);
        $(this.title).val(book.title);
        $(this.author).val(book.author);
        $(this.synopsis).val(book.synopsis);
    };

    this.toHtml = () => {
        const isbn_min = this.adform.getIsbnSize().min;
        const isbn_max = this.adform.getIsbnSize().max;

        return `` +
            `<div class="form-label-group" id=${BookForm.idToString(this.section)}>` +
            `<div class="form-label-group">` +
            `<label for="${BookForm.idToString(this.isbn)}"></label>` +
            `<input 
class="form-control" 
id="${BookForm.idToString(this.isbn)}" type="number" minlength="${isbn_min}" maxlength="${isbn_max}" name="${this.isbn}" placeholder="ISBN" />` +
            `</div>` +
            BookForm.genHtml("", BookForm.idToString(this.title), "text",
                `pattern=".{1,255}" readonly required`) +
            BookForm.genHtml("", BookForm.idToString(this.author), "text",
                `pattern=".{1,255}" readonly required`) +
            BookForm.genHtml("", BookForm.idToString(this.synopsis), "text",
                `pattern=".{1,255}" required`) +
            BookForm.genHtml("", BookForm.idToString(this.wear), "number",
                `required step="1" min="1" max="5"`) +
            `</div>`;
    };
}
