<template>
	<ModalTemplate @modalClosed="$router.back()">
		<LeaveRequestEditForm
				slot="modal-content"
				:request-id="leaveRequestId"></LeaveRequestEditForm>
	</ModalTemplate>
</template>
<script>
    import LeaveRequestEditForm from "./LeaveRequestEditForm";
    import ModalTemplate from "../common/ModalTemplate";

    export default {
        name: "LeaveRequestEditModal",
        components: {
            LeaveRequestEditForm,
            ModalTemplate
        },
        data() {
            return {
                leaveRequestId: ""
            }
        },
        created() {
            this.leaveRequestId = this.$route.params.id;
        }
    }
</script>
<style lang="scss" scoped>

</style>