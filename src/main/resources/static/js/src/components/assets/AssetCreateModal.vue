<template>
  <ModalTemplate @modalClosed="$router.go(-1)">
    <AssetCreateForm
        @createSuccessful="onCreateSuccessful" slot="modal-content">
    </AssetCreateForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../common/ModalTemplate";
import AssetCreateForm from "./AssetCreateForm";
export default {
  components: {
    ModalTemplate,
    AssetCreateForm
  },
  methods:{
    goBack(){
      this.$router.go(-1);
    },
    onCreateSuccessful(){
      this.$emit("createSuccessful");
      this.goBack();

    }
  }
}
</script>