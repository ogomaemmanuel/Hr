<template>
  <ModalTemplate @modalClosed="onModalClosed">
    <ExpenseEditForm
        @updateSuccessfull="onUpdateSuccessful"
        slot="modal-content">

    </ExpenseEditForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import ExpenseEditForm from "./ExpenseEditForm";

export default {
  components: {
    ExpenseEditForm,
    ModalTemplate
  },
  methods: {
    onModalClosed() {
      this.$router.go(-1);
    },
    onUpdateSuccessful(){

    }
  }

}
</script>