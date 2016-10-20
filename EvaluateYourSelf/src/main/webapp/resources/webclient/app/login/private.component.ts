import {Component, OnInit} from '@angular/core';
import {AuntenticationService} from './authentication.service';

@Component({
	moduleId: module.id,
	selector: 'login',
	providers: [AuntenticationService],
	template: `<div class="container" >
                <div class="content">
                    <span>Congratulations, you have successfully logged in!!</span>
                    <br />
                    <a (click)="logout()" href="#">Click Here to logout</a>
                </div>
            </div>`
})

export class PrivateComponent implements OnInit{
	constructor(private _authService:AuntenticationService){}
	ngOnInit():void {
		this._authService.checkCredentials();
	}
	logout():void{
		this._authService.logout();
	}
}