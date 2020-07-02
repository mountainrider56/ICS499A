<template>
  <v-container>
    <h1>{{ title }}</h1>
    <v-btn small to="/employees/create" color="primary">
      + Add an Employee
    </v-btn>
    <v-data-iterator :items="employees" :items-per-page.sync="itemsPerPage">
      <template v-slot:default="props">
        <v-row>
          <v-col v-for="item in props.items" :key="item.name" lg="3">
            <v-card :to="getEmployeeDetailLink(item.id)">
              <v-card-title class="subheading font-weight-bold">
                {{ item.firstName }} {{ item.lastName }}
              </v-card-title>
              <v-divider></v-divider>
              <v-list dense>
                <v-list-item>
                  <v-list-item-content>Email:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.email }}
                  </v-list-item-content>
                </v-list-item>
                <v-list-item>
                  <v-list-item-content>Security Role:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ item.securityRole }}
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-card>
          </v-col>
        </v-row>
      </template>
    </v-data-iterator>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $axios }) {
    const employees = await $axios.$get('/api/eagleeye-msp/v1/employees')
    return { employees }
  },
  data() {
    return {
      title: 'Employees',
      itemsPerPage: 5
    }
  },
  methods: {
    getEmployeeDetailLink(id) {
      return `/employees/detail?id=${id}`
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
