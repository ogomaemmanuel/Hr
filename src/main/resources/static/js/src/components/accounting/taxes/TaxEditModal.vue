<template>
  <div>
    <ModalTemplate @modalClosed="onModalClosed">
      <TaxEditForm :id="$route.params.id" slot="modal-content"></TaxEditForm>
    </ModalTemplate>
  </div>
</template>
<script>
import TaxEditForm from "./TaxEditForm"
import ModalTemplate from "../../common/ModalTemplate";

export default {
  components: {
    ModalTemplate,
    TaxEditForm
  },
  data() {
    return {}
  },
  computed: {
    taxId() {
      return this.$route.params.id;
    }
  },
  methods: {
    onModalClosed() {
      this.$router.go(-1);
    }
  }
}
</script>