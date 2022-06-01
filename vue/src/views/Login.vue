<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Front Line Advisory Group</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <button type="submit">Sign in</button>
    </form>
    <router-link :to="{ name: 'register' }" class="newAccount">Need an account?</router-link>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

* {
  font-family: Arial, Helvetica, sans-serif;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  background-color: #ffffff;
}

#login{
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
  box-shadow: 0px 0px 4px #043464;
  /* background-color: #3c99dc; */
}

#login  h1 {
  display: flex;
  justify-content: center;
  padding: 25px 0 25px 25px;
  font-size: 2.3rem;
}

#login label {
  display: flex;
  justify-content: center;
  padding: 5px;
}

#username, #password {
  display: flex;
  justify-content: center;
  border-radius: 5px;
  box-shadow: 0px 0px 4px #043464;
  background-color: white;
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
  background: #04346435;
}
#password:focus{
  background: #04346435;
}

form button {
  background-color: #043464;
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

.newAccount {
  text-decoration: none;
  display: flex;
  justify-content: center;
  padding-top: 25px;
  color: #000000;
  }

.newAccount:hover {
  color: #acaeaf;
}

.alert-danger {
  color: black;
  font-weight: bolder;
  display: flex;
  justify-content: center;
}

</style>