const BookForm = {
  new: (index) => {
    return Object.freeze(new ImplBookForm(index));
  },
  genHtml: (label, id) => {
    return `` +
    `<div>` +
        `<label for="${id}">${label}</label>` +
        `<input id="${id}" name="${id}" />` +
    `</div>`;
  },
  idToString: (id) => {
    return id.substring(1, id.length);
  },
};

function ImplBookForm(index) {
  // json accessable values
  this.section = `#new-book-${index}`;
  this.isbn = `#new-book-${index}-isbn`;
  this.title = `#new-book-${index}-title`;
  this.author = `#new-book-${index}-author`;
  this.synopsis = `#new-book-${index}-wear`;
  this.wear = `#new-book-${index}-wear`;

  this.autoFill = () => {
    console.log("DEBUG: autoFill(...)")
    // let book = Book.from(OpenBook.response);
    // $(bookForm.title).val(book.title);
    // $(bookForm.author).val(book.author);
    // $(bookForm.synopsis).val(book.synopsis);
  };

  this.toHtml = () => {
    return `` +
    `<section id=${BookForm.idToString(this.section)}>` +
        `<div>` +
          `<label for="${BookForm.idToString(this.isbn)}">ISBN</label>` +
          `<input id="${BookForm.idToString(this.isbn)}" type="number" minlength="${isbn_min}" maxlength="${isbn_max}" name="${bookForm.isbn}" />` +
        `</div>` +
        BookForm.genHtml("Title", BookForm.idToString(this.title)) +
        BookForm.genHtml("Author", BookForm.idToString(this.author)) +
        BookForm.genHtml("Synopsis", BookForm.idToString(this.synopsis)) +
        BookForm.genHtml("Condition", BookForm.idToString(this.wear)) +
    `</section>`;
  };
}
