import { Injectable } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';
import { Observable, Subject} from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AlertService {

    private subject = new Subject<any>();
    private keepAfterNavigatingChange = false;

    constructor(private router: Router) {
        // clear alert message on route change 
        router.events.subscribe(event => {
            
            if(event instanceof NavigationStart) {
            
                if(this.keepAfterNavigatingChange)
                // ?? only keep for a single lovation change
                this.keepAfterNavigatingChange = false;
            } else {
                this.subject.next();
            }
        });
    }

    success(message: string, keepAfterNavigatingChange = false){
        this.keepAfterNavigatingChange = keepAfterNavigatingChange;
        this.subject.next({
            type: 'success',
            test: message
        });
    }

    error(message: string, keepAfterNavigatingChange = false) {
        this.keepAfterNavigatingChange = keepAfterNavigatingChange;
        this.subject.next({
            type: 'error',
            test: message
        });
    }

    getMessage(): Observable<any> {
        return this.subject.asObservable();
    }
}