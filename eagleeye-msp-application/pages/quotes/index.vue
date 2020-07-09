<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-btn small to="/quotes/create" color="primary">Create a Quote</v-btn>
    <v-data-iterator :items="quotes" :items-per-page.sync="itemsPerPage">
      <template v-slot:default="props">
        <v-row>
          <v-col v-for="item in props.items" :key="item.id" lg="3">
            <v-card :to="getQuoteDetailLink(item.id)">
              <v-card-title class="subheading font-weight-bold">
                {{ customers[item.customerId].name }}
              </v-card-title>
              <v-divider></v-divider>
              <v-list dense>
                <v-list-item>
                  <v-list-item-content>Total:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.total }}
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-card>
          </v-col>
        </v-row>
      </template>
    </v-data-iterator>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $quoteApi, $customerApi }) {
    const quotes = await $quoteApi.getQuotes()
    const customers = await $customerApi.getCustomersIdAndName()
    return { quotes, customers }
  },
  data() {
    return {
      title: 'View all Quotes',
      itemsPerPage: 5
    }
  },
  methods: {
    getQuoteDetailLink(id) {
      return `/quotes/detail?id=${id}`
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
