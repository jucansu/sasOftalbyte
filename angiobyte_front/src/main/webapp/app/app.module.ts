import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ng2-webstorage';

import { AngiobyteSharedModule, UserRouteAccessService } from './shared';
import { AngiobyteHomeModule } from './home/home.module';
import { AngiobyteHistoryModule } from './history/history.module';
import { AngiobyteAdminModule } from './admin/admin.module';
import { AngiobyteAccountModule } from './account/account.module';
import { AngiobyteEntityModule } from './entities/entity.module';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';


import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    AgbMainComponent,
    LayoutRoutingModule,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ActiveMenuDirective,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        LayoutRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
        AngiobyteSharedModule,
        AngiobyteHomeModule,
        AngiobyteHistoryModule,
        AngiobyteAdminModule,
        AngiobyteAccountModule,
        AngiobyteEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        AgbMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        {provide: LocationStrategy, useClass: HashLocationStrategy},
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [AgbMainComponent]
})
export class AngiobyteAppModule { }
