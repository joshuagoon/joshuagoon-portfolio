const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");
const confirmlogin = document.querySelector(".confirmlogin");
const submitButton = document.getElementById('submitButton');
const popUpButton = document.querySelector(".popup-btn");
const popUp = document.querySelector(".pop-up");
const okButton = document.querySelector(".ok-btn");

signupLink.onclick = (()=>{
    signupBtn.click();
});
  
submitButton.addEventListener("click",()=>{
    popUp.style.display = "flex"
});
  
okButton.addEventListener("click",()=>{
    popUp.style.display = "none"
})
confirmlogin.addEventListener('click', () => {
    window.location.replace("Cart.html");
    document.location.href = 'Cart.html';
});