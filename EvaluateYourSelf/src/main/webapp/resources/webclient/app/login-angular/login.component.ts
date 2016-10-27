import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Component({
	moduleId : module.id,
	selector : 'login',
	providers : [AuthenticationService],
	templateUrl : './login.component.html',
	styleUrls : ['./login.component.css']
})
export class LoginComponent{

	constructor(private _authService:AuthenticationService, private _router: Router){}

	onSubmit(email,password) { 
		console.log(email,password)
		this._authService.login(email,password).subscribe((result) => {
			if(result){
				this._router.navigate(['']);
			}
		});
	}

}