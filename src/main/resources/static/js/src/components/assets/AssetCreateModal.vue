<template>
  <ModalTemplate @modalClosed="$router.go(-1)">
    <AssetCreateForm slot="modal-content">
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
  }
}
</script>