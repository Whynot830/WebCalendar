import { createApp } from 'vue'
import App from './App.vue'
import components from './components'
// import router from './router/router'
// import store from './store'
const app = createApp(App)


Object.values(components).forEach(component => {
    app.component(component.name, component)
})

app.mount('#wrap')
