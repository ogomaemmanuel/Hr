<template>
	<div>
		<div class="columns">
			<div class="column is-9">
				<div class="field">
					<label class="label">Leave Types</label>
					<div class="control w-full">
						<div class="select w-full">
							<select @input="clearFieldError('leaveTypeId')" v-model="leaveRequest.leaveTypeId"
									class="w-full">
								<option value="" disabled selected hidden>Select One</option>
								<option
										v-for="leaveType in leaveTypes"
										:value="leaveType.id"
										:key="leaveType.id">{{leaveType.name}}
								</option>
							</select>
						</div>
						<span v-if="errors['leaveTypeId']" class="text-red-400">
							{{errors['leaveTypeId'][0]}}
						</span>
					</div>
				</div>
				<div class="field">
					<label class="label">Start Date</label>
					<div class="control">
						<DatePicker
								v-model="leaveRequest.startDate"
								format="dd-MM-yyyy"
								:picker-options="datePickerOptions"
								@input="clearFieldError('startDate')"
								value-format="yyyy-MM-dd"
								class="date-picker-el w-full"></DatePicker>
					</div>
					<span v-if="errors['startDate']" class="text-red-400">
							{{errors['startDate'][0]}}
						</span>
				</div>
				<div class="field">
					<label class="label">Number of Days</label>
					<div class="control">
						<input
								@input="clearFieldError('numberOfDays')"
								v-model="leaveRequest.numberOfDays"
								class="input"
								type="number">
					</div>
					<span
							v-if="errors['numberOfDays']"
							
							class="text-red-400">
							{{errors['numberOfDays'][0]}}
					</span>
				</div>
				<div class="field">
					<label class="label">Employee In Place</label>
					<div class="control w-full">
						<div class="select w-full">
							<select
									@input="clearFieldError('inPlaceId')"
									v-model="leaveRequest.inPlaceId"
									class="w-full">
								<option value="" disabled selected hidden>Select One</option>
								<option v-for="inPlaceEmployee in inPlaceEmployees" :value="inPlaceEmployee.staffId">
									{{inPlaceEmployee.fullName}}
								</option>
							</select>
						</div>
						<span
								v-if="errors['inPlaceId']"
								class="text-red-400">
							{{errors['inPlaceId'][0]}}
					</span>
					</div>
				</div>
				<div class="field">
					<label class="label">Reason (Optional)</label>
					<div class="control">
						<textarea
								@input="clearFieldError('reason')"
								v-model="leaveRequest.reason"
								class="textarea"
								placeholder="Textarea">
						</textarea>
					</div>
					<span v-if="errors['reason']" class="text-red-400">
							{{errors['reason'][0]}}
					</span>
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
    import CommonMixin from "../../mixins/common_mixin"

    export default {
        name: "LeaveRequestForm",
        mixins: [CommonMixin],
        components: {
            DatePicker
        },
        data() {
            return {
                datePickerOptions: {
                    disabledDate(date) {
                        return (date.getTime() < Date.now() - 8.64e7)||
							moment(date.getTime()).isoWeekday()==7||moment(date.getTime()).isoWeekday()==6;
                    }
                },
                leaveRequest: {
                    leaveTypeId: "",
                    inPlaceId: ""
                },
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
                                text: "Leave Request successfully submitted"
                            }
                        )
                    }
                }, error => {
                    vm.loading = false;
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
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