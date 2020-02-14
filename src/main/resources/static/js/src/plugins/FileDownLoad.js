export default {
    install(Vue, options) {
        Vue.prototype.$downLoadFile = function (args) {
            let vm = this;
            let requestMethod = args.requestMethod;
            let endPoint = args.endPoint;
            let params = args.param;
            if (requestMethod.toLowerCase() == "get") {
                axios.get(endPoint,{
                    params:params,
                }).then((response) => {
                    console.log("request",response.data)
                    vm.isDownloading = false
                    let blob = new Blob([response.data]);
                    let blobURL = URL.createObjectURL(blob);
                    const url = window.URL.createObjectURL(blob);
                    const link = document.createElement('a');
                    link.href = url;
                    link.setAttribute('download', 'file.pdf');
                    document.body.appendChild(link);
                    link.click();

                }, error => {
                    vm.isDownloading = false
                });

            } else {
                axios.post(endPoint, params).then((response) => {
                    vm.isDownloading = false
                    let blob = new Blob([response.data]);
                    let blobURL = URL.createObjectURL(blob);
                    const url = window.URL.createObjectURL(blob);
                    const link = document.createElement('a');
                    link.href = url;
                    link.setAttribute('download', 'file.pdf');
                    document.body.appendChild(link);
                    link.click();

                }, error => {
                    vm.isDownloading = false
                });
                ;
            }

        }
    }
}