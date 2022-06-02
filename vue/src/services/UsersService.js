import axios from "axios";

const http=axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    getUsers(){
        return http.get('/users');
    },

    getUserById(id){
        return http.get(`/users/id/${id}`);
    },

    getUserByUsername(username){
        return http.get(`/users/${username}`);
    }
}