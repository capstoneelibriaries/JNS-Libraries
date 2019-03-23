const BookForm = {
    new: (adform, index) => {
        console.log("DEBUG: BookForm.new(...)");
        return new ImplBookForm(adform, index);
    }
};

function ImplBookForm(adform, index) {
    console.log("ImplBookForm(..., ...)");
    // BookForms require an AdForm
    // inject dependency
    this.adform = adform;
    // book value gets set later
    this.book = {};

    if(index === undefined){
        this.isbn = "#book-isbn";
        this.title = "#book-title";
        this.author = "#book-author";
        this.synopsis = "#book-synopsis";
        this.image = "#book-image";
        this.wear = "#book-wear";
    }else{
        this.isbn = `#book-${index}-isbn`;
        this.title = `#book-${index}-title`;
        this.author = `#book-${index}-author`;
        this.synopsis = `#book-${index}-synopsis`;
        this.image = `#book-${index}-image`;
        this.wear = `#book-${index}-wear`;
    }

    this.autoFill = () => {
        console.log("DEBUG: ImplBookForm.autoFill()");

        this.book = Book.from(OpenBook.response);

        $(this.title).val(this.book.title);
        $(this.author).val(this.book.author);
        $(this.synopsis).val(this.book.synopsis);
        $(this.image).val(this.book.image);
        $(this.wear).val(this.book.wear);
    };

    this.getBook = () => {
        console.log("DEBUG: ImplBookForm.getBook()");
        this.book.isbn = $(this.isbn).val();
        this.book.title = $(this.title).val();
        this.book.author = $(this.author).val();
        this.book.synopsis = $(this.synopsis).val();
        this.book.image = $(this.image).val();
        this.book.wear = $(this.wear).val();
        return this.book;
    };

}
