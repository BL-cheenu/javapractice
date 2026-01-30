let addressBook = [];

// Regex patterns
const namePattern = /^[A-Z][a-zA-Z]{2,}$/;
const textPattern = /^[a-zA-Z\s]{4,}$/;
const zipPattern = /^[0-9]{6}$/;
const phonePattern = /^[0-9]{10}$/;
const emailPattern = /^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/;

// UC1: Create Contact + UC2: Validate Contact + UC3: Add to Address Book
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
    validateContact(contact); // UC2 Validation
    addressBook.push(contact);
    console.log("Contact Added Successfully");
}

function validateContact(contact) {
    if (!namePattern.test(contact.firstName)) {
        throw new Error("Invalid First name")
    }
    if (!namePattern.test(contact.lastName)) {
        throw new Error("Invalid Last Name");
    }

    if (!textPattern.test(contact.address)) {
        throw new Error("Invalid Address");
    }

    if (!textPattern.test(contact.city)) {
        throw new Error("Invalid City");
    }

    if (!textPattern.test(contact.state)) {
        throw new Error("Invalid State");
    }

    if (!zipPattern.test(contact.zip)) {
        throw new Error("Invalid Zip");
    }

    if (!phonePattern.test(contact.phone)) {
        throw new Error("Invalid Phone Number");
    }

    if (!emailPattern.test(contact.email)) {
        throw new Error("Invalid Email");
    }
}

try {
    addContact("John",
        "Doe",
        "Main Street",
        "Chennai",
        "Tamilnadu",
        "600001",
        "9876543210",
        "john.doe@email.com"
    );

    addContact(
        "Alice",
        "Smith",
        "Park Avenue",
        "Bangalore",
        "Karnataka",
        "560001",
        "9123456780",
        "alice.smith@email.com"
    );

    console.log(addressBook);

} catch (error) {
    console.log("Error :", error.message);
}

