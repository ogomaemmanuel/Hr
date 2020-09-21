import {createLocalVue, mount} from "@vue/test-utils"
import RoleCreateForm from "../RoleCreateForm";
import VueSweetalert2 from 'vue-sweetalert2';
let localVue=createLocalVue();
localVue.use(VueSweetalert2)
jest.mock("axios");
axios.post.mockResolvedValue({
    data: {}
});

Object.defineProperty(window, 'axios', {value: axios})
describe('Role Create Form', () => {
    it("clicking create button should send data to the backend", async () => {
        localVue.swal({
            title:""

        })
        const wrapper = mount(RoleCreateForm, {
            localVue,
            data: function () {
                return {
                    role: {
                        name: "Test Role",
                        description: "Description"
                    }
                }
            }
        })

        await wrapper.findComponent({ref: "createButton"}).trigger('click');
        await wrapper.vm.$nextTick();
        console.log(  wrapper.vm.$swal().isVisible());
        //console.log(button.html());
        expect(axios.post).toBeCalledTimes(1);



    })
})