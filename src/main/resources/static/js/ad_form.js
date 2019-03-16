const AdForm = {
  isbn: {
    min: 10,
    max: 13,
  },
  new: () => {
    return Object.freeze(new ImplAdForm());
  }
};

function ImplAdForm() {
  this.form = "#create-ad";
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
  }
  this.submit = {
      label: "#ad-submit-all",
      button: "#btn-ad-submit-all",
  };
  // all book forms are listed in the following array
  this.bookforms = [];

  this.bookCount = () => {
    return this.bookforms.length;
  }

  this.addBookForm = (bookform) => {
    this.bookforms.push(bookform);
    $(this.form).append(bookform.toHtml());
  };
}
