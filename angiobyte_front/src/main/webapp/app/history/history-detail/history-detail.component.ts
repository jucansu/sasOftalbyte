import { Component, OnInit, OnDestroy } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate,ActivatedRoute } from '@angular/router';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { JhiLanguageHelper, User, UserService, HistoryService } from '../../shared';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
    selector: 'agb-history-detail',
    templateUrl: './history-detail.component.html',
    styleUrls: [
        'history-detail.css'
    ]
})
export class HistoryDetailComponent implements OnInit {
    routeSub: any;
    user: User;
    detail: any;
    currentUserDetail: {
        angi: true,
        bio: false,
        campi: false,
        conta: false,
        topo: false,
        octp: false,
        octa: false,
        otra1: false,
        otra2: false,
        reti: false,
        polo: false,
        paqui: false,
    };

    constructor(
        private route: ActivatedRoute,
        private historyService: HistoryService,
       
    ) { }

    ngOnInit() {
      /*  let  route: ActivatedRouteSnapshot; */
        this.routeSub = this.route.params.subscribe((params) => {
            this.loadData(params['id']);
        });
       /*  this.route.queryParams.subscribe((params) => {
            this.loadData(this.route2.queryParams['id']);
        }); */
      /*   this.loadData(route.queryParams['id']); */

    }

    updateCurrentUserDetail() {
        this.detail.forEach((element) => {
            if (element.angi) {
                this.currentUserDetail.angi = element.angi
            }
            if (element.bio) {
                this.currentUserDetail.bio = element.bio
            }
            if (element.campi) {
                this.currentUserDetail.campi = element.campi
            }
            if (element.conta) {
                this.currentUserDetail.conta = element.conta
            }
            if (element.topo) {
                this.currentUserDetail.topo = element.topo
            }
            if (element.octp) {
                this.currentUserDetail.octp = element.otcp
            }
            if (element.octa) {
                this.currentUserDetail.octa = element.octa
            }
            if (element.otra1) {
                this.currentUserDetail.otra1 = element.otra1
            }
            if (element.otra2) {
                this.currentUserDetail.otra2 = element.otra2
            }
            if (element.reti) {
                this.currentUserDetail.reti = element.reti
            }
            if (element.polo) {
                this.currentUserDetail.polo = element.polo
            }
            if (element.paqui) {
                this.currentUserDetail.paqui = element.paqui
            }
        });
        // this.currentUserDetail = this.detail[number]
    }

    loadData(id) {
        this.historyService.get(id).subscribe((user) => {
            this.user = user.json;
        });

        this.historyService.getRetina(id).subscribe((retina) => {
            this.detail = retina.json;
            this.currentUserDetail = this.detail[0]
            this.updateCurrentUserDetail()
        });
    }
}
