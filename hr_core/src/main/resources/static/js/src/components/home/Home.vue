<template>
  <section class="main-content columns  is-fullheight">
    <sidebar-menu
        :menu="menu"
        width="250px"
        :showOneChild="true"
    >
      <template v-slot:header>
        <router-link class="text-white align-middle font-medium pl-2 pr-4 py-2 my-2 " to="/profile" style="color: #FFFFFF; border-bottom: 2px solid #1e1e21">
          <LogoMini style="color: #FFFFFF; float: left" class="mr-4" />
          {{ authenticatedUser.fullName.split(" ")[0] }}
          <i class="fa fa-angle-down" aria-hidden="true"></i>
        </router-link>
      </template>

      <template v-slot:footer>
        <div class="text-white px-4 pb-4">
          <logout-form></logout-form>
        </div>
      </template>

      <template v-slot:toggle-icon>
          <i class="fa fa-angle-double-left" style="font-size: 24px;" aria-hidden="true"></i>
      </template>
      <template v-slot:dropdown-icon="{ isOpen }">
        <span v-if="!isOpen">
          <i class="fa fa-chevron-right" aria-hidden="true"></i>
        </span>
        <span v-else>
          <i class="fa fa-chevron-down " aria-hidden="true"></i>
        </span>
      </template>
    </sidebar-menu>

    <div class=" column is-offset-2 is-10 pr-10 pl-10 h-screen mb-0">
      <div class=" ">
        <div class="columns mt-1">
          <div class="column p-0">
            <div class="flex flex-col pt-2">
              <TestBreadCrump></TestBreadCrump>
              <portal-target name="header">
              </portal-target>
            </div>
          </div>
          <div class="column p-0"></div>
          <div class="column p-0">
            <div class="flex sm:justify-start md:justify-end py-1">
              <portal-target name="page-controls">
                <!--
                This component can be located anywhere in your App.
                The slot content of the above portal component will be rendered here.
                -->
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
import LogoMini from "../auth/Logos/LogoMain.vue";
export default {
  components: {LogoMini, LogoutForm, TestBreadCrump},
  data() {
    return {
      menu: [

        {
          href:  { path: '/dashboard' },
          title: 'Dashboard',
          icon: 'fa fa-user'
        },
        {
          href: { path: '/employees' },
          title: ' Employee',
          icon: 'fa fa-building-o',
          child: [
            {
              href: { path: '/employees' },
              icon: 'fa fa-',
              title: 'All Employees'
            },
            {
              href: { path: '/departments' },
              icon: 'fa fa-',
              title: 'Departments'
            },
            {
              href: { path: '/designations' },
              icon: 'fa fa-',
              title: 'Designations'
            },
            {
              href: { path: '/overtime-requests' },
              icon: 'fa fa-',
              title: 'Overtime'
            },
            {
              href: { path: '/employee-resignations' },
              icon: 'fa fa-',
              title: 'Resignation'
            },
            {
              href: { path: '/employee-terminations' },
              icon: 'fa fa-',
              title: 'Termination'
            }
          ]
        },
        {
          href: { path: '/salary' },
          title: 'Payroll',
          icon: 'fa fa-money',
          child: [
            {
              href: { path: '/salary' },
              icon: 'fa fa-',
              title: 'Employee Salary'
            },
            {
              href: { path: '/salary-view' },
              icon: 'fa fa-',
              title: 'Payslip'
            },
            {
              href: { path: '/payroll-items' },
              icon: 'fa fa-',
              title: 'Payroll Items'
            }

          ]
        },
        {
          href:  { path: '/leave' },
          title: 'My Leaves',
          icon: 'fa fa-table'
        },
        {
          href: {path: '/employee-attendance'},
          icon: 'fa fa-clock-o',
          title: 'Attendance',
          child: [
            {
              href: { path: '/admin-attendance' },
              icon: 'fa fa-',
              title: 'Admin'
            },
            {
              href: { path: '/employee-attendance' },
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