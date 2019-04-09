import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validator, Validators } from '@angular/forms'

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  contactForm: FormGroup;
  email: string;
  message: string;
  submitted: boolean = false;
  success: boolean = false;

  constructor(private formBuilder:FormBuilder) {
    this.contactForm = this.formBuilder.group({
    email: ['', Validators.required],
    message: ['', Validators.required]
    })
   }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;

    if (this.contactForm.invalid) {
        return;
    }

    this.success = true;
}

}
