<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">

    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import common_mixin from "../../../mixins/common_mixin";
import {Message} from "element-ui";

export default {
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      loading: false,
      trainer: {}
    }
  },
  methods: {
    createTrainer() {
      let vm = this;
      axios.post("/api/trainers", this.trainer).then(resp => {
        Message.success("Trainer successfully created");
        vm.$emit("createSuccessful")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>