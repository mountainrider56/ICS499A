<template>
  <div>
    <v-btn
      color="secondary"
      class="inline-block mr-3"
      outlined
      @click.prevent="downloadPdf()"
    >
      Download PDF
    </v-btn>
    <v-btn
      class="inline-block"
      color="secondary"
      outlined
      @click.prevent="viewPdf()"
    >
      View PDF
    </v-btn>
  </div>
</template>

<script>
export default {
  props: {
    downloadPdf: {
      type: Function,
      required: true
    },
    viewPdf: {
      type: Function,
      required: true
    }
  }
}
</script>
