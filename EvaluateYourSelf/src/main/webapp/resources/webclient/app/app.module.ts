import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpModule, Http } from '@angular/http';


/*TRANSLATION STUFF*/
import { TranslateModule, TranslateLoader, TranslateStaticLoader, TranslateService} from 'ng2-translate/ng2-translate';
import { MyMissingTranslationHandler } from './utils/translate/mymissingtranslation.handler';

//COMPOENTS IMPORTS
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LearningComponent } from './learning/learning.component';
import { DropdownComponent } from './learning/ng2-bootstrap/dropdown/dropdown.component';
import { ButtonComponent } from './learning/ng2-bootstrap/button/button.component';
import { UsersComponent } from './users/users.component';
import { LoginComponent } from './login-angular/login.component';
import { PassWordTrengthBarComponent } from './utils/password-strength-bar/password-strength-bar.component';
import { RegisterComponent } from './register-angular/register.component';

import { routing } from './app.routing'

//PROVIDERS IMPORTS


@NgModule({
    imports :      [
                        BrowserModule,
                        FormsModule,
                        HttpModule,
                        routing,
                        TranslateModule.forRoot({
                          provide: TranslateLoader,
                          useFactory: (http: Http) => new TranslateStaticLoader(http, '/app/utils/translate/translations/i18n', '.json'),
                          deps : [Http]
                        })
                   ],
    declarations : [
                        AppComponent,
                        ButtonComponent,
                        DropdownComponent,
                        FooterComponent,
                        HeaderComponent,
                        LearningComponent,
                        LoginComponent,
                        PassWordTrengthBarComponent,
                        RegisterComponent,
                        UsersComponent
                   ],
    bootstrap :    [
                        AppComponent
                   ],
    providers :    [ 
                        TranslateService
                   ]
})
export class AppModule {}