import { NgModule, LOCALE_ID } from '@angular/core';
import { Title } from '@angular/platform-browser';

import {
    AngiobyteSharedLibsModule,
    JhiLanguageHelper,
    FindLanguageFromKeyPipe,
    AgbAlertComponent,
    AgbAlertErrorComponent
} from './';

@NgModule({
    imports: [
        AngiobyteSharedLibsModule
    ],
    declarations: [
        FindLanguageFromKeyPipe,
        AgbAlertComponent,
        AgbAlertErrorComponent
    ],
    providers: [
        JhiLanguageHelper,
        Title,
        {
            provide: LOCALE_ID,
            useValue: 'es'
        },
    ],
    exports: [
        AngiobyteSharedLibsModule,
        FindLanguageFromKeyPipe,
        AgbAlertComponent,
        AgbAlertErrorComponent
    ]
})
export class AngiobyteSharedCommonModule {}
