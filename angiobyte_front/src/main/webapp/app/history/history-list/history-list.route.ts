import { Route } from '@angular/router';
import { HistoryListComponent } from './history-list.component';

export const historyListRoute: Route = {
    path: 'nuhsa',
    component: HistoryListComponent,
    data: {
        pageTitle: 'history.title'
    }
};
