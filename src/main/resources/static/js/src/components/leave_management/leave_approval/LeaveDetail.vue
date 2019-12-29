<template>
	<div class="">
		<div class="flex justify-end">
			<router-link tag="a" to="/leave-approvals">
				<span class="icon">
					<i class="fa fa-angle-left"></i>
				</span>
				<span>Back To List</span>
			</router-link>
		</div>
		<div class="relative bg-white mt-5 p-5">
			
			<div class="columns">
				<div class="column">
					<h4 class="has-text-black">Employee Name</h4>
					<h4 class="has-text-grey-light">Emmanuel Ogoma</h4>
				</div>
				<div class="column">
					<h4 class="has-text-black">Date Submitted</h4>
					<h4 class="has-text-grey-light">Date Submitted</h4>
				</div>
				<div class="column">
					<h4 class="has-text-black">Leave Type</h4>
					<h4 class="has-text-grey-light">Leave Type</h4>
				</div>
				<div class="column">
					<h4 class="has-text-black">Status</h4>
					<h4 class="has-text-grey-light">Status</h4>
				</div>
			</div>
			<div class="columns">
				<div class="column">
					<h4 class="has-text-black">Start Date</h4>
					<h4 class="has-text-grey-light">Emmanuel Ogoma</h4>
				</div>
				<div class="column">
					<h4 class="has-text-black">End Date</h4>
					<h4 class="has-text-grey-light">Date Submitted</h4>
				</div>
				<div class="column">
					<h4 class="has-text-black">Leave Period in Days</h4>
					<h4 class="has-text-grey-light">Leave Type</h4>
				</div>
				<div class="column">
					<h4 class="has-text-black">Status</h4>
					<h4 class="has-text-grey-light">Status</h4>
				</div>
			</div>
			<div class="flex justify-center">
				<button class="button is-primary is-small mr-5">
					<span>
						Approve
                    </span>
				</button>
				<button class="button is-light is-small">
					<span>
						Reject
                    </span>
				</button>
			</div>
		</div>
	</div>
</template>
<script>
    export default {
        data() {

            return {}
        }
    }
</script>