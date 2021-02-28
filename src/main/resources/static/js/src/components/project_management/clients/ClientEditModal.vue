<template>
    <ModalTemplate width="900" overflow="visible"  @modalClosed="$router.back()">
        <slot name="modal-content">
            <ClientEditForm
                    @updateSuccessful="onUpdated"
                    :client-id="$route.params.id"
                    slot="modal-content">
            </ClientEditForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import ClientEditForm from "./ClientEditForm";
    export default {
        components: {
            ModalTemplate,
            ClientEditForm
        },
        methods: {
            onUpdated() {
                this.$emit("updateSuccessful");
                this.$router.back();
            }
        },
    }
</script>