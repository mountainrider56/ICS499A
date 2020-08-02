<template>
  <v-container>
    <h1>{{ title }} for {{ customer.name }}</h1>
    <QuoteForm ref="quoteForm" :services="services" :quote="quote">
      <v-btn
        type="submit"
        color="primary"
        class="mt-6 mr-3"
        @click.stop.prevent="submit()"
      >
        Add
      </v-btn>
      <v-btn class="mt-6" outlined to="/quotes" exact>
        Cancel
      </v-btn>
    </QuoteForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $quoteApi, $customerApi, route }) {
    const customer = await $customerApi.getCustomer(route.query.customerId)
    const services = await $quoteApi.getServices()
    const quote = {
      selections: {},
      customerId: customer.id
    }
    for (const id in services) {
      quote.selections[id] = { quantity: 0 }
    }
    return {
      customer,
      services,
      quote
    }
  },
  data() {
    return {
      title: 'Create a Quote',
      client: {}
    }
  },
  methods: {
    async submit() {
      const data = await this.$refs.quoteForm.submit()
      if (data) {
        this.$router.push({
          path: '/quotes/detail',
          query: { id: data.id, success: true }
        })
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
