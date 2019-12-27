<template>
	<tr>
		<td>{{leaveRequestClone.leaveType.name}}</td>
		<td>{{leaveRequestClone.numberOfDays}}</td>
		<td>{{leaveRequestClone.startDate|dateFormat}}</td>
		<td>{{leaveRequestClone.endDate|dateFormat}}</td>
		<td>
										<span :class="statusColor" class="tag  is-light">
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
				<b-dropdown-item :disabled="disableWithdrawOption"   value="withdraw" @click="confirmLeaveWithdrawal" aria-role="listitem">Withdraw</b-dropdown-item>
				<b-dropdown-item :disabled="disableEditOption"  value="edit" aria-role="listitem">Edit</b-dropdown-item>
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
                    type: 'is-primary is-light',
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
        },
        computed: {
            statusColor() {
                if (this.leaveRequestClone.leaveStatuses.toLowerCase() == "new") {
                    return 'is-primary'
                }
                if (this.leaveRequestClone.leaveStatuses.toLowerCase() == "withdrawn") {
                    return 'is-warning'
                }
            },
            disableEditOption() {
                let isNew= this.leaveRequestClone.leaveStatuses.toLowerCase()=="new";
                return !isNew;
            },
            disableWithdrawOption(){
                let isWithdrawn= this.leaveRequestClone.leaveStatuses.toLowerCase()=="withdrawn";
                return isWithdrawn;
			}
        }
    }
</script>