

export class dashboardManager {
    static hideAllDashboardContent(){
        // Get all elements with class 'dashboardContent'
        const dashboardContents = document.querySelectorAll('.dashboardContent');

        // Hide each dashboard content element
        dashboardContents.forEach(element => {
            element.style.display = 'none';
        });

        document.getElementById('main').style.display = 'none';
    };

    static showDashboardContent(linkId){
        console.log('this works')
        // Hide all dashboard content first
        this.hideAllDashboardContent();

        const dashboardContent = document.getElementById(linkId);
        if(dashboardContent){
            dashboardContent.style.display = 'block';
        }
    };
}