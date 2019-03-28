function createAd(args){
    { // TEST
        console.assert(OpenBook !== undefined);
        console.assert(AdForm !== undefined);
        console.assert(BookForm !== undefined);
        console.assert(typeof(args) === "number");
    } // END TEST

    let adform = AdForm.new(OpenBook);
    Object.seal(adform);

    { // TEST
        console.assert(adform.openbookApi !== undefined);
        console.assert($(adform.title) !== undefined);
        console.assert($(adform.description) !== undefined);
        console.assert($(adform.price) !== undefined);
        console.assert($(adform.shipping) !== undefined);
        console.assert($(adform.btn.newad) !== undefined);
        console.assert($(adform.btn.newbook) !== undefined);
    } // END TEST

    adform.addBookForm(Object.seal(BookForm.new(adform)));

    { // TEST
        console.assert(adform.bookCount() === 1);
        console.assert(adform.bookforms[0] !== {});
    } // END TEST

    const bookc = args;
    console.assert(typeof(bookc) === "number");

    for(let i = 0 ; i < bookc; i++){
        addform.addBookForm(BookForm.new(adform));
        console.assert(adform.bookCount() === (i + 1));
    }
};