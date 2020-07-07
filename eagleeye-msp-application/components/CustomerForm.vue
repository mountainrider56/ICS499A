<template>
  <v-form>
    <h2 class="mt-6">General</h2>
    <v-text-field
      v-model="customer.name"
      :error="!errors.customer.name.valid"
      :error-messages="errors.customer.name.message"
      label="Name"
      autofocus
    ></v-text-field>
    <v-text-field
      v-model="customer.telephone"
      :error="!errors.customer.telephone.valid"
      :error-messages="errors.customer.telephone.message"
      label="Telephone"
    ></v-text-field>
    <v-text-field
      v-model="customer.email"
      :error="!errors.customer.email.valid"
      :error-messages="errors.customer.email.message"
      label="Email"
    ></v-text-field>

    <h2 class="mt-6">Address</h2>
    <v-text-field
      v-model="customer.address1"
      :error="!errors.customer.address1.valid"
      :error-messages="errors.customer.address1.message"
      label="Address 1"
    ></v-text-field>
    <v-text-field v-model="customer.address2" label="Address 2"></v-text-field>
    <v-text-field
      v-model="customer.city"
      :error="!errors.customer.city.valid"
      :error-messages="errors.customer.city.message"
      label="City"
    ></v-text-field>
    <v-radio-group
      v-model="customer.state"
      :error="!errors.customer.state.valid"
      :error-messages="errors.customer.state.message"
      label="State"
    >
      <v-radio
        v-for="state in states"
        :key="state"
        :label="state"
        :value="state"
      ></v-radio>
    </v-radio-group>

    <v-text-field
      v-model="customer.zipcode"
      :error="!errors.customer.zipcode.valid"
      :error-messages="errors.customer.zipcode.message"
      label="Zipcode"
    ></v-text-field>

    <h2 class="mt-6">Representative</h2>
    <v-text-field
      v-model="customer.representative.firstName"
      :error="!errors.customer.representative.firstName.valid"
      :error-messages="errors.customer.representative.firstName.message"
      label="First Name"
    ></v-text-field>
    <v-text-field
      v-model="customer.representative.lastName"
      :error="!errors.customer.representative.lastName.valid"
      :error-messages="errors.customer.representative.lastName.message"
      label="Last Name"
    ></v-text-field>
    <v-text-field
      v-model="customer.representative.telephone"
      :error="!errors.customer.representative.telephone.valid"
      :error-messages="errors.customer.representative.telephone.message"
      label="Telephone"
    ></v-text-field>
    <v-text-field
      v-model="customer.representative.email"
      :error="!errors.customer.representative.email.valid"
      :error-messages="errors.customer.representative.email.message"
      label="Email"
    ></v-text-field>

    <slot />
  </v-form>
</template>

<script>
const defaults = {
  getNoErrors() {
    return {
      customer: {
        name: {
          valid: true,
          message: ''
        },
        telephone: {
          valid: true,
          message: ''
        },
        email: {
          valid: true,
          message: ''
        },
        address1: {
          valid: true,
          message: ''
        },
        address2: {
          valid: true,
          message: ''
        },
        city: {
          valid: true,
          message: ''
        },
        state: {
          valid: true,
          message: ''
        },
        zipcode: {
          valid: true,
          message: ''
        },
        representative: {
          firstName: {
            valid: true,
            message: ''
          },
          lastName: {
            valid: true,
            message: ''
          },
          telephone: {
            valid: true,
            message: ''
          },
          email: {
            valid: true,
            message: ''
          }
        }
      }
    }
  }
}

export default {
  props: {
    states: {
      type: Array,
      required: true
    },
    customer: {
      type: Object,
      default() {
        return {
          name: '',
          telephone: '',
          email: '',
          address1: '',
          address2: '',
          city: '',
          state: 'MN',
          zipcode: '',
          representative: {
            firstName: '',
            lastName: '',
            telephone: '',
            email: ''
          }
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
      const data = await this.$customerApi.saveCustomer(this.customer)
      if (!data.id) {
        Object.keys(data).map((i) => {
          const field = i
            .split('.')
            .reduce((a, b) => a[b], this.errors.customer)
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
