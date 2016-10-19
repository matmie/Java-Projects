import { Component } from '@angular/core';

import { AppSettings } from '../app.settings';

import { TranslateService } from 'ng2-translate/ng2-translate';

@Component({
    moduleId : module.id,
    selector : 'app-header',
    templateUrl : './header.component.html',
    styleUrls : [ './header.component.css' ]
})
export class HeaderComponent{

    constructor(private translate: TranslateService){
    	translate.addLangs(['pl', 'en']);
    	translate.use(AppSettings._language);
    }
}