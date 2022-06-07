import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import ListUsers from '../views/ListUsers.vue'
import NewProject from '../views/NewProject.vue'
import ProjectListView from '../views/ProjectListView.vue'
import NewContact from '../views/NewContact.vue'
import UserInfo from '../views/UserInfo.vue'
import ProjectInfoView from '../views/ProjectInfoView.vue'
import ContactListView from '../views/ContactListView.vue'
import ContactInfoView from '../views/ContactInfoView.vue'
import GroupListView from '../views/GroupListView.vue'
import GroupInfoView from '../views/GroupInfoView.vue'
import UpdateProject from "@/components/UpdateProject";
import UpdateContact from '@/components/UpdateContact';
import AssignContact from '../views/AssignContactToGroupView.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/userlist",
      name: "userlist",
      component: ListUsers,
      meta:{
        requiresAuth:false
      }
    },
    {
      path: "/newproject",
      name: "newproject",
      component: NewProject,
      meta: {
        requiresAuth: false
      }
    },
    {
      path:"/allprojects",
      name: "allProjects",
      component: ProjectListView,
      meta:{
        requiresAuth: false
      }
    },{
    path: "/newcontact",
    name: "newcontact",
    component: NewContact,
    },
    {
      path:"/userlist/:id",
      name:"userinfo",
      component: UserInfo,
      meta:{
        requiresAuth: false
      }
    },
    {
      path:"/project/:id",
      name:"projectinfoview",
      component:ProjectInfoView,
      meta:{
        requiresAuth:true
      }
    },
    {
      path:"/contacts",
      name:"allContacts",
      component:ContactListView,
      meta:{
        requiresAuth:true
      }
    },
    {
      path:"/contacts/:id",
      name:"ContactInfoView",
      component:ContactInfoView,
      meta:{
        requiresAuth:true
      }
    },
    {
      path:"/groups",
      name:"group-list",
      component:GroupListView,
      meta:{
        requiresAuth:true
      }
    },
    {
      path:"/groups/:id",
      name: "groupinfoview",
      component: GroupInfoView,
      meta:{
        requiresAuth:true
      }
    },
    {
      path: "/projects/update/:id",
      name: "UpdateProject",
      component: UpdateProject
    },
    {
      path: "/contacts/update/:id",
      name: "UpdateContact",
      component: UpdateContact
    },
    {path: "/contacts/:id/assign/group",
    name: "AssignContact",
    component: AssignContact
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;

