import {Component, OnChanges, Input, SimpleChange} from '@angular/core';

@Component({
	moduleId:module.id,
	selector:'password-strength-bar',
	templateUrl:'./password-strength-bar.component.html',
	styleUrls:['./password-strength-bar.component.css']
})
export class PassWordTrengthBarComponent implements OnChanges{
	@Input() passwordToCheck: string;
	@Input() minLength:number;
    bar0: string;
    bar1: string;
    bar2: string;
    bar3: string;
    bar4: string;

    private colors = ['#F00', '#F90', '#FF0', '#9F0', '#0F0'];

    private static measureStrength(password, minLength) {
        var _force = 0;
        var _regex = /[!@#\$%\^\*\(\)\+=\{\}\[\]]/g; // "

        var _lowerLetters = /[a-z]+/.test(password);
        var _upperLetters = /[A-Z]+/.test(password);
        var _numbers = /[0-9]+/.test(password);
        var _symbols = _regex.test(password);

        var _flags = [_lowerLetters, _upperLetters, _numbers, _symbols];

        var _passedMatches = 0;
        for (let _flag of _flags) {
            _passedMatches += _flag === true ? 1 : 0;
        }

        _force += 2 * password.length + ((password.length >= minLength) ? 1 : 0);
        _force += _passedMatches * 10;

        // penality (poor variety of characters)
        _force = (_passedMatches === 1) ? Math.min(_force, 10) : _force;
        _force = (_passedMatches === 2) ? Math.min(_force, 20) : _force;
        _force = (_passedMatches === 3) ? Math.min(_force, 40) : _force;

        return _force;

    }
    private getColor(force) {
        var idx = 0;
        if (force <= 10) {
            idx = 0;
        }
        else if (force <= 20) {
            idx = 1;
        }
        else if (force <= 30) {
            idx = 2;
        }
        else if (force <= 40) {
            idx = 3;
        }
        else {
            idx = 4;
        }
        return {
            idx: idx + 1,
            color: this.colors[idx]
        };
    }

    ngOnChanges(changes: {[propName: string]: SimpleChange}): void {
        var password = changes['passwordToCheck'].currentValue;
        this.setBarColors(5, '#DDD');
        if ((password)) {
            let c = this.getColor(PassWordTrengthBarComponent.measureStrength(password, this.minLength));
            this.setBarColors(c.idx, c.color);
        }
    }
    private setBarColors(count, col) {
        for (let _n = 0; _n < count; _n++) {
            this['bar' + _n] = col;
        }
    }
}