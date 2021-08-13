<template>
  <ModalTemplate @modalClosed="goBack()">
    <JobCreateForm slot="modal-content"></JobCreateForm>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import JobCreateForm from "./JobCreateForm";
export default {
  components:{
    ModalTemplate,
    JobCreateForm
  },
  methods:{
    goBack(){
      this.$router.go(-1);
    }
  }
}
</script>