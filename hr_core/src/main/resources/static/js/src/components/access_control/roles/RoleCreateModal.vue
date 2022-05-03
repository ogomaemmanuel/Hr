<template>
	<ModalTemplate ref="modalTemplate" @modalClosed="onModalClosed">
		<slot name="modal-content">
			<RoleCreateForm @roleCreateSuccessful="onRoleCreateSuccessful"
							   slot="modal-content"></RoleCreateForm>
		</slot>
	</ModalTemplate>
</template>
<script>
    import RoleCreateForm from "./RoleCreateForm";
    import ModalTemplate from "../../common/ModalTemplate"
    export default {
        components: {
            ModalTemplate,
            RoleCreateForm
        },
        methods: {
            onRoleCreateSuccessful() {
                this.$emit("roleCreateSuccessful");
                this.$router.back();
            },
            onModalClosed() {
                this.$router.back();
            }
        }

    }
</script>