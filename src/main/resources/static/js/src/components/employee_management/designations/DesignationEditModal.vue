<template>
    <ModalTemplate overflow="visible" ref="modalTemplate" @modalClosed="$router.back()">
        <slot name="modal-content">
            <DesignationEditForm
                    @designationUpdated="onDesignationUpdated"
                    :designation-id="$route.params.id"
                    slot="modal-content">
            </DesignationEditForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import DesignationEditForm from "./DesignationEditForm";

    export default {
        components: {
            ModalTemplate,
            DesignationEditForm
        },
        data() {
            return {}
        },
        methods: {
            onDesignationUpdated() {
                this.$emit("designationUpdated");
                this.$router.back();
            }
        },
        created() {

        }

    }
</script>