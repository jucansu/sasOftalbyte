import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { DatePipe } from '@angular/common';

import {
    AngiobyteSharedLibsModule,
    AngiobyteSharedCommonModule,
    CSRFService,
    AuthServerProvider,
    AccountService,
    UserService,
    HistoryService,
    StateStorageService,
    LoginService,
    LoginModalService,
    Principal,
    HasAnyAuthorityDirective,
    AgbLoginModalComponent
} from './';

@NgModule({
    imports: [
        AngiobyteSharedLibsModule,
        AngiobyteSharedCommonModule
    ],
    declarations: [
        AgbLoginModalComponent,
        HasAnyAuthorityDirective
    ],
    providers: [
        LoginService,
        LoginModalService,
        AccountService,
        StateStorageService,
        Principal,
        CSRFService,
        AuthServerProvider,
        UserService,
        HistoryService,
        DatePipe
    ],
    entryComponents: [AgbLoginModalComponent],
    exports: [
        AngiobyteSharedCommonModule,
        AgbLoginModalComponent,
        HasAnyAuthorityDirective,
        DatePipe
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]

})
export class AngiobyteSharedModule { }
