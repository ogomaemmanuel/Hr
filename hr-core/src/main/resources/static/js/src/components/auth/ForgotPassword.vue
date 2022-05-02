<template>
	<form>
		<div class="hero is-fullheight">
			<div class="hero-body">
				<div class="container">
					<div class="columns is-centered">
						
						<div class="column is-12-mobile is-6">
							<article class="message is-medium">
								<div class="message-header">
									<p>Forgot Password</p>
									<button class="delete" aria-label="delete"></button>
								</div>
								<div class="message-body">
									An Email with password reset link will be sent to the email you used during
									registration
								</div>
							</article>
							<div class="field">
								<p class="control has-icons-left">
									<input
											@input="clearFieldError('email')"
											v-model="forgotPasswordRequest.email" class="input" type="email"
											placeholder="Your Email">
									<span class="icon is-small is-left">
      <i class="fa fa-lock"></i>
    </span>
								</p>
								<span v-if="errors['email']" class="has-text-danger">
                                    {{errors['email'][0]}}
                                </span>
							</div>
							<div class="field">
								<div class="control is-block">
									<button :class="{'is-loading':isLoading}" @click.prevent="submitRequest"
											class="button  is-fullwidth is-success">
										Submit
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			
			</div>
		</div>
	</form>
</template>
<script>
    import {Notification} from "element-ui"
    import CommonMixin from "../../mixins/common_mixin.js"

    export default {
        mixins: [
            CommonMixin
        ],
        data() {
            return {
                isLoading: false,
                forgotPasswordRequest: {}
            }
        }
        ,
        methods: {
            submitRequest() {
                let vm = this;
                vm.isLoading = true,
                    axios.post("/forgot-password", vm.forgotPasswordRequest).then(resp => {
                        vm.isLoading = false
                        Notification.success(resp.data);
                    }, error => {
                        vm.isLoading = false
                        if (error.response.status == 400) {
                            vm.errors = error.response.data;
                        }
                    })
            }
        }
    }
</script>