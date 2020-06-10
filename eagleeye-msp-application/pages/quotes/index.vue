<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-btn small to="/quotes/create" color="primary">Create a Quote</v-btn>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      title: 'Quotes',
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
