import {Component} from '@angular/core';
import {AuntenticationService, UserForLogin} from '../login/authentication.service';

@Component({
	moduleId : module.id,
	selector : 'login',
	providers : [AuntenticationService],
	templateUrl : './login.component.html',
	styleUrls : ['./login.component.css']
})
export class LoginComponent{

	user = new UserForLogin('','');

	submitted:boolean = false;

	constructor(private _authService:AuntenticationService){}

	onSubmit() { 
		this.submitted = true; 
	}

	getDiagnostic() {
		return JSON.stringify(this.user);
	}
}