<template>
	<form>
		<div class="has-text-centered m-3">
			<h1 class="has-text-black"><b>Edit Leave</b></h1>
		</div>
		<div class="field">
			<label class="label is-size-7">Leave Types <span><sup class="has-text-danger">*</sup></span></label>
			<div class="control w-full">
				<div class="select w-full">
					<select @input="clearFieldError('leaveTypeId')"
							v-model="leaveRequest.leaveTypeId"
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
		<div class="columns">
			<div class="column">
				<div class="field">
					<label class="label is-size-7">From <span><sup class="has-text-danger">*</sup></span></label>
					<div class="control">
						<DatePicker
								v-model="leaveRequest.startDate"
								class="min-w-full">
						</DatePicker>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="field">
					<label class="label is-size-7">To <span><sup class="has-text-danger">*</sup></span></label>
					<div class="control">
						<DatePicker
								v-model="leaveRequest.endDate"
								class="min-w-full"></DatePicker>
					
					</div>
				</div>
			</div>
		
		</div>
		
		
		<div class="field">
			<label class="label is-size-7">Number of Days<span><sup>*</sup></span></label>
			<div class="control">
				<input
						disabled
						class="input"
						type="text">
			</div>
		</div>
		<div class="field">
			<label class="label is-size-7">Remaining Leaves Days<span><sup>*</sup></span></label>
			<div class="control">
				<input
						disabled
						class="input"
						type="text">
			</div>
		</div>
		<div class="field">
			<label class="label is-size-7">Reason<span><sup>*</sup></span></label>
			<div class="control">
				<textarea class="textarea"></textarea>
			</div>
		</div>
		<div class="flex justify-center m-3">
			<button
					@click.prevent.stop=""
					class="button is-small is-rounded"
					type="submit">Submit
			</button>
		</div>
	</form>
</template>

<script>
    import CommonMixin from "../../mixins/common_mixin"
    import {DatePicker} from "element-ui"

    export default {
        name: "LeaveRequestEditForm",
        mixins: [CommonMixin],
        components: {
            DatePicker
        },
        data() {
            return {
                leaveRequest: {},
                leaveTypes: []
            }
        },
        created() {
            this.getLeaveTypes();
        },
        methods: {
            getLeaveTypes() {
                axios.get("/api/leave-types").then(resp => {
                    this.leaveTypes = resp.data;
                })
            },
        }
    }
</script>

<style scoped>

</style>