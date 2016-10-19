import { MissingTranslationHandler } from 'ng2-translate/ng2-translate';

/* When the translations cannot be found in source, then handle method run*/
export class MyMissingTranslationHandler implements MissingTranslationHandler{
	handle(key: string){
		return 'cannot find translation for ' + key;
	}
}
