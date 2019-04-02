import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  h1Style: boolean = true;
  title: string = "TPRICE"
  summary: string = "We’re an online professional tender pricing service. Simply taking a picture."
  caption : string = "AS SIMPLE AS TAKING A PICTURE"
  alreadyAMember: string = "Already a member?"
  registerDetail: string = "Click register and fill out the corresponding online form. Once you have completed the simple online form you will receive a membership number with a dedicated whatsapp number (solely for BOQ submission) and email address."
  takePicDetail: string = "When you are ready to price your document you simply take a clear picture or scan each page of your BOQ. You choose: either email or whatsapp your BOQ pictures to our dedicated team of quantity surveyors. Please email accompanying documents required to price i.e. maps, drawings etc."
  checkEmailDetail:string = "Within 5 working days your BOQ will be priced and emailed back to you. All rates are priced at 10% profit at market related prices."
  
  constructor() { }

  ngOnInit() {
  }
    
  }
