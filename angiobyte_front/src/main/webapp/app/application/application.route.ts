import { Route } from '@angular/router';

import { UserRouteAccessService } from '../shared';
import { ApplicationComponent } from '../application';

export const APPLICATION_ROUTE: Route = {
    path: 'application',
    component: ApplicationComponent,
    data: {
        authorities: [],
        pageTitle: 'application.title'
    }
};
