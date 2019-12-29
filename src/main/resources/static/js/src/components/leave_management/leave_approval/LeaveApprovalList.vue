<template>
	<div class="mt-5 bg-white p-5 is-size-7">
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
        }
        
    }
</script>