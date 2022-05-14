<template>
    <tr>
      <td>{{ member.name }}</td>
      <td>{{ member.relationship }}</td>
      <td> {{ member.dob }}</td>
      <td>{{ member.phoneNumber }}</td>
<!--      <td><span @click.prevent="showModal=true" class="fa fa-ellipsis-v"></span></td>-->
      <td><span @click.prevent="showModal=true" class="fa fa-pencil" title="Edit"></span></td>

    <ModalTemplate width="920" @modalClosed="closeModal" v-if="showModal">
      <div slot="modal-content">
        <UpdateMember @updatedMember="showModal=false" :member="member"></UpdateMember>
      </div>
    </ModalTemplate>
    </tr>
</template>

<script>
import ModalTemplate from "../../../common/ModalTemplate";
import UpdateMember from "../UpdateMember";

export default {
  name: "Member",
  props: {
    member: {
      required: true
    }
  },
  components: {
    ModalTemplate,
    UpdateMember
  },
  data(){
    return {
      showModal: false
    }
  },
  methods: {
    closeModal() {
      let vm = this;
      vm.showModal = false;
    }
  }
}
</script>

<style lang="scss" scoped>
.fa-pencil {
  background-color: transparent;
  border: none;
  color: #00d1b2;
}
.fa-pencil:hover {
  background-color: transparent;
  transform: scale(1.2);
  color: #00d1b2;
}
</style>