let WebApi = {
    getLoginUser(username, password){
        const data = {
            "userName":username,
            "password": password,
            "rememberMe": "True",
            "token": "",
            "name": [],
            "cookie": "",
            "cookieExpirytime": "12"
        };
        return fetch("http://localhost:9090/CCSBI/api/login", {
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
    }
};

export default WebApi;