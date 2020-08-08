<template>
  <v-container>
    <v-alert v-if="success" class="mt-7 mb-7" type="success" outlined>
      Successfully saved employee.
    </v-alert>
    <v-alert v-if="fail" class="mt-7 mb-7" type="error" outlined>
      {{ alert.fail.message }}
    </v-alert>
    <h1>{{ display }}</h1>
    <EmployeeForm
      ref="employeeForm"
      :security-roles="securityRoles"
      :account-statuses="accountStatuses"
      :employee="employee"
      :edit="true"
    >
      <v-btn
        type="submit"
        class="mt-6 mr-3"
        color="primary"
        @click.stop.prevent="submit()"
      >
        Update
      </v-btn>
      <v-btn
        class="mt-6 mr-3"
        color="secondary"
        @click.stop.prevent="navigateToUpdatePasswordPage()"
      >
        Update password
      </v-btn>
      <v-btn class="mt-6" outlined to="/employees" exact>
        Cancel
      </v-btn>
      <DeleteModal
        ref="deleteModal"
        :message="modal.delete.message"
        :callback="deleteEmployee"
      >
      </DeleteModal>
    </EmployeeForm>
  </v-container>
</template>

<script>
export default {
  watchQuery: ['id'],
  middleware: ['must-be-self-or-admin'],
  async asyncData({ $employeeApi, route, $userFlags, $route }) {
    const securityRoles = await $employeeApi.getSecurityRoles()
    const accountStatuses = await $employeeApi.getAccountStatuses()
    const employee = await $employeeApi.getEmployee(route.query.id)
    const display = `${employee.firstName} ${employee.lastName}`
    return { securityRoles, accountStatuses, employee, display }
  },
  data() {
    return {
      title: 'Edit a Employee',
      display: '',
      success: false,
      fail: false,
      alert: {
        fail: {
          message: '',
          delete: {
            message: 'Unable to delete employee.'
          },
          update: {
            message: 'Unable to save employee.'
          }
        }
      },
      modal: {
        delete: {
          message:
            'This will permanently delete this employee. This cannot be undone.'
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
    this.display = this.name
    this.success = this.$route.query.success
    this.$routeUtils.removeQueryParam(this, 'success')
  },
  methods: {
    async submit() {
      const data = await this.$refs.employeeForm.submit('updateEmployee')
      this.reset()
      if (data) {
        this.display = this.name
        this.success = true
      } else {
        this.fail = true
        this.alert.fail.message = this.alert.fail.update.message
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
        this.alert.fail.message = this.alert.fail.delete.message
        window.scrollTo(0, 0)
      }
    },
    reset() {
      this.success = false
      this.fail = false
    },
    navigateToUpdatePasswordPage() {
      this.$router.push({
        path: '/employees/update-password',
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
