function formatToCurrency(value) {
    return (value).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
}
function formattedDate() {
        return moment(value).format('LLL');
}
function formattedTime() {
        return moment(value).format('LT');
}
export  default {
    formatToCurrency,
    formattedTime,
    formattedDate
}