<template>
	<div>
		<form>
			<div class="has-text-centered m-3">
				<h1 class="has-text-black"><b>Add Holiday</b></h1>
			</div>
			<div class="field">
				<label class="label is-size-7">Holiday Name <span><sup>*</sup></span></label>
				<div class="control">
					<input v-model="holiday.name" class="input" type="text">
				</div>
			</div>
			<div class="field">
				<label class="label is-size-7">Holiday Date <span><sup>*</sup></span></label>
				<div class="control">
					<DatePicker
							format="dd-MM-yyyy"
							value-format="yyyy-MM-dd"
							class="date-picker" v-model="holiday.date">
					</DatePicker>
				</div>
			</div>
			<div class="flex justify-center m-3">
				<button @click.stop="createHoliday" class="button is-small is-rounded" type="submit">Submit</button>
			</div>
		</form>
	</div>
</template>
<script>
    import {DatePicker} from "element-ui"

    export default {
        components: {
            DatePicker
        },
        data() {
            return {
                holiday: {
                    name: null,
                    date: null,
                }
            }
        },
        methods: {
            createHoliday() {
                let vm = this;
                axios.post("/api/holidays", vm.holiday).then(resp => {

                }, error => {

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