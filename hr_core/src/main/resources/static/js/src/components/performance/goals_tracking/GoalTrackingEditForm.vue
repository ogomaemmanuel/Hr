<template>
  <ModalTemplate @modalClosed="$emit(`modalClosed`)">
    <div slot="modal-content">

    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";

export default {
  props: {
    id: {
      required: true
    }
  },
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