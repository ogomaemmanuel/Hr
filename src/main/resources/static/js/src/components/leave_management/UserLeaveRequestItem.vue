<template>
	<tr>
		<td>{{leaveRequestClone.leaveType.name}}</td>
		<td>{{leaveRequestClone.numberOfDays}}</td>
		<td>{{leaveRequestClone.startDate|dateFormat}}</td>
		<td>{{leaveRequestClone.endDate|dateFormat}}</td>
		<td>
										<span class="tag is-success">
										{{leaveRequestClone.leaveStatuses}}
										</span>
		</td>
		<td>{{leaveRequestClone.createdAt|dateFormat}}</td>
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
                    type: 'is-primary',
                    onConfirm: () => this.withdrawLeave()
                })
            },
            withdrawLeave() {
                axios.put(`/api/user/leave-requests/withdrawal/${this.leaveRequestClone.id}`).then(resp => {
                    this.leaveRequestClone = resp.data.data;
                }, error => {

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