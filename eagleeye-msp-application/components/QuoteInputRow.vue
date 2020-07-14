<template>
  <v-row align="center" :class="isSubRow || isListRow ? '' : 'mt-6'">
    <v-col class="pt-0 pb-0" :cols="1">
      <v-text-field
        v-model="selection.quantity"
        type="number"
        label="Quantity"
        dense
      />
    </v-col>
    <v-col class="pt-3" :cols="4">
      <ul v-if="isListRow">
        <li>{{ service.title }}</li>
      </ul>
      <component :is="isSubRow ? 'div' : 'h3'" v-else>
        {{ service.title }}
      </component>
    </v-col>
    <v-col class="pt-3" :cols="4">
      Cost per {{ costType }}: ${{ service.price.toFixed(2) }}
    </v-col>
    <v-col class="pt-3" :cols="3"> Cost: ${{ subTotal.toFixed(2) }} </v-col>
  </v-row>
</template>

<script>
export default {
  props: {
    service: {
      type: Object,
      required: true
    },
    selection: {
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
    },
    costType: {
      type: String,
      required: true
    }
  },
  computed: {
    subTotal() {
      return this.service.price * this.selection.quantity
    }
  },
  watch: {
    'selection.quantity'(val) {
      this.$emit('onQuantityUpdate')
    }
  }
}
</script>
