<template>
	<div class="is-size-8 h-full">
    <portal to="page-controls">
      <div class="py-1 pr-2 flex justify-end">
        <p class="buttons">
          <router-link
              class="button  is-rounded"
              tag="button"
              :to="{name:'leave-create'}">
				<span class="icon">

				<i class="fa fa-plus-circle"></i>
				</span>
            <span>New Request</span>
          </router-link>
        </p>
      </div>
    </portal>
		<div class="flex justify-start">
			<router-link tag="a" to="/leave">
				<span class="icon">
					<i class="fa fa-angle-left"></i>
				</span>
				<span>Back To List</span>
			</router-link>
		</div>
		<div class="relative bg-white mt-5 p-5">
			<div class="columns">
				<div class="column flex gap-4">
					<h4 class="has-text-black">Employee Name</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.employee}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Date Submitted</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.createdAt|dateFormat}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Leave Type</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.leaveType}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Status</h4>
					<h4 class="has-text-grey-light">Status</h4>
				</div>
			</div>
			<div class="columns">
				<div class="column flex gap-4">
					<h4 class="has-text-black">Start Date</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.startDate|dateFormat}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">End Date</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.endDate|dateFormat}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Days To End Date</h4>
					<h4 class="has-text-grey-light">{{daysToEndDate}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Reason</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.status}}</h4>
				</div>
			</div>
			<div class="columns">
				<div class="column flex gap-4">
					<h4 class="has-text-black">Leave Balance</h4>
					<h4 class="has-text-grey-light">{{leaveBalance}} days</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Balance After Approval</h4>
					<h4 class="has-text-grey-light">{{balanceAfterApproval}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Leave Period in Days</h4>
					<h4 class="has-text-grey-light">{{leaveDetail.numberOfDays}}</h4>
				</div>
				<div class="column flex gap-4">
					<h4 class="has-text-black">Employee Department</h4>
					<h4 class="has-text-grey-light">Status</h4>
				</div>
			</div>
			<div class="flex justify-center">
				<button @click="confirmApproval" class="button is-primary is-rounded is-small mr-5">
					<span>
						Approve
                    </span>
				</button>
				<button @click="openRejectDialog" class="button is-rounded is-light is-small">
					<span>
						Reject
                    </span>
				</button>
			</div>
		</div>
		<div class="mt-1 bg-white">
			<div class="tabs">
				<ul>
					<li class="is-active"><a>Leave Request History</a></li>
				</ul>
			</div>
		</div>
		<LeaveRequestHistoryList></LeaveRequestHistoryList>
  </div>
</template>
<script>
import LeaveRequestHistoryList from "./LeaveRequestHistoryList.vue"
import {Message} from "element-ui"

export default {
        components: {
            LeaveRequestHistoryList
        },
        data() {
            return {
                leaveDetail: {},
                leaveId: false,
            }
        },
        created() {
            this.leaveId = this.$route.params.id;
            this.getLeaveDetails();
        },
        //api/user/leave-requests/{id}
        methods: {
            getLeaveDetails() {
                let leaveId = this.$route.params.id;
                let vm = this;
                axios.get(`/api/user/leave-requests/summary/${leaveId}`).then(resp => {
                    vm.leaveDetail = resp.data;
                })
            },
            getDateDiffence(endDate, startDate) {
                let dateOne = moment(endDate);
                let dateTwo = moment(startDate);
                return dateOne.diff(dateTwo, 'days')
            },
            confirmApproval() {
                this.$buefy.dialog.confirm({
                    title: 'Leave Approve',
                    confirmText: "Approve",
                    message: 'Are you sure want to approve for this leave?',
                    onConfirm: () => this.approveLeave()
                })
            },
            openRejectDialog() {
                this.$buefy.dialog.prompt({
                    message: `Add Comment (Optional)`,
                    confirmText: "Proceed",
                    inputAttrs: {
                        placeholder: 'e.g. Walter',
                        required: false
                    },
                    trapFocus: true,
                    onConfirm: (value) => this.$buefy.toast.open(`Your name is: ${value}`)
                })

            },
            approveLeave() {
                axios.post(`/api/leave-request-approvals/${this.leaveId}`).then(resp => {
                    Message.success(resp.data.message);
                }, error => {

                })
            },
            rejectLeaveApproval(comment) {
                axios.post(`/api/user/leave-approvals/accept/${this.leaveId}`, {
                    params: {
                        comment: comment
                    }
                }).then(resp => {
                    this.$buefy.toast.open('User confirmed')
                }, error => {

                })
            }
        },
        computed: {
            daysToEndDate() {
                return this.getDateDiffence(this.leaveDetail.endDate, new Date())
            },
            leaveBalance() {
                return this.leaveDetail.elligibleDays - this.leaveDetail.daysUsed;
            },
            balanceAfterApproval() {
                return this.leaveBalance - this.leaveDetail.numberOfDays;
            }
        },
        filters: {
            dateFormat(date) {
                return moment(date).format("DD-MM-YYYY")
            }
        }
    }
</script>
