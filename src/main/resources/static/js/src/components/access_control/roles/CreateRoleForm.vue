<template>
	<div>
		<form>
			<div class="has-text-centered m-3">
				<h1 class="has-text-black"><b>Add Holiday</b></h1>
			</div>
			<div class="field">
				<label class="label is-size-7">Holiday Name <span><sup>*</sup></span></label>
				<div class="control">
					<input
							v-model="role.name"
							@input="clearFieldError('name')"
							class="input"
							type="text">
					<span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
				</div>
			</div>
			<div class="flex justify-center m-3">
				<button
						
						:class="{'is-loading':isLoading}"
						:disabled="disableSubmitButton"
						@click.prevent.stop="createRole"
						class="button is-small is-rounded"
						type="submit">Submit
				</button>
			</div>
		</form>
	</div>
</template>
<script>
	import FormMixin from "../../../mixins/common_mixin"
    export default {
	    mixins:[FormMixin],
        data() {
            return {
                role: {},
                isLoading: false,
            }
        },
        methods: {
            createRole() {
                axios.post("/api/roles").then(resp => {

                }, error => {

                })
            }
        },
        computed: {
            disableSubmitButton() {
                return this.role.name.length > 0 || this.isLoading;
            }
        }
    }
</script>