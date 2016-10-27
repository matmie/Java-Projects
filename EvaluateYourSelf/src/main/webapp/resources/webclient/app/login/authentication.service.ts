import { Injectable } from '@angular/core';
import {Router} from '@angular/router';


export class UserForLogin {
	constructor(public email:string, public password:string){}
}

var users = [ 
	new UserForLogin('admin@admin.com', 'adm9'),
	new UserForLogin('user1@gmail.com', 'a23')
];

@Injectable()
export class AuntenticationService {
	constructor(private _router:Router){}

	logout(){
		localStorage.removeItem("user");
		this._router.navigate(['Login']);
	}

	login(user:UserForLogin){
		var authenticatedUser = users.find(u => u.email === user.email);
		if(authenticatedUser && authenticatedUser.password === user.password){
			//localStorage.setItem("user", authenticatedUser);
			this._router.navigate(['Home']);
			return true;
		}
		return false;
	}
	checkCredentials(){
		if(localStorage.getItem("user") === null){
			this._router.navigate(['Login']);
		}
	}
}