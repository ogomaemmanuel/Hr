<template>
    <div>
        <div>
            <router-view></router-view>
        </div>
        <portal to="side-menu">
            <ul class="menu-list">
                <li>
                    <router-link to="/" class="">
                        <span class="icon"><i class="fa fa-home"></i></span> Back Home
                    </router-link>
                </li>
                <li>
                    <a href="#" class="">
                        <span class="icon"><i class="fa fa-group"></i></span> Settings
                    </a>

                    <ul class="mr-0 pr-0 border-l-0">
                        <li>
                            <router-link to="/users">
                                <span>Company Settings</span>
                            </router-link>
                        </li>
                        <li>
                            <router-link to="roles">
                                <span>Localisation</span>
                            </router-link>
                        </li>
                        <li>
                            <router-link to="/permissions">
                                <span>Theme Settings</span>
                            </router-link>
                        </li>
                        <li>
                            <router-link to="/permissions">
                                <span>Email Settings</span>
                            </router-link>
                        </li>
                        <li>
                            <router-link to="/permissions">
                                <span>Invoice Settings</span>
                            </router-link>
                        </li>
                        <li>
                            <router-link to="/permissions">
                                <span>Salary Settings</span>
                            </router-link>
                        </li>
                        <li>
                            <router-link to="/permissions">
                                <span>Notifications</span>
                            </router-link>
                        </li>
                    </ul>
                </li>
            </ul>
        </portal>
    </div>
</template>
<script>
    export default {}
</script>
<style>

</style>