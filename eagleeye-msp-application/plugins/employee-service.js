export default (context, inject) => {
  const employeeApi = {
    async getSecurityRoles() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/employees/security-roles')
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to get valid security roles.'
          })
        })
    },
    async getEmployee(id) {
      return await context.$axios
        .$get(`/api/eagleeye-msp/v1/employees/${id}`)
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: `Unable to get employee: ${id}.`
          })
        })
    },
    async getEmployees() {
      return await context.$axios
        .$get('/api/eagleeye-msp/v1/employees')
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to get employees.'
          })
        })
    },
    async saveEmployee(employee) {
      return await context.$axios
        .$put('/api/eagleeye-msp/v1/employees', employee)
        .then((response) => {
          return response
        })
        .catch((e) => {
          if (e.response.status === 400) {
            return e.response.data
          }
          context.error({
            statusCode: e.response.status,
            message: 'Unable to save employee.'
          })
        })
    },
    async deleteEmployee(id) {
      return await context.$axios
        .$delete(`/api/eagleeye-msp/v1/employees/${id}`)
        .then((response) => {
          return response
        })
        .catch((e) => {
          context.error({
            statusCode: e.response.status,
            message: 'Unable to delete employee.'
          })
        })
    }
  }
  inject('employeeApi', employeeApi)
  context.$employeeApi = employeeApi
}
