<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-text-field label="First Name" outlined></v-text-field>
    <v-text-field label="Last Name" outlined></v-text-field>
    <v-text-field label="Email" outlined></v-text-field>
    <v-select :items="securityRoles" label="Security Role" outlined></v-select>
    <v-text-field label="Password" outlined></v-text-field>
    <v-btn color="primary">Add</v-btn>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $axios }) {
    const securityRoles = await $axios.$get(
      '/api/eagleeye-msp/v1/employees/security-roles'
    )
    return { securityRoles }
  },
  data() {
    return {
      title: 'Add an Employee'
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
