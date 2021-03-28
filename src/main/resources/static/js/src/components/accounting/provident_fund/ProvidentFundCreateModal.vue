<template>
  <ModalTemplate @modalClosed="onModalClosed">
    <ProvidentFundCreateForm slot="modal-content"></ProvidentFundCreateForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import ProvidentFundCreateForm from "./ProvidentFundCreateForm";
export default {
  components: {
    ModalTemplate,
    ProvidentFundCreateForm
  },
  data() {
    return {}
  },
  methods: {
    onModalClosed() {
      this.$router.go(-1);
    },
  }
}
</script>