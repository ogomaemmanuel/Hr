<template>
	<div>
		<form>
			<div class="has-text-centered m-3">
				<h1 class="has-text-black"><b>Add Holiday</b></h1>
			</div>
			<div class="field">
				<label class="label is-size-7">Holiday Name <span><sup>*</sup></span></label>
				<div class="control">
					<input
							v-model="holiday.name"
							@input="clearFieldError('name')"
							class="input"
							type="text">
					<span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
				</div>
			</div>
			<div class="field">
				<label class="label is-size-7">Holiday Date <span><sup>*</sup></span></label>
				<div class="control">
					<DatePicker
							@input="clearFieldError('date')"
							format="dd-MM-yyyy"
							value-format="yyyy-MM-dd"
							class="date-picker" v-model="holiday.date">
					</DatePicker>
					<span class="mb-2 has-text-danger" v-if="errors['date']">
						{{errors['date'][0]}}
					</span>
				</div>
			</div>
			<div class="flex justify-center m-3">
				<button
						:class="{'is-loading':loading}"
						@click.prevent.stop="createHoliday"
						class="button is-small is-rounded"
						type="submit">Submit
				</button>
			</div>
		</form>
	</div>
</template>
<script>
    import {DatePicker} from "element-ui"
    import CommonMixin from "../../mixins/common_mixin"

    export default {
        mixins: [CommonMixin],
        components: {
            DatePicker
        },
        data() {
            return {
                holiday: {
                    name: null,
                    date: null,
                },
                loading: false
            }
        },
        methods: {
            createHoliday() {
                let vm = this;
                vm.loading = true;
                axios.post("/api/holidays", vm.holiday).then(resp => {
                    vm.loading = false;
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Holiday created successfully"
                    })
                    vm.$emit("holidayCreateSuccessful")
                }, error => {
                    vm.loading = false;
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            }
        }
    }
</script>
<style scoped lang="scss">
	.date-picker {
		min-width: 100%;
		width: 100%;
	}
</style>