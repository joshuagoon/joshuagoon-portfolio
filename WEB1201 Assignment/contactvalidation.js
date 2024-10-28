const submitButton = document.getElementById('submitButton');
const name = document.getElementById('name');
const email = document.getElementById('mail');
let err = document.getElementById('err');
const popUpButton = document.querySelector(".popup-btn");
const popUp = document.querySelector(".pop-up");
const okButton = document.querySelector(".ok-btn");

function Validation() {
    if(name.value === '') {
        name.style.borderColor = 'red';
        nameErr.style.color = 'red';
        nameErr.textContent = 'Please fill out the "Name" field';
    } else {
        name.style.borderColor = 'green';
        nameErr.textContent = '';
    }

    if (email.value === '') {
        email.style.borderColor = 'red';
        emailErr.style.color = 'red';
        emailErr.textContent = 'Please fill out "Email" field';
    } else {
        var mailformat = /^\w+([.-]?\w+)@\w+([.-]?\w+)(.\w{2,3})+$/;
        if (email.value.match(mailformat)) {
            email.style.borderColor = 'green';
            emailErr.textContent = '';
        } else {
            email.style.borderColor = 'red';
            emailErr.style.color = 'red';
            emailErr.textContent = 'This is not an email';
        }
    }

    if (msg.value === '') {
        msg.style.borderColor = 'red';
        msgErr.style.color = 'red';
        msgErr.textContent = 'Please fill out the "Message" field';
    } else {
        msg.style.borderColor = 'green';
        msgErr.textContent = '';
    }

    if (msg.value !== '' && email.value !== '' && name.value !== '' && email.value.match(mailformat)) {
        popUp.style.display = "flex"
    }
}

submitButton.addEventListener('click', (e) => {
    if (!Validation()) {
        e.preventDefault();
    }
})