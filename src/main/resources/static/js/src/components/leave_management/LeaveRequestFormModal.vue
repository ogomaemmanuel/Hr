<template>
	<ModalTemplate @modalClosed="$router.back()">
		<LeaveRequestForm slot="modal-content">
		
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
        }

    }
</script>
<style lang="scss" scoped>

</style>