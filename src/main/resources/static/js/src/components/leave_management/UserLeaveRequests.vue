<template>
	<div>
		<div class="pb-2 flex justify-end">
			<router-link
					to="leave-create"
					tag="button"
					class="button is-primary">
				<i class="fa fa-plus mr-1"></i>New Requests
			</router-link>
		</div>
		<div class="columns">
			<div class="column is-8">
				<div class="card">
					
					<div class="card-content">
						<div class="content">
							<h4>My Leave Requests</h4>
							<table class="table w-full">
								<thead class="font-thin">
								<tr>
									<th>
										Type
									</th>
									<th>
										Days
									</th>
									<th>
										Start Date
									</th>
									<th>
										End Date
									</th>
									<th>
										Status
									</th>
									<th>
										Date Requested
									</th>
									<th>
										Action
									</th>
								</tr>
								</thead>
								<tbody>
								<tr v-for="leaveRequest in leaveRequests">
									<td>{{leaveRequest.leaveType.name}}</td>
									<td>{{leaveRequest.numberOfDays}}</td>
									<td>{{leaveRequest.startDate|dateFormat}}</td>
									<td>{{leaveRequest.endDate|dateFormat}}</td>
									<td>{{leaveRequest.leaveStatuses}}</td>
									<td>{{leaveRequest.createdAt|dateFormat}}</td>
									<td>
										<b-dropdown aria-role="list">
											<i
													class="fa fa-ellipsis-h"
													slot="trigger"
													role="button">
											</i>
											<b-dropdown-item aria-role="listitem">Widhraw</b-dropdown-item>
											<b-dropdown-item aria-role="listitem">Another action</b-dropdown-item>
											<b-dropdown-item aria-role="listitem">Something else</b-dropdown-item>
										</b-dropdown>
									</td>
								</tr>
								</tbody>
								<tfoot>
								<tr>
									<td colspan="7">
										<Paginator :paginationData="pageable"></Paginator>
									</td>
								</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="column is-4">
				<LeaveBalanceCard></LeaveBalanceCard>
			</div>
		</div>
	
	</div>
</template>
<script>
    import LeaveBalanceCard from "./LeaveBalanceCard.vue"
    import Paginator from "../common/paginator/Paginator"

    export default {
        components: {
            LeaveBalanceCard,
            Paginator
        },
        data() {
            return {
                loading: false,
                leaveRequests: [],
                pageable: false,
                pageSize: 10,
                page: 0
            }
        },
        created() {
            this.getUserLeaveRequests();
        },
        methods: {
            getUserLeaveRequests() {
                let vm = this;
                axios.get("/api/user/leave-requests", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    vm.leaveRequests = resp.data.content;
                    vm.pageable = resp.data;
                })
            }
        },
        filters: {
            dateFormat(date) {
                return moment(date).format("LL")
            }
        }
    }
</script>