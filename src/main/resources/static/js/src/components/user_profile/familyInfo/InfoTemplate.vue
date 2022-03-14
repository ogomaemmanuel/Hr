<template>
  <div>
    <div class="card h-full">
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
        <table class="table has-mobile-cards w-full is-hoverable">
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
          <tr>
            <td>Eric</td>
            <td>Father</td>
            <td>2020-05-05</td>
            <td>0720051193</td>
            <td>:</td>
          </tr>
          </tbody>

        </table>
      </div>
      </div>
    </div>
    <ModalTemplate width="920" @modalClosed="closeModal" v-if="showModal">
      <div slot="modal-content">
        <UpdateInfo></UpdateInfo>
      </div>
    </ModalTemplate>
  </div>
</template>

<script>
import ModalTemplate from "../../common/ModalTemplate";
import UpdateInfo from "./UpdateInfo";

export default {
  name: "InfoTemplate",
  components: {
    UpdateInfo,
    ModalTemplate
  },
  data() {
    return {
      showModal: false,
    }
  },
  methods: {
    closeModal() {
      let vm = this;
      vm.showModal = false;
    },
  }
}
</script>

<style scoped>

</style>