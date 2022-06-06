import axios from "axios";

const http=axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    getContacts(){
        return http.get('/contact');
    },

    addContact(contact){
        console.log("add new contact");
        return http.post(`/contacts/new`, contact);
    },
    listContacts(){
        return http.get('/contacts')
    },
}