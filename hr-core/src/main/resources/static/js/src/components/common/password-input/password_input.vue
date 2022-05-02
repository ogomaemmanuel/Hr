<template>
    <div class="password-wrapper">
        <input @input="onInput" :type="passwordInputType"
               aria-describedby="" class="form-control input is-large"
               v-model="password">
        <i @click="togglePasswordInputType" :class="`fa fa-${eye} password-toggler`"></i>
    </div>
</template>
<script>
    export default {
        name: "password-input",
        data() {
            return {
                password: "",
                passwordInputType: "password",
                // eyeIcon:"eye"
            }
        },
        methods: {
            onInput() {
                let vm = this;
                this.$emit('input', vm.password);
            },
            togglePasswordInputType() {
                this.passwordInputType = this.passwordInputType == "password" ? "text" : "password"
            }
        },
        computed:{
            eye:function () {
              return this.passwordInputType == "password"?"eye":"eye-slash";
            }
        }
    }
</script>
<style scoped lang="scss">
    .password-wrapper {
        position: relative;
        .password-toggler {
            position: absolute;
            right: 5px;
            z-index: 2000;
            top: 35%;
        }
    }
</style>
