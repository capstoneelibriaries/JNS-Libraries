const address = {
    streetAddr: "",
    subAddr: "",
    country: "",
    city: "",
    state: "",
    zipcode: ""
};

const newAddress = (name) => {
    console.log("DEBUG: newAddress(...)");

    let self = Object.create(address);

    Object.keys(address).forEach( (key) => {
        self[key] = `#${name}-${key}`;
    });

    return self;
};

const autofill = (form, data) => {
    console.log("DEBUG: autofill(...)");
    $(`${form.streetAddr}`).val(data.address1);
    $(`${form.subAddr}`).val(data.address2);
    $(`${form.country}`).val(data.country);
    $(`${form.city}`).val(data.city);
    $(`${form.state}`).val(data.state);
    $(`${form.zipcode}`).val(data.zipcode);
};

function addresses(userId){
    console.log(`DEBUG: addresses(${userId})`);

    let req = new XMLHttpRequest();
    req.open("GET", `${window.origin}/profile/addresses/${userId}`);
    // when the request is complete
    req.onload = () => {
        // parse the addresses into an object
        const addr = JSON.parse(req.responseText);
        console.log(addr);

        const billing = newAddress("billing");
        const shipping = newAddress("shipping");

        autofill(billing, addr[0]);
        autofill(shipping, addr[1]);

        console.log(billing);
        console.log(shipping);
    };

    req.send();
}