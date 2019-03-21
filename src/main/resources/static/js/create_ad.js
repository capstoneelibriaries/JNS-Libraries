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
    post.append("book-count", adform.bookCount());

    adform.bookforms.forEach( (bookform, index) => {
      const book = bookform.getBook();
      post.append(`book-isbn-${index}`, book.isbn);
      post.append(`book-title-${index}`, book.title);
      post.append(`book-author-${index}`, book.author);
      post.append(`book-synopsis-${index}`, book.synopsis);
      post.append(`book-wear-${index}`, book.wear);
      // additional items that are not displayed in the ad yet
      post.append(`book-pages-${index}`, book.pages);
      post.append(`book-publish-date-${index}`, book.publishDate);
      post.append(`book-image-${index}`, book.image);
    });

    // get the name of the site
    const origin = window.location.origin;

    let request = new XMLHttpRequest();
    request.open("POST", `${origin}/ads/create`);
    // when the post is complete
    request.onload = () => {
      // redirect
      if(request.status === 200){
        $(location).attr('href', `${origin}/ads/index`);
      }else{
        $(location).attr('href', `${origin}/${request.status}`);
      }
    };
    // submit the post
    request.send(post);
    // the redirect happens here
  }
  
});