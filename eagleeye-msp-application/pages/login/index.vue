<template>
  <v-container>
    <h1>{{ title }}</h1>
    <p>
      Welcome to the EagleEYE MSP Application.
    </p>
    <v-form>
      <v-text-field
        v-model="username"
        label="Username"
        autofocus
      ></v-text-field>
      <v-text-field
        v-model="password"
        label="password"
        type="password"
      ></v-text-field>
      <v-btn class="mt-6" color="primary">
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
      username: '',
      password: ''
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
