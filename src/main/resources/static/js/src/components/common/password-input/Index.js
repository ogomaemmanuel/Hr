import PasswordInput from './password_input'
PasswordInput.install = function (Vue) {
    Vue.component(PasswordInput.name, PasswordInput)
}
if (typeof window !== 'undefined' && window.Vue) {
    window.Vue.use(PasswordInput)
}
export default PasswordInput