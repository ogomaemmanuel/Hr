<template>
  <ModalTemplate @modalClosed="onModalClosed">
    <LeaveRequestForm @leaveRequestSuccessful="onLeaveRequestSuccessful" slot="modal-content">
    </LeaveRequestForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../common/ModalTemplate";
import LeaveRequestForm from "./LeaveRequestForm";

export default {


  props: {
    useRouter: {
      default: true
    }
  },

  components: {
    ModalTemplate,
    LeaveRequestForm
  },
  methods: {
    onModalClosed(){
      if (this.useRouter) {
        this.$router.back();
        return
      }
      else {
        this.$emit("modalClosed")
      }
    },
    onLeaveRequestSuccessful() {
      this.$emit("leaveRequestSuccessful");
      if (this.useRouter) {
        this.$router.back();
        return
      }


    }
  }

}
</script>
<style lang="scss" scoped>

</style>