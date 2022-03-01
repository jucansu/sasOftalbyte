import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { OrderModule } from 'ngx-order-pipe';

import { AngiobyteSharedModule } from '../shared';

import {
    historyListRoute,
    HistoryListComponent,
    ImagesManagementComponent,
    ImagesComparisonComponent,
    HistoryDetailComponent,
    historyDetailRoute,
    historyListState
} from './';

@NgModule({
    imports: [
        AngiobyteSharedModule,
        RouterModule.forRoot(historyListState),
        OrderModule
        /*, { useHash: true } */
    ],
    declarations: [
        HistoryListComponent,
        HistoryDetailComponent,
        ImagesComparisonComponent,
        ImagesManagementComponent
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AngiobyteHistoryModule { }
