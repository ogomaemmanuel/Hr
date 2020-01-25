<template>
	<div>
		<form>
			<div class="has-text-centered m-3">
				<h1 class="has-text-black"><b>Edit Leave Type</b></h1>
			</div>
			<div class="field">
				<label class="label is-size-7">Name <span><sup>*</sup></span></label>
				<div class="control">
					<input
							v-model="leaveType.name"
							@input="clearFieldError('name')"
							class="input"
							type="text">
					<span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
				</div>
			</div>
			<div class="field">
				<label class="label is-size-7">Number of Days<span><sup>*</sup></span></label>
				<div class="control">
					<input
							@input="clearFieldError('numberOfDays')"
							class="min-w-full input"
							type="number"
							v-model="leaveType.numberOfDays">
					
					<span class="mb-2 has-text-danger" v-if="errors['numberOfDays']">
						{{errors['numberOfDays'][0]}}
					</span>
				</div>
			</div>
			<div class="flex justify-center m-3">
				<button
						
						:class="{'is-loading':loading}"
						:disabled="disableSubmitButton"
						@click.prevent.stop="updateLeaveType"
						class="button is-small is-rounded"
						type="submit">Submit
				</button>
			</div>
		</form>
	</div>
</template>
<script>
	import CommonMixin from "../../../mixins/common_mixin"
    export default {
	    mixins:[CommonMixin],
        props: {
            leaveTypeId: {
                required: true,
            }
        },
        data() {
            return {
                leaveType: {
                    name:"",
					numberOfDays:""
				},
                loading:false
            }
           
        },
        created() {
           this.getLeaveTypeById();
        },
        methods: {
            getLeaveTypeById() {
                let vm = this;
                axios.get(`/api/leave-types/${vm.leaveTypeId}`).then(resp => {
                    vm.leaveType = resp.data;
                }, error => {

                })
            },
            updateLeaveType() {
                axios.put(`/api/leave-types/${vm.leaveTypeId}`,this.leaveType).then(resp => {
                    this.$swal({
                        text: "Leave type successfully updated",
                        type: "success"
                    })
                    this.$emit("leaveUpdateSuccessful");
                })
            }
        },
        computed: {
            disableSubmitButton() {
                return this.leaveType.name.length == 0 ||
                    this.leaveType.numberOfDays.length == 0 || this.loading;
            }
        }
    }
</script>