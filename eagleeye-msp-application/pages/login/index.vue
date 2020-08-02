<template>
  <v-container>
    <h1>{{ title }}</h1>
    <p>
      Welcome to the EagleEYE MSP Application.
    </p>
    <v-alert v-if="alert.fail.show" class="mt-7 mb-7" type="error" outlined>
      {{ alert.fail.message }}
    </v-alert>
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
      <v-btn
        type="submit"
        class="mt-6"
        color="primary"
        @click.stop.prevent="userLogin()"
      >
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
      alert: {
        fail: {
          show: false,
          message: ''
        }
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
        await this.$auth.loginWith('local', {
          data: this.login
        })
      } catch (err) {
        this.alert.fail.show = true
        this.alert.fail.message = err.response.data.message
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
