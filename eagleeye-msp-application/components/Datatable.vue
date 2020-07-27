<template>
  <v-card>
    <v-card-title>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="datatable.headers"
      :items="items"
      :footer-props="footerProps"
      :items-per-page="itemsPerPage"
      :search="search"
      :sort-by.sync="datatable.sortBy"
      :sort-desc.sync="sortDesc"
      :must-sort="mustSort"
      class="row-pointer"
      @click:row="handleRowClick"
    >
      <template v-slot:item.actions="{ item }">
        <v-icon @click="handleRowClick(item)">
          mdi-pencil
        </v-icon>
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
export default {
  props: {
    items: {
      type: Array,
      required: true
    },
    datatable: {
      type: Object,
      required: true
    },
    handleRowClick: {
      type: Function,
      required: true
    }
  },
  data() {
    return {
      search: '',
      sortDesc: false,
      mustSort: true,
      itemsPerPage: 50,
      footerProps: {
        'items-per-page-options': [5, 10, 20, 30, 40, 50]
      }
    }
  }
}
</script>

<style lang="css" scoped>
.row-pointer >>> tbody tr :hover {
  cursor: pointer;
}
</style>
