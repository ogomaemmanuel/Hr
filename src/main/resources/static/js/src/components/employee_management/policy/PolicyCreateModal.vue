<template>
  <ModalTemplate>
    <PolicyCreateForm slot="modal-content"></PolicyCreateForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import PolicyCreateForm from "./PolicyCreateForm";
export default {
  components: {
    ModalTemplate,
    PolicyCreateForm
  }

}
</script>