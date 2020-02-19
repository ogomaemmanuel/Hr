<template>
	<ModalTemplate @modalClosed="$router.back()">
		<LeaveRequestForm @leaveRequestSuccessful="onLeaveRequestSuccessful" slot="modal-content">
		
		</LeaveRequestForm>
	</ModalTemplate>
</template>
<script>
    import ModalTemplate from "../common/ModalTemplate";
    import LeaveRequestForm from "./LeaveRequestForm";

    export default {
        components: {
            ModalTemplate,
            LeaveRequestForm
        },
        methods: {
            onLeaveRequestSuccessful() {
                this.$emit("leaveRequestSuccessful");
                this.$router.back();
            }
        }

    }
</script>
<style lang="scss" scoped>

</style>