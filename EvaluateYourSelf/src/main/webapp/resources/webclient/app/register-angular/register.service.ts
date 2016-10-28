import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {UsersRegisteredInfos} from '../structures/users.structures'

import {AppSettings} from '../app.settings';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class RegisterService{
	
	constructor(private _http:Http){

	}

	signup(email, password) : Promise<UsersRegisteredInfos> {
		let headers = new Headers();
		headers.append('Content-Type','application/json');
		return this._http.post(`${AppSettings._api_endpoint}` + '/authentication/signup', JSON.stringify({usemail:btoa(email), uspassword:btoa(password)}), {headers}).
		toPromise().then(resp => resp.json() as UsersRegisteredInfos); 
	}

}