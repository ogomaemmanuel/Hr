<script>
    import {Notification} from "element-ui"
    import CommonMixin from "../../mixins/common_mixin.js"

    export default {
        mixins: [
            CommonMixin
        ],
        props: {
            userId: {},
            token: {},
        },
        data() {
            return {
                passwordResetRequest: {}
            }
        },
        created() {
            this.passwordResetRequest.userId = this.userId;
            this.passwordResetRequest.token = this.token;
        },

        methods: {
            resetPassword() {
                axios.post("/password-reset", this.passwordResetRequest).then((resp) => {
                    if (resp.status == 200) {
                        Notification.success(resp.data.message);
                    }
                }, error => {
                    Notification.success("An error occurred");
                });
            }
        }
    }
</script>
