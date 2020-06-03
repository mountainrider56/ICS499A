<template>
  <div>
    <h1>{{ title }}</h1>
    {{ client }}
    <button @click="getClient()">Get Client</button>
    <sc-p-decorator>
      <p>This should be red text.</p>
    </sc-p-decorator>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      title: 'Hello',
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
