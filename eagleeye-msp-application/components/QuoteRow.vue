<template>
  <v-row align="center">
    <v-col :class="isSubRow ? 'pt-3' : 'pt-6'" :cols="3" :offset="1">
      <component :is="isSubRow ? 'div' : 'h3'">{{ service.title }}</component>
    </v-col>
  </v-row>
</template>

<script>
export default {
  props: {
    service: {
      type: Object,
      required: true
    },
    isSubRow: {
      type: Boolean,
      default: false,
      required: false
    }
  }
}
</script>
