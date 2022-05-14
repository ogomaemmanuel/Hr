<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Update Contact</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="contactClone.name"
                @input="clearFieldError('name')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
					</span>
          </div>
        </div>
        <div class="field">
          <label class="label">Email<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="contactClone.email"
                @input="clearFieldError('email')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['email']">
						{{ errors['email'][0] }}
					</span>
          </div>
        </div>
        <div class="field">
          <label class="label">Phone No<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="contactClone.phoneNo"
                @input="clearFieldError('phoneNo')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['phoneNo']">
						{{ errors['phoneNo'][0] }}
					</span>
          </div>
        </div>
        <div class="flex justify-center m-3">
          <button

              :class="{'is-loading':loading}"
              :disabled="disableSubmitButton"
              @click.prevent.stop="updateContact"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../common/ModalTemplate";
import {Message} from "element-ui"
import common_mixin from "../../mixins/common_mixin";

export default {
  components: {
    ModalTemplate
  },
  mixins: [
    common_mixin
  ],
  props: {
    contact: {
      // type: Object,
      required: true
    }
  },
  data() {
    return {
      loading: false,
      contactClone: {
        email: "",
        phoneNo: "",
        name: "",
      }
    }
  },
  created() {
    this.contactClone = {...this.contact}
  },
  computed: {
    disableSubmitButton() {
      return false
    }
  },
  methods: {
    getContactById() {
    },
    updateContact() {
      let vm = this;
      axios.put(`/api/address-book/${this.contactClone.id}`,
          this.contactClone).then(resp => {
        Message.success("Contact successfully updated");
        vm.$emit("updateSuccessful")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>