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

export class CreateformComponent implements OnInit{

   client: Client;


  constructor(private route: ActivatedRoute,
              private router: Router,
              public dialogRef: MatDialogRef<CreateformComponent>,
              private clientService : ClientService) {
  }

  ngOnInit() {

    console.log(this.client);
  }


  onSubmit() {

    this.clientService.addClient(this.client).subscribe(result => this.goToClientList());
    //this.client = new Client();
    this.dialogRef.close();
  }

  goToClientList(){
    this.router.navigate(['/clients']);
  }
}
