import {Component, OnInit} from '@angular/core';
import {RegisterService} from './register.service';

import {Users} from '../structures/users.structures';

@Component({
	moduleId : module.id,
	selector : 'register',
	templateUrl : './register.component.html',
	styleUrls : ['./register.component.css'],
	providers: [RegisterService]
})
export class RegisterComponent implements OnInit{
     private user:Users;
     private emailError:boolean = false;

     ngOnInit():void {
     	
     }


     constructor(private _regService:RegisterService){
     	this.user = {
     		usemail : '',
     		uspassword : '',
     		uspasswordConfirm :''
     	}
     }
     private onSubmit(email,password){
     	this._regService.signup(email,password).catch(errors => {
     		if(errors._body === 'UserWithEmailExist'){
     			this.emailError = true;
     		}
     	});
     }

     private cancelEmailError(){
     	this.emailError = false;
     }
}