<template>
    <ModalTemplate>
        <TerminationEditForm slot="modal-content">
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
        }
    }
</script>
<style>

</style>