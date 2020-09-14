<template>
    <ModalTemplate width="900" ref="modalTemplate" @modalClosed="onModalClosed">
        <slot name="modal-content">
            <ClientCreateForm
                    @roleCreateSuccessful="onClientCreateSuccessful"
                    slot="modal-content">
            </ClientCreateForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import ClientCreateForm from "./ClientCreateForm";
    import ModalTemplate from "../../common/ModalTemplate"
    export default {
        components: {
            ModalTemplate,
            ClientCreateForm
        },
        methods: {
            onClientCreateSuccessful() {
                this.$emit("createSuccessful");
                this.$router.back();
            },
            onModalClosed() {
                this.$router.back();
            }
        }

    }
</script>
