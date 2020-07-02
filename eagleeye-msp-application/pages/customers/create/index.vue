<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-text-field label="Name" outlined></v-text-field>
    <v-text-field label="Telephone" outlined></v-text-field>
    <v-text-field label="Address 1" outlined></v-text-field>
    <v-text-field label="Address 2" outlined></v-text-field>
    <v-text-field label="City" outlined></v-text-field>
    <v-text-field label="State" outlined></v-text-field>
    <v-text-field label="Zipcode" outlined></v-text-field>
    <v-btn color="primary">Add</v-btn>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      title: 'Add a Customer'
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
