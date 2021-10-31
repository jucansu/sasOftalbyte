import { Component, OnInit } from '@angular/core';

import { JhiEventManager } from 'ng-jhipster';

import { Account, LoginModalService, Principal, HistoryService } from '../../shared';

@Component({
    selector: 'agb-history',
    templateUrl: './history-list.component.html',
    styleUrls: [
        'history-list.css'
    ]

})
export class HistoryListComponent implements OnInit {
    history: History;
    totalItems: any;
    page: any;
    itemsPerPage: any;
    nuhsa_id: number;
    filter: string;
    constructor(
        private historyService: HistoryService
    ) {
        this.totalItems = 10000;
        this.itemsPerPage = 100;
        this.page = 0;
        this.filter = '';
    }

    ngOnInit() {
        this.loadData();
    }

    loadData() {
        this.historyService.find({ page: this.page, size: this.itemsPerPage }).subscribe((history) => {
            this.history = history.json;
        });
    }
}
