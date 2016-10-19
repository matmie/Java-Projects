import { Component, OnInit } from '@angular/core';

import { LanguagesService } from '../services/languages.service';
import { LanguageControllsResp } from '../structures/languagescontrolls.respstructure';

import { AppSettings } from '../app.settings';

import { Observable } from 'rxjs/Observable';

@Component({
    moduleId : module.id,
    selector : 'app-header',
    templateUrl : './header.component.html',
    styleUrls : [ './header.component.css' ]
})
export class HeaderComponent implements OnInit{
    langauagesControlls : Observable<LanguageControllsResp[]>;

    ngOnInit(): void {
    	this.languagesService.trySendRequest('header', `${AppSettings._language}`);
    	this.langauagesControlls = this.languagesService.getControllsNamesByParentAndLanguage('header', `${AppSettings._language}`);
    	console.log(this.langauagesControlls);
    }

    constructor(private languagesService: LanguagesService){

    }

	public header:{title:string, 
		              buttons: {signin:string, signup:string}
		          } = {title:'Evaluate YourSelf2', buttons : { signin : 'Zaloguj', signup : 'Rejestracja'}} ; 
}