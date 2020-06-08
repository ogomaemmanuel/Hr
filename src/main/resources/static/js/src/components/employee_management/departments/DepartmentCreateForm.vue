<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Create New Department</b></h1>
            </div>
            <div class="field">
                <label class="label is-size-7">Department Name <span><sup>*</sup></span></label>
                <div class="control">
                    <input
                            v-model="department.name"
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
                        @click.prevent.stop="createDepartment"
                        class="button is-small is-rounded"
                        type="submit">Submit
                </button>
            </div>
        </form>
    </div>
</template>
<script>
    import CommonMixin from "../../../mixins/common_mixin"

    export default {
        mixins: [CommonMixin],
        data() {
            return {
                department: {
                    name: ""
                },
                loading: false
            }

        },
        methods: {
            createDepartment() {
                let vm = this;
                axios.post("/api/departments",
                    this.department).then(resp => {
                    this.loading = false
                }, error => {
                    this.loading = false;
                })
            }
        },
        computed: {
            disableSubmitButton() {
                return this.department.name.length <= 0 || this.loading;
            }
        }
    }
</script>
<style>

</style>