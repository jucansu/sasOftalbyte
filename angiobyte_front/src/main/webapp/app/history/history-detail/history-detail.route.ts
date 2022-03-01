import { Route } from '@angular/router';
import { HistoryDetailComponent } from './history-detail.component';


export const historyDetailRoute: Route = {
    path: 'nuhsa/detail',
    component: HistoryDetailComponent, 
    data: {
        authorities: [],
        pageTitle: 'history.detail.title'
    }
};
