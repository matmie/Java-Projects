import { Injectable } from '@angular/core';
import { Users } from './users';
import { Http, Response } from '@angular/http';

import { AppSettings } from '../app.settings';

import 'rxjs/add/operator/toPromise';

import { TranslateService } from 'ng2-translate/ng2-translate';


@Injectable()
export class UsersService{
	
    constructor(private http: Http, private translate: TranslateService){
    	translate.use(AppSettings._language);
    }
	getTheSimpleValue():string{
		return 'value';
	}

	getAllUsers():Promise<Map<number,Users>>{
		return this.http.get(`${AppSettings._api_endpoint}` + 'users/getall').toPromise().
		then((response => response.json() as Map<number,Users>)).catch(this.errorHandle);
	}

	errorHandle(error:any): Promise<any> {
		console.error('An error ocucred ', error);
		return Promise.reject(error);
	}
}