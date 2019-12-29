<template>
	<tr>
		<td>{{leaveRequestClone.employee}}</td>
		<td>{{leaveRequestClone.startDate}}</td>
		<td>{{leaveRequestClone.endDate}}</td>
		<td>{{leaveRequestClone.numberOfDays}}</td>
		
		<td>{{leaveRequestClone.leaveType}}</td>
		<td>{{leaveRequestClone.status}}</td>
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
        }
    }
</script>