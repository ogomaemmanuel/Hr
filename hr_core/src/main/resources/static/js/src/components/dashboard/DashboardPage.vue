<template>
  <div>
    <AdminDashboard v-if="showAdminDashBoard"></AdminDashboard>
    <EmployeeDashboard v-else></EmployeeDashboard>
  </div>
</template>
<script>
import {mapGetters} from "vuex";

const EmployeeDashboard = () => import("./EmployeeDashboard");
const AdminDashboard = () => import("./AdminDashboard")
export default {
  components: {
    EmployeeDashboard,
    AdminDashboard
  },
  computed: {
    ...mapGetters(["authenticatedUser"]),
    showAdminDashBoard() {
      return this.authenticatedUser?.authorities.some(auth =>
          auth?.authority?.toLowerCase() === "admin");
    }
  }
}
</script>