<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-btn small to="/customers/create" color="primary">+ Add a Customer</v-btn>
    <v-data-iterator :items="customers" :items-per-page.sync="itemsPerPage">
      <template v-slot:default="props">
        <v-row>
          <v-col v-for="item in props.items" :key="item.name" lg="3">
            <v-card :to="getCustomerDetailLink(item.id)">
              <v-card-title class="subheading font-weight-bold">
                {{ item.name }}
              </v-card-title>
              <v-divider></v-divider>
              <v-list dense>
                <v-list-item>
                  <v-list-item-content>Telephone:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.telephone }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>Address1:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.address1 }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>Address2:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.address2 }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>City:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.city }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>Zipcode:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.zipcode }}
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
  async asyncData({ $axios }) {
    const customers = await $axios.$get('/api/eagleeye-msp/v1/customers')
    return { customers }
  },
  data() {
    return {
      title: 'Customers',
      itemsPerPage: 5
    }
  },
  methods: {
    getCustomerDetailLink(id) {
      return `/customers/detail?id=${id}`
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
