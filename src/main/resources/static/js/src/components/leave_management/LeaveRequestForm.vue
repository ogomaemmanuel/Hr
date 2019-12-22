<template>
	<div>
		<div class="columns">
			<div class="column is-9">
				<div class="field">
					<label class="label">Leave Types</label>
					<div class="control w-full">
						<div class="select w-full">
							<select class="w-full">
								<option>Select dropdown</option>
								<option>With options</option>
							</select>
						</div>
					</div>
				</div>
				<div class="field">
					<label class="label">Name</label>
					<div class="control">
						<input class="input" type="text" placeholder="Text input">
					</div>
				</div>
				<div class="field">
					<label class="label">Reason</label>
					<div class="control">
						<textarea class="textarea" placeholder="Textarea"></textarea>
					</div>
				</div>
				<div class="field is-grouped">
					<div class="control">
						<button class="button is-primary">Submit</button>
					</div>
					<div class="control">
						<button @click.prevent="goBack()" class="button is-light">Cancel</button>
					</div>
				</div>
			</div>
			<div class="column is-3 available-leave-days-card">
			
			</div>
		</div>
	</div>
</template>

<script>
    export default {
        name: "LeaveRequestForm",

        methods: {
            goBack() {
                this.$router.go(-1);
            }
        }
    }
</script>

<style scoped>

</style>