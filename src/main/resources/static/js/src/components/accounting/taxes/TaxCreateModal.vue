<template>
  <div>
    <ModalTemplate @modalClosed="onModalClosed">
      <slot name="modal-content">
        <TaxCreateForm></TaxCreateForm>
      </slot>
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
    }
  }
}
</script>