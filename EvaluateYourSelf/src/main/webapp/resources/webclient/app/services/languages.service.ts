import { Injectable} from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { LanguageControllsResp } from '../structures/languagescontrolls.respstructure';

import { AppSettings } from '../app.settings';

@Injectable()
export class LanguagesService{
    private headers: Headers;

	constructor(private http: Http){
		this.headers = new Headers();
		this.headers.append('Access-Control-Allow-Origin', '*');
		this.headers.append('Origin', 'http://localhost:8080');
	}
    trySendRequest(parentId:string, language:string):void{
    	this.http.get(`${AppSettings._api_endpoint}` + '/settings/language/' + parentId + '/' + language, {headers:this.headers}).subscribe();
    } 

	getControllsNamesByParentAndLanguage(parentId:string, language:string): Observable<LanguageControllsResp[]> {
		console.log(`${AppSettings._api_endpoint}` + '/settings/language/' + parentId + '/' + language);
		return this.http.get(`${AppSettings._api_endpoint}` + '/settings/language/' + parentId + '/' + language).
		map((r:Response) => r.json()).catch((error:any) => Observable.throw(error.json().error || 'Server eroor'));	
	}
}
