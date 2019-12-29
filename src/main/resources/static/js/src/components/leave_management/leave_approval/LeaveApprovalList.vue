<template>
	<div>
		<div class="flex  justify-end  mb-5 mt-5">
			<div class="field w-60 mr-5">
				<div class="control">
					<input class="input flex-grow-0 is-rounded is-small" type="text" placeholder="Search ...">
				</div>
			</div>
			<button class="button is-small is-rounded">
				<span class="icon">
					<i class="fa fa-download"></i>
				</span>
				<span>
					Export All
				</span>
			</button>
		</div>
		
		<div class="mt-5 bg-white p-5 is-size-7 is-full">
			
			<table class="table w-full">
				<thead>
				<tr>
					<th>Employee</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Days</th>
					<th>Leave Type</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
				</thead>
				<tbody>
				<tr v-for="leaveRequest in leaveRequests" is="LeaveApprovalItem" :leaveRequest="leaveRequest">
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
</template>
<script>
    import Paginator from "../../common/paginator/Paginator"
    import LeaveApprovalItem from "./LeaveApprovalItem.vue"

    export default {
        components: {
            Paginator,
            LeaveApprovalItem
        },
        data() {
            return {
                loading: false,
                leaveRequests: [],
                pageable: false,
                pageSize: 10,
                page: 0,
                showLeaveBalances: false
            }
        },
        created() {
            this.getLeaveRequestesToApprove();
        },
        methods: {
            getLeaveRequestesToApprove() {
                let vm = this;
                axios.get("/api/leave-request-approvals", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    vm.leaveRequests = resp.data.content;
                    vm.pageable = resp.data;
                })
            },
            goToPrevious() {
                this.page--;
                this.getUserLeaveRequests();
            },
            goToNext() {
                this.page++;
                this.getUserLeaveRequests();
            },
            onPaginationChanged(pageSize) {
                this.page = 0;
                this.pageSize = pageSize;
                this.getUserLeaveRequests();
            }
        },

    }
</script>