<template>
	<div class="hero is-fullheight">
		<div class="hero-body">
			<div class="container">
				<div class="text-center">
					<h2 class="text-black font-semibold">This page isn't available</h2>
					<h5>The link you followed may be broken, or the page may have been removed.</h5>
					<div class="flex m-2 justify-center">
					<img src="/images/undraw_not_found_60pq.svg" width="200px" alt="page not found image">
					</div>
					<button @click="goBack()" class="button is-success">Back</button>
				</div>
			</div>
		</div>
	
	</div>
</template>
<script>
    export default {
        methods: {
            goBack() {
                return this.$router.go(-1);
            }
        }
    }
</script>
