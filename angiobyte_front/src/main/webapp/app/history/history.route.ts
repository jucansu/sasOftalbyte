import { Routes } from '@angular/router';
import { UserRouteAccessService } from '../shared';
import { historyDetailRoute } from './history-detail/history-detail.route';
import { historyListRoute } from './history-list/history-list.route';
import { imagesManagementRoute } from './images-management/images-management.route';
import { imagesComparisonRoute } from './images-comparison/images-comparison.route';

const CHILD_ROUTES = [
    historyDetailRoute,
    historyListRoute,
    imagesManagementRoute,
    imagesComparisonRoute,
];

export const historyListState: Routes = [{
    path: '',
    children: CHILD_ROUTES
}];
