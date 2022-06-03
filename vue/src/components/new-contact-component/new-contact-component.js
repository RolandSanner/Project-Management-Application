import ContactService from './../../services/ContactService'

export default {
	name: "new-contact-component",
	components: {},
	data() {
		return {
			contact: {
				firstName: '',
				lastName: '',
				email: '',
				phoneNumber: '',
				contactRole: '',
				companyName: '',
				street: '',
				city: '',
				state: '',
				zip: '',
				industry: ''
			}
		}
	},
	created() {},
	computed: {},
    methods: {
    saveDocument() {
      ContactService.addContact(this.contact)
                     .then(response => {
                       if(response.status === 201){
                         this.$router.push("/")
                       }
                     })
                     .catch(error => {
                       console.error(error)
                     })
    },
    cancel() {
      this.$router.push('/')
    }
   }
  };