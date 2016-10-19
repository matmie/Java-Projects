import { Component } from '@angular/core'; 
import { OnInit } from '@angular/core';
import { Cookie } from 'ng2-cookies/ng2-cookies';

import { AppSettings } from './app.settings';

@Component({
    moduleId    : module.id,
    selector    : 'app-root',
    templateUrl : './app.component.html', 
    styleUrls   : [ './app.component.css' ]
})
export class AppComponent implements OnInit{ 
	ngOnInit(): void {
        this.setTheLanguage();
	}

	setTheLanguage():void {
	   
	   if(!Cookie.get('lang')){
	   		AppSettings._language = navigator.language;
	   		Cookie.set('lang', AppSettings._language);
	   }
	   else
	   {
	   		AppSettings._language = Cookie.get('lang');
	   }

	}
}