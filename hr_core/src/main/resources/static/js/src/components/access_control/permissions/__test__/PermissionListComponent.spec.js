import {mount} from "@vue/test-utils"
import PermissionList from "../PermissionList.vue";
import axios from 'axios';


jest.mock('axios');
axios.get.mockResolvedValue({
    data: {
        content: [{}, {}]
    }
});
Object.defineProperty(window, 'axios', {value: axios});
describe("PermissionList Component", () => {
    it("fetches permission when created", async () => {
        let wrapper = mount(PermissionList, {
            stubs: ['router-view']
        });
        await wrapper.vm.$nextTick();
        expect(wrapper.vm.permissions.length).toEqual(2)
        expect(axios.get).toHaveBeenCalledWith("/api/permissions",{"params": {"page": 0, "pageSize": 10}});

    })
})