import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {


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

  submitted = false;
  success = false;

  constructor(private formBuilder: FormBuilder) {

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

     this.success = true;
   }

  ngOnInit() {
  }

}
