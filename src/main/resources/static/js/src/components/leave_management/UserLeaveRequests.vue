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
				<div class="card" ref="leaveRequests">
					<div class="card-content card-simple">
						<div class="content">
							<h4>My Leave Requests</h4>
							<table class="table  is-hoverable">
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
								<tr is="UserLeaveRequestItem" v-for="leaveRequest in leaveRequests" :leave-request="leaveRequest" :key="leaveRequest.id">
								</tr>
								</tbody>
								<tfoot>
								<tr>
									<td colspan="7">
										<Paginator
												@previousPage="goToPrevious"
												@nextPage="goToNext"
												@paginationChanged="onPaginationChanged"
												:paginationData="pageable">
										
										</Paginator>
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
	import UserLeaveRequestItem from "./UserLeaveRequestItem"

    export default {
        components: {
            LeaveBalanceCard,
            Paginator,
            UserLeaveRequestItem
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
                const loadingComponent = this.$buefy.loading.open({
                    container: this.isFullPage ? null : vm.$refs.leaveRequests
                })
                axios.get("/api/user/leave-requests", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    loadingComponent.close();
                    vm.leaveRequests = resp.data.content;
                    vm.pageable = resp.data;
                }, error => {
                    loadingComponent.close();
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
        filters: {
            dateFormat(date) {
                return moment(date).format("LL")
            }
        }
    }
</script>
<style lang="scss" scoped>
	
	
	/*.card-simple {*/
	/*	background: #fff;*/
	/*	!*cursor: pointer !important;*!*/
	/*	box-shadow: none !important ;*/
	/*	transition: all 0.5s ease-in-out;*/
	/*	border: 1px solid #e7eef7 !important;*/
	/*}*/
	
	
	 /*.card-simple:hover {*/
		/* box-shadow: 0.5rem 1.5rem 1rem rgba(120,130,140,0.13) !important;*/
		/* transition: all 0.5s ease-in-out;*/
	 /*}*/
</style>