import { Component, OnInit, OnDestroy, HostListener } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { JhiLanguageHelper, User, UserService, HistoryService } from '../../shared';

@Component({
    selector: 'agb-images-comparison',
    templateUrl: './images-comparison.component.html',
    styleUrls: [
        'images-comparison.css'
    ]

})

export class ImagesComparisonComponent implements OnInit {
    routeSub: any;
    user: User;
    id: any;
    type: any;
    detail: any;
    currentUserDetail: any;
    currentType: any;
    availableButtons: {
        campi: null,
        topo: null,
        octp: null,
        octa: null,
        otra1: null,
        otra2: null,
        reti: null,
        angi: null,
        conta: null,
        bio: null,
        polo: null,
        paqui: null
    };
    popUp: any;
    historial: any;
    popUpImage: any;
    spinner: any;
    enableZoomDer: any;
    enableZoomIzq: any;
    boxSelection: any;
    images: any;
    izqImageComparison: any;
    izqDetails: any;
    derImageComparison: any;
    derDetails: any;

    constructor(
        private route: ActivatedRoute,
        private historyService: HistoryService,
        private router: Router
    ) {
    }

    @HostListener('document:keydown', ['$event']) onKeydownHandler(event: KeyboardEvent) {
        if (event.keyCode === 27) {
            this.popUp = false
            this.enableZoomDer = false
            this.enableZoomIzq = false
        }
    }

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.id = params['id'];
            this.type = params['type'];
            this.loadData(params['id']);
        });
        this.availableButtons = {
            campi: null,
            topo: null,
            octp: null,
            octa: null,
            otra1: null,
            otra2: null,
            reti: null,
            angi: null,
            conta: null,
            bio: null,
            polo: null,
            paqui: null
        };

        this.boxSelection = 'izq'
        this.izqImageComparison = ''
        this.izqImageComparison = ''

    }
    changeVisit(visita: any) {
        this.detail.forEach((element, index) => {
            if (element.visita === visita) {
                this.updateCurrentUserDetail(index)
                const fecha = element.fecha.split('-')
                this.images = []
                this.getImageName(this.id, this.currentType, fecha[2] + fecha[1] + fecha[0])
            }
        });
    }

    zoom(e, type) {
        switch (type) {
            case 'der':
                if (this.enableZoomDer) {
                    let offsetX, offsetY, x, y
                    const zoomer = e.currentTarget;
                    e.offsetX ? offsetX = e.offsetX : offsetX = e.touches[0].pageX
                    e.offsetY ? offsetY = e.offsetY : offsetX = e.touches[0].pageX
                    x = offsetX / zoomer.offsetWidth * 100
                    y = offsetY / zoomer.offsetHeight * 100
                    zoomer.style.backgroundPosition = x + '% ' + y + '%';
                }

                break;
            case 'izq':
                if (this.enableZoomIzq) {
                    let offsetX, offsetY, x, y
                    const zoomer = e.currentTarget;
                    e.offsetX ? offsetX = e.offsetX : offsetX = e.touches[0].pageX
                    e.offsetY ? offsetY = e.offsetY : offsetX = e.touches[0].pageX
                    x = offsetX / zoomer.offsetWidth * 100
                    y = offsetY / zoomer.offsetHeight * 100
                    zoomer.style.backgroundPosition = x + '% ' + y + '%';
                }

                break;

            default:
                break;
        }
    }

    openPopUp(data: any) {
        this.popUpImage = data
        this.popUp = true
    }

    enablingZoom(state, type) {
        switch (type) {
            case 'der':
                this.enableZoomDer = state

                break;
            case 'izq':
                this.enableZoomIzq = state

                break;

            default:
                break;
        }
    }
    closePopUp(event: any) {
        if (event.target.className === 'outter_modal') {
            this.popUp = false
            this.enableZoomDer = false
            this.enableZoomIzq = false
        }
    }
    updateCurrentUserDetail(number) {
        this.currentUserDetail = this.detail[number]
    }

    hasType(item) {
        for (const i in item) {
            if (i === this.currentType && item[i]) {
                return true;
            }
        }

        return false;
    }

    imageSelect(image) {
        if (this.boxSelection === 'izq') {
            this.izqImageComparison = image;
            this.izqDetails = {
                visit: this.currentUserDetail.visita,
                date: this.currentUserDetail.fecha
            }
        } else {
            this.derImageComparison = image;
            this.derDetails = {
                visit: this.currentUserDetail.visita,
                date: this.currentUserDetail.fecha
            }
        }
        this.changeBox()
    }
    changeType(newType) {
        this.currentType = newType;
        this.images = []
        this.changeVisit(this.currentUserDetail.visita)
    }

    loadData(id) {
        this.images = [];
        this.historyService.get(id).subscribe((user) => {
            this.user = user.json;
        });

        this.getRetina(id)
        this.getImageName(id, 'campi', 13022007)
        this.currentType = this.type;

    }

    getImageName(id, type, date) {
        let counter = 0
        this.historyService.getImageName(id, type, date).subscribe((list) => {
            list.json.listNames.forEach((element) => {
                this.spinner = true;
                counter += 1
                this.historyService.getImage(id, element).subscribe((image) => {
                    this.images.push(image.json)
                    counter -= 1
                    if (counter === 0) {
                        this.spinner = false
                    }
                });
            });
            if (!list.json.listNames) {
                this.spinner = false
            }
        });
    }

    getRetina(id) {
        if (id) {
            this.spinner = true;
        }
        this.historyService.getRetina(id).subscribe((retina) => {
            this.detail = retina.json;
            this.detail.forEach((element) => {
                for (const item in element) {
                    if (element[item] === true) {
                        this.availableButtons[item] = true;
                    }
                }

            });
            this.currentUserDetail = this.detail[0]
            this.currentType = this.type;
            this.spinner = false
        });
    }

    changeBox() {
        this.boxSelection = (this.boxSelection === 'izq') ? 'der' : 'izq';
    }
}
