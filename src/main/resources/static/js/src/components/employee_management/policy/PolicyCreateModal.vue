<template>
  <ModalTemplate>
    <PolicyCreateForm
        @createSuccessful="onCreateSuccessful"
        slot="modal-content">
    </PolicyCreateForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import PolicyCreateForm from "./PolicyCreateForm";

export default {
  components: {
    ModalTemplate,
    PolicyCreateForm
  },
  methods: {
    onCreateSuccessful() {
      this.$emit("createSuccessful");
      this.$router.go(-1);
    }
  }

}
</script>