<template>
	<div class="card">
		<div class="card-content">
			<div class="content">
				<h4>My Leave Balances</h4>
				<table class="table w-full">
					<thead class="font-thin">
					<tr>
						<th>
							Type
						</th>
						<th>
							Days Eligible
						</th>
						<th>
							Available
						</th>
					</tr>
					</thead>
					<tbody>
					<tr v-for="leaveBalance in leaveBalances">
						<td>{{leaveBalance.leaveType}}</td>
						<td>{{leaveBalance.elligibleDays}}</td>
						<td>{{getDaysAvailable(leaveBalance.elligibleDays,leaveBalance.totalDaysApplied)}}</td>
					</tr>
					
					</tbody>
				</table>
			</div>
		</div>
	</div>
</template>
<script>
    export default {
        data() {
            return {
                leaveBalances: []
            }
        },
        created() {
            this.getUserLeaveBalances();
        },
        methods: {
            getUserLeaveBalances() {
                let vm = this;
                axios.get("/api/user/leave-balances").then(resp => {
                    vm.leaveBalances = resp.data;
                })
            },
            getDaysAvailable(daysElligible, daysApplied){
              return   daysElligible-daysApplied
			}
        },
		
    }
</script>