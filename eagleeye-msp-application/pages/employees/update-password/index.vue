<template>
  <v-container>
    <h1>{{ title }} for {{ name }}</h1>
    <EmployeeForm
      ref="employeeForm"
      :security-roles="securityRoles"
      :account-statuses="accountStatuses"
      :employee="employee"
      :password="true"
    >
      <v-btn
        type="submit"
        class="mt-6 mr-3"
        color="primary"
        @click.stop.prevent="submit()"
      >
        Update
      </v-btn>
      <v-btn class="mt-6" outlined exact @click.stop.prevent="cancel()">
        Cancel
      </v-btn>
    </EmployeeForm>
  </v-container>
</template>

<script>
export default {
  middleware: ['must-be-self-or-admin'],
  async asyncData({ $employeeApi, route }) {
    const securityRoles = await $employeeApi.getSecurityRoles()
    const accountStatuses = await $employeeApi.getAccountStatuses()
    const employee = await $employeeApi.getEmployee(route.query.id)
    employee.password = null
    employee.password2 = null
    return { securityRoles, accountStatuses, employee }
  },
  data() {
    return {
      title: 'Update password'
    }
  },
  computed: {
    name() {
      return `${this.employee.firstName} ${this.employee.lastName}`
    }
  },
  methods: {
    async submit() {
      const data = await this.$refs.employeeForm.submit('saveEmployee')
      if (data) {
        this.$router.push({
          path: '/employees/detail',
          query: { id: data.id, success: true }
        })
      }
    },
    cancel() {
      this.$router.push({
        path: '/employees/detail',
        query: { id: this.employee.id }
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
