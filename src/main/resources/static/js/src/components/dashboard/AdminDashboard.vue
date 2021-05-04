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
        <div class="card h-64">
          <p class="card-header-title">
            Statistics
          </p>
          <div class="card-content"></div>
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
          <div class="card-content"></div>
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
                <th>Action</th>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>

    </div>

  </div>
</template>
<script>
export default {}
</script>