import {shallowMount, createLocalVue} from '@vue/test-utils';
import sinon from "sinon";
import RolesPage from "../RolesPage.vue";
import Buefy from "buefy"
 import VueSweetalert2 from "../../../../utils/vue_sweet_alert";
import axios from "axios";

let localVue = createLocalVue();
localVue.use(Buefy, {
    defaultProgrammaticPromise: true
});
 localVue.use(VueSweetalert2);
jest.mock('axios');
axios.delete.mockResolvedValue({
    data: {
        content: [{}, {}]
    }
});
axios.get.mockResolvedValue({
    data: {
        content: [{}, {}]
    }
});
Object.defineProperty(window, 'axios', {value: axios});
describe('Roles Page', () => {
    it('Shows a confirmation dialog to remove role', async () => {
        const wrapper = shallowMount(RolesPage, {
            stubs: ["router-view", "router-link"],
            localVue,
            data: () => {
                return {
                    roles: [{name: "Test", id: "1", description: "Test"}]

                }
            }
        });
        const spyConfirmRemoveRole = sinon.spy(wrapper.vm, 'confirmRemoveRole');
        const spyRemoveRole = sinon.spy(wrapper.vm, 'removeRole');
        const spyDialog = sinon.stub(wrapper.vm.$buefy.dialog, 'confirm');
        spyDialog.resolves(true)

        let deleteButtons = await wrapper.findAllComponents({ref: "deleteButton"});
        await deleteButtons.at(0).trigger('click');
        expect(spyConfirmRemoveRole.calledOnce).toBe(true);
        expect(spyDialog.calledOnce).toBe(true);
        // wrapper.findComponent("O")
        expect(spyRemoveRole.calledOnce).toBe(true);
    })

})