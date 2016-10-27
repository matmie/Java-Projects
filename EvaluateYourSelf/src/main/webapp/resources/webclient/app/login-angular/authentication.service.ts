import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';

import {AppSettings} from '../app.settings';

@Injectable()
export class AuthenticationService {
	private _token:string;

	constructor(private _http:Http){
		var currentUser = JSON.parse(localStorage.getItem('currentUser'));
		this._token = currentUser && currentUser.token;
	}

	login(email,password){
		let headers = new Headers();
		headers.append('Content-Type', 'application/json');

		return this._http.post(`${AppSettings._api_endpoint}` + '/authentication/login', JSON.stringify({usemail:email,uspassword:password}), {headers}).
		map((res:Response) => {
			let token = res.json() && res.json().token;
			if(token){
				this._token = token;
				localStorage.setItem("currentUser", JSON.stringify({email:email, token:token}));
				return true;
			}
			else{
				return false;
			}
		}); 
	}

	logout() {
		localStorage.removeItem('currentUser');
	}

	getToken():string{
		return this._token;
	}
}