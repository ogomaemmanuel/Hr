<template>
    <ModalTemplate @modalClosed="onModalClose">
        <div slot="modal-content">
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Change Password</b></h1>
            </div>
            <form>

                <div class="field">
                    <p class="control has-icons-left">
                        <input
                                class="input"
                                @input="clearFieldError('oldPassword')"
                               v-model="passwordUpdate.oldPassword"
                               type="password"
                               placeholder="Old Password">
                        <span class="icon is-small is-left">
      <i class="fa fa-key"></i>
    </span>
                    </p>
                    <span class="mb-2 has-text-danger" v-if="errors['oldPassword']">
						{{errors['oldPassword'][0]}}
					</span>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <input
                                v-model="passwordUpdate.newPassword"
                                @input="clearFieldError('newPassword')"
                                class="input"
                                type="password"
                                placeholder="New Password">
                        <span class="icon is-small is-left">
      <i class="fa fa-key"></i>
    </span>
                    </p>
                    <span class="mb-2 has-text-danger" v-if="errors['newPassword']">
						{{errors['newPassword'][0]}}
					</span>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <input
                                @input="clearFieldError('confirmationPassword')"
                                v-model="passwordUpdate.confirmationPassword"
                                class="input" type="password"
                                placeholder="Confirm New Password">
                        <span class="icon is-small is-left">
      <i class="fa fa-key"></i>
    </span>
                    </p>
                    <span class="mb-2 has-text-danger" v-if="errors['confirmationPassword']">
						{{errors['confirmationPassword'][0]}}
					</span>
                </div>
                <div class="flex justify-center m-3">
                    <button

                            :class="{'is-loading':loading}"
                            @click.prevent.stop="changePassword"
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

    export default {
        mixins: [common_mixin],
        components: {ModalTemplate},
        data() {
            return {
                passwordUpdate: {
                    oldPassword: "",
                    newPassword: "",
                    confirmationPassword: ""
                },
                loading: false
            }
        },
        methods: {
            changePassword() {
                let vm = this;
                axios.post("/api/profile/update-password",
                    this.passwordUpdate).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Password  successfully updated"
                    })
                    vm.onModalClose()
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            },
            onModalClose() {
                this.$emit("close")
            }
        }
    }

</script>