<template>
  <v-dialog v-model="dialog" max-width="500">
    <template v-slot:activator="{ on, attrs }">
      <v-btn class="mt-6 float-right" v-bind="attrs" v-on="on">
        Delete
      </v-btn>
    </template>
    <v-card>
      <v-card-title class="headline">Are you sure?</v-card-title>
      <v-card-text> {{ message }} </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn outlined @click="dialog = false">
          Cancel
        </v-btn>
        <v-btn color="primary" @click="respond()">
          Confirm
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    message: {
      type: String,
      required: true
    },
    callback: {
      type: Function,
      required: true
    }
  },
  data() {
    return {
      dialog: false
    }
  },
  methods: {
    respond() {
      this.callback()
    }
  }
}
</script>
