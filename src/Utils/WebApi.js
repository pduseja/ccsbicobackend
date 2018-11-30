

let WebApi = {
    getLoginUser(username, password){
        const data = {
            "userName":"pk100001",
            "password": "PrashantK",
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
    }
};

export default WebApi;