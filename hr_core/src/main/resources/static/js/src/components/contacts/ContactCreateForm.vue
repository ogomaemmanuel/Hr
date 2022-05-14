<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Add Contact</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="contact.name"
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
                v-model="contact.email"
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
                v-model="contact.phoneNo"
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
              @click.prevent.stop="createContact"
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
import common_mixin from "../../mixins/common_mixin";
import {Message} from "element-ui"

export default {
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      loading: false,
      contact: {
        email: "",
        phoneNo: "",
        name: "",
      }
    }

  },
  methods: {
    createContact() {
      axios.post("api/address-book", this.contact).then(resp => {
        Message.success("Contact successfully created");
        this.$emit("createSuccessful")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  },
  computed: {
    disableSubmitButton() {
      return false;
    }
  }
}
</script>