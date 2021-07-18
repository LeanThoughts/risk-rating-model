export class RiskReportModel {
    riskModelId: string;
    loanNumber: string;
    projectName: string;
    projectType: string;
    projectPhase: string;
    initiatingDepartment: string;
    loanContractAmount: number;
    totalLoanDisbursedAmount: number;
    initiator: string;
    createDate: Date;
    createdTime: string;
    processedBy: string;
    processDate: Date;
    processTime: String;
    finalRating: string;
    riskCategory: string;

    /**
     * constructor()
     * Initialize the object.
     * @param _riskReport
     */
    constructor( _riskReport: any) {
        this.riskModelId = _riskReport.riskModelId;
        this.loanNumber = _riskReport.loanNumber + '' || '';
        this.projectName = _riskReport.projectName + '' || '';
        this.projectType = _riskReport.projectType + '' || '';
        this.projectPhase = _riskReport.projectPhase+ '' || '';
        this.initiatingDepartment = _riskReport.initiatingDepartment+ '' || '';
        this.loanContractAmount = _riskReport.loanContractAmount ;
        this.totalLoanDisbursedAmount = _riskReport.totalLoanDisbursedAmount ;
        this.initiator = _riskReport.initiator+ '' || '';
        this.createDate = _riskReport.createDate;
        this.createdTime = _riskReport.createdTime + '' || '';
        this.processedBy = _riskReport.processedBy;
        this.processDate = _riskReport.processTime;  + '' || ''
        this.processDate = _riskReport.processTime;  + '' || ''
        this.finalRating = _riskReport.finalRating + '' || ''
        this.riskCategory = _riskReport.riskCategory  + '' || '' ;
    }
}