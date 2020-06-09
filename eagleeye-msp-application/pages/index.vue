<template>
  <v-container>
    <h1>{{ title }}</h1>
    <p>
      Welcome to the EagleEYE MSP Application. The tool to generate quotes for
      our customers.
    </p>
    <h2>Get started</h2>
    <v-list dense>
      <v-list-item>
        <v-btn to="/quotes" color="primary">Create a quote</v-btn>
      </v-list-item>
      <v-list-item>
        <v-btn to="/customers/create" color="primary">Add a Customer</v-btn>
      </v-list-item>
      <v-list-item>
        <v-btn to="/employees/create" color="primary">Add an Employee</v-btn>
      </v-list-item>
    </v-list>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      title: 'Home'
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
