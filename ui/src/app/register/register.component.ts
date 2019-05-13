import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { DataService } from '../_services/data.service';
import { User } from '../_models/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {


  returnData: any;
  // firstName : string;

  User: User;

  detailForm: FormGroup;
  post:any;
  firstName: string = '';
  lastName: string = '';
  phone: string = '';
  email: string = '';
  position: string = ''; 
  companyName: string = '';
  tradingName: string = '';
  cidbGrade: string = '';

  user: Object

  submitted = false;
  success = false;

  constructor(private formBuilder: FormBuilder, private dataService:DataService) {

    this.detailForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      position: ['', Validators.required],
      companyName: ['', Validators.required],
      tradingName: ['', Validators.required],
      cidbGrade: ['', Validators.required],
    })

   }

   onSubmit(){
     this.submitted = true;

     if(this.detailForm.invalid){
       return;
     }

     this.dataService.addUser(this.detailForm.value.subscribe(data => this.User = data)).subscribe(data => this.returnData = data);
     this.firstName = this.returnData.firstName;

     this.success = true;
   }

  ngOnInit() {
  }

}
