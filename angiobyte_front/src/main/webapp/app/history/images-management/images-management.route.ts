import { Route } from '@angular/router';
import { ImagesManagementComponent } from './images-management.component';

export const imagesManagementRoute: Route = {
    path: 'nuhsa/:id/images/:type',
    component: ImagesManagementComponent,
    data: {
        authorities: [],
        pageTitle: 'history.detail.title'
    }
};