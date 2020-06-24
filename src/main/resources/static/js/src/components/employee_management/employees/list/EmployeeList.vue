<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button>
                <p class="buttons">
                    <button class="button" @click="showTableList=true">
    <span class="icon is-small">
      <i class="fa fa-th"></i>
    </span>
                    </button>
                    <button @click="showTableList=false" class="button">
    <span class="icon is-small">
      <i class="fa fa-bars"></i>
    </span>
                    </button>
                </p>
            </button>
            <portal to="page-controls">
            <router-link
                    to="/employees-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Employee
				</span>
            </router-link>
            <a
                    href="/api/holidays/excel-report"
                    class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
                <span>
					 Export
				</span>
            </a>
            </portal>
        </div>
        <div class="columns">
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
        methods: {
        },
        created() {
        },
    }
</script>