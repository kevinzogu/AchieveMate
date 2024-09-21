document.getElementById('signupForm').addEventListener('submit', function(event) {
    const name = document.getElementById('name').value;
    const surname = document.getElementById('surname').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const email = document.getElementById('email').value;
    const birthDate = document.getElementById('birthDate').value;

    if (!name || !surname || !username || !password || !email || !birthDate) {
        event.preventDefault();
        alert("All fields are required!");
    }
});
