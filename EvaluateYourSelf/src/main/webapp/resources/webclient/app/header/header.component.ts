import { Component } from '@angular/core';
import { Router } from '@angular/router'; 

import { AppSettings } from '../app.settings';

import { TranslateService } from 'ng2-translate/ng2-translate';

@Component({
    moduleId : module.id,
    selector : 'app-header',
    templateUrl : './header.component.html',
    styleUrls : [ './header.component.css' ]
})
export class HeaderComponent{

    constructor(private translate: TranslateService, private _router:Router){
    	translate.addLangs(['pl', 'en']);
    	translate.use(AppSettings._language);
    }

    gotoLoginForm():void{
    	let link = ['/login'];
    	this._router.navigate(link);
    }

    gotoRegisterForm():void{
        let link = ['/register'];
        this._router.navigate(link);
    }
}