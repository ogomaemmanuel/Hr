<template>
	<div class="notification-item  pr-2 pl-2 pt-1 pb-1">
		<div>
			{{notification.message}}
		</div>
		<div class="mt-1 is-size-7">
			<span class="mr-2">
				{{notification.updatedAt|formattedDate}}
			</span>
		</div>
		<div>
		</div>
	</div>
</template>
<script>
    export default {
        props: {
            notification: {
                required: true,
                type: Object
            }
        },
        filters: {
            formattedDate(value) {
                return moment(value).format("LLL")
            }
        },
    }
</script>
<style scoped lang="scss">
	.notification-item {
		display: flex;
		flex-direction: column;
		
		&:hover {
			background-color: #fafafa;
		}
	}
</style>