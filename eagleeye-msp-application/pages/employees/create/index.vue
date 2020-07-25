<template>
  <v-container>
    <h1>{{ title }}</h1>
    <EmployeeForm ref="employeeForm" :security-roles="securityRoles">
      <v-btn color="primary" class="mt-6" @click.stop.prevent="submit()">
        Add
      </v-btn>
    </EmployeeForm>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $employeeApi }) {
    const securityRoles = await $employeeApi.getSecurityRoles()
    return { securityRoles }
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
