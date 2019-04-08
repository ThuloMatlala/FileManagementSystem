import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { getLocaleDateFormat } from '@angular/common';

@Component({
  selector: 'app-file-management',
  templateUrl: './file-management.component.html',
  styleUrls: ['./file-management.component.scss']
})
export class FileManagementComponent implements OnInit {

  files: Object;
  headElements = ['ID', 'File Name', 'Company Name', 'Company Grading','Date Created', 'Last Modified', 'Status'];
  lastModified: Date = new Date();
  status:string = "OPEN";


  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getFiles().subscribe(data => {
      this.files = data;
      console.log(this.files);
    })
  }

}
