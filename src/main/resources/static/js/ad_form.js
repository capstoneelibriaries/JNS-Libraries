const AdForm = {
  isbn: {
    min: 10,
    max: 13,
  },
  new: (openbookApi) => {
    return Object.freeze(new ImplAdForm(openbookApi));
  }
};

function ImplAdForm(openbookApi) {
    console.log("DEBUG: ImplAdForm(...)");

    this.openbookApi = openbookApi;
    this.title = "#ad-title";
    this.description = "#ad-description";
    this.price = "#ad-price";
    this.shipping = "#ad-shipping";
    this.btn = {
      newad: "#btn-new-ad",
      newbook: "btn-new-book"
    };

    // all book forms are listed in the following array
    this.bookforms = [{}];

    this.bookCount = () => {
        console.log("DEBUG: ImplAdForm.bookCount(...)");
        return this.bookforms.length;
    };

    this.getIsbnSize = () => {
        console.log("DEBUG: ImplAdForm.getIsbnSize(...)");
        return AdForm.isbn;
    };

    this.addBookForm = (bookform) => {
        console.log("DEBUG: ImplAdForm.adBookForm(...)");
        console.assert(typeof(bookform) === "object");

        this.bookforms.push(bookform);

        let isbn = "";
        $(bookform.isbn).on("keyup", () => {

            isbn = $(bookform.isbn).val();

            if(isbn.length === AdForm.isbn.min || isbn.length === AdForm.isbn.max){
                console.log(isbn);
                openbookApi.request(isbn, bookform);
                // enable the submit button since the ajax request should be finished
                $(this.btn.newad).prop('disabled', false);
                $(this.btn.newbook).prop('disabled', false);
            }
        });
    }

}
