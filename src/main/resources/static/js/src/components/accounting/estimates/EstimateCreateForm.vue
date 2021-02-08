<template>
  <div>
    <form action="">
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Client</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Project</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Email</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Tax</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>

      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Client Address</label>
            <div class="control">
              <textarea class="textarea" placeholder="Textarea"></textarea></div>
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
            <label class="label">Estimate Date</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Expiry Date</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>

      </div>
    </form>
    <div class="card mt-3">
      <div class="card-content">
        <table class="table is-fullwidth">
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
          <tr>
            <td>
              1
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input class="input" placeholder="Textarea"></input></div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input class="input" placeholder="Textarea"></input></div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input class="input" placeholder="Textarea"></input></div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input class="input" placeholder="Textarea"></input></div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input class="input" placeholder="Textarea"></input></div>
              </div>
            </td>


          </tr>
          </tbody>
        </table>
        <div class="flex justify-end">
          <button class="button">
				<span class="icon">
          <i class="fa fa-plus-circle mr-1"></i>
				</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {}
</script>