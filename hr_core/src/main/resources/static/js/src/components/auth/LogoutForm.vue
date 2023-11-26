<template>
		<form ref="logoutForm" method="post" action="/logout">
			<input type="hidden" name="_csrf" :value="csrfToken">
      <span @click="logout" class="text-white cursor-pointer">
        <i class="fa fa-sign-out font-medium pr-2 " style="font-size: 20px;"></i>
<!--        Logout <span class="bold">({{ authenticatedUser.fullName.split(" ")[0] }})</span>-->
      </span>
		</form>
</template>
<script>
    import {mapGetters} from "vuex";

    export default {
        data() {
            return {
                csrfToken: null,
        }
        },
        created() {
            this.csrfToken =document.querySelector("meta[name='_csrf']").getAttribute("content");
        },
		methods:{
            logout() {
                this.$refs.logoutForm.submit();
            },
		},
      computed: {
        ...mapGetters(["authenticatedUser"])
      },
    }
</script>