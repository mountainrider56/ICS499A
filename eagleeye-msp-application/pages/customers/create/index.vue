<template>
  <v-container>
    <h1>{{ title }}</h1>
    <CustomerForm ref="customerForm" :states="states">
      <v-btn
        type="submit"
        color="primary"
        class="mt-6 mr-3"
        @click.stop.prevent="submit()"
      >
        Add
      </v-btn>
      <v-btn class="mt-6" outlined to="/customers" exact>
        Cancel
      </v-btn>
    </CustomerForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $customerApi, route }) {
    const states = await $customerApi.getStates()
    return { states }
  },
  data() {
    return {
      title: 'Add a Customer'
    }
  },
  methods: {
    async submit() {
      const data = await this.$refs.customerForm.submit()
      if (data) {
        this.$router.push({
          path: '/customers/detail',
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
