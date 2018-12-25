let WebApi = {
    getLoginUser(username, password, rememberMe){
        const data = {
            "userName":username,
            "password": password,
            "rememberMe": rememberMe
        };
        return fetch("http://localhost:9090/CCSBI/api/login", {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            },
        })
    },
    getLoggedInUser(cookie, token){
        const data = {
            "cookie": cookie,
            "token": token,
            "rememberMe": true
        };
        return fetch("http://localhost:9090/CCSBI/api/login",{
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            },
        })
    },
    registerUser(data, photo, done){
        let request = new XMLHttpRequest();
        request.open('POST', 'http://localhost:9090/CCSBI/api/registration');
        let formData = new FormData();
        formData.append('photo', photo || {})
        formData.append('users', JSON.stringify(data));
        request.onload = function () {
            done(null, request.response);
        };
        request.onerror = function () {
            done(request.response);
        };
        request.send(formData);
    },
    getDataFromUserId(id){
        return fetch(`http://localhost:9090/CCSBI/api/reset/`+id,{
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            },
        })
    },
    changeUserPassword(userId, password){
        let data = {
            "userName": userId,
            "UsersDetails": {
                "password": password
            }
        };
        return fetch('http://localhost:9090/CCSBI/api/passwordReset',{
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            },
        })
    },
    getSystemParams(){
        return fetch('http://localhost:9090/CCSBI/api/params/a',{
            method: "GET",
            headers: {
            "Content-Type": "application/json"
        },
    })
    }
};

export default WebApi;