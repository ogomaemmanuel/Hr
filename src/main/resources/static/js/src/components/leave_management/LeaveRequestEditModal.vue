<template>
	<ModalTemplate @modalClosed="$router.back()">
		<LeaveRequestEditForm :id="leaveRequestId"></LeaveRequestEditForm>
	</ModalTemplate>
</template>

<script>
    import LeaveRequestEditForm from "./LeaveRequestEditForm";
    export default {
        name: "LeaveRequestEditModal",
        components: {
            LeaveRequestEditForm
        },
        props: {
            leaveRequestId: this.route.params.id
        },
    }
</script>
<style lang="scss" scoped>

</style>