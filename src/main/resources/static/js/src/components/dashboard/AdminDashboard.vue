<template>
  <div class="mb-4">
    <div class="columns">
      <div class="column">
        <div class="card">
          <div class="card-content">
            <div class="columns is-mobile">
              <div class="column is-6-mobile">
                <div
                    class="w-20 h-20 rounded-full text-3xl has-text-primary  flex items-center justify-center has-background-primary-light">
                  <i class="fa fa-cubes"></i>
                </div>
              </div>
              <div class="column is-6-mobile">
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
            <div class="columns is-mobile">
              <div class="column">
                <div
                    class="w-20 h-20 rounded-full text-3xl has-text-primary  flex items-center justify-center has-background-primary-light">
                  <i class="fa fa-usd"></i>
                </div>
              </div>
              <div class="column ">
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
            <div class="columns is-mobile">
              <div class="column">
                <div
                    class="w-20 h-20 rounded-full text-3xl has-text-primary  flex items-center justify-center has-background-primary-light">
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
            <div class="columns is-mobile">
              <div class="column">
                <div
                    class="w-20 h-20 rounded-full text-3xl has-text-primary  flex items-center justify-center has-background-primary-light">
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
                    Open Tickets
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
        <div class="card">
          <p class="card-header-title">
            Task Statistics
          </p>
          <div class="card-content">
            <div class="columns">
              <div class="column">
                <div class="card h-16">
                  <div class="card-content p-2">
                    <div class="level">
                      <div class="level-item has-text-centered">
                        <div>
                          <p class="heading">Total Tasks</p>
                          <p class="title is-7">385</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="column">
                <div class="card h-16">
                  <div class="card-content p-2">
                    <div class="level">
                      <div class="level-item has-text-centered">
                        <div>
                          <p class="heading">Overdue Tasks</p>
                          <p class="title is-7">19</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

            </div>

            <div class="progress mb-4">
              <div class="progress-bar has-background-link-dark" role="progressbar" style="width: 30%"
                   aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">30%
              </div>
              <div class="progress-bar has-background-warning" role="progressbar" style="width: 22%" aria-valuenow="18"
                   aria-valuemin="0" aria-valuemax="100">22%
              </div>
              <div class="progress-bar has-background-success" role="progressbar" style="width: 24%" aria-valuenow="12"
                   aria-valuemin="0" aria-valuemax="100">24%
              </div>
              <div class="progress-bar has-background-danger" role="progressbar" style="width: 26%" aria-valuenow="14"
                   aria-valuemin="0" aria-valuemax="100">21%
              </div>
              <div class="progress-bar has-background-info" role="progressbar" style="width: 10%" aria-valuenow="14"
                   aria-valuemin="0" aria-valuemax="100">10%
              </div>
            </div>

            <p class="mb-4"><i class="fa fa-dot-circle-o has-text-link-dark	mr-2"></i>Completed Tasks <span
                class="float-right">166</span></p>
            <p class="mb-4"><i class="fa fa-dot-circle-o has-text-warning mr-2"></i>Inprogress Tasks<span
                class="float-right">166</span></p>
            <p class="mb-4"><i class="fa fa-dot-circle-o has-text-success mr-2"></i>On Hold Tasks<span
                class="float-right">166</span></p>
            <p class="mb-4"><i class="fa fa-dot-circle-o has-text-danger mr-2"></i>Pending Tasks<span
                class="float-right">166</span></p>
            <p class="mb-4"><i class="fa fa-dot-circle-o has-text-info mr-2"></i>Review Tasks<span class="float-right">166</span>
            </p>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <p class="card-header-title">
            Today Absent
          </p>
          <div class="card-content">
            <div class="card min-h-32 mb-4">
              <div class="card-content">


                <article class="media mb-2">
                  <figure class="media-left">
                    <p class="image is-48x48">
                      <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                    </p>
                  </figure>
                  <div class="media-content align-self-center">
                    <div class="content">
                      <p class="title is-6">
                        John Smith
                      </p>
                    </div>
                  </div>
                </article>
                <div class="columns is-centered is-mobile">
                  <div class="column is-6-mobile is-6-tablet">
                    <h6 class="title mb-0 is-7">4 Sep 2019</h6>
                    <span class="subtitle text-muted is-7">Leave Date</span>
                  </div>
                  <div class="column is-6-mobile is-6-tablet text-right">
                    <span class="tag is-success is-light">Pending</span>
                  </div>
                </div>
              </div>
            </div>
            <div class="card min-h-32 mb-4">
              <div class="card-content">


                <article class="media mb-2">
                  <figure class="media-left">
                    <p class="image is-48x48">
                      <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                    </p>
                  </figure>
                  <div class="media-content align-self-center">
                    <div class="content">
                      <p class="title is-6">
                        John Smith
                      </p>
                    </div>
                  </div>
                </article>
                <div class="columns is-mobile">
                  <div class="column is-6">
                    <h6 class="title mb-0 is-7">4 Sep 2019</h6>
                    <span class="subtitle text-muted is-7">Leave Date</span>
                  </div>
                  <div class="column is-6 text-right">
                    <span class="tag is-success is-light">Pending</span>
                  </div>
                </div>
              </div>
            </div>

            <div class="flex justify-center">
              <button class="button">Load More</button>
            </div>
          </div>
        </div>
      </div>

    </div>
    <div class="columns">
      <div class="column">
        <div class="card">
          <p class="card-header-title">
            Invoices
          </p>
          <div class="card-content pl-0 pr-0">
            <div class="table-container">
              <table class="table is-fullwidth">
                <thead>
                <tr>
                  <td>Invoice Id</td>
                  <td>Client</td>
                  <td>Due Date</td>
                  <td>Total</td>
                  <td>Status</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td><a href="invoice-view.html">#INV-0001</a></td>
                  <td>
                    <h2><a href="#">Global Technologies</a></h2>
                  </td>
                  <td>11 Mar 2019</td>
                  <td>$380</td>
                  <td>
                    <span class="badge bg-inverse-warning">Partially Paid</span>
                  </td>
                </tr>
                <tr>
                  <td><a href="invoice-view.html">#INV-0001</a></td>
                  <td>
                    <h2><a href="#">Global Technologies</a></h2>
                  </td>
                  <td>11 Mar 2019</td>
                  <td>$380</td>
                  <td>
                    <span class="badge bg-inverse-warning">Partially Paid</span>
                  </td>
                </tr>
                <tr>
                  <td><a href="invoice-view.html">#INV-0001</a></td>
                  <td>
                    <h2><a href="#">Global Technologies</a></h2>
                  </td>
                  <td>11 Mar 2019</td>
                  <td>$380</td>
                  <td>
                    <span class="badge bg-inverse-warning">Partially Paid</span>
                  </td>
                </tr>
                <tr>
                  <td><a href="invoice-view.html">#INV-0001</a></td>
                  <td>
                    <h2><a href="#">Global Technologies</a></h2>
                  </td>
                  <td>11 Mar 2019</td>
                  <td>$380</td>
                  <td>
                    <span class="badge bg-inverse-warning">Partially Paid</span>
                  </td>
                </tr>
                <tr>
                  <td><a href="invoice-view.html">#INV-0001</a></td>
                  <td>
                    <h2><a href="#">Global Technologies</a></h2>
                  </td>
                  <td>11 Mar 2019</td>
                  <td>$380</td>
                  <td>
                    <span class="badge bg-inverse-warning">Partially Paid</span>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card ">
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
<style scoped lang="scss">
.progress {
  display: -ms-flexbox;
  display: flex;
  height: 1rem;
  overflow: hidden;
  font-size: .75rem;
  background-color: #e9ecef;
  border-radius: .25rem;
}

//.progress > .progress-bar {
//  background-color: #25628F;
//}

//.bg-purple, .badge-purple {
//  background-color: #7460ee !important;
//}
.progress-bar {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-direction: column;
  flex-direction: column;
  -ms-flex-pack: center;
  justify-content: center;
  color: #fff;
  text-align: center;
  white-space: nowrap;
  background-color: #007bff;
  transition: width .6s ease;
}

</style>