<template>
	<div>
		<form>
			<div class="has-text-centered m-3">
				<h1 class="has-text-black"><b>Edit Role</b></h1>
			</div>
			<div class="field">
				<label class="label is-size-7">Role Name <span><sup>*</sup></span></label>
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
						
						:class="{'is-loading':loading}"
						:disabled="disableSubmitButton"
						@click.prevent.stop="updateRole"
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
        props: {
            roleId: {
                required: true
            }
        },
        data() {
            return {
                role: {},
                loading: false
            }
        },
        methods: {
            updateRole() {
                axios.put(`/api/roles/${this.roleId}`).then(resp => {

                }, error => {
                })
            }
        },

        computed: {
            disableSubmitButton() {
                return role.name.length <= 0 || this.loading;
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>