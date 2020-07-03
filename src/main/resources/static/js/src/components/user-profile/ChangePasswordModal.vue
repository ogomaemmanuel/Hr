<template>
    <ModalTemplate @modalClosed="onModalClose">
        <div slot="modal-content">
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Change Password</b></h1>
            </div>
            <form>

                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="password" placeholder="Old Password">
                        <span class="icon is-small is-left">
      <i class="fa fa-key"></i>
    </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="password" placeholder="New Password">
                        <span class="icon is-small is-left">
      <i class="fa fa-key"></i>
    </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="password" placeholder="Confirm New Password">
                        <span class="icon is-small is-left">
      <i class="fa fa-key"></i>
    </span>
                    </p>
                </div>
                <div class="flex justify-center m-3">
                    <button

                            :class="{'is-loading':loading}"
                            :disabled="disableSubmitButton"
                            @click.prevent.stop="createHoliday"
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
                passwordReset: {
                    oldPassword: "",
                    newPassword: "",
                    confirmPassword: ""
                }
            }
        },
        methods: {
            changePassword() {
                axios.post("api/profile/change-passwod",
                    this.passwordReset).then(resp => {

                }, error => {

                })
            },
            onModalClose(){
               this.$emit("close")
            }
        }
    }

</script>