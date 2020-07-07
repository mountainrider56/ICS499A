<template>
  <v-container>
    <v-alert v-if="success" class="mt-7 mb-7" type="success" outlined>
      Successfully saved employee.
    </v-alert>
    <h1>{{ displayName }}</h1>
    <EmployeeForm
      ref="employeeForm"
      :security-roles="securityRoles"
      :employee="employee"
    >
      <v-btn class="mt-6" color="primary" @click.stop.prevent="submit()">
        Update
      </v-btn>
      <v-btn class="mt-6 float-right" @click="deleteEmployee()">Delete</v-btn>
    </EmployeeForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $employeeApi, route }) {
    const securityRoles = await $employeeApi.getSecurityRoles()
    const employee = await $employeeApi.getEmployee(route.query.id)
    return { securityRoles, employee }
  },
  data() {
    return {
      title: 'Edit a Employee',
      displayName: '',
      success: false
    }
  },
  computed: {
    name() {
      return `${this.employee.firstName} ${this.employee.lastName}`
    }
  },
  mounted() {
    this.displayName = this.name
    this.success = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
  },
  methods: {
    async submit() {
      const data = await this.$refs.employeeForm.submit()
      if (data) {
        this.displayName = this.name
        this.success = true
        window.scrollTo(0, 0)
      }
    },
    async deleteEmployee() {
      const data = await this.$employeeApi.deleteEmployee(this.employee.id)
      if (data) {
        this.$router.push({
          path: '/employees',
          query: { success: true }
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
