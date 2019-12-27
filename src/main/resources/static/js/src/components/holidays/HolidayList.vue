<template>
	<div>
		<div class="pb-2 flex justify-end">
			<router-link
					to="leave-create"
					tag="button"
					class="button is-primary">
				<i class="fa fa-plus mr-1"></i> Add New
			</router-link>
		</div>
		<div class="columns">
			<div class="column is-12">
				<div class="card" ref="leaveRequests">
					<div class="card-content">
						<div class="content">
							<h4>Holidays</h4>
							<table class="table w-full">
								<thead class="font-thin">
								<tr>
									<th>
										Name
									</th>
									<th>
										Date
									</th>
									<th>
										Description
									</th>
									<th>
										Action
									</th>
								</tr>
								</thead>
								<tbody>
								<tr v-for="holiday in holidays">
									<td>{{holiday.name}}</td>
									<td>{{holiday.date}}</td>
									<td>{{holiday.name}}</td>
									<td>
										<i class="fa fa-eye"></i>
										<i class="fa fa-trash"></i>
									</td>
								</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
    export default {
        data() {
            return {
                holidays: []
            }
        },
        created() {
            this.getHolidays();
        },
        methods: {
            getHolidays() {
                axios.get("/api/holidays").then(resp => {
                    this.holidays = resp.data;
                })
            }

        }
    }
</script>