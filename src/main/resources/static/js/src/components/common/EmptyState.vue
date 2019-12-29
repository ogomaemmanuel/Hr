<template>
	<div class="bg-white  min-h-full p-5 flex justify-center align-center">
		<div>
			<img src="/images/undraw_no_data_qbuo.svg" width="200px" alt="empty state here">
			<div class="mt-3 flex flex-col justify-center has-text-grey-light">
				<slot></slot>
			</div>
		</div>
	</div>
</template>
<script>
	export default {
	
	}
</script>