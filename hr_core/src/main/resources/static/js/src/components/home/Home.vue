<template>
  <section class="main-content columns  is-fullheight">
    <sidebar-menu
        :menu="menu"
        :showOneChild="true"
        width="250px"
    >
      <template v-slot:header>
        <router-link class="text-white align-middle font-medium pl-2 pr-4 py-2 my-2 " style="color: #FFFFFF; border-bottom: 2px solid #1e1e21"
                     to="/profile">
          <ProfileMenuItem></ProfileMenuItem>
        </router-link>
      </template>

      <template v-slot:footer>
        <div class="text-white">
          <!--          <logout-form></logout-form>-->
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

    <div class=" column is-offset-2 is-10 pr-10 pl-10 h-screen mb-0">
      <div class=" ">
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
                <div class="pt-2 pr-2 flex justify-end">
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
                        to="leave-create">
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
      <div class="mt-5 h-full">
        <router-view></router-view>
      </div>
    </div>
  </section>
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
      ],
      // Sidebar width (expanded)


    }
  },
  computed: {
    ...mapGetters(["authenticatedUser"])
  },
}
</script>
<style>
.v-sidebar-menu .vsm--header {
  background: #1e1e21;
}
</style>