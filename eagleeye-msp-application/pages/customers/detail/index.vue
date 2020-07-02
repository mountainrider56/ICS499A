<template>
  <v-container>
    <h1>{{ customer.name }}</h1>
    <v-text-field label="Name" outlined :value="customer.name"></v-text-field>
    <v-text-field
      label="Telephone"
      outlined
      :value="customer.telephone"
    ></v-text-field>
    <v-text-field
      label="Address 1"
      outlined
      :value="customer.address1"
    ></v-text-field>
    <v-text-field
      label="Address 2"
      outlined
      :value="customer.address2"
    ></v-text-field>
    <v-text-field label="City" outlined :value="customer.city"></v-text-field>
    <v-text-field label="State" outlined :value="customer.state"></v-text-field>
    <v-text-field
      label="Zipcode"
      outlined
      :value="customer.zipcode"
    ></v-text-field>
    <v-btn color="primary">Update</v-btn>
    <v-btn color="secondary">Create a quote</v-btn>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $axios, route }) {
    const customer = await $axios.$get(
      `/api/eagleeye-msp/v1/customers/${route.query.id}`
    )
    return { customer }
  },
  data() {
    return {
      title: 'Customer'
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
