console.log("DEBUG: Running create ad.js");

let adform = AdForm.new(OpenBook);

$(adform.book.button).on("click", (event) => {
  console.log($(adform.book.button));
  adform.addBookForm(BookForm.new(adform));
});
