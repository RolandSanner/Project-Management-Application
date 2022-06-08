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

    listContactsByGroupId(id){
        return http.get(`/groups/${id}/contacts`)
    },
    updateContact(contact){
        return http.put('/contact/update', contact)
    },
    getContactByID(id){
        return http.put('/contacts/id', id)
    },
    assignContactToGroup(groupContact){
        return http.post('/contact/assignGroup',groupContact)
    },
    assignContactToProject(projectContact){
        return http.post('/contractor/assignProject',projectContact)
    }
}