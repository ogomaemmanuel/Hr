<template>
	<form>
		<div class="has-text-centered m-3">
			<h1 class="has-text-black"><b>Create Leave Type</b></h1>
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
					@click.prevent.stop="createLeaveType"
					class="button is-small is-rounded"
					type="submit">Submit
			</button>
		</div>
	</form>
</template>
<script>
    import CommonMixin from "../../../mixins/common_mixin"

    export default {
        mixins: [CommonMixin],
        data() {
            return {
                leaveType: {
                    name: "",
                    numberOfDays: ""
                },
                loading: false
            }
        },
        methods: {
            createLeaveType() {
                this.loading = true;
                axios.post("api/leave-types", this.leaveType).then(resp => {
                        this.loading = false;
                        this.$swal({
                            "text": "Leave Type successfully created",
                            "type": "success"
                        });
                        this.$emit("leaveTypeCreateSuccessful")
                    },
                    error => {
                        if (error.response.status == 400) {
                            this.errors = error.response.data;
                        }
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