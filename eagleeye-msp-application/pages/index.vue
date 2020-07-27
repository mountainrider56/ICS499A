<template>
  <v-container>
    <h1>{{ title }}</h1>
    <p>
      Welcome to the EagleEYE MSP Application. The tool to generate quotes for
      our customers.
    </p>
    <h2 class="mb-3">Get started</h2>
    <v-btn to="/quotes/select-customer" class="mr-3" outlined color="primary">
      Create a quote
    </v-btn>
    <v-btn to="/customers/create" class="mr-3" outlined color="primary">
      Add a Customer
    </v-btn>
    <v-btn to="/employees/create" class="mr-3" outlined color="primary">
      Add an Employee
    </v-btn>
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
