<template>
  <div>
    <ModalTemplate @modalClosed="onModalClosed">
      <TaxCreateForm
          @createSuccessful="onCreateSuccessful"
          slot="modal-content"></TaxCreateForm>
    </ModalTemplate>
  </div>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import TaxCreateForm from "./TaxCreateForm";

export default {
  components: {
    ModalTemplate,
    TaxCreateForm
  },
  data() {
    return {}
  },
  methods: {
    onModalClosed() {
      this.$router.go(-1);
    },
    onCreateSuccessful() {
      this.$emit('createSuccessful')
      this.$router.go(-1);
    }
  }
}
</script>