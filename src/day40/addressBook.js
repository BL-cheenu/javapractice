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

// UC4: Find existing contact and edit it
function editContact(firstName, updatedDetails) {
    let contact = addressBook.find(function (person) {
        return person.firstName === firstName;
    });

    if (!contact) {
        console.log("Contact not found");
        return;
    }

    contact.lastName = updatedDetails.lastName || contact.lastName;
    contact.address = updatedDetails.address || contact.address;
    contact.city = updatedDetails.city || contact.city;
    contact.state = updatedDetails.state || contact.state;
    contact.zip = updatedDetails.zip || contact.zip;
    contact.phone = updatedDetails.phone || contact.phone;
    contact.email = updatedDetails.email || contact.email;

    validateContact(contact);
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
    editContact("John", {
        city: "Bangalore",
        phone: "9999999999"
    });
    console.log(addressBook);


} catch (error) {
    console.log("Error :", error.message);
}

