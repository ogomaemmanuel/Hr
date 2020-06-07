<template>
	<div>
		<form>
			<div class="has-text-centered m-3">
				<h1 class="has-text-black"><b>Add Role</b></h1>
			</div>
			<div class="field">
				<label class="label is-size-7">Name <span><sup>*</sup></span></label>
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
			<div class="field">
				<label class="label is-size-7">Description <span><sup>*</sup></span></label>
				<div class="control">
					<textarea
							v-model="role.description"
							@input="clearFieldError('description')"
							class="textarea"
							type="text">
					</textarea>
					<span class="mb-2 has-text-danger" v-if="errors['description']">
						{{errors['description'][0]}}
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
        mixins: [FormMixin],
        data() {
            return {
                role: {
                    name: ""
                },
                isLoading: false,
            }
        },
        methods: {
            createRole() {
                let vm = this;
                axios.post("/api/roles", this.role).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Role created successfully"
                    })
                    this.$emit("roleCreateSuccessful");
                }, error => {

                })
            }
        },
        computed: {
            disableSubmitButton() {
                return this.role.name.length <= 0 || this.isLoading;
            }
        }
    }
</script>