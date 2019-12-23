<template>
	<div>
		<div class="pb-2 flex justify-end">
			<router-link
					to="leave-create"
					tag="button"
					class="button is-primary">
				<i class="fa fa-plus mr-1"></i>New Requests
			</router-link>
		</div>
		<div class="columns">
			<div class="column is-8">
				<div class="card">
					
					<div class="card-content">
						<div class="content">
							<h4>My Leave Requests</h4>
							<table class="table w-full">
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
								
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="column is-4">
				<LeaveBalanceCard></LeaveBalanceCard>
			</div>
		</div>
	
	</div>
</template>
<script>
    import LeaveBalanceCard from "./LeaveBalanceCard.vue"
    export default {
        components: {
            LeaveBalanceCard
        }
    }
</script>