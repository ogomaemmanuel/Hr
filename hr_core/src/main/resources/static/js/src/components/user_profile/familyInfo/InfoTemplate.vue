<template>
  <div>
    <div class="card">
      <div class="card-content">
        <div class="flex">
          <h1 class="flex-1 title is-5">Family Information </h1>
          <div>
            <button @click="showModal=true">
              <i class="fa fa-pencil"></i>
            </button>
          </div>
        </div>
        <div>
          <table class="table-body table has-mobile-cards w-full is-hoverable">
            <thead>
            <tr>
              <th>Name</th>
              <th>Relationship</th>
              <th>Date of Birth</th>
              <th>Phone</th>
              <th></th>
            </tr>
            </thead>
              <tbody>
              <tr is="Member" v-for="member in members" :member="member"
                  :key="member.id"></tr>
              </tbody>
          </table>
        </div>
      </div>
    </div>
    <ModalTemplate width="920" @modalClosed="closeModal" v-if="showModal">
      <div slot="modal-content">
        <CreateMembers @updatedMember="showModal=false" :user-id="userId"></CreateMembers>
      </div>
    </ModalTemplate>
  </div>
</template>

<script>
import ModalTemplate from "../../common/ModalTemplate";
import CreateMembers from "./CreateFamilyMembers";
import Member from "./tables/Member";

export default {
  name: "InfoTemplate",
  props: {
    userId: {
      required: true
    }
  },
  components: {
    CreateMembers,
    ModalTemplate,
    Member
  },
  data() {
    return {
      showModal: false,
      members: []
    }
  },
  created() {
    this.getFamilyMembers();
  },
  methods: {
    closeModal() {
      let vm = this;
      vm.showModal = false;
    },
    getFamilyMembers() {
      let vm = this;
      axios.get(`/api/users/family-members/${vm.userId}`).then(resp => {
        vm.members = resp.data;
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.table-body {
  max-height: 200px;
  overflow: scroll;
}
</style>