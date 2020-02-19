<template>
	<div>
		<div class="flex  justify-end  mb-5">
			<div class="columns">
				<div class="column is-flex justify-end">
					<!--					<input class="input  is-rounded is-small mr-1" type="text" placeholder="Search ...">-->
					
					
					<router-link to="/leave-type-create" class="button mr-1 is-small is-rounded">
				          <span class="icon">
					         <i class="fa fa-plus-circle"></i>
				           </span>
						<span>
								Add New
							</span>
					</router-link>
					<a href="/api/leave-types/excel-report" class="button is-small is-rounded">
				          <span class="icon">
					         <i class="fa fa-download"></i>
				           </span>
						<span>
					Export All
				</span>
					</a>
				
				</div>
			</div>
		</div>
		
		<div class="mt-5 b-table bg-white p-5 is-size-7 is-full">
			
			<table class="table has-mobile-cards is-hoverable  w-full">
				<thead>
				<tr>
					<th>Name</th>
					<th>Number of Days</th>
					<th>Action</th>
				</tr>
				</thead>
				<tbody>
				<tr
						v-for="leaveType in leaveTypes"
						is="LeaveTypeItem"
						@leaveTypeRemoveSuccessful="getLeaveTypes"
						:leaveType="leaveType">
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
		<router-view
				@leaveUpdateSuccessful="getLeaveTypes"
				@holidayCreateSuccessful="getLeaveTypes">
		</router-view>
	</div>
</template>
<script>
    import LeaveTypeItem from "./LeaveTypeItem";
    import DataTableMixin from "../../../mixins/data_table_mixin"
    import Paginator from "../../common/paginator/Paginator";

    export default {
        mixins: [DataTableMixin],
        components: {
            LeaveTypeItem,
            Paginator
        },
        data() {
            return {
                leaveTypes: []
            }
        },
        created() {
            this.fetchRecords();
        },
        methods: {
            getLeaveTypes() {
                let request = {
                    page: this.page,
                    pageSize: this.pageSize,
                }
                axios.get("/api/leave-types/paged", {
                    params: request
                }).then(resp => {
                    this.leaveTypes = resp.data.content;
                    this.pageable = resp.data;
                })
            },
            fetchRecords() {
                this.getLeaveTypes();
            }
        }

    }
</script>
<style lang="scss" scoped>

</style>