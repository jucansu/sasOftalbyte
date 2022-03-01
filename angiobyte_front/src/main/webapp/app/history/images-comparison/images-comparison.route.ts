import { Route } from '@angular/router';
import { ImagesComparisonComponent } from './images-comparison.component';

export const imagesComparisonRoute: Route = {
    path: 'nuhsa/detail/comparison/:type',
    component: ImagesComparisonComponent,
    data: {
        authorities: [],
        pageTitle: 'history.detail.title'
    }
};
