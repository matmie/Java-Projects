import {Component,ElementRef} from '@angular/core';
import {AuntenticationService, UserForLogin} from './authentication.service';


@Component({
	moduleId : module.id,
	selector : 'login',
	providers: [AuntenticationService],
	templateUrl : './login.component.html',
	styleUrls : ['./login.component.css']
})
export class LoginComponent {
	public user = new UserForLogin('','');
	public errorMsg = '';

	constructor(private _authservice: AuntenticationService){}

	login(){
		if(this._authservice.login(this.user)){
			this.errorMsg = 'Failed to login';
		}
	}
}