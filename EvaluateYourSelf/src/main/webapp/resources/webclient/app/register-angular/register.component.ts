import {Component, OnInit} from '@angular/core';
import {RegisterService, UserRegistration} from './register.service';

@Component({
	moduleId : module.id,
	selector : 'register',
	templateUrl : './register.component.html',
	styleUrls : ['./register.component.css']
})
export class RegisterComponent implements OnInit{
	  
     user = new UserRegistration('','');

     ngOnInit():void {

     }
}