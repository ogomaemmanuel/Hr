<template>
    <ModalTemplate width="900" @modalClosed="$router.back()">
        <TerminationEditForm
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
        }
    }
</script>
<style>

</style>