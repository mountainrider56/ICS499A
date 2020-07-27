export default (context, inject) => {
  const quoteApi = {
    async getQuote(id) {
      return await context.$axios
        .$get(`/api/eagleeye-msp/v1/quotes/${id}`)
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: `Unable to get quote: ${id}.`
          })
        })
    },
    async getQuoteIdByCustomer(id) {
      return await context.$axios
        .$get(`/api/eagleeye-msp/v1/quotes/customers/${id}`)
        .then((response) => {
          return response
        })
        .catch((e) => {
          if (e.response.status === 404) {
            return null
          }
          context.error({
            statusCode: e.response.status,
            message: `Unable to get quote: ${id}.`
          })
        })
    },
    async saveQuote(quote) {
      return await context.$axios
        .$put('/api/eagleeye-msp/v1/quotes', quote)
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to save quote.'
          })
        })
    },
    async downloadPdf(id, name) {
      return await context
        .$axios({
          method: 'get',
          url: `/api/eagleeye-msp/v1/quotes/${id}/files/pdf`,
          responseType: 'blob'
        })
        .then((response) => {
          const file = new Blob([response.data], { type: 'application/pdf' })
          const link = document.createElement('a')
          link.href = window.URL.createObjectURL(file)
          link.download = `${name}.pdf`
          link.click()
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: `Unable to generate PDF for quote: ${id}.`
          })
        })
    },
    async getQuotePdf(id) {
      return await context
        .$axios({
          method: 'get',
          url: `/api/eagleeye-msp/v1/quotes/${id}/files/pdf`,
          responseType: 'blob'
        })
        .then((response) => {
          const file = new Blob([response.data], { type: 'application/pdf' })
          const fileURL = URL.createObjectURL(file)
          window.open(fileURL)
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: `Unable to generate PDF for quote: ${id}.`
          })
        })
    },
    async getQuotes() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/quotes')
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to get quotes.'
          })
        })
    },
    async getServices() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/quotes/services')
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to get pc management services.'
          })
        })
    },
    async getSelections() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/quotes/services/selections')
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to get pc management selections.'
          })
        })
    }
  }
  inject('quoteApi', quoteApi)
  context.$quoteApi = quoteApi
}
