<template>
  <ModalTemplate width="800" @modalClosed="onModalClosed">
    <ExpenseCreateForm
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
    }
  },
}
</script>