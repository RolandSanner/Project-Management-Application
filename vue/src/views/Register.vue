<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <!-- <label for="username" class="sr-only">Username</label> -->
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <!-- <label for="password" class="sr-only">Password</label> -->
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
    <router-link :to="{ name: 'login' }" class="hasAccount">Have an account?</router-link>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

* {
  font-family: Arial, Helvetica, sans-serif;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  background-color: #fff;
}

#register{
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  height: auto;
  color: #313131;
  font-size: 1.5rem;;
  transform: translate(-50%, -50%);
  padding: 30px;
  appearance: none;
  border:none;
  outline: none;
  background: none;
  border-radius: 5px;
  box-shadow: 0px 0px 5px #073763;
  /* background-color: #3c99dc; */
}

#register  h1 {
  display: flex;
  justify-content: center;
  padding: 25px 0 25px 25px;
  font-size: 2rem;
}

#register label {
  display: flex;
  justify-content: center;
  padding: 5px;
}

#username, #password, #confirmPassword {
  display: flex;
  justify-content: center;
  border-radius: 5px;
  box-shadow: 0px 0px 5px #073763;
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 3px;
  font-size: 1.8rem;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 15px;
  cursor: text;
  padding-left: 5px;
  width: auto;
}

#username:focus{
  background: #07376335;
}
#password:focus{
  background: #07376335;
}
#confirmPassword:focus{
  background: #07376335;
}

form button {
  background-color: #073763;
  color: white;
  display: flex;
  margin-left: auto;
  margin-right: auto;
  margin-top: 15px;
  font-size: 18px;
  padding: 3px;
  border-radius: 3px;
  cursor: pointer;
}
form button:hover{
  color: black;
}

.hasAccount {
  text-decoration: none;
  display: flex;
  justify-content: center;
  padding-top: 25px;
  color: #000000;
  /* padding-bottom: 15px; */
}

.hasAccount:hover {
  color: #acaeaf;
}

</style>
