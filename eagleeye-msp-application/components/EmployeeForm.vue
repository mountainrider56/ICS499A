<template>
  <v-form>
    <v-text-field
      v-model="employee.username"
      :error="!errors.employee.username.valid"
      :error-messages="errors.employee.username.message"
      label="Username"
      autofocus
    ></v-text-field>
    <v-text-field
      v-model="employee.firstName"
      :error="!errors.employee.firstName.valid"
      :error-messages="errors.employee.firstName.message"
      label="First Name"
    ></v-text-field>
    <v-text-field
      v-model="employee.lastName"
      :error="!errors.employee.lastName.valid"
      :error-messages="errors.employee.lastName.message"
      label="Last Name"
    ></v-text-field>
    <v-text-field
      v-model="employee.email"
      :error="!errors.employee.email.valid"
      :error-messages="errors.employee.email.message"
      label="Email"
    ></v-text-field>
    <v-radio-group
      v-model="employee.securityRole"
      label="Security Role"
      :error="!errors.employee.securityRole.valid"
      :error-messages="errors.employee.securityRole.message"
    >
      <v-radio
        v-for="role in securityRoles"
        :key="role"
        :label="role"
        :value="role"
      ></v-radio>
    </v-radio-group>
    <v-text-field
      v-model="employee.password"
      :error="!errors.employee.password.valid"
      :error-messages="errors.employee.password.message"
      label="Password"
      type="password"
    ></v-text-field>

    <slot />
  </v-form>
</template>

<script>
const defaults = {
  getNoErrors() {
    return {
      employee: {
        username: {
          valid: true,
          message: ''
        },
        firstName: {
          valid: true,
          message: ''
        },
        lastName: {
          valid: true,
          message: ''
        },
        email: {
          valid: true,
          message: ''
        },
        securityRole: {
          valid: true,
          message: ''
        },
        password: {
          valid: true,
          message: ''
        }
      }
    }
  }
}

export default {
  props: {
    securityRoles: {
      type: Array,
      required: true
    },
    employee: {
      type: Object,
      default() {
        return {
          username: '',
          firstName: '',
          lastName: '',
          email: '',
          securityRole: 'USER',
          password: ''
        }
      }
    }
  },
  data() {
    return {
      errors: defaults.getNoErrors()
    }
  },
  methods: {
    resetErrors() {
      this.errors = defaults.getNoErrors()
    },
    async submit() {
      this.resetErrors()
      const data = await this.$employeeApi.saveEmployee(this.employee)
      if (!data.id) {
        Object.keys(data).map((i) => {
          const field = i
            .split('.')
            .reduce((a, b) => a[b], this.errors.employee)
          field.valid = false
          field.message = data[i]
        })
        return null
      } else {
        return data
      }
    }
  }
}
</script>
