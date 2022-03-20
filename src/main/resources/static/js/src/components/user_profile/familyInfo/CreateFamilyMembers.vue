<template>
  <div>
    <h1 class="has-text-weight-bold modal-heading flex justify-center">Family Informations</h1>
    <div v-for="(member,index)  in members">
      <div v-if="members.length>1"
           class="flex is-hidden-desktop justify-end contact-header">
        <i @click.prevent="removeRow(index)" class="fa fa-trash has-text-danger"></i>
      </div>
      <div class="single-member">
        <div class="forms">
          <div class="columns">
            <h1 class="sub-heading column">
              Family Information
            </h1>
            <div class="column flex justify-end">
              <i v-if="members.length > 1"
                 @click.prevent="removeRow(index)"
                 class="fa fa-trash has-text-danger delete-contact is-hidden-mobile"></i>
            </div>
          </div>
          <div class="columns">
            <div class="column">
              <div class="field">
                <label class="label ">Contact Name <span><sup>*</sup></span></label>
                <div class="control">
                  <input
                      v-model="member.name"
                      @input="clearFieldError(`members[${index}].name`)"
                      class="input"
                      type="text">
                  <span class="mb-2 has-text-danger"
                        v-if="errors[`members[${index}].name`]">
                            {{ errors[`members[${index}].name`][0] }}
                          </span>
                </div>
              </div>
            </div>
            <div class="column is-relative">
              <div class="field">
                <label class="label ">Relationship <span><sup>*</sup></span></label>
                <div class="control">
                  <Select
                      class="form-control is-large w-full"
                      v-model="member.relationshipId"
                      required
                  >
                    <Option v-for="relationship in relationships"
                            :value="relationship.id"
                            :label="relationship.name"
                            :key="relationship.id" class="form-control">
                    </Option>
                  </Select>
                  <span class="mb-2 has-text-danger" v-if="errors[`members[${index}].relationshipId`]">
                                                    {{ errors[`members[${index}].relationshipId`][0] }}
    					            </span>
                </div>
              </div>
            </div>
          </div>
          <div class="columns">
            <div class="column">
              <div class="field">
                <label class="label ">Date of Birth <span><sup>*</sup></span></label>
                <div class="control">
                  <DatePicker
                      class="datepicker"
                      value-format="yyyy-MM-dd"
                      v-model="member.dob"
                      @input="clearFieldError(`members[${index}].dob`)"
                  ></DatePicker>
                  <span class="mb-2 has-text-danger"
                        v-if="errors[`members[${index}].dob`]">
                            {{ errors[`members[${index}].dob`][0] }}
                          </span>
                </div>
              </div>
            </div>
            <div class="column">
              <div class="field">
                <label class="label ">Phone Number <span><sup>*</sup></span></label>
                <div class="control">
                  <input
                      v-model="member.phoneNumber"
                      @input="clearFieldError(`members[${index}].phoneNumber`)"
                      class="input"
                      type="text">
                  <span class="mb-2 has-text-danger"
                        v-if="errors[`members[${index}].phoneNumber`]">
                            {{ errors[`members[${index}].phoneNumber`][0] }}
                          </span>
                </div>
              </div>
            </div>
          </div>
          <div v-if="members.length === index+1">
            <button class="button" @click="addRow()">
              <i class="fa fa-plus add-row"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="flex justify-center">
      <button
          :disabled="disableSubmitButton"
          @click.prevent="submit"
          :class="{'is-loading':isLoading}"
          class="button is-rounded p-2">
        Submit
      </button>
    </div>
  </div>
</template>

<script>
import CommonMixin from "../../../mixins/common_mixin";
import {DatePicker, Select, Option, Message} from "element-ui";

export default {
  name: "CreateMembers",
  props: {
    userId: {
      required: true
    }
  },
  mixins: [CommonMixin],
  components: {
    DatePicker,
    Select,
    Option
  },
  data() {
    return {
      members: [],
      relationships: [],
      isLoading: false
    }
  },
  created() {
    this.initialize();
    this.getFamilyRelations();
  },
  computed: {
    disableSubmitButton(){
      return this.isLoading;
    }
  },
  methods: {
    addRow() {
      this.members.push({
        name: "",
        relationshipId: "",
        dob: "",
        phoneNumber: ""
      })
    },
    removeRow(index) {
      if (this.members.length > 1) {
        this.members.splice(index, 1);
      }

    },
    initialize() {
      this.members = [
        {
          name: "",
          relationshipId: "",
          dob: "",
          phoneNumber: ""
        },
        {
          name: "",
          relationshipId: "",
          dob: "",
          phoneNumber: ""
        }
      ]
    },
    submit() {
      let vm = this;
      let request = {
        userId: vm.userId,
        members: vm.members
      }
      axios.post(`/api/users/family-members/new`, request).then(resp => {
        vm.isLoading = false;
        if (resp.data.status === "00") {
          this.$emit("updatedMember");
          Message.success(resp.data.msg);
        } else {
          Message.error(resp.data.msg);
        }
      }, error => {
        if (error.response.status === 400) {
          vm.isLoading = false;
          this.errors = error.response.data;
        }else{
          vm.isLoading = false;
          Message.error("Something went wrong. Contact Admin");
        }
      })
    },
    getFamilyRelations(){
      let vm = this;
      axios.get(`/api/users/family-relationships`).then(resp => {
        vm.relationships = resp.data;
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.single-member{
  padding: 20px;
}
.forms{
  padding: 20px;
  border-radius: 10px;
  border: 1px solid #b6b6b6;
}
.delete-contact,.add-row{
  transform: scale(1.5);
}

</style>