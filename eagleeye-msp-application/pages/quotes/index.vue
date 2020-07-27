<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-btn class="mt-6" to="/quotes/select-customer" color="primary">
      Create a Quote
    </v-btn>
    <Datatable
      class="mt-8"
      :items="quotes"
      :datatable="datatable"
      :handle-row-click="handleRowClick"
    ></Datatable>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $quoteApi, $customerApi }) {
    const quotes = await $quoteApi.getQuotes()
    const customers = await $customerApi.getCustomersIdAndNameMap()
    for (const id in quotes) {
      const item = quotes[id]
      item.fixedTotal = `$${item.total.toFixed(2)}`
      item.customerName = customers[item.customerId].name
    }
    return { quotes, customers }
  },
  data() {
    return {
      title: 'View all Quotes',
      datatable: {
        headers: [
          {
            text: 'Customer',
            align: 'left',
            value: 'customerName'
          },
          {
            text: 'Total',
            align: 'left',
            value: 'fixedTotal'
          },
          {
            text: 'Actions',
            value: 'actions',
            sortable: false
          }
        ],
        sortBy: 'customerName'
      }
    }
  },
  methods: {
    handleRowClick(event) {
      this.$router.push({
        path: '/quotes/detail',
        query: { id: event.id }
      })
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
