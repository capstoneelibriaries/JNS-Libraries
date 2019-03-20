const BookForm = {

    adform: {},

    new: (adform) => {
        return new ImplBookForm(adform);
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
    // book value gets set later
    this.book = {};

    this.autoFill = () => {
        console.log("DEBUG: autoFill()");
        this.book = Book.from(OpenBook.response);
        console.log(this.book);
        $(this.title).val(this.book.title);
        $(this.author).val(this.book.author);
        $(this.synopsis).val(this.book.synopsis);
    };

    this.getBook = () => {
        console.log("DEBUG: getBook()");
        this.book.isbn = $(this.isbn).val();
        this.book.title = $(this.title).val();
        this.book.author = $(this.author).val();
        this.book.synopsis = $(this.synopsis).val();
        this.book.wear = $(this.wear).val();
        return this.book;
    };

    this.toHtml = () => {
        const isbn_min = this.adform.getIsbnSize().min;
        const isbn_max = this.adform.getIsbnSize().max;

        return `` +
            `<div class="card card-signin my-5"></div>` +
            `<div class="card-body" ></div>` +
            `<div class="form-signin"></div>` +
            `<div class="form-label-group" id=${BookForm.idToString(this.section)}>` +
            `<div class="form-label-group">` +
            `<label for="${BookForm.idToString(this.isbn)}"></label>` +
            `<input class="form-control" id="${BookForm.idToString(this.isbn)}" 
                type="number" minlength="${isbn_min}" maxlength="${isbn_max}" 
                name="${this.isbn}"/>` +
                    `</div>` +
                    `</div>` +
                    `</div>` +
                    `</div>` +
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
