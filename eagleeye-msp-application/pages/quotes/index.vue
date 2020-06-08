<template>
  <v-container>
    <h1>{{ title }}</h1>
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
