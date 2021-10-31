import { Route } from '@angular/router';

import { AgbMetricsMonitoringComponent } from './metrics.component';

export const metricsRoute: Route = {
    path: 'agb-metrics',
    component: AgbMetricsMonitoringComponent,
    data: {
        pageTitle: 'metrics.title'
    }
};
