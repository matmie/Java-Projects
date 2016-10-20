import {Injectable} from '@angular/core';


export class UserRegistration{
	constructor(public usemail:string, public uspassword:string){}
}

@Injectable()
export class RegisterService{
	
}