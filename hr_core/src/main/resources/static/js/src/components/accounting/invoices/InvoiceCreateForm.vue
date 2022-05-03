<template>
  <div>
    <form action="">
      <div class="columns">
        <div class="column">
          <ClientSelectInput
              @input="clearFieldError('clientId')"
              :emit-all-fields="true"
              v-model="selectClient">
            <span slot="errors" class="mb-2 has-text-danger" v-if="errors['clientId']">
						        {{ errors['clientId'][0] }}
            </span>
          </ClientSelectInput>
        </div>
        <div class="column">
          <ProjectSelectInput
              v-model="invoice.projectId"
              @input="clearFieldError('projectId')">
             <span slot="errors" class="mb-2 has-text-danger" v-if="errors['projectId']">
						        {{ errors['projectId'][0] }}
            </span>
          </ProjectSelectInput>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Email</label>
            <div class="control">
              <input
                  v-model="selectClient.email"
                  class="input"
                  type="text">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Tax</label>
            <div class="select is-fullwidth">
              <select v-model="invoice.taxId">
                <option value="" selected>Select Tax</option>
                <option :value="tax.id"
                        v-for="tax in taxes">{{ tax.name }}
                </option>
                <option>No tax</option>
              </select>
            </div>
          </div>
        </div>

      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Client Address</label>
            <div class="control">
              <textarea class="textarea"></textarea></div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Billing Address</label>
            <div class="control">
              <textarea class="textarea" placeholder="Textarea"></textarea></div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Invoice Date</label>
            <div class="control">
              <DatePicker
                  @input="clearFieldError('invoiceDate')"
                  v-model="invoice.invoiceDate">
              </DatePicker>
              <span class="mb-2 has-text-danger" v-if="errors['invoiceDate']">
						        {{ errors['invoiceDate'][0] }}
					    </span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Expiry Date</label>
            <div class="control">
              <DatePicker
                  @input="clearFieldError('expiryDate')"
                  v-model="invoice.expiryDate">
              </DatePicker>
              <span class="mb-2 has-text-danger" v-if="errors['expiryDate']">
						        {{ errors['expiryDate'][0] }}
					    </span>
            </div>
          </div>
        </div>

      </div>
    </form>
    <div class="card mt-3 pr-0 pl-0">
      <div class="card-content">
        <table class="table is-hoverable is-fullwidth">
          <thead>
          <tr>
            <th>#</th>
            <th>Item</th>
            <th>Description</th>
            <th>Unit Cost</th>
            <th>Qty</th>
            <th>Amount</th>
          </tr>
          </thead>
          <tbody>
          <tr is="EstimateItemCreate"
              @removedItem="removeInvoiceItem"
              :errorMessages="errors"
              v-for="(invoiceItem ,index) in invoiceItems"
              :invoiceItem="invoiceItem" :index="index" :key="index">
          </tr>
          </tbody>
        </table>
        <div class="flex justify-end">
          <button @click="addInvoiceItemRow" class="button">
				<span class="icon">
          <i class="fa fa-plus-circle mr-1"></i>
				</span>
          </button>
        </div>
      </div>
    </div>
    <div class="card mt-3 p-8">
      <table class="table is-fullwidth">
        <tbody>
        <tr>
          <td class="has-text-right">
            Total
          </td>
          <td class="has-text-right">
            0
          </td>
        </tr>
        <tr>
          <td class="has-text-right">
            Tax
          </td>
          <td class="has-text-right w-48">
            <input
                disabled="true"
                class="input"
                type="text">
          </td>
        </tr>
        <tr>
          <td class="has-text-right">
            Discount %
          </td>
          <td w class="has-text-right w-48">
            <input
                v-model="invoice.percentageDiscount"
                class="input"
                type="text">
          </td>
        </tr>
        <tr>
          <td class="has-text-right">
            Grand Total
          </td>
          <td w class="has-text-right w-48">
            $0.00
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="mt-3">
      <div class="field">
        <div class="control">
          <label class="label">Other Information</label>
          <textarea
              v-model="invoice.otherInformation"
              class="textarea"
              placeholder="Textarea">
          </textarea>
        </div>
      </div>
    </div>
    <div class="mt-3 pb-5 flex justify-center">
      <div class="mr-2">
        <button @click="createInvoice" class="button is-primary is-rounded">Save and Send</button>
      </div>
      <div class="ml-2">
        <button class="button is-primary is-rounded">Save</button>
      </div>
    </div>
  </div>
</template>
<script>
import {Message, DatePicker, InputNumber} from "element-ui"
import common_mixin from "../../../mixins/common_mixin";
import ClientSelectInput from "../../common/ClientSelectInput";
import EstimateItemCreate from "./InvoiceItemCreate";
import ProjectSelectInput from "../../common/ProjectSelectInput";

export default {
  components: {
    DatePicker,
    InputNumber,
    ClientSelectInput,
    EstimateItemCreate,
    ProjectSelectInput
  },
  mixins: [common_mixin],
  data() {
    return {
      taxes: [],
      selectClient: {},
      invoice: {
        taxId: "",
        invoiceItems: [
          {}
        ]
      }
    }
  },
  computed: {
    invoiceItems() {
      return this.invoice.invoiceItems;
    }
  },
  created() {
    this.getTaxes();
  },
  methods: {
    addInvoiceItemRow() {
      this.invoice.invoiceItems.push({})
    },
    createInvoice() {
      this.invoice.clientId = this.selectClient.id;
      axios.post("/api/invoices",
          this.invoice).then(resp => {
        Message.success("invoice successfully created")
      }, error => {
        Message.error("There was problem invoice");
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    },
    removeInvoiceItem(index) {
      if (this.invoiceItems.length > 1) {
        this.invoiceItems.splice(index, 1);
      }
    },
    getTaxes() {
      axios.get("/api/taxes/all").then(resp => {
        this.taxes = resp.data;
      }, error => {
        console.log("Error fetching taxes  data in EstimateCreateForm")
      })
    }
  }

}
</script>
<style scoped lang="scss">
.estimate-remove-btn {
  position: absolute;
  right: -1rem;
  top: 0.5rem;
}
</style>