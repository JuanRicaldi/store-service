import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material';
import {PromotionService} from '../services/promotion.service';
import {Promotions} from "../shared/promotions";
import {CreateformComponent} from "../client/createform/createform.component";


@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.scss']
})


export class PromotionComponent implements OnInit {
  promotions : Promotions[];
  showbody: boolean;
  displayedColumns: string[] = ['namePromotion','discountPromotion','startproDatePro','expiredproDatePro'];

  constructor(public dialog: MatDialog, private serve: PromotionService) { }

  ngOnInit() {
    this.serve.listOfPromotions().subscribe(promotions => {
      this.promotions = promotions;
      console.log(this.promotions);

    });
    // this.serve.listOfPromotions()

  }
  openCreatePromotion() {

    console.log('probando..');

    //this.dialog.open(CreateformComponent, {width: '500px', height: '450px'});

  }

  showPromotionsBody() {
    console.log('view container');
    this.showbody = !this.showbody;
  }

}

