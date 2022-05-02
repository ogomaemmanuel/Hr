<template>
<div>
  <div class="card h-full">
    <div class="card-content">
      <div class="flex">
        <h1 class="flex-1 title is-5 has-text-weight-bold">Emergency Contact</h1>
        <div>
          <button @click.prevent="showEcModal=true; showModal=true">
            <i class="fa fa-pencil"></i>
          </button>
        </div>
      </div>
      <div>
        <div class="columns">
          <label class="column is-7 has-text-weight-bold">Primary</label>
        </div>
        <div class="columns contact-detail">
          <label class="column is-7 contact-label has-text-weight-bold">Name</label>
          <p class=" column is-5 has-text-weight-medium text-gray-600">{{ emergencyContact.primaryName }}</p>
        </div>
        <div class="columns contact-detail">
          <label class="column is-7 contact-label has-text-weight-bold">Relationship</label>
          <p class=" column is-5 has-text-weight-medium text-gray-600">{{ emergencyContact.primaryRelationship }}</p>
        </div>
        <div class="columns">
          <label class="column is-7 has-text-weight-bold">Phone</label>
          <p class=" column is-5 has-text-weight-medium text-gray-600">{{ primaryPhone }}</p>
        </div>
        <div class="columns contact-header show-top-border">
          <label class="column is-7 has-text-weight-bold">Secondary</label>
        </div>
        <div class="columns contact-detail">
          <label class="column is-7 contact-label has-text-weight-bold">Name</label>
          <p class=" column is-5 has-text-weight-medium text-gray-600">{{ emergencyContact.secondaryName }}</p>
        </div>
        <div class="columns contact-detail">
          <label class="column is-7 contact-label has-text-weight-bold">Relationship</label>
          <p class=" column is-5 has-text-weight-medium text-gray-600">{{ emergencyContact.secondaryRelationship }}</p>
        </div>
        <div class="columns contact-detail">
          <label class="column is-7 contact-label has-text-weight-bold">Phone</label>
          <p class=" column is-5 has-text-weight-medium text-gray-600">{{ secondaryPhone }}</p>
        </div>
      </div>
    </div>
  </div>
  <ModalTemplate width="920" @modalClosed="closeModal" v-if="showModal">
    <div slot="modal-content">
      <UpdateContact @updatedContact="closeModal"
                        :employeeId="employeeId"
                        :emergencyContact="emergencyContact">
      </UpdateContact>
    </div>
  </ModalTemplate>
</div>
</template>

<script>
import {mapGetters} from "vuex";
import ModalTemplate from "../../common/ModalTemplate";
import UpdateContact from "./UpdateContact";

export default {
  name: "ContactsTemplate",
  components: {
    ModalTemplate,
    UpdateContact
  },
  data() {
    return {
      showModal: false,
      emergencyContact: {
        userId: this.employeeId,
        primaryName: "",
        primaryRelationship: "",
        primaryPhoneOne: "",
        primaryPhoneTwo: "",
        secondaryName: "",
        secondaryRelationship: "",
        secondaryPhoneOne: "",
        secondaryPhoneTwo: ""
      }
    }
  },
  computed: {
    ...mapGetters(["authenticatedUser"]),
    employeeId() {
      return this.authenticatedUser.id;
    },
    primaryPhone() {
      let phoneOne = this.emergencyContact.primaryPhoneOne;
      let phoneTwo = this.emergencyContact.primaryPhoneTwo;
      if (phoneTwo !== null && phoneTwo !== "")
        return phoneOne + ", " + phoneTwo;

      return phoneOne
    },
    secondaryPhone() {
      let phoneOne = this.emergencyContact.secondaryPhoneOne;
      let phoneTwo = this.emergencyContact.secondaryPhoneTwo;
      if (phoneTwo !== null && phoneTwo !== "")
        return phoneOne + ", " + phoneTwo;

      return phoneOne
    }
  },
  created() {
    this.getContact();
  },
  methods: {
    getContact() {
      let vm = this;
      axios.get(`/api/emergency-contacts/${vm.employeeId}`).then(resp => {
        let data = resp.data;
        if (data !== "")
          vm.emergencyContact = data;
      })
    },
    closeModal() {
      let vm = this;
      vm.showModal = false;
    },
  }
}
</script>

<style scoped>

</style>