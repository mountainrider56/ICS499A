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
    async getPcManagmentServices() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/quotes/management/pc/services')
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
    async getPcManagmentEmptySelections() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/quotes/management/pc/selections')
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
