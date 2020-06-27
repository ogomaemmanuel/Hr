<template>
    <div class="">
        <div  class="flex pb-2 justify-end">
            <button @click="exportReport"
                    class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download"></i>
				</span>
                <span>Export</span>
            </button>
        </div>
        <div class="columns">
            <div class="column is-12">
                <div class="card" ref="leaveRequests">
                    <div class="card-content">
                        <div class="content b-table is-relative" :class="{'is-loading':loading}">
                            <h4>Permissions</h4>
                            <table class="table has-mobile-cards w-full is-hoverable">
                                <thead class="font-thin">
                                <tr>
                                    <th>
                                       Name
                                    </th>
                                    <th>
                                        Description
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="permission in permissions">
                                    <td data-label="Name">{{permission.name}}</td>
                                    <td data-label="Date">{{permission.description}}</td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="8">
                                        <Paginator
                                                @previousPage="goToPrevious"
                                                @nextPage="goToNext"
                                                @paginationChanged="onPaginationChanged"
                                                :paginationData="pageable"
                                        ></Paginator>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <router-view></router-view>
    </div>
</template>
<script>
    import DataTableMixin from "../../../mixins/data_table_mixin"
    import Paginator from "../../common/paginator/Paginator";
    export default {
        mixins: [DataTableMixin],
        components: {
            Paginator
        },
        data() {
            return {
                isLoading: false,
                permissions: [],
                loading:false,
            }
        },
        created() {
            this.fetchRecords();
        },
        methods: {
            fetchRecords() {
                return this.getPermissions()
            },
            getPermissions()  {
                let vm = this;
                this.isLoading = true;
                axios.get("/api/permissions", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    vm.isLoading = false
                    vm.permissions = resp.data.content;
                    this.pageable = resp.data;
                    vm.loading = false;
                }, error => {
                    vm.isLoading = false
                })
            },
            exportReport() {
                this.$downLoadFile({
                    requestMethod: "Get",
                    endPoint: "/api/permissions/reports"
                });
            }
        }

    }
</script>