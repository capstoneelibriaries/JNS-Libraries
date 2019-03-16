console.log("DEBUG: Running create ad.js");

let adform = AdForm.new();

$(adform.book.button).on("click", (event) => {
  console.log($(adform.book.button));
  adform.addBookForm(BookForm.new(adform.bookCount()));
});
