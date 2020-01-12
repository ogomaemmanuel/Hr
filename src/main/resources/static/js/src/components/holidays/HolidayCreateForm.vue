<template>
	<form>
		<div class="has-text-centered m-3">
			<h1 class="has-text-black">Add Holiday</h1>
		</div>
		<div class="field">
			<label class="label">Holiday Name <span><sup>*</sup></span></label>
			<div class="control">
				<input class="input" type="text" placeholder="Text input">
			</div>
		</div>
		<div class="field">
			<label class="label">Holiday Date <span><sup>*</sup></span></label>
			<div class="control">
				<input class="input" type="text" placeholder="Text input">
			</div>
		</div>
		<div class="flex justify-center m-3">
			<button class="button is-small is-rounded" type="submit">Submit</button>
		</div>
	</form>
</template>
<script>
    export default {
        data() {
            return {
                holiday: {
                    name: null,
                    date: null,
                }
            }
        },
        methods:{
            createHoliday(){
                axios.post("/api/holidays").then(resp=>{
                
				})
			}
		}
    }
</script>