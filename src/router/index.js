import { createRouter, createWebHistory } from 'vue-router'
import Login from "../views/LoginForm";
import vueHome from "../views/VueHome";
import TaskForm from "../views/TaskForm";
import vueProfile from "../views/VueProfile"
const routes = [
    {
        path: "/",
        component: vueHome,
        meta: {
            requiresAuth: true
        }
    },
    {
        path: "/add-task",
        component: TaskForm,
        meta: {
            requiresAuth: true
        }
    },
    {
        path: "/auth",
        component: Login,
        meta: {
            requiresAuth: false
        }
    },
    {
        path: "/profile",
        component: vueProfile,
        meta: {
            requiresAuth: true
        }
    },
    {
        path: "/:catchAll(.*)",
        redirect: "/"
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})


router.beforeEach(async (to, from, next) => {
    try {
        if (to.meta.requiresAuth && !localStorage.getItem('token'))
            next('/auth')
        else
            next()
    }
    catch (error) {
        // Handle error if necessary
        next(error);
    }
});
export default router