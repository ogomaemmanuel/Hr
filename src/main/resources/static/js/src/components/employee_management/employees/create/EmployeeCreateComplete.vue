<template>
    <div>
        <div class="steps-body  pt-4 pb-4  pr-0 pl-2">
            <div class="steps-content">
                <!-- Step content -->
                <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                    <div class="step-content has-text-centered is-active">
                        <div class="flex justify-center">
                            <img class="confirm-image pb-30" src="/images/illustrations/success_tick.svg" width="40%">
                        </div>
                        <h1 class="title is-5 mt-2">Employee Successfully created!</h1>
                        <div class="">
                            <button type="button" class="button is-success">
                                Add Another Employee
                            </button>
                            <router-link to="/employees" tag="button" type="button"  class="button is-clear is-text">
                                Back to employees
                            </router-link>
                        </div>
                        <!--                        <p class="is-muted">Another text goes here..</p>-->
                    </div>

                </div>
            </div>
        </div>
        <slot :isLoading="isLoading" :onNext="onNext">

        </slot>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                isLoading: false
            }
        },
        methods: {
            onNext() {

            }
        }
    }
</script>