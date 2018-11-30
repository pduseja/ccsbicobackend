let Helpers = {
    authenticateUser() {
        return JSON.parse(localStorage.getItem('user'));
    }
};

export default Helpers;