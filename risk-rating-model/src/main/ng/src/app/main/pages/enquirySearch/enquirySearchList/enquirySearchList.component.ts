import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { fuseAnimations } from '@fuse/animations';
import { BehaviorSubject } from 'rxjs';
import { LoanEnquiryService } from '../enquiryApplication.service';
import { EnquiryApplicationModel } from 'app/main/model/enquiryApplication.model';
import { DataSource } from '@angular/cdk/table';

@Component({
    selector: 'fuse-enquiry-search-list',
    templateUrl: './enquirySearchList.component.html',
    styleUrls: ['./enquirySearchList.component.scss'],
    animations: fuseAnimations
})
export class EnquirySearchListComponent implements OnInit {

    @Input()
    displaySpinner: boolean;

    dataSource: MatTableDataSource<any>;

    @ViewChild(MatSort) sort: MatSort;

    @ViewChild(MatPaginator) paginator: MatPaginator;

    @Input()
    set enquiryList(enquiryList: EnquiryApplicationModel[]) {
        this.dataSource = new MatTableDataSource(enquiryList);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
    }

    pageSizeOptions: number[] = [10, 25, 50, 100];

    displayedColumns = [
        'functionalStatusDescription', 'createdOn', 'enquiryNumber', 'loanContractId', 'busPartnerNumber',
        'projectDepartmentInitiator', 'monitoringDepartmentInitiator', 'riskDepartmentInitiator','projectName', 
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
     * @param enquiry: EnquiryApplicationModel
     */
    onSelect(enquiry: EnquiryApplicationModel): void {
        this.selectedEnquiry = enquiry;
        this._service.selectedLoanApplicaton = enquiry;
        this._service.selectedLoanApplicationId = new BehaviorSubject(enquiry.loanContractId);
    }
}
