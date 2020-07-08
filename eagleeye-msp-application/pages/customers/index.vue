<template>
  <v-container>
    <v-alert v-if="successAlert" class="mt-7 mb-7" type="success" outlined>
      Successfully deleted customer.
    </v-alert>
    <h1>{{ title }}</h1>
    <v-btn small to="/customers/create" color="primary">+ Add a Customer</v-btn>
    <v-data-iterator :items="customers" :items-per-page.sync="itemsPerPage">
      <template v-slot:default="props">
        <v-row>
          <v-col v-for="item in props.items" :key="item.id" lg="3">
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
  async asyncData({ $customerApi }) {
    const customers = await $customerApi.getCustomers()
    return { customers }
  },
  data() {
    return {
      title: 'View all Customers',
      itemsPerPage: 5,
      successAlert: false
    }
  },
  mounted() {
    this.successAlert = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
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
