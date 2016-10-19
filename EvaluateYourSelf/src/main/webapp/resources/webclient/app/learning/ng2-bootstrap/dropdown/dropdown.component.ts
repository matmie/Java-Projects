import { Component } from '@angular/core';
import { DropdownModule } from 'ng2-bootstrap/ng2-bootstrap';

@Component({
	moduleId : module.id,
	selector : 'my-dropdown',
	templateUrl : './dropdown.component.html',
	styleUrls : ['./dropdown.component.css']

})
export class DropdownComponent {
	public disabled:boolean = false;
	public status:{isopen:boolean} = {isopen:false};
	public items:Array<string> = ['The first choice!', 'And another choice for you.', 'but wait! A third!'];

	public toggled(open:boolean):void {
		console.log('Dropdown is now: ', open);
	}

	public toggleDropDown($event:MouseEvent):void {
		$event.preventDefault();
		$event.stopPropagation();
		this.status.isopen = !this.status.isopen;
	}
}