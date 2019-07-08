import { Component, OnInit } from '@angular/core';
import {Client} from '../shared/client';
import {MatDialog, MatDialogRef} from '@angular/material';
import {CreateformComponent} from './createform/createform.component';
import {ClientService} from '../services/client.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})



export class ClientComponent implements OnInit {
   clients: Client[];
   showbody: boolean;
   displayedColumns: string[] = ['firstNameClient', 'lastNameClient', 'emailClient', 'numberTelephoneC', 'nitClient', 'ciClient', 'accion'];


  constructor(private router: Router, public dialog: MatDialog, private serve: ClientService) { }

  ngOnInit() {
    this.serve.listofclient().subscribe(clients => {
        this.clients = clients;
        console.log(this.clients);

     });
    // this.serve.listofclient()


  }
    openCreateClient() {

    console.log('probando..');

    this.dialog.open(CreateformComponent, {width: '500px', height: '450px'});

  }

  showBody() {

    console.log('view container');
    this.showbody = !this.showbody;
  }


  DeleteClient(client: Client) {
    console.log(client);
    console.log('verificando delete');
    this.serve.DeleteClient(client).subscribe(
        data => {
        this.clients = this.clients.filter(c => c !== client);
        alert('user delete... ');

        });
  }


}
