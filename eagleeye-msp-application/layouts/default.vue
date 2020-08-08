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
          <v-btn v-if="$userFlags.isAdmin()" text to="/employees">
            Employees
          </v-btn>
          <v-btn text @click.stop="drawer = !drawer">
            <v-icon>mdi-account-settings</v-icon>
          </v-btn>
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
      <v-navigation-drawer
        v-if="$auth.loggedIn"
        v-model="drawer"
        absolute
        temporary
        right
      >
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>{{ name }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list dense>
          <v-list-item link @click="toUser()">
            <v-list-item-icon>
              <v-icon>mdi-account</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>Account</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item link @click="logout()">
            <v-list-item-icon>
              <v-icon>mdi-logout</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>Logout</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </v-app>
  </div>
</template>

<script>
export default {
  data() {
    return {
      drawer: null
    }
  },
  computed: {
    name() {
      return `${this.$auth.user.firstName} ${this.$auth.user.lastName}`
    }
  },
  methods: {
    async logout() {
      await this.$auth.logout()
    },
    toUser() {
      this.$router.push({
        path: '/employees/detail',
        query: { id: this.$auth.user.id }
      })
      this.drawer = false
    }
  }
}
</script>
