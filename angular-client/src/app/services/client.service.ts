import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client} from '../shared/client';
import {baseURL} from '../shared/baseurl';
import {NgForm} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) {}

  listofclient(): Observable<Client[]> {

    return this.http.get(baseURL + 'clients') as Observable<Client[]>;
  }

  CreateList(form: Client): Observable<Client> {

    return this.http.post(baseURL + 'clients', form) as Observable<Client>;

  }

  // tslint:disable-next-line:ban-types
  // tslint:disable-next-line:ban-types
  DeleteClient(client: Client) {
    return this.http.delete(baseURL + 'clients/' + client.id);

  }

}
