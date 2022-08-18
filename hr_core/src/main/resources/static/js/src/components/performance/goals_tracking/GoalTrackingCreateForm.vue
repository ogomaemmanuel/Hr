<template>
  <ModalTemplate @modalClosed="$emit(`modalClosed`)">
    <div slot="modal-content">

    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";

export default {
  components: {
    ModalTemplate
  },
  data() {
    return {
      goalTracking: {}
    }
  }

}
</script>