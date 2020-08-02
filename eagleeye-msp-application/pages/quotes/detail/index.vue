<template>
  <v-container>
    <v-alert v-if="success" class="mt-7 mb-7" type="success" outlined>
      Successfully saved quote.
    </v-alert>
    <h1>{{ title }} for {{ customer.name }}</h1>
    <DownloadPdf
      class="mt-6"
      :download-pdf="downloadPdf"
      :view-pdf="viewPdf"
    ></DownloadPdf>
    <QuoteForm ref="quoteForm" class="mt-6" :services="services" :quote="quote">
      <v-btn
        type="submit"
        class="mt-6 mr-3"
        color="primary"
        @click.stop.prevent="submit()"
      >
        Update
      </v-btn>
      <v-btn class="mt-6" outlined to="/quotes" exact>
        Cancel
      </v-btn>
      <DownloadPdf
        class="float-right mt-6"
        :download-pdf="downloadPdf"
        :view-pdf="viewPdf"
      ></DownloadPdf>
    </QuoteForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $quoteApi, $customerApi, route }) {
    const services = await $quoteApi.getServices()
    const quote = await $quoteApi.getQuote(route.query.id)
    const customer = await $customerApi.getCustomer(quote.customerId)
    quote.customerId = customer.id
    return {
      quote,
      customer,
      services
    }
  },
  data() {
    return {
      title: 'Quote details',
      success: false
    }
  },
  mounted() {
    this.success = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
  },
  methods: {
    async submit() {
      this.success = false
      await this.$refs.quoteForm.submit()
      this.success = true
      window.scrollTo(0, 0)
    },
    viewPdf() {
      this.$quoteApi.getQuotePdf(this.quote.id)
    },
    downloadPdf() {
      this.$quoteApi.downloadPdf(this.quote.id, this.customer.name)
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
