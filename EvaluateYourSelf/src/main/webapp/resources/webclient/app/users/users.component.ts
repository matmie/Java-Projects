import { Component, OnInit } from '@angular/core';
import { UsersService } from './users.service';
import { Users } from './users';

@Component({
	moduleId : module.id,
	providers : [UsersService],
	selector : 'users',
	templateUrl : './users.component.html',
	styleUrls : ['./users.component.css']
})
export class UsersComponent implements OnInit{
    users: Array<Users>;

    constructor(private usersService:UsersService){

	}
    
	ngOnInit(): void {
		this.usersService.getAllUsers().then(this.handleUsers).then(users => this.users = users);
	}

	private handleUsers(usr:Map<number, Users>):Array<Users>{
		let tmpUsers = new Array<Users>();
		for(var key in usr){
			tmpUsers.push(usr[key]);
		}
		return tmpUsers;
	}
}
