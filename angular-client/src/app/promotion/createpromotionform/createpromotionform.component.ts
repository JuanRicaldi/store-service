import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import {PromotionService} from "../../services/promotion.service";
import {Promotions} from '../../shared/promotions';
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-createpromotionform',
  templateUrl: './createpromotionform.component.html',
  styleUrls: ['./createpromotionform.component.scss']
})

export class CreatepromotionformComponent implements OnInit {

  promotions = new Promotions();

  constructor(private route: Router , private serve: PromotionService , public dialogRef: MatDialogRef<CreatepromotionformComponent>) { }

  ngOnInit() {

  }


  onSubmited() {

    this.serve.addPromotion(this.promotions).subscribe(res => {
      console.log(res);

      this.dialogRef.close();
      location.reload();

    });

    // console.log('verificando....');
    // this.dialogRef.close();

  }


}
