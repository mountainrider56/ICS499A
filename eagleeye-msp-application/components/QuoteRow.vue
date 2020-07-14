<template>
  <v-row align="center">
    <v-col
      :class="isSubRow || isListRow ? 'pt-3' : 'pt-6'"
      :cols="4"
      :offset="1"
    >
      <ul v-if="isListRow">
        <li>{{ service.title }}</li>
      </ul>
      <component :is="isSubRow ? 'div' : 'h3'" v-else>
        {{ service.title }}
      </component>
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
    },
    isListRow: {
      type: Boolean,
      default: false,
      required: false
    }
  }
}
</script>
