<template>
  <div>

  </div>
</template>
<script>
import data_table_mixin from "../../mixins/data_table_mixin";
import Paginator from "../common/paginator/Paginator";

export default {
  components: {
    Paginator
  },
  mixins: [data_table_mixin],
  data() {
    return {
      assets: []
    }
  },
  created() {
    this.getAssets();
  },
  methods: {
    fetchRecords() {
      this.getAssets();
    },
    getAssets() {
      axios.get(`api/assets/`, {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.assets = resp.data.content;
        this.pageable = resp.data;
        this.loading = false
      })
    }
  }
}
</script>