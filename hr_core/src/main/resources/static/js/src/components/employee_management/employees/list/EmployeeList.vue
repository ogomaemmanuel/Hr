<template>
  <div>
    <div class=" flex justify-end">
      <portal to="page-controls">
        <a
            class="button is-rounded mr-2"
            href="/api/holidays/excel-report">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
          <span>
					 Export
				</span>
        </a>

        <button>
          <p class="buttons">
            <button class="button" @click="showTableList=true">
            <span class="icon is-small">
              <i class="fa fa-th"></i>
            </span>
            </button>
            <button class="button mr-2" @click="showTableList=false">
            <span class="icon is-small">
              <i class="fa fa-bars"></i>
            </span>
            </button>
          </p>
        </button>
      </portal>
    </div>
    <div class="flex justify-start">
      <router-link
          class="button mr-1 mb-2 is-rounded"
          tag="button"
          to="/employees-create">
                  <span class="icon">
                    <i class="fa fa-plus-circle mr-1"></i>
                  </span>
        <span>
                       Add Employee
                    </span>
      </router-link>
    </div>
    <div class="columns h-full">
      <div class="column is-12">
        <EmployeeTableList v-if="showTableList"></EmployeeTableList>
        <EmployeeCardList v-else></EmployeeCardList>
      </div>
    </div>
  </div>
</template>
<script>
import Paginator from "../../../common/paginator/Paginator";
import EmployeeTableList from "./EmployeeTableList";
import EmployeeCardList from "./EmployeeCardList";

export default {
  components: {
    Paginator,
    EmployeeTableList,
    EmployeeCardList
  },
  data() {
    return {
      showTableList: true,
    }
  },
  methods: {},
  created() {
  },
}
</script>