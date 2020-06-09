<template>
  <div>
    <v-app>
      <v-app-bar app>
        <v-btn text to="/">Home</v-btn>
        <v-btn text to="/customers">Customers</v-btn>
        <v-btn text to="/quotes">Quotes</v-btn>
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
