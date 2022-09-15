<template>
  <ModalTemplate @modalClosed="$emit(`modalClosed`)">
    <div slot="modal-content">

    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import common_mixin from "../../../mixins/common_mixin";
import {Message} from "element-ui"

export default {
  mixins: [common_mixin],
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
      loading: false,
      goalTracking: {}
    }
  },
  methods: {
    createGoalTracking() {
      axios.post("/api/goal-tracking", this.goalTracking)
          .then(resp => {
            Message.success("Goal Tracking Created Successfully");
            this.$emit("createSuccessful");
          }, error => {
            if (error.response.status == 400) {
              this.errors = error.response.data;
              return;
            }
            Message.error("Error creating goal")
          })
    }
  }
}
</script>