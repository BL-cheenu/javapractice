let addressBook = [];

function addContact(firstName, lastName, address, city, state, zip, phone, email) {
    let contact = {
        firstName: firstName,
        lastName: lastName,
        address: address,
        city: city,
        state: state,
        zip: zip,
        phone: phone,
        email: email
    };

    addressBook.push(contact);
}
addContact("John",
    "Doe",
    "123 Main St",
    "New York",
    "NY",
    "10001",
    "9876543210",
    "john.doe@email.com"
);
console.log(addressBook);
