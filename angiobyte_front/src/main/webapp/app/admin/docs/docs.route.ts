import { Route } from '@angular/router';

import { AgbDocsComponent } from './docs.component';

export const docsRoute: Route = {
    path: 'docs',
    component: AgbDocsComponent,
    data: {
        pageTitle: 'global.menu.admin.apidocs'
    }
};
