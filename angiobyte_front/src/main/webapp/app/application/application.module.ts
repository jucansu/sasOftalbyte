import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AngiobyteSharedModule } from '../shared';

import { APPLICATION_ROUTE, ApplicationComponent } from './';

@NgModule({
    imports: [
        AngiobyteSharedModule,
        RouterModule.forRoot([APPLICATION_ROUTE], { useHash: false })
    ],
    declarations: [
        ApplicationComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AngiobyApplicationModule { }
