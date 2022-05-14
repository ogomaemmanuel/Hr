<template>
    <ModalTemplate width="900" @modalClosed="$router.back()">
        <TerminationEditForm
                @terminationUpdated="onTerminationUpdated"
                :id="$route.params.id"
                slot="modal-content">
        </TerminationEditForm>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import TerminationEditForm from "./TerminationEditForm";

    export default {
        components: {
            ModalTemplate,
            TerminationEditForm
        },
        data() {
            return {}
        },
        methods: {
            onTerminationUpdated() {
                this.$emit("terminationUpdated");
                this.$router.back();
            }
        }
    }
</script>
<style>

</style>