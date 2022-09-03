<template>

</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";

export default {
  mixins: [data_table_mixin],
  components: {
    Paginator
  },
  data() {
    return {
      loading: false,
      trainingList: []
    }
  },
  created() {
    this.getTrainingList();
  },
  methods: {
    fetchRecords() {
      this.getTrainingList();
    },
    getTrainingList() {
      let vm = this;
      axios.get("/api/trainings", {
        params: {
          page: vm.page,
          pageSize: vm.pageSize
        }
      }).then(resp => {
        vm.trainingList = resp.data.content;
        vm.pageable = resp.data;
      }, error => {

      })
    }
  }
}
</script>