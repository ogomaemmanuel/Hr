<template>
	<ModalTemplate @modalClosed="$router.back()">
		<slot name="modal-content">
			<LeaveTypeEditForm
					slot="modal-content"
					@leaveUpdateSuccessful="onUpdateSuccessful"
					:leave-type-id="id">
			</LeaveTypeEditForm>
		</slot>
	</ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import LeaveTypeEditForm from "./LeaveTypeEditForm";

    export default {
        name: "LeaveTypeEditModal",
        components: {
            ModalTemplate,
            LeaveTypeEditForm
        },
        data() {
            return {
                id: ""
            }
        },
        created() {
            this.id = this.$route.params.id;
        },
        methods: {
            onUpdateSuccessful() {
                this.$emit("leaveUpdateSuccessful");
                this.$router.go(-1);
            },
        }

    }
</script>

<style scoped>

</style>