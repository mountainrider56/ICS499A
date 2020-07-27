<template>
  <v-container>
    <v-alert v-if="successAlert" class="mt-7 mb-7" type="success" outlined>
      Successfully deleted employee.
    </v-alert>
    <h1>{{ title }}</h1>
    <v-btn class="mt-6" to="/employees/create" color="primary">
      Add an Employee
    </v-btn>
    <Datatable
      class="mt-8"
      :items="employees"
      :datatable="datatable"
      :handle-row-click="handleRowClick"
    ></Datatable>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $employeeApi }) {
    const employees = await $employeeApi.getEmployees()
    return { employees }
  },
  data() {
    return {
      title: 'View all Employees',
      successAlert: false,
      datatable: {
        headers: [
          {
            text: 'Username',
            align: 'left',
            value: 'username'
          },
          {
            text: 'First name',
            align: 'left',
            value: 'firstName'
          },
          {
            text: 'Last name',
            align: 'left',
            value: 'lastName'
          },
          {
            text: 'Email',
            align: 'left',
            value: 'email'
          },
          {
            text: 'Security Role',
            align: 'left',
            value: 'securityRole'
          },
          {
            text: 'Actions',
            value: 'actions',
            sortable: false
          }
        ],
        sortBy: 'username'
      }
    }
  },
  mounted() {
    this.successAlert = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
  },
  methods: {
    handleRowClick(event) {
      this.$router.push({
        path: '/employees/detail',
        query: { id: event.id }
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
