<template>
  <v-container>
    <v-alert v-if="success" class="mt-7 mb-7" type="success" outlined>
      Successfully saved employee.
    </v-alert>
    <v-alert v-if="fail" class="mt-7 mb-7" type="error" outlined>
      {{ modal.fail.message }}
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
      <DeleteModal ref="deleteModal" type="employee" :callback="deleteEmployee">
      </DeleteModal>
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
      success: false,
      fail: false,
      modal: {
        fail: {
          message: '',
          delete: {
            message: 'Unable to delete employee.'
          },
          update: {
            message: 'Unable to save employee.'
          }
        }
      }
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
      this.reset()
      if (data) {
        this.displayName = this.name
        this.success = true
      } else {
        this.fail = true
        this.modal.fail.message = this.modal.fail.update.message
      }
      window.scrollTo(0, 0)
    },
    async deleteEmployee() {
      const data = await this.$employeeApi.deleteEmployee(this.employee.id)
      this.reset()
      if (data) {
        this.$router.push({
          path: '/employees',
          query: { success: true }
        })
      } else {
        this.$refs.deleteModal.dialog = false
        this.fail = true
        this.modal.fail.message = this.modal.fail.delete.message
        window.scrollTo(0, 0)
      }
    },
    reset() {
      this.success = false
      this.fail = false
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
