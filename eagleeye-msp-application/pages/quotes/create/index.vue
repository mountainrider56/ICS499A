<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-row>
      <v-col cols="3">
        Device Monitoring (${{ items.deviceMonitoring.price }})
      </v-col>
      <v-col cols="9">
        <v-text-field label="Quantity" outlined></v-text-field>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $axios }) {
    const items = await $axios.$get(
      `/api/eagleeye-msp/v1/quotes/pc-management/items`
    )
    return { items }
  },
  data() {
    return {
      title: 'Create a Quote',
      client: {}
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
