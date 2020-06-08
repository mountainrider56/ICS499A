<template>
  <v-container>
    <h1>{{ title }}</h1>
    {{ client }}
    <v-btn @click="getClient()">Get Client</v-btn>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      title: 'Clients',
      client: {}
    }
  },
  methods: {
    async getClient() {
      const url = '/api/eagleeye-msp/v1/clients/1'
      const { data } = await axios.get(url)
      this.client = data
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
