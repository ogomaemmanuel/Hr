<template>
	<div class="notification-item  pr-2 pl-2 pt-1 pb-1">
		<div>
			{{notification.message}}
		</div>
		<div class="mt-1">
		<span><i class="fa fa-calendar"></i></span>	{{notification.updatedAt|formattedDate}}
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
        filters:{
            formattedDate(value){

                return    moment(value).format("LL")
            }
        },
    }
</script>
<style scoped lang="scss">
	.notification-item {
		display: flex;
		flex-direction: column;
		&:hover{
			background-color: #fafafa;
		}
	}
</style>