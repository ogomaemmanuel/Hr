<template>
	<tr>
		<td data-label="Name">{{leaveRequestClone?.leaveType?.name}}</td>
		<td data-label="Number of Days">{{leaveRequestClone.numberOfDays}}</td>
		<td data-label="Start Date">{{leaveRequestClone.startDate|dateFormat}}</td>
		<td data-label="End Date">{{leaveRequestClone.endDate|dateFormat}}</td>
		<td data-label="Status">
										<span :class="statusColor" class="tag  is-light">
										{{leaveRequestClone.leaveStatuses}}
										</span>
		</td>
		<td data-label="Date Requested">{{leaveRequestClone.createdAt|dateFormat}}</td>
		<td>
			<b-dropdown aria-role="list">
				<i
						class="fa fa-ellipsis-h text-muted"
						slot="trigger"
						role="button">
				</i>
				<b-dropdown-item :disabled="disableWithdrawOption"
								 value="withdraw"
								 @click="confirmLeaveWithdrawal"
								 aria-role="listitem">
					<span class="icon"><i class="fa fa-undo"></i></span>
					Withdraw
				</b-dropdown-item>
				<b-dropdown-item v-if="disableEditOption"
								 :disabled="disableEditOption" value="edit" aria-role="listitem">
					<span class="icon"><i class="fa fa-pencil"></i></span>
					Edit
				</b-dropdown-item>
				<b-dropdown-item v-else
								 @click="goToEdit"
								 value="edit"
								 aria-role="listitem">
					<span class="icon"><i class="fa fa-pencil"></i></span>
					Edit
				</b-dropdown-item>
			</b-dropdown>
		</td>
	</tr>
</template>
<script>
    import {Message} from "element-ui"

    export default {
        props: {
            leaveRequest: {
                required: true,
                type: Object,
            }
        },
        data() {
            return {
                leaveRequestClone: {}
            }
        },
        created() {
            this.leaveRequestClone = {...this.leaveRequest}
        },
        methods: {
            confirmLeaveWithdrawal() {
                this.$buefy.dialog.confirm({
                    title: 'Leave Withdrawal',
                    message: 'Are you sure you want to <b>withdraw</b> this leave?',
                    confirmText: 'Withdraw',
                    type: 'is-primary is-light',
                    onConfirm: () => this.withdrawLeave()
                })
            },
            goToEdit() {
                this.$router.push(`/leave-request-edit/${this.leaveRequestClone.id}`)
            },
            withdrawLeave() {
                axios.put(`/api/user/leave-requests/withdrawal/${this.leaveRequestClone.id}`).then(resp => {
                    this.leaveRequestClone = resp.data.data;
                    Message.success(
                        resp.data.message
                    )
                }, error => {

                })
            }
        },
        filters: {
            dateFormat(date) {
                return moment(date).format("LL")
            }
        },
        computed: {
            statusColor() {
                if (this.leaveRequestClone.leaveStatuses.toLowerCase() === "new") {
                    return 'is-primary'
                }
                if (this.leaveRequestClone.leaveStatuses.toLowerCase() === "withdrawn") {
                    return 'is-warning'
                }
            },
            disableEditOption() {
                let isNew = this.leaveRequestClone.leaveStatuses.toLowerCase() === "new";
                return !isNew;
            },
            disableWithdrawOption() {
                let isWithdrawn = this.leaveRequestClone.leaveStatuses.toLowerCase() === "withdrawn";
                return isWithdrawn;
            }
        }
    }
</script>