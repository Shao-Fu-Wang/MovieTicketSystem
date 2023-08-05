function createAccount() {
    let status = document.querySelector('.status');
    let name = document.querySelector('#name');
    let mobileNumber = document.querySelector('#mobile_number');
    let password = document.querySelector('#password');
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:6969/register";

    // open a connection
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");


    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Print received data from server
            status.innerHTML = "Registration successful, going back to login page...";
            location.href='./login'
//            redirectLogin();
//             status.innerHTML = this.responseText;
        }
    };
    // Converting JSON data to string
    if (name.value !== "" && mobileNumber.value != "" && password.value != "") {
        var data = JSON.stringify({ "customerName": name.value, "customerMobileNumber": mobileNumber.value, "customerPassword": password.value });
        // Sending data with the request
        xhr.send(data);
    }

    // Print received data from server

    // status.innerHTML = "Account created, go back to login page";
}
