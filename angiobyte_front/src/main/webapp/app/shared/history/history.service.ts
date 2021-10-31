import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { SERVER_API_URL } from '../../app.constants';
import { History } from './history.model';
import { ResponseWrapper } from '../model/response-wrapper.model';
import { createRequestOption } from '../model/request-util';

@Injectable()
export class HistoryService {
    private resourceUrl = SERVER_API_URL + 'api/angios';

    constructor(private http: Http) { }

    find(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(`${this.resourceUrl}`, options)
            .map((res: Response) => this.convertResponse(res));
    }

    get(req?: any): Observable<ResponseWrapper> {
        return this.http.get(`${this.resourceUrl}/` + req)
            .map((res: Response) => this.convertResponse(res));
    }

    getRetina(req?: any): Observable<ResponseWrapper> {
        return this.http.get('api/retinas/' + req)
            .map((res: Response) => this.convertResponse(res));
    }

    getImageName(id?: any, type?: any, date?: any): Observable<ResponseWrapper> {
        return this.http.get('api/images/name?id=' + id + '&type=' + type + '&date=' + date)
            .map((res: Response) => this.convertResponse(res));
    }

    getImage(id?: any, name?: any): Observable<ResponseWrapper> {
        return this.http.get('api/images/' + id + '?name=' + name)
            .map((res: Response) => this.convertResponse(res));
    }

    // create(user: User): Observable<ResponseWrapper> {
    //     return this.http.post(this.resourceUrl, user)
    //         .map((res: Response) => this.convertResponse(res));
    // }

    // update(user: User): Observable<ResponseWrapper> {
    //     return this.http.put(this.resourceUrl, user)
    //         .map((res: Response) => this.convertResponse(res));
    // }

    // find(login: string): Observable<User> {
    //     return this.http.get(`${this.resourceUrl}/${login}`).map((res: Response) => res.json());
    // }

    // query(req?: any): Observable<ResponseWrapper> {
    //     const options = createRequestOption(req);
    //     return this.http.get(this.resourceUrl, options)
    //         .map((res: Response) => this.convertResponse(res));
    // }

    // delete(login: string): Observable<Response> {
    //     return this.http.delete(`${this.resourceUrl}/${login}`);
    // }

    authorities(): Observable<string[]> {
        return Observable.of(['ROLE_USER', 'ROLE_ADMIN']);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }
}
