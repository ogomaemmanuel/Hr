<template>
  <div class="h-full user-profile-page">
    <div class="card min-h-48">
      <div class="card-content">
        <div class="content">
          <div class="columns">
            <div class="column is-2">
              <div class="profile-image-wrapper ">
                <figure class="image is-128x128 relative profile-img-wrap edit-img">
                  <img class="is-rounded"
                       src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                       alt="">
                  <div class="fileupload btn">
                    <span class="btn-text">edit</span>
                    <form ref="imageForm" action="">
                      <input @change="onFileChange" ref="imageInput" accept="image/*" class="upload" type="file">
                    </form>
                  </div>
                </figure>
              </div>
            </div>
            <div class="column is-10 pl-5">
              <div class="columns">
                <div class="column">
                  <div class="pt-5">
                    <h2 class="font-semibold">{{ authenticatedUser.fullName }}</h2>
                  </div>
                  <div class="flex ">
                    <div class="mr-1">
                                     <span>
                                    <i class="fa fa-building"></i>
                                </span>
                      <span>{{ authenticatedUser.departmentName }}</span>
                    </div>
                    <div>
                                     <span>
                                    <i class="fa fa-phone"></i>
                                </span>
                      <span>{{ authenticatedUser.phone }}</span>
                    </div>
                  </div>
                </div>
                <div class="column"></div>
              </div>


            </div>
          </div>

        </div>
      </div>
    </div>
    <div class="card mt-1">
      <div class="tabs">
        <ul>
          <li @click="showAdditions=true" :class="{'is-active':showAdditions}"><a>Profile</a></li>
          <li @click="showAdditions=false" :class="{'is-active':!showAdditions}"><a>Projects</a></li>
          <li @click="showAdditions=false" :class="{'is-active':!showAdditions}"><a>Bank & Statutory</a>
          </li>
        </ul>
      </div>
    </div>
    <div class="columns mt-2 personal-emergency">
      <div class="column">
        <div class="card h-full">
          <div class="card-content">
            <div class="flex">
              <h1 class="flex-1 title is-5 has-text-weight-bold">Personal Information </h1>
              <div>
                <!--                <button @click="showModal=true">-->
                <!--                  <i class="fa fa-pencil"></i>-->
                <!--                </button>-->
              </div>
            </div>
            <div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Identity No</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.idNo }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Phone</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.phone }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Employment Date</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.employmentDate }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Department</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.department }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">KRA Pin</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.kraPin }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">NHIF Number</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.nhifNo }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">NSSF Number</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.nssfNo }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Marital Status</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.maritalStatus }}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <ContactsTemplate></ContactsTemplate>
      </div>
    </div>
    <div class="columns mt-2">
      <div class="column">
        <div class="card h-full">
          <div class="card-content">
            <div class="flex">
              <h1 class="flex-1 title is-5">Bank information </h1>
              <div>
                <!--                <button>-->
                <!--                  <i class="fa fa-pencil"></i>-->
                <!--                </button>-->
              </div>
            </div>
            <div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Bank Name</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.bankName }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Branch</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.bankBranch }}</p>
              </div>
              <div class="columns personal-detail">
                <label class="column is-7 personal-label has-text-weight-bold">Account No</label>
                <p class=" column is-5 has-text-weight-medium text-gray-600">{{ employeeDetails.accountNo }}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <InfoTemplate :user-id="employeeId"></InfoTemplate>
      </div>
    </div>
    <ProfilePhotoPreview
        @closepreview="closeImagePreview"
        v-if="showImagePreview"
        :imageUrl="newImageUrl"
        :key="">
    </ProfilePhotoPreview>

  </div>
</template>
<script>
import {mapGetters} from "vuex"
import ProfilePhotoPreview from "./ProfilePhotoPreview";
import ContactsTemplate from "./emergencyContacts/ContactsTemplate";
import InfoTemplate from "./familyInfo/InfoTemplate";

export default {
  components: {
    InfoTemplate,
    ContactsTemplate,
    ProfilePhotoPreview
  },
  data() {
    return {
      showAdditions: true,
      employeeSalaryInfo: {},
      showImagePreview: false,
      newImageUrl: "",
      employeeDetails: {}
    }
  },
  computed: {
    ...mapGetters(["authenticatedUser"]),
    employeeId() {
      return this.authenticatedUser.id;
    }
  },
  created() {
    this.getEmployeeDetails();
    //this.getEmployeeSalaryInfo();

  },
  methods: {
    closeImagePreview(refresh) {
      let vm = this;
      vm.showImagePreview = false;
      this.$refs.imageForm.reset();
      if (refresh) {
        //this.getUserUserDetails();
      }
    },

    getEmployeeSalaryInfo() {
      axios.get(`/api/employee-salary/${this.employeeId}`).then(resp => {
        this.employeeSalaryInfo = resp.data;
      })
    },
    getEmployeeDetails() {
      axios.get(`/api/profile/details/${this.employeeId}`).then(resp => {
        this.employeeDetails = resp.data;
      })
    },
    onFileChange(e) {
      let vm = this;
      const file = e.target.files[0];
      if (!file.type.includes('image/')) {
        return;
      }
      if (typeof FileReader === 'function') {
        const reader = new FileReader();
        reader.onload = (event) => {
          this.newImageUrl = event.target.result;
          vm.showImagePreview = true;
          vm.$refs.imageForm.reset();
        };
        reader.readAsDataURL(file);
      } else {
        alert('Sorry, FileReader API not supported');
      }
    },

  }
}
</script>
<style lang="scss" scoped>
.fileupload input.upload {
  cursor: pointer;
  filter: alpha(opacity=0);
  font-size: 20px;
  margin: 0;
  opacity: 0;
  padding: 0;
  position: absolute;
  right: -3px;
  top: -3px;
  padding: 5px;
}

.btn {
  display: inline-block;
  font-weight: 400;
  color: #212529;
  text-align: center;
  vertical-align: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  background-color: transparent;
  border: 1px solid transparent;
  padding: .375rem .75rem;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: .25rem;
  transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.btn {
  font-weight: 400;
  color: #212529;
  text-align: center;
  font-size: 1rem;
  line-height: 1.5;
}

.fileupload.btn {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
  background: rgba(33, 33, 33, 0.5);
  border-radius: 0;
  padding: 3px 10px;
  border: none;
  color: #fff;
}

.profile-img-wrap.edit-img {
  border-radius: 50%;
  margin: 0 auto 30px;
  position: relative;
}

.profile-img-wrap {
  height: 128px;
  position: absolute;
  width: 128px;
  background: #fff;
  overflow: hidden;
}

</style>