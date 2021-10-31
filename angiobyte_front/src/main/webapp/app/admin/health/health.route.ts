import { Route } from '@angular/router';

import { AgbHealthCheckComponent } from './health.component';

export const healthRoute: Route = {
    path: 'agb-health',
    component: AgbHealthCheckComponent,
    data: {
        pageTitle: 'health.title'
    }
};
