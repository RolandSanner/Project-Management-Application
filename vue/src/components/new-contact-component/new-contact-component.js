import ContractorService from './../../services/ContractorService'

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
				role: '',
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
      ContractorService.addContractor(this.Contact)
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