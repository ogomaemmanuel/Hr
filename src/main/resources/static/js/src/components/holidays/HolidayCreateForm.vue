<template>
	<form>
		<div class="field">
			<label class="label">Name</label>
			<div class="control">
				<input class="input" type="text" placeholder="Text input">
			</div>
		</div>
		<div class="field">
			<label class="label">Name</label>
			<div class="control">
				<input class="input" type="text" placeholder="Text input">
			</div>
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
        }
    }
</script>