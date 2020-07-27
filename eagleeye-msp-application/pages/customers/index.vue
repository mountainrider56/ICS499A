<template>
  <v-container>
    <v-alert v-if="successAlert" class="mt-7 mb-7" type="success" outlined>
      Successfully deleted customer.
    </v-alert>
    <h1>{{ title }}</h1>
    <v-btn to="/customers/create" class="mt-6" color="primary">
      Add a Customer
    </v-btn>
    <Datatable
      class="mt-8"
      :items="customers"
      :datatable="datatable"
      :handle-row-click="handleRowClick"
    ></Datatable>
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
      successAlert: false,
      datatable: {
        headers: [
          {
            text: 'Name',
            align: 'left',
            value: 'name'
          },
          {
            text: 'Telephone',
            align: 'left',
            value: 'telephone'
          },
          {
            text: 'Email',
            align: 'left',
            value: 'email'
          },
          {
            text: 'Address',
            align: 'left',
            value: 'address1'
          },
          {
            text: 'Address 2',
            align: 'left',
            value: 'address2'
          },
          {
            text: 'City',
            align: 'left',
            value: 'city'
          },
          {
            text: 'State',
            align: 'left',
            value: 'state'
          },
          {
            text: 'Zipcode',
            align: 'left',
            value: 'zipcode'
          },
          {
            text: 'Actions',
            value: 'actions',
            sortable: false
          }
        ],
        sortBy: 'name'
      }
    }
  },
  mounted() {
    this.successAlert = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
  },
  methods: {
    handleRowClick(event) {
      this.$router.push({
        path: '/customers/detail',
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
