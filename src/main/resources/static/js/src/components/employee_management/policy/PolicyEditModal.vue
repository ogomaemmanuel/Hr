<template>
  <ModalTemplate @modalClosed="$router.go(-1)">
    <PolicyEditForm
        :id="$route.params.id"
        slot="modal-content">
    </PolicyEditForm>
  </ModalTemplate>
</template>
<script>
import PolicyEditForm from "./PolicyEditForm";
import ModalTemplate from "../../common/ModalTemplate";

export default {
  components: {
    PolicyEditForm,
    ModalTemplate
  },
  data() {
    return {

    }
  },
  created() {

  },
  methods: {}
}
</script>