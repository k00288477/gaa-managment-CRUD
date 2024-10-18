import { createRouter, createWebHistory} from 'vue-router';
import HomePage from '@/components/HomePage.vue';
import MembersPortal from '@/components/MembersPortal.vue';
import AdminPortal from '@/components/AdminPortal.vue';
import About from "@/components/About.vue";
import Contact from "@/components/Contact.vue";
import AllEvents from "@/components/member-components/AllEvents.vue";
import PlayerSignUp from "@/components/member-components/PlayerSignUp.vue";
import MemberSignUp from "@/components/member-components/MemberSignUp.vue";
import AddEvent from "@/components/staff-components/AddEvent.vue";
import StaffForm from "@/components/staff-components/StaffForm.vue";
import UpdateStaff from "@/components/staff-components/updateStaff.vue";
import AddTeam from "@/components/staff-components/AddTeam.vue";
import AddContact from "@/components/staff-components/AddContact.vue";
import StaffLogIn from "@/components/staff-components/StaffLogIn.vue";
import AllEventsHome from "@/components/AllEventsHome.vue";
import UpdateEvent from "@/components/staff-components/UpdateEvent.vue";
import UpdateMember from "@/components/staff-components/UpdateMember.vue";

const routes = [
    {path: '/', component:  HomePage},
    {path: '/members-portal', component: MembersPortal},
    {path: '/admin-portal', component: AdminPortal},
    {path: '/add-staff', component: StaffForm},
    {path: '/add-team', component: AddTeam},
    {path: '/update-staff/:id' ,name: 'UpdateStaff', component: UpdateStaff, props: true},
    {path: '/about', component: About},
    {path: '/contact', component: Contact},
    {path: '/all-events', component: AllEvents},
    {path: '/player-signup', component: PlayerSignUp},
    {path: '/member-signup', component: MemberSignUp},
    {path: '/add-event', component: AddEvent},
    {path: '/add-contact', component: AddContact},
    {path: '/staff-login', component: StaffLogIn},
    {path: '/all-events-home', component: AllEventsHome},
    {path: '/update-event/:id', name: 'UpdateEvent', component: UpdateEvent, props: true},
    {path: '/update-member/:id', name: 'UpdateMember', component: UpdateMember, props: true}
]

const router = createRouter ({
    history: createWebHistory(),
    routes
});

export default router;
