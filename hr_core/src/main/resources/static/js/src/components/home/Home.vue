<template>
  <div class="relative z-0 flex h-full w-full overflow-hidden">
    <div class=" h-full flex-shrink-0 overflow-x-hidden " :class="{'opacity-75':hover && !collapsed}" :style="{width:collapsed?'0':sideBarWidth}">
      <sidebar-menu
          :menu="menu"
          :showOneChild="true"
          :hideToggle="true"
          :relative="true"
          :collapsed="collapsed"
          widthCollapsed="0"
          :width="sideBarWidth"
      >
        <template v-slot:header>
          <router-link class="text-white align-middle font-medium pl-2 pr-4 py-2 my-2 " style="color: #FFFFFF; border-bottom: 2px solid #1e1e21"
                       to="/profile">
            <ProfileMenuItem></ProfileMenuItem>
          </router-link>
        </template>

        <template v-slot:footer>
          <div class="text-white">
            <SideMenuFooter></SideMenuFooter>
          </div>
        </template>

        <template v-slot:toggle-icon>
          <i aria-hidden="true" class="fa fa-chevron-right"></i>
        </template>
        <template v-slot:dropdown-icon="{ isOpen }">
        <span v-if="!isOpen">
          <i aria-hidden="true" class="fa fa-chevron-right"></i>
        </span>
          <span v-else>
          <i aria-hidden="true" class="fa fa-chevron-left "></i>
        </span>
        </template>
      </sidebar-menu>
    </div>
    <div class="relative flex h-full max-w-full flex-1 flex-col overflow-hidden">
      <main class="transition-width relative h-full w-full flex-1 overflow-auto">

        <div class="fixed top-1/2 z-40 -translate-y-1/2 transition-transform translate-x-[260px]" @mouseover="hover = true"
             @mouseleave="hover = false" v-tooltip.right="collapsed?'Open Sidebar':'Close Sidebar'">
          <div class="cursor-pointer" @click="toggleSideNav() ">
              <div class="flex h-20 w-8 items-center justify-center opacity-25  hover:opacity-100">
                <div class="flex h-6 w-6 flex-col items-center"  :style="{rotate: collapsed?'180deg':'0deg'}">
                  <div class="bg-gray-800  h-3 w-1 rounded-full" :style="{transform: hover || collapsed?'translateY(0.15rem) rotate(15deg) translateZ(0px)':'translateY(0.15rem) rotate(0deg) translateZ(0px)'}"></div>
                  <div class="bg-gray-800  h-3 w-1 rounded-full" :style="{transform: hover || collapsed?'translateY(-0.15rem) rotate(-15deg)  translateZ(0px)':'translateY(-0.15rem) rotate(0deg) translateZ(0px)'}"></div>
                </div>
              </div>
          </div>
        </div>

        <div class="px-8">
          <div class="columns mt-1 mb-8 is-3" style="border-bottom: 1px solid rgb(224, 220, 229);">
            <div class="column p-0">
              <div class="flex flex-col  ">
                <TestBreadCrump></TestBreadCrump>
                <portal-target name="header">
                </portal-target>
              </div>
            </div>
            <div class="column p-0 is-5">
              <GlobalSearchInput></GlobalSearchInput>
            </div>
            <div class="column p-0 is-4">
              <div class="flex sm:justify-start md:justify-end py-1">
                <portal-target name="page-controls">
                  <!--
                  This component can be located anywhere in your App.
                  The slot content of the above portal component will be rendered here.
                  -->
                  <div class="py-1 pr-2 flex justify-end">
                    <p class="buttons">
                      <router-link
                          class="button  is-rounded"
                          tag="button"
                          to="leave-create">
                      <span class="icon">
                        <i class="fa fa-plus-circle"></i>
                      </span>
                        <span>New Request</span>
                      </router-link>
                      <router-link
                          class="button  is-rounded"
                          tag="button"
                          to="employee-attendance">
                      <span class="icon">
                        <i class="fa fa-plus-circle"></i>
                      </span>
                        <span>Clock In</span>
                      </router-link>
                    </p>
                  </div>
                </portal-target>
              </div>
            </div>
          </div>
        </div>
        <div class="mt-5 h-full px-8 ">
          <router-view></router-view>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import TestBreadCrump from "../common/TestBreadCrump"
import LogoutForm from "../auth/LogoutForm.vue"
import {mapGetters} from "vuex";
import ProfileMenuItem from "./ProfileMenuItem.vue"
import SideMenuFooter from "./SideMenuFooter.vue"
import GlobalSearchInput from "./GlobalSearchInput.vue"

export default {
  components: {LogoutForm, TestBreadCrump, ProfileMenuItem, SideMenuFooter,GlobalSearchInput},
  data() {
    return {
      collapsed:false,
      hover: false,
      sideBarWidth:'250px',
      menu: [

        {
          href: {path: '/'},
          title: 'Dashboard',
          icon: 'fa fa-user'
        },
        {
          href: {path: '/employees'},
          title: ' Employee',
          icon: 'fa fa-building-o',
          child: [
            {
              href: {path: '/employees'},
              icon: 'fa fa-',
              title: 'All Employees'
            },
            {
              href: {path: '/departments'},
              icon: 'fa fa-',
              title: 'Departments'
            },
            {
              href: {path: '/designations'},
              icon: 'fa fa-',
              title: 'Designations'
            },
            {
              href: {path: '/overtime-requests'},
              icon: 'fa fa-',
              title: 'Overtime'
            },
            {
              href: {path: '/employee-resignations'},
              icon: 'fa fa-',
              title: 'Resignation'
            },
            {
              href: {path: '/employee-terminations'},
              icon: 'fa fa-',
              title: 'Termination'
            }
          ]
        },
        {
          href: {path: '/salary'},
          title: 'Payroll',
          icon: 'fa fa-money',
          child: [
            {
              href: {path: '/salary'},
              icon: 'fa fa-',
              title: 'Employee Salary'
            },
            {
              href: {path: '/salary-view'},
              icon: 'fa fa-',
              title: 'Payslip'
            },
            {
              href: {path: '/payroll-items'},
              icon: 'fa fa-',
              title: 'Payroll Items'
            }

          ]
        },
        {
          href: {path: '/leave'},
          title: 'My Leaves',
          icon: 'fa fa-table'
        },
        {
          href: {path: '/employee-attendance'},
          icon: 'fa fa-clock-o',
          title: 'Attendance',
          child: [
            {
              href: {path: '/admin-attendance'},
              icon: 'fa fa-',
              title: 'Admin'
            },
            {
              href: {path: '/employee-attendance'},
              icon: 'fa fa-',
              title: 'Employee'
            }
          ]
        },
        {
          href: {path: '/events'},
          icon: 'fa fa-calendar-check-o',
          title: 'Calender',
          badge: {
            text: 'new',
            class: 'vsm--badge_default',
             // attributes: {},
             // element: 'span',
          }
        }
      ],
      // Sidebar width (expanded)


    }
  },
  computed: {
    ...mapGetters(["authenticatedUser"])
  },
  methods:{
    toggleSideNav() {
      this.collapsed = !this.collapsed;
    }
  }
}
</script>
<style>
.v-sidebar-menu .vsm--header {
  background: #1e1e21;
}
.top-1\/2 {
  top: 50%;
}
</style>