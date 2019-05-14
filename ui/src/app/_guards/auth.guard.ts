// A CLASS OF THE UNSULLIED - The guards that is used to prevent stuff
import { Injectable} from '@angular/core'
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router'

import { AuthenticationService} from '../_services/authentication.service';

@Injectable({ providedIn: 'root'})
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private authenticationServices: AuthenticationService){}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        const currentUser = this.authenticationServices.currenUserValue;
        if(currentUser){
            return true; // Authorized
        }
        
        //not logged in so direct to login oage with return url
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
        return false;
    }
}