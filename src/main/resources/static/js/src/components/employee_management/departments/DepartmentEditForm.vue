<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Update Department</b></h1>
            </div>
            <div class="field">
                <label class="label">Department Name <span><sup>*</sup></span></label>
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
                        @click.prevent.stop="updateDepartment"
                        class="button  is-rounded"
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
        props: {
            departmentId: {
                required: true
            }
        },
        data() {
            return {
                department: {
                    name: ""
                },
                loading: false
            }
        },
        created() {
            this.getDepartmentById();
        },
        methods: {
            getDepartmentById() {
                axios.get(`/api/departments/${this.departmentId}`)
                    .then(resp => {
                        this.department = resp.data;
                    })
            },
            updateDepartment() {
                let vm = this;
                axios.put(`/api/departments/${this.departmentId}`,
                    this.department).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Department successfully updated"
                    })
                    this.$emit("departmentUpdated")
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