<template>
  <div>
    <v-app outlined>
      <v-app-bar color="#fff" app>
        <router-link v-if="$auth.loggedIn" to="/">
          <Logo />
        </router-link>
        <Logo v-if="!$auth.loggedIn" />
        <v-layout v-if="$auth.loggedIn" justify-end>
          <v-btn text to="/">Home</v-btn>
          <v-btn text to="/quotes">Quotes</v-btn>
          <v-btn text to="/customers">Customers</v-btn>
          <v-btn text to="/employees">Employees</v-btn>
          <v-btn text @click="logout()">Logout</v-btn>
        </v-layout>
      </v-app-bar>
      <v-content>
        <nuxt />
      </v-content>
      <v-footer class="mt-10 pa-5">
        <v-spacer></v-spacer>
        <div>&copy; {{ new Date().getFullYear() }}</div>
      </v-footer>
      <Timeout v-if="$auth.loggedIn" />
    </v-app>
  </div>
</template>

<script>
export default {
  methods: {
    async logout() {
      await this.$auth.logout()
    }
  }
}
</script>
