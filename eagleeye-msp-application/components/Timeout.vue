<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="290">
      <v-card>
        <v-card-title class="headline">
          Are you still there?
        </v-card-title>
        <v-card-text>
          You have been inactive for awhile. You will soon lose your current
          session.
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" outlined @click="logout()">
            Logout
          </v-btn>
          <v-btn color="primary" @click="cancel()">
            Cancel
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  data() {
    return {
      now: Date.now(),
      dialog: false,
      counter: null
    }
  },
  mounted() {
    const $this = this
    this.counter = setInterval(async () => {
      const diff = $this.instant() - $this.now
      const seconds = Math.floor((diff / 1000) % 60)
      if (seconds > 1500 && !$this.dialog) {
        $this.dialog = true
      }
      const isActive = await $this.ping()
      if (!isActive) {
        $this.logout()
      }
    }, 60000)
  },
  destroyed() {
    clearInterval(this.counter)
  },
  methods: {
    instant() {
      return Date.now()
    },
    async ping() {
      return await this.$loginApi.pingSession()
    },
    async logout() {
      this.dialog = false
      await this.$auth.logout()
    },
    async cancel(dialog) {
      const $this = this
      await this.$loginApi
        .getSession()
        .then((response) => {
          this.now = this.instant()
          $this.dialog = false
        })
        .catch((e) => {
          $this.dialog = false
          this.$auth.logout()
        })
    }
  }
}
</script>
