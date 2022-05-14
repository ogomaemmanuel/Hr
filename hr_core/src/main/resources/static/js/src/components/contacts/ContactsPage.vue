<template>
  <div class="columns">
    <div class="column">
      <button @click="showCreateForm=true" class="button is-primary is-fullwidth">
         <span class="icon">
      <i class="fa fa-plus"></i>
    </span>
        <span>Add Contact</span>
      </button>
      <div class="mt-4">
        <div class="box">
          <div class="menu">
            <ul class="menu-list">
              <li><a>All</a></li>
              <li><a> Company</a></li>
              <li><a>Client</a></li>
              <li><a>Staff</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="column is-9">
      <div class="card">
        <div class="card-content">
          <div class="content">

            <article v-for="contact in contacts" class="media min-h-4">
              <figure class="media-left">
                <p class="image is-64x64">
                  <img src="/images/undraw_profile_pic_ic-5-t.svg">
                </p>
              </figure>
              <div class="media-content">
                <div class="content">
                  <p>
                    <strong>{{ contact.name }}</strong>
                    <br>
                    <i class="fa fa-envelope"></i> {{ contact.email }} <i class="fa fa-phone"></i>
                    {{ contact.phoneNo }}
                  </p>
                </div>
              </div>
              <div class="media-right">
                <b-dropdown class="text-left" aria-role="list">
                  <i
                      class="fa fa-ellipsis-v text-muted"
                      slot="trigger"
                      role="button">
                  </i>
                  <b-dropdown-item :disabled="false"
                                   value="withdraw"
                                   @click="confirmRemoveContact(contact)"
                                   aria-role="listitem">
                    <span class="icon"><i class="fa fa-trash"></i></span>
                    Remove
                  </b-dropdown-item>
                  <b-dropdown-item
                      @click="setContactToEdit(contact)"
                      :disabled="false" value="edit" aria-role="listitem">
                    <!--                    <router-link :to="`/clients-edit/${client.id}`">-->
                    <span class="icon"><i class="fa fa-pencil"></i></span>
                    Edit
                    <!--                    </router-link>-->
                  </b-dropdown-item>
                </b-dropdown>
              </div>
            </article>

            <div>
              <Paginator
                  @previousPage="goToPrevious"
                  @nextPage="goToNext"
                  @paginationChanged="onPaginationChanged"
                  :paginationData="pageable"
                  v-if="pageable"></Paginator>
            </div>
          </div>
        </div>
      </div>
    </div>
    <ContactCreateForm
        @createSuccessful="handleContactCreatedEvent"
        @modalClosed="showCreateForm=false"
        v-if="showCreateForm"></ContactCreateForm>
    <ContactEditForm
        @updateSuccessful="handleContactUpdateEvent"
        @modalClosed="showEditForm=false"
        :contact="contactToEdit"
        v-if="showEditForm">
    </ContactEditForm>
  </div>
</template>
<script>
import ContactCreateForm from "./ContactCreateForm";
import Paginator from "../common/paginator/Paginator";
import data_table_mixin from "../../mixins/data_table_mixin";
import ContactEditForm from "./ContactEditForm";

export default {
  mixins: [data_table_mixin],
  components: {
    ContactEditForm,
    Paginator,
    ContactCreateForm
  },
  data() {
    return {
      showCreateForm: false,
      showEditForm: false,
      contactToEdit: {},
      contacts: []
    }
  },
  created() {
    this.getContacts();
  },
  methods: {
    confirmRemoveContact(contact) {
      this.$buefy.dialog.confirm({
        title: 'Delete Contact',
        message: `Are you sure want to remove <b> ${contact.email}</b>`,
        onConfirm: () => this.removeContact(contact)
      })
    },
    removeContact(contact) {
      axios.delete(`api/address-book/${contact.id}`)
          .then(resp => {
            this.getContacts();
          }, error => {
          })
    },
    handleContactCreatedEvent() {
      this.showCreateForm = false;
      this.getContacts();
    },
    handleContactUpdateEvent() {
      this.showEditForm = false;
      this.getContacts();
    },
    fetchRecords() {
      this.getContacts();
    },
    setContactToEdit(contact) {
      let vm = this;
      this.contactToEdit = contact;
      this.$nextTick(() => {
        vm.showEditForm = true;
      })
    },
    getContacts() {
      let vm = this;
      axios.get("/api/address-book", {
        params: {
          pageSize: vm.pageSize,
          page: vm.page
        }
      }).then(resp => {
        this.contacts = resp.data.content;
        this.pageable = resp.data;
      }, error => {

      })
    }
  }
}
</script>
<style scoped lang="scss"></style>