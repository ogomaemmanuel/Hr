<template>
  <ModalTemplate @modalClosed="onModalClosed">
    <ExpenseEditForm
        :id="id"
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
  data() {
    return {
      id: ""
    }
  },
  created() {
    this.id = this.$route.params.id;
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