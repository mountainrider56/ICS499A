<template>
  <v-container>
    <v-alert v-if="success" class="mt-7 mb-7" type="success" outlined>
      Successfully saved customer.
    </v-alert>
    <h1>{{ name }}</h1>
    <CustomerForm ref="customerForm" :states="states" :customer="customer">
      <v-btn class="mt-6 mr-3" color="primary" @click.stop.prevent="submit()">
        Update
      </v-btn>
      <v-btn class="mt-6" color="secondary">Create a quote</v-btn>
    </CustomerForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $customerApi, route }) {
    const states = await $customerApi.getStates()
    const customer = await $customerApi.getCustomer(route.query.id)
    return { customer, states }
  },
  data() {
    return {
      title: 'Edit a Customer',
      name: '',
      success: false
    }
  },
  mounted() {
    this.name = this.customer.name
    this.success = this.$route.query.success
    const query = Object.assign({}, this.$route.query)
    delete query.success
    this.$router.replace({ query }).catch(() => {})
  },
  methods: {
    async submit() {
      const data = await this.$refs.customerForm.submit()
      if (data) {
        this.name = this.customer.name
        this.success = true
        window.scrollTo(0, 0)
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
