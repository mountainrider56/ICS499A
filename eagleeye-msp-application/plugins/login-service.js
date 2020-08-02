export default (context, inject) => {
  const loginApi = {
    async pingSession() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/employees/login/ping')
        .then((response) => {
          return response
        })
        .catch((e) => {
          return false
        })
    },
    async getSession() {
      return await context.$axios.$get('/api/eagleeye-msp/v1/employees/login')
    }
  }
  inject('loginApi', loginApi)
  context.$loginApi = loginApi
}
