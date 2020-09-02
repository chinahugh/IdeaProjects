window.document.write('<script src="/static/js/vue.js"></script>')
window.document.write('<script src="/static/js/element-ui.js"></script>')
window.document.write('<script src="/static/js/axios.min.js"></script>')

const ajax=axios.create({
    baseURL: 'http://127.0.0.1:8080',
    timeout: 1000,
    headers: {'X-Custom-Header': 'foobar'}
})
Vue.use(ajax);