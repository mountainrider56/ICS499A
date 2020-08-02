<template>
  <v-container>
    <h1>{{ title }}</h1>
    <EmployeeForm
      ref="employeeForm"
      :security-roles="securityRoles"
      :account-statuses="accountStatuses"
    >
      <v-btn
        type="submit"
        color="primary"
        class="mt-6 mr-3"
        @click.stop.prevent="submit()"
      >
        Add
      </v-btn>
      <v-btn class="mt-6" outlined to="/employees" exact>
        Cancel
      </v-btn>
    </EmployeeForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $employeeApi }) {
    const securityRoles = await $employeeApi.getSecurityRoles()
    const accountStatuses = await $employeeApi.getAccountStatuses()
    return { securityRoles, accountStatuses }
  },
  data() {
    return {
      title: 'Add a Employee'
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
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
