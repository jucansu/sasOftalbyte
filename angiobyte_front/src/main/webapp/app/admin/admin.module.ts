import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AngiobyteSharedModule } from '../shared';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

import {
    adminState,
    AuditsComponent,
    UserMgmtComponent,
    UserDialogComponent,
    UserDeleteDialogComponent,
    UserMgmtDetailComponent,
    UserMgmtDialogComponent,
    UserMgmtDeleteDialogComponent,
    LogsComponent,
    AgbMetricsMonitoringModalComponent,
    AgbMetricsMonitoringComponent,
    AgbHealthModalComponent,
    AgbHealthCheckComponent,
    AgbConfigurationComponent,
    AgbDocsComponent,
    AuditsService,
    AgbConfigurationService,
    AgbHealthService,
    AgbMetricsService,
    LogsService,
    UserResolvePagingParams,
    UserResolve,
    UserModalService
} from './';

@NgModule({
    imports: [
        AngiobyteSharedModule,
        RouterModule.forRoot(adminState),
        /* , { useHash: true }jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        AuditsComponent,
        UserMgmtComponent,
        UserDialogComponent,
        UserDeleteDialogComponent,
        UserMgmtDetailComponent,
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent,
        LogsComponent,
        AgbConfigurationComponent,
        AgbHealthCheckComponent,
        AgbHealthModalComponent,
        AgbDocsComponent,
        AgbMetricsMonitoringComponent,
        AgbMetricsMonitoringModalComponent
    ],
    entryComponents: [
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent,
        AgbHealthModalComponent,
        AgbMetricsMonitoringModalComponent,
    ],
    providers: [
        AuditsService,
        AgbConfigurationService,
        AgbHealthService,
        AgbMetricsService,
        LogsService,
        UserResolvePagingParams,
        UserResolve,
        UserModalService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AngiobyteAdminModule {}
