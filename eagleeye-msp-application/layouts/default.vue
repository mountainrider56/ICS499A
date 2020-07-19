<template>
  <div>
    <v-app outlined>
      <v-app-bar color="#fff" app>
        <router-link to="/">
          <v-img
            alt="eagleEye logo"
            max-width="184px"
            min-height="50px"
            :src="require('@/static/logo.png')"
          ></v-img
        ></router-link>
        <v-layout justify-end>
          <v-btn text to="/">Home</v-btn>
          <v-btn text to="/quotes">Quotes</v-btn>
          <v-btn text to="/customers">Customers</v-btn>
          <v-btn text to="/employees">Employees</v-btn>
        </v-layout>
      </v-app-bar>
      <v-content>
        <nuxt />
      </v-content>
      <v-footer class="mt-10 pa-5">
        <v-spacer></v-spacer>
        <div>&copy; {{ new Date().getFullYear() }}</div>
      </v-footer>
    </v-app>
  </div>
</template>
