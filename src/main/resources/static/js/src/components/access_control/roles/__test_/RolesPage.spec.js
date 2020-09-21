import {shallowMount, createLocalVue} from '@vue/test-utils';
import sinon from "sinon";
import RolesPage from "../RolesPage";
import Buefy from "buefy"
import axios from "axios";

let localVue = createLocalVue();
localVue.use(Buefy);
jest.mock('axios');
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
        const spyDialog = sinon.spy(wrapper.vm.$buefy.dialog, 'confirm');
        spyDialog.
        let deleteButtons = await wrapper.findAllComponents({ref: "deleteButton"});
        console.log(deleteButtons.at(0).html());
        await deleteButtons.at(0).trigger('click');
        expect(spyConfirmRemoveRole.calledOnce).toBe(true);
        expect(spyDialog.calledOnce).toBe(true);
        expect(spyRemoveRole.calledOnce).toBe(true);
    })

})