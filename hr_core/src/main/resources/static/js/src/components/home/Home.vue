<template>
  <div>
    <section class="main-content columns  is-fullheight">

      <aside
          class="column pt-12 is-2 bg-gray-900 text-white pr-0 pl-3 pt-5 is-narrow-mobile fixed inset-y-0 section is-hidden-mobile">

        <div class="menu-wrapper">
          <portal-target class="side-menu-portal-target" name="side-menu">
            <ul class="menu-list">
              <li>
                <router-link to="/"  class="">
                  <span tag="span" to="/" class="icon"><i class="fa fa-home"></i></span> Home
                </router-link>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-cubes"></i></span> Apps
                </a>

                <ul class="mr-0 pr-0 border-l-0">
                  <li>
                    <router-link to="/events">
                      <span>Calender</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="roles">
                      <span>Contacts</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/permissions">
                      <span>Permissions</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-group"></i></span> Access Control
                </a>

                <ul class="mr-0 pr-0 border-l-0">
                  <li>
                    <router-link to="/users">
                      <span>Users</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="roles">
                      <span>Roles</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/permissions">
                      <span>Permissions</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-building-o"></i></span> Employee Management
                </a>
                <ul class="mr-0 pr-0 border-l-0">
                  <li>
                    <router-link to="/employees">
                      <span>All Employees</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/departments">
                      <span>Departments</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/designations">
                      <span>Designations</span>
                    </router-link>
                  </li>
                  <li>
                    <a href="#">
                      <span>Attendance(Admin)</span>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <span>Attendance(Employee)</span>
                    </a>
                  </li>
                  <li>
                    <router-link to="/overtime-requests">
                      <span>Overtime</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/employee-resignations">
                      <span>Resignation</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/employee-terminations">
                      <span>Termination</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/policies">
                      <span>Policy</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-money"></i></span> Payroll
                </a>
                <ul class="mr-0 pr-0 border-l-0">
                  <li>
                    <router-link to="/salary">
                      <span>Employee Salary</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/salary-view">
                      <span>Payslip</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/payroll-items">
                      <span>Payroll Items</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-money"></i></span> Project Management
                </a>
                <ul class="mr-0 pr-0 border-l-0">
                  <li>
                    <router-link to="/clients">
                      <span>Clients</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/projects">
                      <span>Projects</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/tasks">
                      <span>Tasks</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/payroll-items">
                      <span>Task Board</span>
                    </router-link>
                  </li>
                </ul>
              </li>

              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-table"></i></span> Leave Management
                </a>
                <ul class="border-l-0">
                  <li>
                    <router-link to="/leave">
                      <span>My Leaves</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/documents">
                      <span>In Place</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/leave-approvals">
                      <span>Leave approvals</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/holidays">
                      <span>Holidays</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/leave-types">
                      <span>Leave Types</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-files-o"></i></span> Accounts
                </a>
                <ul class="border-l-0">
                  <li>
                    <router-link to="/estimates">
                      <span>Estimates</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/invoices">
                      <span>Invoices</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/payments">
                      <span>Payments</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/expenses">
                      <span>Expenses</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/provident-funds">
                      <span>Provided Fund</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/taxes">
                      <span>Taxes</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <router-link to="/assets" class="">
                  <span class="icon"><i class="fa fa-object-ungroup"></i></span> Assets
                </router-link>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-briefcase"></i></span> Jobs
                </a>
                <ul class="border-l-0">
                  <li>
                    <router-link to="/jobs">
                      <span>Manage Jobs</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/taxes">
                      <span>Applied Candidates</span>
                    </router-link>
                  </li>
                </ul>
              </li>

              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-folder-open"></i></span> File Management
                </a>
                <ul class="border-l-0">
                  <li>
                    <router-link to="/documents">
                      <span>Manage Files</span>
                    </router-link>
                  </li>
                  <li>
                    <router-link to="/documents">
                      <span>My Files</span>
                    </router-link>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" class="">
                  <span class="icon"><i class="fa fa-info"></i></span> About
                </a>
              </li>
            </ul>
          </portal-target>
        </div>
        <div class="side-bar-footer bg-gray-800 left-0  right-0 h-8 absolute bottom-0">
          <div class="flex justify-end mr-4">
            <i><span class="fa fa-angle-left"></span></i>
          </div>
          <!--						<div class="relative mt-5 h-full">-->
          <!--					</div>-->
        </div>
      </aside>


      <div class=" column is-offset-2 is-10 pr-10 pl-10 pb-10 pt-20 h-screen mb-0">
        <div class="">

          <div class="columns">
            <div class="column">

              <div class="flex align-center">
                <button type="button" class="is-hidden-desktop toggle-mobile-nav">
                  <i class="fa fa-bars text-gray-600"></i>
                </button>
                <TestBreadCrump></TestBreadCrump>
              </div>
            </div>
            <div class="column">
              <div class="flex sm:justify-start md:justify-end">
                <portal-target name="page-controls">
                  <!--
                  This component can be located anywhere in your App.
                  The slot content of the above portal component will be rendered here.
                  -->
                </portal-target>
              </div>
            </div>
          </div>


          <!--                    <breadcrumbs></breadcrumbs>-->
        </div>
        <div class="mt-5 h-full">
          <router-view></router-view>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import TestBreadCrump from "../common/TestBreadCrump"

export default {
  components: {
    TestBreadCrump,
  },
  data() {
    return {
      isFullPage: true,
    }

  },
  computed: {},
  created() {
    // this.open();

  },
  methods: {}
}
</script>
<style scoped lang="scss">

.navbar-item .profile-image {
  height: 36px;
  width: 36px;
  max-height: 36px;
}

.toggle-mobile-nav {
  //display: none;
  background-color: transparent;
  border: 0px;
  padding: 6px 16px;
  margin: 0 0 0 -15px;
  height: 46px;
}

.menu-wrapper {
  overflow-y: scroll;
  position: relative;
  height: 100%;
  margin-top: 2rem;
}

.side-menu-portal-target {
  display: revert;
}
</style>
