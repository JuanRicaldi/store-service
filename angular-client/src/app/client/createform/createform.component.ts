import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import {ClientService} from "../../services/client.service";
import {Client} from '../../shared/client';
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-createform',
  templateUrl: './createform.component.html',
  styleUrls: ['./createform.component.scss']
})

export class CreateformComponent implements OnInit {

  client = new Client();

  constructor(private route: Router , private serve: ClientService , public dialogRef: MatDialogRef<CreateformComponent>) { }

  ngOnInit() {

  }


  onSubmited() {

    this.serve.CreateList(this.client).subscribe(res => {
      console.log(res);

      this.dialogRef.close();
      location.reload();

    });

    // console.log('verificando....');
    // this.dialogRef.close();

  }


}
