<template>
  <div class="mb-4">
    <div class="columns">
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="columns">
              <div class="column">
                <div class="w-20 h-20 rounded-full  flex items-center justify-center has-background-primary-light">
                  <i class="fa fa-cubes"></i>
                </div>
              </div>
              <div class="column">
                <p class="heading ">Projects</p>
                <p class="title is-6">3,456</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="columns">
              <div class="column">
                <div class="w-20 h-20 rounded-full  flex items-center justify-center has-background-primary-light">
                  <i class="fa fa-usd"></i>
                </div>
              </div>
              <div class="column">
                <p class="heading ">Clients</p>
                <p class="title is-6">3,456</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="columns">
              <div class="column">
                <div class="w-20 h-20 rounded-full  flex items-center justify-center has-background-primary-light">
                  <i class="fa fa-diamond"></i>
                </div>
              </div>
              <div class="column">
                <p class="heading ">Tasks</p>
                <p class="title is-6">3,456</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="columns">
              <div class="column">
                <div class="w-20 h-20 rounded-full  flex items-center justify-center has-background-primary-light">
                  <i class="fa fa-user"></i>
                </div>
              </div>
              <div class="column">
                <p class="heading ">Employees</p>
                <p class="title is-6">3,456</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="columns">
      <div class="column">
        <div class="card h-64">
          <div class="card-content"></div>
        </div>
      </div>
      <div class="column">
        <div class="card h-64">
          <div class="card-content"></div>
        </div>
      </div>
    </div>
    <div class="columns is-gapless">
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="flex justify-between">
              <div>
                <p class="title is-6">New Employees</p>
              </div>
              <div>
                <p class="heading is-6">+10%</p>
              </div>
            </div>
            <div class="mt-2 mb-2">
              <p class="title is-6">10</p>
            </div>
            <b-progress type="is-success" size="is-small" :value="80"></b-progress>
            <div class="">
              <p>Overall Employees 218</p>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="flex justify-between">
              <div>
                <p class="title is-6">Earnings</p>
              </div>
              <div>
                <p class="heading is-6">+12.5%</p>
              </div>
            </div>
            <div class="mt-2 mb-2">
              <p class="title is-6">$1,42,300</p>
            </div>
            <b-progress type="is-success" size="is-small" :value="80"></b-progress>
            <div class="">
              <p>Previous Month $1,15,852</p>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="flex justify-between">
              <div>
                <p class="title is-6">Expenses</p>
              </div>
              <div>
                <p class="heading is-6">-2.8%</p>
              </div>
            </div>
            <div class="mt-2 mb-2">
              <p class="title is-6">$8,500</p>
            </div>
            <b-progress type="is-success" size="is-small" :value="80"></b-progress>
            <div class="">
              <p>Previous Month $7,500</p>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="flex justify-between">
              <div>
                <p class="title is-6">Profit</p>
              </div>
              <div>
                <p class="heading is-6">-75%</p>
              </div>
            </div>
            <div class="mt-2 mb-2">
              <p class="title is-6">$1,12,000</p>
            </div>
            <b-progress type="is-success" size="is-small" :value="80"></b-progress>
            <div class="">
              <p>Previous Month $1,42,000</p>
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="columns">
      <div class="column">
        <div class="card">
          <p class="card-header-title">
            Statistics
          </p>
          <div class="card-content">
            <div class="card h-16">
              <div class="card-content p-1">
                <div class="flex mt-2 mr-2 ml-2 justify-between">
                  <p class="title is-7">
                    Today Leave
                  </p>
                  <p class="title is-7">
                    4 / 65
                  </p>
                </div>
                <div class="mr-2 ml-2">
                  <Progress :show-text="false" :percentage="70"></Progress>
                </div>
              </div>
            </div>
            <div class="card h-16 mt-1">
              <div class="card-content p-1">
                <div class="flex mt-2 mr-2 ml-2 justify-between">
                  <p class="title is-7">
                    Pending Invoice
                  </p>
                  <p class="title is-7">
                    4 / 65
                  </p>
                </div>
                <div class="mr-2 ml-2">
                  <Progress :show-text="false" :percentage="70"></Progress>
                </div>
              </div>
            </div>
            <div class="card h-16 mt-1">
              <div class="card-content p-1">
                <div class="flex mt-2 mr-2 ml-2 justify-between">
                  <p class="title is-7">
                    Completed Projects
                  </p>
                  <p class="title is-7">
                    4 / 65
                  </p>
                </div>
                <div class="mr-2 ml-2">
                  <Progress :show-text="false" :percentage="70"></Progress>
                </div>
              </div>
            </div>
            <div class="card h-16 mt-1">
              <div class="card-content p-1">
                <div class="flex mt-2 mr-2 ml-2 justify-between">
                  <p class="title is-7">
                    Completed Projects
                  </p>
                  <p class="title is-7">
                    4 / 65
                  </p>
                </div>
                <div class="mr-2 ml-2">
                  <Progress :show-text="false" :percentage="70"></Progress>
                </div>
              </div>
            </div>
            <div class="card h-16 mt-1">
              <div class="card-content p-1">
                <div class="flex mt-2 mr-2 ml-2 justify-between">
                  <p class="title is-7">
                    Closed Tickets
                  </p>
                  <p class="title is-7">
                    4 / 65
                  </p>
                </div>
                <div class="mr-2 ml-2">
                  <Progress :show-text="false" :percentage="70"></Progress>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card h-64">
          <p class="card-header-title">
            Task Statistics
          </p>
          <div class="card-content"></div>
        </div>
      </div>
      <div class="column">
        <div class="card h-64">
          <p class="card-header-title">
            Today Absent
          </p>
          <div class="card-content"></div>
        </div>
      </div>

    </div>
    <div class="columns">
      <div class="column">
        <div class="card h-64">
          <p class="card-header-title">
            Invoices
          </p>
          <div class="card-content"></div>
        </div>
      </div>
      <div class="column">
        <div class="card h-64">
          <p class="card-header-title">
            Payments
          </p>
          <div class="card-content"></div>
        </div>
      </div>

    </div>
    <div class="columns">
      <div class="column">
        <div class="card h-64">
          <p class="card-header-title">
            Clients
          </p>
          <div class="card-content pt-0 pr-0 pl-0">
            <table class="table is-stripped is-fullwidth">
              <thead>
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>Barry Cuda</td>
                <td>barrycuda@example.com</td>
                <td>Active</td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Barry Cuda</td>
                <td>barrycuda@example.com</td>
                <td>Active</td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Barry Cuda</td>
                <td>barrycuda@example.com</td>
                <td>Active</td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Barry Cuda</td>
                <td>barrycuda@example.com</td>
                <td>Active</td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Barry Cuda</td>
                <td>barrycuda@example.com</td>
                <td>Active</td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card h-64">
          <p class="card-header-title">
            Recent Projects
          </p>
          <div class="card-content mt-0 pt-0 pl-0 pr-0">
            <table class="table is-striped is-fullwidth mt-0">
              <thead>
              <tr>
                <th>Project Name</th>
                <th>Progress</th>
                <th class="text-right">Action</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>Office Management</td>
                <td>
                  <b-progress type="is-success" size="is-small" :value="80"></b-progress>
                </td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Office Management</td>
                <td>
                  <b-progress type="is-success" size="is-small" :value="80"></b-progress>
                </td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Office Management</td>
                <td>
                  <b-progress type="is-success" size="is-small" :value="80"></b-progress>
                </td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Office Management</td>
                <td>
                  <b-progress type="is-success" size="is-small" :value="80"></b-progress>
                </td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Office Management</td>
                <td>
                  <b-progress type="is-success" size="is-small" :value="80"></b-progress>
                </td>
                <td>
                  <div class="text-right">
                    <i class="fa fa-ellipsis-v"></i>
                  </div>
                </td>
              </tr>
              </tbody>
            </table>

          </div>
        </div>
      </div>

    </div>

  </div>
</template>
<script>
import {Progress} from "element-ui"

export default {
  components: {
    Progress
  }
}
</script>