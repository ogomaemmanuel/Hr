<template>
	<ModalTemplate ref="modalTemplate" @modalClosed="onModalClosed">
		<slot name="modal-content">
			<LeaveTypeCreateForm @leaveTypeCreateSuccessful="onCreateSuccessful"
								 slot="modal-content"></LeaveTypeCreateForm>
		</slot>
	</ModalTemplate>
</template>
<script>
    import LeaveTypeCreateForm from "./LeaveTypeCreateForm";
    import ModalTemplate from "../../common/ModalTemplate"

    export default {
        components: {
            ModalTemplate,
            LeaveTypeCreateForm
        },
        methods: {
            onCreateSuccessful() {
                this.$emit("holidayCreateSuccessful");
                this.$router.go(-1);
            },
            onModalClosed() {
                this.$router.go(-1);
            }
        }

    }
</script>