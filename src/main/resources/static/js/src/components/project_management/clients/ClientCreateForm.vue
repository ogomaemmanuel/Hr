<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add Client</b></h1>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">First Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="client.user.firstName"

                  @input="clearFieldError('user.firstName')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['user.firstName']">
						{{ errors['user.firstName'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Last Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="client.user.lastName"
                  @input="clearFieldError('user.lastName')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['user.lastName']">
						{{ errors['user.lastName'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>

      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Email<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="client.user.email"
                  @input="clearFieldError('user.email')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['user.email']">
						{{ errors['user.email'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Phone<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="client.user.phone"
                  @input="clearFieldError('user.phone')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['user.phone']">
						{{ errors['user.phone'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>

      <div class="field">
        <label class="label">Company Name<span><sup>*</sup></span></label>
        <div class="control">
          <input
              v-model="client.companyName"
              @input="clearFieldError('companyName')"
              class="input"
              type="text">
          <span class="mb-2 has-text-danger" v-if="errors['companyName']">
						{{ errors['companyName'][0] }}
					</span>
        </div>
      </div>
      <div class="field">
        <label class="label">Description <span><sup>*</sup></span></label>
        <div class="control">
          <MarkdownEditor
              v-model="client.description"
              @input="clearFieldError('description')"
          >
          </MarkdownEditor>
          <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['description'][0] }}
					</span>
        </div>
      </div>

      <div class="flex justify-center m-3">
        <button
            :class="{'is-loading':isLoading}"
            :disabled="isLoading"
            @click.prevent.stop="createClient"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import MarkdownEditor from "../../common/MarkdownEditor/index"
import {Message} from "element-ui"

export default {
  components: {
    MarkdownEditor
  },
  mixins: [common_mixin],
  data() {
    return {
      client: {
        user: {}
      },
      isLoading: false
    }
  },
  methods: {
    createClient() {
      this.isLoading = true
      axios.post("/api/clients", this.client).then(resp => {
        this.isLoading = false;
        Message.success("Client successfully created")
        this.$emit("createSuccessful")
      }, error => {
        this.isLoading = false;
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>