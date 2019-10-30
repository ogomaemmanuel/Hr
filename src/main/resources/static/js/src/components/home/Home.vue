<template>
	<div>
		<nav class="navbar is-primary" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="https://bulma.io">
					<img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
				</a>
				
				<a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false"
				   data-target="navbarBasicExample">
					<span aria-hidden="true"></span>
					<span aria-hidden="true"></span>
					<span aria-hidden="true"></span>
				</a>
			</div>
			
			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item">
						Home
					</a>
					
					<a class="navbar-item">
						Documentation
					</a>
					
					<div class="navbar-item has-dropdown is-hoverable">
						<a class="navbar-link">
							More
						</a>
						
						<div class="navbar-dropdown">
							<a class="navbar-item">
								About
							</a>
							<a class="navbar-item">
								Jobs
							</a>
							<a class="navbar-item">
								Contact
							</a>
							<hr class="navbar-divider">
							<a class="navbar-item">
								Report an issue
							</a>
						</div>
					</div>
				</div>
				
				<div class="navbar-end">
					
					<div class="navbar-item">
						<b-tooltip label="logout"
								   type="is-dark"
								   position="is-left">
							<form ref="logoutForm" method="post" action="/logout">
								<input type="hidden" name="_csrf" :value="csrfToken">
								<i @click="logout" class="fa fa-sign-out fa-2x"></i>
							</form>
						</b-tooltip>
					</div>
					
					
					<div class="navbar-item has-dropdown is-hoverable">
						<!--						<a class="navbar-link">-->
						<!--							Docs-->
						<!--						</a>-->
						
						<figure class="image is-fullwidth navbar-link is-64x64">
							<img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
						</figure>
						
						<div class="navbar-dropdown is-right">
							<a class="navbar-item">
								Overview
							</a>
							<a class="navbar-item">
								Elements
							</a>
							<a class="navbar-item">
								Components
							</a>
							<hr class="navbar-divider">
							<div class="navbar-item">
								Version 0.7.5
							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>
		
		<section class="main-content columns is-fullheight">
			
			<aside class="column is-2 is-narrow-mobile is-fixed is-fullheight section is-hidden-mobile">
				<p class="menu-label is-hidden-touch">Navigation</p>
				<ul class="menu-list">
					<li>
						<a href="#" class="">
							<span class="icon"><i class="fa fa-home"></i></span> Home
						</a>
					</li>
					<li>
						<a href="#" class="is-active">
							<span class="icon"><i class="fa fa-table"></i></span> Access Control
						</a>
						
						<ul>
							<li>
								<router-link to="/users">
									<span class="icon is-small"><i class="fa fa-link"></i></span> Users
								</router-link>
							</li>
							<li>
								<a href="#">
									<span class="icon is-small"><i class="fa fa-link"></i></span> Link2
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#" class="">
							<span class="icon"><i class="fa fa-info"></i></span> About
						</a>
					</li>
				</ul>
			</aside>
			
			<div class="container column is-10">
				<router-view></router-view>
			</div>
		</section>
	</div>
</template>
<script>
    export default {
        props: {
            user: {}
        },
        data() {
            return {
                isFullPage: true,
                csrfToken: null,
            }
        },
        created() {
            this.open();
            this.csrfToken =document.querySelector("meta[name='_csrf']").getAttribute("content");
                // document.getElementsByTagName('meta')
                //     .find(x => x.getAttribute('name') == "_csrf")
                //     .getAttribute('content') || "";
        },
        methods: {
            logout() {
                this.$refs.logoutForm.submit();
            },

            open() {
                const loadingComponent = this.$buefy.loading.open({
                    container: this.isFullPage ? null : this.$refs.element.$el
                })
                setTimeout(() => loadingComponent.close(), 3 * 1000)
            }
        }
    }
</script>
<style scoped>
	
	.navbar-item img {
		max-height: 3rem;
	}
</style>
