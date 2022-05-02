<template>
  <ModalTemplate @modalClosed="goBack()">
    <JobEditForm
        :id="$route.params.id"
        @updateSuccessful="onUpdateSuccessful"
        slot="modal-content"></JobEditForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import JobEditForm from "./JobEditForm";

export default {
  components: {
    JobEditForm,
    ModalTemplate
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    onUpdateSuccessful() {
      this.$emit("updateSuccessful");
      this.goBack();
    }

  }
}
</script>
<style lang="scss" scoped>

</style>