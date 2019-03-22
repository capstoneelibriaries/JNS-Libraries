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

    this.form = "#create-ad";
    this.title = {
        label: "#ad-title",
        field: "#create-ad-title",
    };
    this.description = {
        label: "#ad-description",
        field: "#create-ad-description",
    };
    this.price = {
      label: "#ad-price",
      field: "#create-ad-price",
    };
    this.shipping = {
      label: "#ad-shipping",
      field: "#create-ad-shipping",
    };
    this.tradable = {
      label: "#ad-tradable",
      field: "#create-ad-tradable",
    };
    this.book = {
      label: "#ad-new-book",
      button: "#btn-ad-new-book",
      form: "#ad-new-book-form",
    };

    this.submit = {
      label: "#ad-submit-all",
      button: "#btn-ad-submit-all",
    };
    // all book forms are listed in the following array
    this.bookforms = [];

    this.bookCount = () => {
        console.log("DEBUG: adform.bookCount()");
        return this.bookforms.length;
    };

    this.getIsbnSize = () => {
        console.log("DEBUG: adform.getIsbnSize");
        return AdForm.isbn;
    };

    this.addBookForm = (bookform) => {
        console.log("DEBUG: adform.addBookForm");

        // check if the previous book form is complete
        if(this.bookCount() > 0 && $(adform.bookforms[adform.bookCount() - 1].isbn).val().length !== (10||13) ){
            alert("Previous form incomplete. Please enter an isbn.");
        }else{
            // add the book form to a list of bookforms
            this.bookforms.push(bookform);
            // embed the new form in the html
            $(this.form).append(bookform.toHtml());
            // watch the for the user's input into the isbn field
            let isbn = "";
            $(bookform.isbn).on("keyup", () => {

                isbn = $(bookform.isbn).val();

                if(isbn.length === AdForm.isbn.min || isbn.length === AdForm.isbn.max){
                    console.log(isbn);
                    openbookApi.request(isbn, bookform);
                    // enable the submit button since the ajax request should be finished
                    if(this.bookCount() > 0){
                        $(this.submit.button).prop('disabled', false);
                    }
                }
            });
        }
    };
}
