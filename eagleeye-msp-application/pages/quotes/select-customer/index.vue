<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-autocomplete
      v-model="id"
      :items="customers"
      item-text="name"
      item-value="id"
      :error-messages="error.message"
      dense
      filled
      class="mt-3"
      label="Select Customer"
    >
    </v-autocomplete>
    <v-btn class="mt-6 mr-3" color="primary" @click.stop.prevent="select()">
      Select
    </v-btn>
    <v-btn class="mt-6" outlined to="/quotes" exact>
      Cancel
    </v-btn>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $axios, $customerApi }) {
    const customers = await $customerApi.getCustomersIdAndNameList()
    return { customers }
  },
  data() {
    return {
      title: 'Select a customer',
      id: null,
      error: {
        message: ''
      }
    }
  },
  methods: {
    async select() {
      this.error.message = ''
      if (this.id === null) {
        this.error.message = 'Please select a customer'
      } else {
        const data = await this.$quoteApi.getQuoteIdByCustomer(this.id)
        if (data === null) {
          this.$router.push({
            path: '/quotes/create',
            query: { customerId: this.id }
          })
        } else {
          this.$router.push({
            path: '/quotes/detail',
            query: { id: data }
          })
        }
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
