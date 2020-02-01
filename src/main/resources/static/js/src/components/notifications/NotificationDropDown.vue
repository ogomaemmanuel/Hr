<template>
	<div @wheel="fetchMoreNotification($event)" class="drop-menu-custom text-black">
		<div v-if="loaded" class="drop-menu-inner h-full w-full relative">
			<div class="h-full">
				<div class="notification-header p-2 h-12 has-background-white-bis">
					<div class="flex h-full items-center">
						<div class="flex-1">
							Notifications
						</div>
						<div class="hu">
							Mark All as Read
						</div>
					</div>
				</div>
				<div class="notification-content">
					<NotificationItem
							v-for="notification in notifications"
							:notification="notification">
					</NotificationItem>
				</div>
				<div>
					<div class="notification-footer h-12 has-background-white-bis">
<!--						<div class="flex h-2 pt-1 justify-center">-->
<!--							<i v-if="loading" class="fa fa-spin  fa-spinner"></i>-->
<!--						</div>-->
						
						<div class="flex h-full items-center justify-center">
							See All
						</div>
					</div>
				</div>
			</div>
		</div>
	    <div v-else class="h-48 flex justify-center is-relative">
			
				<b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>
		</div>
	</div>
</template>
<script>
    import NotificationItem from "./NotificationItem";
    import _throttle from "lodash.throttle"

    export default {
        components: {
            NotificationItem
        },
        data() {
            return {
                notifications: [],
                loaded: false,
                page: 0,
                pageSize: 10,
                loading: false,
            }
        },
        created() {
            this.getUserNotifications();
        },

        methods: {
            getUserNotifications() {
                let vm = this;
                let request = {
                    page: vm.page,
                    pageSize: vm.pageSize
                }
                vm.loading = true;
                axios.get("/api/user-notifications", {
                    params: request
                }).then(resp => {
                    vm.loaded = true;
                    vm.loading = false;
                    vm.notifications.push(...resp.data.content);
                    if (resp.data.totalPages > vm.page) {
                        vm.page++;
                    }
                }, error => {
                    vm.loading = false;
                })
            },
            fetchMoreNotification: _throttle(function (event) {
                    let vm = this;
                    if (event.deltaY > 0) {
                        vm.getUserNotifications();
                    }
                },
                2000),

        },


    }
</script>
<style lang="scss" scoped>
	.drop-menu-custom {
		/*left: unset !important;*/
		left: auto;
		right: 0px;
		position: absolute;
		display: block;
		top: 92%;
		background: #fff;
		width: 430px;
		max-height: 400px;
		min-height: 0px;
		border: 1px solid #ededed;
		border-radius: 3px;
		-webkit-transform: translateY(5px);
		transform: translateY(5px);
		-webkit-box-shadow: -1px 3px 15px 0 rgba(0, 0, 0, 0.06);
		box-shadow: -1px 3px 15px 0 rgba(0, 0, 0, 0.06);
		-webkit-transition: all .3s;
		transition: all .3s;
		z-index: 20;
		.loading-indicator{
		z-index: -60;
	}
		.notification-header {
			z-index: 40;
		}
		
		.notification-footer {
			z-index: 40;
		}
		
		.notification-content {
			max-height: 300px;
			overflow-y: scroll;
		}
		
	}
</style>