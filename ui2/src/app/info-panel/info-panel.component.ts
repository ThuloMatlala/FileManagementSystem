import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'infoPanel',
  templateUrl: './info-panel.component.html',
  styleUrls: ['./info-panel.component.css']
})
export class InfoPanelComponent implements OnInit {

  constructor() { }

  cardTitle: string

  ngOnInit() {
    this.cardTitle = "Delicious! Everytime!"
  }

}
