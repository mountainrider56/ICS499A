<template>
  <v-container>
    <h1>{{ title }}</h1>
    <p>
      Welcome to the EagleEYE MSP Application.
    </p>
    <v-form>
      <v-text-field
        v-model="login.username"
        label="Username"
        autofocus
      ></v-text-field>
      <v-text-field
        v-model="login.password"
        label="password"
        :type="form.password.show ? 'text' : 'password'"
        counter
        :append-icon="form.password.show ? 'mdi-eye' : 'mdi-eye-off'"
        @click:append="form.password.show = !form.password.show"
      ></v-text-field>
      <v-btn class="mt-6" color="primary" @click.once.prevent="userLogin()">
        Login
      </v-btn>
    </v-form>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      title: 'Login',
      login: {
        username: '',
        password: ''
      },
      form: {
        password: {
          show: false
        }
      }
    }
  },
  methods: {
    async userLogin() {
      try {
        const response = await this.$auth.loginWith('local', {
          data: this.login
        })
        console.log(response.data)
      } catch (err) {
        console.log(err)
      }
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
