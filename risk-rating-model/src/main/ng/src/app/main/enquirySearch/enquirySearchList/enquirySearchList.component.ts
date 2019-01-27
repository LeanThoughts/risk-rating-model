import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort } from '@angular/material';
import { fuseAnimations } from '@fuse/animations';
import { BehaviorSubject } from 'rxjs';
import { LoanEnquiryService } from '../enquiryApplication.service';
import { EnquiryApplicationModel } from 'app/main/model/enquiryApplication.model';

@Component({
    selector: 'fuse-enquiry-search-list',
    templateUrl: './enquirySearchList.component.html',
    styleUrls: ['./enquirySearchList.component.scss'],
    animations: fuseAnimations
})
export class EnquirySearchListComponent implements OnInit {

    dataSource: MatTableDataSource<any>;
    @ViewChild(MatSort) sort: MatSort;

    @Input()
    set enquiryList(enquiryList: EnquiryApplicationModel[]) {
        this.dataSource = new MatTableDataSource(enquiryList);
        this.dataSource.sort = this.sort;
    }

    displayedColumns = [
        'functionalStatusDescription', 'createdOn', 'enquiryNumber', 'loanContractId', 'busPartnerNumber', 'projectName', 
        'projectLocationState', 'projectTypeDescription', 'loanClassDescription', 'projectCapacity', 'assistanceTypeDescription', 
        'projectCost', 'loanAmount'
    ];

    selectedEnquiry: EnquiryApplicationModel;

    /**
     * constructor()
     */
    constructor(private _service: LoanEnquiryService) {
    }
    
    /**
     * ngOnInit()
     */
    ngOnInit(): void {
        /**
         * this.sort will not be initialized in the constructor phase. It will be undefined and hence sorting
         * will not work. The below line has to be in ngOnInit() which is executed after all initializations.
         */
        this.dataSource.sort = this.sort;
    }

    /**
     * 
     * @param enquiry 
     */
    onSelect(enquiry: EnquiryApplicationModel): void {
        this.selectedEnquiry = enquiry;
        this._service.selectedLoanApplicationId = new BehaviorSubject(enquiry.id);
    }
}
