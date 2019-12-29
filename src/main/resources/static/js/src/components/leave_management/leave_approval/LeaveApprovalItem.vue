<template>
	<tr>
		<td>
			<div class="has-text-primary">
			{{leaveRequestClone.employee}}
			</div>
		</td>
		<td>{{leaveRequestClone.startDate|dateFormat}}</td>
		<td>{{leaveRequestClone.endDate|dateFormat}}</td>
		<td>{{leaveRequestClone.numberOfDays}}</td>
		<td>
			{{leaveRequestClone.leaveType}}
		</td>
		<td>{{statusText}}</td>
		<td>
			<div>
				<button class="button is-small is-white">
					<span class="icon">
						<i class="fa fa-eye has-text-primary"></i>
					</span>
				</button>
				<button class="button is-small is-white">
					<span class="icon ">
						<i class="fa fa-trash has-text-danger"></i>
					</span>
				</button>
			</div>
		</td>
	</tr>

</template>
<script>
    export default {
        props: {
            leaveRequest: {
                required: true,
                type: Object
            }
        },
		created(){
            this.leaveRequestClone={...this.leaveRequest}
		},
        data() {
            return {
                leaveRequestClone: {}
            }
        },
        filters: {
            dateFormat(date) {
                return moment(date).format("LL")
            }
        },
		computed:{
            statusColor() {
                if (this.leaveRequestClone.status.toLowerCase() == "new") {
                    return 'is-primary'
                }
                if (this.leaveRequestClone.status.toLowerCase() == "withdrawn") {
                    return 'is-warning'
                }
            },
			statusText() {
                if (this.leaveRequestClone.status.toLowerCase() == "new") {
                    return 'Awaiting In Place Approval'
                }
                if (this.leaveRequestClone.status.toLowerCase() == "withdrawn") {
                    return 'is-warning'
                }
            },
		}
    }
</script>