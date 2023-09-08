function submitForm(){
    var login_id = document.getElementById("login").value;
    var password = document.getElementById("password").value;

    fetch('/login',{
        method: 'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify({login_id:login_id,password:password})
    })
    .then(response => response.json)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error',error);
    });
}