import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable} from 'rxjs';

import { User } from '../_models/User';

@Injectable({ providedIn: 'root'})
export class AuthenticationService {

    private currentUserSubject: BehaviorSubject<User>;
    private currentUser: Observable<User>;

    constructor(private http: HttpClient){
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    };

    public get currenUserValue(): User {
        return this.currentUserSubject.value;
    }
}