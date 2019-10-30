<template>
	<b-tooltip label="logout"
			   type="is-dark"
			   position="is-left">
		<form ref="logoutForm" method="post" action="/logout">
			<input type="hidden" name="_csrf" :value="csrfToken">
			<i @click="logout" class="fa fa-sign-out fa-2x"></i>
		</form>
	</b-tooltip>
</template>
<script>
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
		}
    }
</script>