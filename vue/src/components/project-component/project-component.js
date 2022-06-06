import projectService from './../../services/ProjectService.js'


export default {
	name: "project-component",
	components: {
        
    },
	data() {
		return {
			project: {
				projectID: '',
				projectName: '',
				description: '',
				fundingSource: '',
				precinct: '',
				municipality: '',
				location: '',
				contractName: '',
				projectManagerID: '',
				groupID: ''
			}
		}
	},
	created() {},
	computed: {},
	methods: {
		saveDocument() {
			projectService.create(this.project)
			.then(response => {
				if(response.status === 200){
					this.$router.push("/")
					this.clearNewProject();
				}
			})
			.catch(error => {
				console.error(error)
			})
		},
		cancel() {
			this.$router.push('/')
		},
		clearNewProject() {
			this.project = {
				projectID: '',
				projectName: '',
				description: '',
				fundingSource: '',
				precinct: '',
				municipality: '',
				location: '',
				contractName: '',
				projectManagerID: '',
				groupID: ''
			}
		}
	}
}



