<template>
	<div>
	<form>
		<div class="has-text-centered m-3">
			<h1 class="has-text-black"><b>Add Holiday</b></h1>
		</div>
		<div class="field">
			<label class="label is-size-7">Holiday Name <span><sup>*</sup></span></label>
			<div class="control">
				<input class="input" type="text">
			</div>
		</div>
		<div class="field">
			<label class="label is-size-7">Holiday Date <span><sup>*</sup></span></label>
			<div class="control">
				<input class="input" type="text">
			</div>
		</div>
		<div class="flex justify-center m-3">
			<button class="button is-small is-rounded" type="submit">Submit</button>
		</div>
	</form>
	</div>
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