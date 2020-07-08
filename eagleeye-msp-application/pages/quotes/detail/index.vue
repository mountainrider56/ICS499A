<template>
  <v-container>
    <h1>{{ title }}</h1>
    <h2 class="mt-8">PC Management</h2>
    <div v-for="i in pcManagementServicesKeys" :key="i" class="mt-6">
      <v-row align="center">
        <v-col class="pt-0 pb-0" :cols="1">
          <v-text-field
            v-if="priceExists(pcManagementServices[i])"
            v-model="selections[i].quantity"
            type="number"
            label="Quantity"
            dense
          />
        </v-col>
        <v-col class="pt-3" :cols="3">
          <h3>{{ pcManagementServices[i].name }}</h3>
        </v-col>
        <v-col class="pt-3" :cols="3">
          <div v-if="priceExists(pcManagementServices[i])">
            Price: ${{ pcManagementServices[i].price }} x per workstation
          </div>
        </v-col>
        <v-col class="pt-3" :cols="3">
          <div v-if="priceExists(pcManagementServices[i])">
            Subtotal: ${{ getSubTotal(pcManagementServices[i]) }}
          </div>
        </v-col>
      </v-row>
      <v-row
        v-for="(ii, iiIndex) in pcManagementServices[i].breakdowns"
        :key="iiIndex"
        align="center"
      >
        <v-col class="pt-0 pb-0" :cols="1">
          <v-text-field
            v-if="priceExists(ii)"
            v-model="selections[ii.id].quantity"
            type="number"
            label="Quantity"
            dense
          />
        </v-col>
        <v-col class="pt-3" :cols="3">
          <div>{{ ii.name }}</div>
        </v-col>
        <v-col class="pt-3" :cols="3">
          <div v-if="priceExists(ii)">
            Price: ${{ ii.price }} x per workstation
          </div>
        </v-col>
        <v-col class="pt-3" :cols="3">
          <div v-if="ii.price > 0">Subtotal: ${{ getSubTotal(ii) }}</div>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $quoteApi, $customerApi, route }) {
    const pcManagementServices = await $quoteApi.getPcManagmentServices()
    const selections = await $quoteApi.getPcManagmentEmptySelections()
    const pcManagementServicesKeys = Object.keys(pcManagementServices)
    const quotes = await $quoteApi.getQuote(route.query.id)
    const customer = await $customerApi.getCustomer(route.query.id)
    return {
      quotes,
      customer,
      selections,
      pcManagementServices,
      pcManagementServicesKeys
    }
  },
  data() {
    return {
      title: 'Quote'
    }
  },
  methods: {
    priceExists(service) {
      return service.price > 0
    },
    getSubTotal(service) {
      const selection = this.selections[service.id]
      return service.price * selection.quantity
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
