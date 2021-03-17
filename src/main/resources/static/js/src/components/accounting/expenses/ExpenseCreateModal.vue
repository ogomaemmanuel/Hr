<template>
  <ModalTemplate width="800" @modalClosed="onModalClosed">
    <ExpenseCreateForm
        :id="id"
        @createSuccessful="onCreateSuccessful"
        slot="modal-content">
    </ExpenseCreateForm>
  </ModalTemplate>
</template>
<script>
import ExpenseCreateForm from "./ExpenseCreateForm";
import ModalTemplate from "../../common/ModalTemplate";

export default {
  components: {
    ExpenseCreateForm,
    ModalTemplate
  },
  methods: {
    onModalClosed() {
      this.$router.go(-1);
    },
    onCreateSuccessful() {
      // this.$emit("createSuccessful")
      this.$router.go(-1);
    }
  },
}
</script>