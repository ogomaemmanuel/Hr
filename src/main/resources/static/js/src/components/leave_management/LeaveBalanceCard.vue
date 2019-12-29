<template>
	<div  class="bg-white">
		<b-notification class="bg-white p-0" ref="leaveBalanceCard" :closable="false">
		<div class="card-content">
			<div  class="content">
				<h4>My Leave Balances</h4>
				<table class="table w-full is-hoverable">
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
		</b-notification>
	</div>
</template>
<script>
	import EmptyState from "../common/EmptyState"
    export default {
	    components:{
            EmptyState
		},
        data() {
            return {
                loaded:false,
                leaveBalances: []
            }
        },
        mounted() {
            this.getUserLeaveBalances();
        },
        methods: {
            getUserLeaveBalances() {
                let vm = this;
                // const loadingComponent = this.$buefy.loading.open({
                //     container: this.isFullPage ? null : this.$refs.leaveBalanceCard.$el
                // })
                axios.get("/api/user/leave-balances").then(resp => {
                  // loadingComponent.close();
                    vm.leaveBalances = resp.data;
                })
            },
            getDaysAvailable(daysElligible, daysApplied) {
                return daysElligible - daysApplied
            }
        },

    }
</script>