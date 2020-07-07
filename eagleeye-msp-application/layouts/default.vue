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
      <!-- <v-navigation-drawer app permanent>
        <v-list dense nav>
          <v-list-item-content> 
            <v-list-item-title>Name</v-list-item-title>
          </v-list-item-content>
        </v-list>
        <v-divider></v-divider>
        <v-list-item link>
          <v-list-item-icon>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Dashboard</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link>
          <v-list-item-icon>
            <v-icon>mdi-account-box</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Account</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link>
          <v-list-item-icon>
            <v-icon>mdi-help-box</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>About</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-navigation-drawer>-->
      <!-- <v-app-bar></v-app-bar> -->
      <v-content>
        <nuxt />
      </v-content>
    </v-app>
  </div>
</template>
