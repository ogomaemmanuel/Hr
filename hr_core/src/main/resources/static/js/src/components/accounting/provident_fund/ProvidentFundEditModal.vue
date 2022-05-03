<template>
  <ModalTemplate width="900">
    <ProvidentFundEditForm :id="id" slot="modal-content">
    </ProvidentFundEditForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import ProvidentFundEditForm from "./ProvidentFundEditForm";

export default {
  components: {
    ModalTemplate,
    ProvidentFundEditForm
  },
  data() {
    return {
      id: ""
    }
  },
  created() {
    this.id = this.$route.params.id;
  }

}
</script>