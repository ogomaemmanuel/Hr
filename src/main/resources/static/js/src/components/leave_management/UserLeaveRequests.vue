<template>
	<div>
		<div class="pb-2 flex justify-end">
			<p class="buttons ">
			<router-link
					to="leave-create"
					tag="button"
					class="button  is-rounded is-small">
				<span class="icon">
 
				<i class="fa fa-plus-circle"></i>
				</span>
					<span>New Requests</span>
			</router-link>
			</p>
		</div>
		<div class="tabs is-boxed is-small">
			<ul>
				<li @click="showLeaveBalances=false"  :class="{'is-active':showLeaveBalances==false}"><a>My Leave Requests</a></li>
				<li @click="showLeaveBalances=true"  :class="{'is-active':showLeaveBalances==true}"><a>My Leave Balances</a></li>
			</ul>
		</div>
		<div class="columns">
			<div v-if="showLeaveBalances==false"  class="column is-12">
				<div class="card" ref="leaveRequests">
					<div class="card-content card-simple is-size-7">
						<div class="content">
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
			<div v-else class="column is-12 is-size-7">
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
                page: 0,
				showLeaveBalances:false
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