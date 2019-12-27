<template>
	<tr>
		<td>{{leaveRequest.leaveType.name}}</td>
		<td>{{leaveRequest.numberOfDays}}</td>
		<td>{{leaveRequest.startDate|dateFormat}}</td>
		<td>{{leaveRequest.endDate|dateFormat}}</td>
		<td>
										<span class="tag is-success">
										{{leaveRequest.leaveStatuses}}
										</span>
		</td>
		<td>{{leaveRequest.createdAt|dateFormat}}</td>
		<td>
			<b-dropdown aria-role="list">
				<i
						class="fa fa-ellipsis-h text-muted"
						slot="trigger"
						role="button">
				</i>
				<b-dropdown-item @click="confirmLeaveWithdrawal" aria-role="listitem">Withdraw</b-dropdown-item>
				<b-dropdown-item aria-role="listitem">Edit</b-dropdown-item>
			</b-dropdown>
		</td>
	</tr>
</template>
<script>
    export default {
        props: {
            leaveRequest: {
                required: true,
                type: Object,
            }
        },
        methods: {
            confirmLeaveWithdrawal() {
                this.$buefy.dialog.confirm({
                    title: 'Leave Withdrawal',
                    message: 'Are you sure you want to <b>withdraw</b> this leave?',
                    confirmText: 'Withdraw',
                    type: 'is-primary',
                    onConfirm: () => this.withdrawLeave()
                })
            },
            withdrawLeave() {

            }
        },
        filters: {
            dateFormat(date) {
                return moment(date).format("LL")
            }
        }
    }
</script>