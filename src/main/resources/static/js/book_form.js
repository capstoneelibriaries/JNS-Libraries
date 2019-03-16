const BookForm = {
  self: {
    section: "",
    isbn: "",
    title: "",
    author: "",
    synopsis: "",
    wear: "",
    toHtml: () => {
      return `` +
      `<section id=${bookForm.section}>` +
          `<div>` +
            `<label for="${bookForm.isbn}">ISBN</label>` +
            `<input id="${bookForm.isbn}" type="number" minlength="${isbn_min}" maxlength="${isbn_max}" name="${bookForm.isbn}" />` +
          `</div>` +
          BookForm.genHtml("Title", BookForm.idToString(this.title)) +
          BookForm.genHtml("Author", BookForm.idToString(this.author)) +
          BookForm.genHtml("Synopsis", BookForm.idToString(this.synopsis)) +
          BookForm.genHtml("Condition", BookForm.idToString(this.wear)) +
      `</section>`;
    },
  },
  new: (index) => {
    let self = Book.self;
    self.section = `#new-book-${index}`;
    self.isbn = `#new-book-${index}-isbn`;
    self.title = `#new-book-${index}-title`;
    self.author = `#new-book-${index}-author`;
    self.synopsis = `#new-book-${index}-wear`;
    self.wear = `#new-book-${index}-wear`;
    return self;
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
  autoFill: (id) => {
    // console.log("DEBUG: autoFill(...)")
    // let book = Book.from(OpenBook.response);
    // $(bookForm.title).val(book.title);
    // $(bookForm.author).val(book.author);
    // $(bookForm.synopsis).val(book.synopsis);
  },
};
