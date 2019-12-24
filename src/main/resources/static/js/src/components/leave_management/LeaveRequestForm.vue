<template>
	<div>
		<div class="columns">
			<div class="column is-9">
				<div class="field">
					<label class="label">Leave Types</label>
					<div class="control w-full">
						<div class="select w-full">
							<select v-model="leaveRequest.leaveTypeId" class="w-full">
								<option>Select One</option>
								<option
										v-for="leaveType in leaveTypes"
										:value="leaveType.id"
										:key="leaveType.id">{{leaveType.name}}
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="field">
					<label class="label">Start Date</label>
					<div class="control">
						<DatePicker v-model="leaveRequest.startDate"
									format="dd-MM-yyyy"
									value-format="yyyy-MM-dd"
									class="date-picker-el w-full"></DatePicker>
					</div>
				</div>
				<div class="field">
					<label class="label">Number of Days</label>
					<div class="control">
						<input v-model="leaveRequest.numberOfDays" class="input" type="number">
					</div>
				</div>
				<div class="field">
					<label class="label">Employee In Place</label>
					<div class="control w-full">
						<div class="select w-full">
							<select v-model="leaveRequest.inPlaceId" class="w-full">
								<option>Select One</option>
								<option v-for="inPlaceEmployee in inPlaceEmployees" :value="inPlaceEmployee.staffId">
									{{inPlaceEmployee.fullName}}
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="field">
					<label class="label">Reason (Optional)</label>
					<div class="control">
						<textarea
								v-model="leaveRequest.reason"
								class="textarea"
								placeholder="Textarea">
						</textarea>
					</div>
				</div>
				<div class="field is-grouped">
					<div class="control">
						<button :class="{'is-loading':loading}" @click.prevent="makeLeaveRequest"
								class="button is-primary"><i
								class="fa fa-save mr-1"></i>Submit
						</button>
					</div>
					<div class="control">
						<button @click.prevent="goBack()" class="button is-light"><i class="fa fa-times mr-1"></i>
							Cancel
						</button>
					</div>
				</div>
			</div>
			<div class="column is-3 available-leave-days-card">
			
			</div>
		</div>
	</div>
</template>
<script>
    import {DatePicker} from "element-ui"

    export default {
        name: "LeaveRequestForm",
        components: {
            DatePicker
        },
        data() {
            return {
                leaveRequest: {},
                leaveTypes: [],
                inPlaceEmployees: [],
                errors: {},
                loading: false,
				
            }
        },
        created() {
            this.getLeaveTypes();
            this.getInPlaceEmployees();
        },
        methods: {
            goBack() {
                this.$router.go(-1);
            },
            getLeaveTypes() {
                axios.get("/api/leave-types").then(resp => {
                    this.leaveTypes = resp.data;
                })
            },
            makeLeaveRequest() {
                let vm = this;
                vm.loading = true;
                axios.post("/api/leave-request", vm.leaveRequest).then(resp => {
                    vm.loading = false;
                    if (resp.status == 200) {
                        vm.$swal(
                            {
                                type: "success",
                                message: "Leave Request successfully submitted"
                            }
                        )
                    }
                }, error => {
                    vm.loading = false;
                    if (error.response.status == 400) {

                    }
                })
            },
            getInPlaceEmployees() {
                axios.get("/api/leave-requests/in-place").then(resp => {
                    this.inPlaceEmployees = resp.data;
                })
            }
        },
		
    }
</script>

<style scoped lang="scss">
	.date-picker-el {
		width: 100% !important;
	}
</style>