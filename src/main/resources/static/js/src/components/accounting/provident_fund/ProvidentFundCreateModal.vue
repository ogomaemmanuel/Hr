<template>
  <ModalTemplate @modalClosed="onModalClosed">

  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";

export default {
  components: {
    ModalTemplate
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