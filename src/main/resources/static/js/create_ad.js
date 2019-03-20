console.log("DEBUG: Running create ad.js");

let adform = AdForm.new(OpenBook);

$(adform.book.button).on("click", (event) => {
  console.log($(adform.book.button));
  adform.addBookForm(BookForm.new(adform));
});

//when the submit button is pressed...
$(adform.submit.button).click( (event) => {
  event.preventDefault();

  //if no books are provided
  if(adform.bookCount() < 1){
    alert("No books provided.");
  }else{

  let post = new FormData();
  post.append("title", $(adform.title.field).val());
  post.append("description", $(adform.description.field).val());
  post.append("price", $(adform.price.field).val());
  post.append("shipping", $(adform.shipping.field).val());
  post.append("tradable", $(adform.tradable.field).val());
  adform.bookforms.forEach( (bookform, index) => {
    post.append(`book-isbn-${index}`, $(bookform.isbn).val());
    post.append(`book-title-${index}`, $(bookform.title).val());
    post.append(`book-author-${index}`, $(bookform.author).val());
    post.append(`book-synopsis-${index}`, $(bookform.synopsis).val());
    post.append(`book-wear-${index}`, $(bookform.wear).val());
  });

    let request = new XMLHttpRequest();
    request.open("POST", "/ads/create");
    let response = request.send(post);
    console.log(response);
  }
  
});