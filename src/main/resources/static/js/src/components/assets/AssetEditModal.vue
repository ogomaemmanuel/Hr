<template>
  <ModalTemplate @modalClosed="goBack()">
    <AssetEditForm :id="id" slot="modal-content">
    </AssetEditForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../common/ModalTemplate";
import AssetEditForm from "./AssetEditForm";

export default {
  components: {
    ModalTemplate,
    AssetEditForm
  },
  data() {
    return {
      id: null
    }
  },
  created() {
    this.id = this.$route.params.id;
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    }
  }

}
</script>