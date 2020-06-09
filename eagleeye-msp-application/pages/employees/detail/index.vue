<template>
  <v-container>
    <h1>{{ employee.firstName }} {{ employee.lastName }}</h1>
    <v-text-field
      label="First Name"
      outlined
      :value="employee.firstName"
    ></v-text-field>
    <v-text-field
      label="Last Name"
      outlined
      :value="employee.lastName"
    ></v-text-field>
    <v-text-field label="Email" outlined :value="employee.email"></v-text-field>
    <v-select
      :items="securityRoles"
      label="Security Role"
      outlined
      :value="employee.securityRole"
    ></v-select>
    <v-text-field
      label="Password"
      outlined
      :value="employee.password"
    ></v-text-field>
    <v-btn color="primary">Update</v-btn>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $axios, route }) {
    const securityRoles = await $axios.$get(
      '/api/eagleeye-msp/v1/employees/security-roles'
    )
    const employee = await $axios.$get(
      `/api/eagleeye-msp/v1/employees/${route.query.id}`
    )
    return { securityRoles, employee }
  },
  data() {
    return {
      title: 'Employee'
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
