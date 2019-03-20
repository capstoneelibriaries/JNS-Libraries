const Ad = {
    self: {
        create: "create-ad",
        title: {
            label: "ad-title",
            field: "create-ad-title",
        },
        description: {
            label: "ad-description",
            field: "create-ad-description",
        },
        price: {
            label: "ad-price",
            field: "create-ad-price",
        },
        shipping: {
            label: "ad-shipping",
            field: "create-ad-shipping",
        },
        tradable: {
            label: "ad-tradable",
            field: "create-ad-tradable",
        },
        newBook: {
            label: "ad-new-book",
            button: "btn-ad-new-book",
            form: "ad-new-book-form",
        },
        submit: {
            label: "ad-submit-all",
            button: "btn-ad-submit-all",
        },
        books: [],
    },
    new: () => {
        return Ad.self;
    }
};
