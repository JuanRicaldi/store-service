import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Promotions} from '../shared/promotions';
import {baseURL} from '../shared/baseurl';

@Injectable({
  providedIn: 'root'
})
export class PromotionService {

  constructor(private http: HttpClient) {}

  listOfPromotions(): Observable<Promotions[]> {

    return this.http.get(baseURL + 'promotion') as Observable<Promotions[]>;
  }

  addPromotion(promotion : Promotions) {
    return this.http.post<Promotions>(baseURL + 'promotion', promotion);
  }

}