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

const keyLeft = 37;
const keyRight = 39;
const keyUp = 38;
const keyDown = 40;
const keyLowA = 65;
const keyLowB = 66;

const konami = [
    keyUp,
    keyUp,
    keyDown,
    keyDown,
    keyLeft,
    keyRight,
    keyLeft,
    keyRight,
    keyLowA,
    keyLowB,
];

function execKonami(form){
    $(`${form.streetAddr}`).val("600 Navaro");
    $(`${form.subAddr}`).val("Floor 3");
    $(`${form.country}`).val("United States");
    $(`${form.city}`).val("San Antonio");
    $(`${form.state}`).val("Texas");
    $(`${form.zipcode}`).val("78259");
}

function addresses(userId){
    console.log(`DEBUG: addresses(${userId})`);

    const billing = newAddress("billing");
    const shipping = newAddress("shipping");

    let req = new XMLHttpRequest();
    req.open("GET", `${window.origin}/profile/addresses/${userId}`);
    // when the request is complete
    req.onload = () => {
        // parse the addresses into an object
        const addr = JSON.parse(req.responseText);
        console.log(addr);

        autofill(billing, addr[0]);
        autofill(shipping, addr[1]);

        console.log(billing);
        console.log(shipping);
    };

    req.send();

    var keyStack = [];
    $(document).keyup(function(event){
        keyStack.push(event.keyCode);

        if(keyStack.length === konami.length){
            var i = 0;
            keyStack.forEach(function(key){
                if(key === konami[i]){
                    i++;
                }
            });
            if(i === konami.length){
                execKonami(billing);
                execKonami(shipping);
            }
            keyStack = [];
        }
    });

}