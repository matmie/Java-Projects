import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppSettings} from './app.settings';
import { AppModule } from './app.module';
import { Cookie } from 'ng2-cookies/ng2-cookies';

import { TranslateService } from 'ng2-translate/ng2-translate';

if(!Cookie.get('lang')){
	AppSettings._language = navigator.language;
	Cookie.set('lang', AppSettings._language);
}
else
{
	AppSettings._language = Cookie.get('lang');
}

const platform = platformBrowserDynamic();
platform.bootstrapModule(AppModule);

