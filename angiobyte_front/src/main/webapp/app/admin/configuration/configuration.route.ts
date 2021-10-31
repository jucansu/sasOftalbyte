import { Route } from '@angular/router';

import { AgbConfigurationComponent } from './configuration.component';

export const configurationRoute: Route = {
    path: 'agb-configuration',
    component: AgbConfigurationComponent,
    data: {
        pageTitle: 'configuration.title'
    }
};
