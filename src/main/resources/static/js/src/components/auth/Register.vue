<template>
    <form>
        <div class="hero is-fullheight">
            <div class="hero-body">
                <div class="container">
                    <div class="columns is-centered">

                        <div class="column is-12-mobile is-6">
                            <div class="field ">
                            <section class="section is-paddingless">
                                <div class="container">
                                    <div class="columns">
                                        <div class="column is-centered">
                                            <h1 class="title">Sing up</h1>
                                        </div>
                                    </div>

                                    <h2 class="subtitle">
                                       It is free and only takes a few seconds
                                    </h2>
                                </div>
                            </section>
                            </div>
                            <div class="field ">
                                <div class="control">
                                    <input v-model="user.firstName" class="input" type="text"
                                           placeholder="First name">
                                    <span class="icon is-small is-left">
    </span>
                                </div>
                            </div>

                            <div class="field">
                                <div class="control">
                                    <input v-model="user.lastName" class="input" type="text"
                                           placeholder="Last name">
                                    <span class="icon is-small is-left">
    </span>
                                </div>
                            </div>


                            <div class="field">
                                <div class="control">
                                    <input v-model="user.email" class="input" type="email"
                                           placeholder="Email">
                                    <span class="icon is-small is-left">
    </span>
                                </div>
                            </div>


                            <div class="field">
                                <div class="control">
                                    <input v-model="user.phone" class="input" type="phone"
                                           placeholder="Phone">
                                    <span class="icon is-small is-left">
    </span>
                                </div>
                            </div>


                            <div class="field">
                                <div class="control">
                                    <input v-model="user.password" class="input" type="password"
                                           placeholder="Last name">
                                    <span class="icon is-small is-left">
    </span>
                                </div>
                            </div>


                            <div class="field">
                                <div class="control">
                                    <input v-model="user.confirmPassword" class="input" type="password"
                                           placeholder="Confirm password">
                                    <span class="icon is-small is-left">
    </span>
                                </div>
                            </div>


                            <div class="field">
                                <div class="control is-block">
                                    <button :class="{'is-loading':isLoading}" @click.prevent="submitRequest"
                                            class="button  is-fullwidth is-success">
                                        Sing up
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

    export default {
        data() {
            return {
                isLoading: false,
                user: {}
            }
        },
        methods: {
            submitRequest() {
                let vm = this;
                vm.isLoading = true,
                    axios.post("/register", vm.user).then(resp => {
                        vm.isLoading = false
                        Notification.success(resp.data);
                    }, error => {
                        vm.isLoading = false
                    })
            }
        }
    }
</script>