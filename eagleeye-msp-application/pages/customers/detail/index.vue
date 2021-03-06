<template>
  <v-container>
    <v-alert v-if="success" class="mt-7 mb-7" type="success" outlined>
      Successfully saved customer.
    </v-alert>
    <v-alert v-if="fail" class="mt-7 mb-7" type="error" outlined>
      {{ alert.fail.message }}
    </v-alert>
    <h1>{{ name }}</h1>
    <CustomerForm ref="customerForm" :states="states" :customer="customer">
      <v-btn
        type="submit"
        class="mt-6 mr-3"
        color="primary"
        @click.stop.prevent="submit()"
      >
        Update
      </v-btn>
      <v-btn class="mt-6 mr-3" color="secondary" @click.prevent="selectQuote()">
        {{ quoteText }}
      </v-btn>
      <v-btn class="mt-6" outlined to="/customers" exact>
        Cancel
      </v-btn>
      <DeleteModal
        ref="deleteModal"
        :message="modal.delete.message"
        :callback="deleteCustomer"
      >
      </DeleteModal>
    </CustomerForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $customerApi, $quoteApi, route }) {
    const states = await $customerApi.getStates()
    const customer = await $customerApi.getCustomer(route.query.id)
    const quoteId = await $quoteApi.getQuoteIdByCustomer(customer.id)
    return { customer, states, quoteId }
  },
  data() {
    return {
      title: 'Edit a Customer',
      name: '',
      success: false,
      fail: false,
      alert: {
        fail: {
          message: '',
          delete: {
            message: 'Unable to delete customer.'
          },
          update: {
            message: 'Unable to save customer.'
          }
        }
      },
      modal: {
        delete: {
          message:
            'This will permanently delete this customer and its quote. This cannot be undone.'
        }
      }
    }
  },
  computed: {
    quoteText() {
      return this.quoteId ? 'Edit Quote' : 'Create a Quote'
    }
  },
  mounted() {
    this.name = this.customer.name
    this.success = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
  },
  methods: {
    async submit() {
      const data = await this.$refs.customerForm.submit()
      this.reset()
      if (data) {
        this.name = this.customer.name
        this.success = true
      } else {
        this.fail = true
        this.alert.fail.message = this.alert.fail.update.message
      }
      window.scrollTo(0, 0)
    },
    selectQuote() {
      if (this.quoteId === null) {
        this.$router.push({
          path: '/quotes/create',
          query: { customerId: this.customer.id }
        })
      } else {
        this.$router.push({
          path: '/quotes/detail',
          query: { id: this.quoteId }
        })
      }
    },
    async deleteCustomer() {
      const data = await this.$customerApi.deleteCustomer(this.customer.id)
      this.reset()
      if (data) {
        this.$router.push({
          path: '/customers',
          query: { success: true }
        })
      } else {
        this.$refs.deleteModal.dialog = false
        this.fail = true
        this.alert.fail.message = this.alert.fail.delete.message
        window.scrollTo(0, 0)
      }
    },
    reset() {
      this.success = false
      this.fail = false
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
