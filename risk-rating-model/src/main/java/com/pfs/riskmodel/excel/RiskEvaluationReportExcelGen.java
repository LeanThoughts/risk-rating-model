package com.pfs.riskmodel.excel;

import com.pfs.riskmodel.dto.RiskModelReportDTO;
import com.pfs.riskmodel.resource.LoanApplication;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sajeev on 27-May-21.
 */
public class RiskEvaluationReportExcelGen {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<RiskModelReportDTO> riskModelReportDTOS;
//    private List<LoanApplication> loanApplications;
//    private List<LoanApplication> loanApplicationsFiltered;

//    private List<RiskModelReportDTO> riskModelReportDTOSOutput;


//    private Boolean activeLoanAccountsOnly;
//    private Boolean latestRatingsOnly;

    public RiskEvaluationReportExcelGen(List<RiskModelReportDTO> riskModelReportDTOS
//                                        List<LoanApplication> loanApplications,
//                                        Boolean activeLoanAccountsOnly,
//                                        Boolean latestRatingsOnly
    ) {
        this.riskModelReportDTOS= riskModelReportDTOS;
//        this.loanApplications = loanApplications;
//        this.activeLoanAccountsOnly = activeLoanAccountsOnly;
//        this.latestRatingsOnly = latestRatingsOnly;
        workbook = new XSSFWorkbook();
    }

//    private void filterOutput() {
//
//        this.riskModelReportDTOSOutput= riskModelReportDTOS;
//
//        if (activeLoanAccountsOnly == true) {
//            this.loanApplicationsFiltered = this.filterLoans();
//        }
//        if (latestRatingsOnly == true) {
//            riskModelReportDTOSOutput =   this.filterRiskModelDTOLatestDate();
//        }
//    }

//    private List<LoanApplication> filterLoans () {
//
//        List<LoanApplication> loanApplicationListFiltered = new ArrayList<>();
//
//        for (LoanApplication loanApplication : loanApplicationListFiltered) {
//            if (loanApplication.getLoanCurrentContractAmount() == 0 ||
//                    loanApplication.getFunctionalStatus() == 8 ||
//                    loanApplication.getFunctionalStatus() == 9 ||
//                    loanApplication.getFunctionalStatus() == 10 ||
//                    loanApplication.getFunctionalStatus() == 11 ||
//                    loanApplication.getFunctionalStatus() == 12 ||
//                    loanApplication.getFunctionalStatus() == 13
//                    ) {
//                loanApplicationListFiltered.add(loanApplication);
//            }
//        }
//
//        return loanApplicationListFiltered;
//    }
//
//    private  List<RiskModelReportDTO> filterRiskModelDTOLatestDate() {
//        List<RiskModelReportDTO> riskModelReportDTOSFiltered = new ArrayList<>();
//
//        for (LoanApplication loanApplication : loanApplications) {
//
//
//                List<RiskModelReportDTO> riskModelReportDTOSForLoan =
//                        riskModelReportDTOS.stream().filter(riskModelReportDTO -> riskModelReportDTO.getLoanNumber().equals(loanApplication.getLoanContractId()))
//                                .collect(Collectors.toList());
//
//                if (latestRatingsOnly == true) {
//                    Comparator<RiskModelReportDTO> riskModelReportDTOComparator = Comparator
//                            .comparing(RiskModelReportDTO::getCreateDate)
//                            .thenComparing(RiskModelReportDTO::getCreatedTime);
//
//                    riskModelReportDTOSForLoan = riskModelReportDTOSForLoan.stream()
//                            .sorted(riskModelReportDTOComparator)
//                            .collect(Collectors.toList());
//
//                    if (riskModelReportDTOSForLoan.size() > 0)
//                        riskModelReportDTOSFiltered.add(riskModelReportDTOSForLoan.get(riskModelReportDTOSForLoan.size() - 1));
//
//                }
//
//        }
//
//
//        return riskModelReportDTOSFiltered;
//
//    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Risk Evaluations");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Risk Evaluation ID", style);
        createCell(row, 1, "Loan Number", style);
        createCell(row, 2, "Project Name ", style);
        createCell(row, 3, "Project Type", style);
        createCell(row, 4, "Project Phase", style);
        createCell(row, 5, "Initiating Department", style);
        createCell(row, 6, "Loan Contract Amount", style);
        createCell(row, 7, "Total Disbursement Amount", style);
        createCell(row, 8, "Initiator", style);
        createCell(row, 9, "Creation Date", style);
        createCell(row, 10, "Creation Time", style);
        createCell(row, 11, "Processed By", style);
        createCell(row, 12, "Process Date", style);
        createCell(row, 13, "Process Time", style);
        createCell(row, 14, "Final Rating", style);
        createCell(row, 15, "Risk Category", style);



    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() throws ParseException {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (RiskModelReportDTO riskModelReportDTO : riskModelReportDTOS) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            if (riskModelReportDTO.getRiskModelId() != null)
                createCell(row, columnCount++, riskModelReportDTO.getRiskModelId().toString(), style);
            else
                createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getLoanNumber() != null)
                createCell(row, columnCount++, riskModelReportDTO.getLoanNumber(), style);
            else
                createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getProjectName() != null)
            createCell(row, columnCount++, riskModelReportDTO.getProjectName(), style);
            else
                createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getProjectType() != null)
            createCell(row, columnCount++, riskModelReportDTO.getProjectType(), style);
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getProjectPhase() != null)
            createCell(row, columnCount++, riskModelReportDTO.getProjectPhase(), style);
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getInitiatingDepartment() != null)
            createCell(row, columnCount++, riskModelReportDTO.getInitiatingDepartment(), style);
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getLoanContractAmount() != null)
            createCell(row, columnCount++, riskModelReportDTO.getLoanContractAmount().toString(), style);
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getTotalLoanDisbursedAmount() != null)
            createCell(row, columnCount++, riskModelReportDTO.getTotalLoanDisbursedAmount().toString(), style);
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getInitiator() != null)
                createCell(row, columnCount++, riskModelReportDTO.getInitiator().toString(), style);
            else
                createCell(row, columnCount++, "", style);

//            SimpleDateFormat formatter = new SimpleDateFormat(
//                    "dd/MM/yyyy");
//            SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");

            if (riskModelReportDTO.getCreateDate() != null) {
                createCell(row, columnCount++, riskModelReportDTO.getCreateDate(), style);
            }
            else
            createCell(row, columnCount++, "", style);


            if (riskModelReportDTO.getCreateDate() != null) {
//                String time = localDateFormat.format(riskModelReportDTO.getCreateDate()).toString();

                createCell(row, columnCount++, riskModelReportDTO.getCreatedTime(), style);
            }
            else
                createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getProcessedBy() != null) {
                createCell(row, columnCount++, riskModelReportDTO.getProcessedBy(), style);
            }
            else
                createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getProcessDate() != null){
//                String date =  formatter.parse(formatter.format(riskModelReportDTO.getProcessDate())).toString();

                createCell(row, columnCount++, riskModelReportDTO.getProcessDate().toString().substring(0,10), style);
            }
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getProcessDate() != null){
//                String time = localDateFormat.format(riskModelReportDTO.getProcessDate()).toString();

                createCell(row, columnCount++, riskModelReportDTO.getProcessTime(), style);
            }
            else
                createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getFinalRating() != null)
                createCell(row, columnCount++, riskModelReportDTO.getFinalRating(), style);
            else
            createCell(row, columnCount++, "", style);

            if (riskModelReportDTO.getRiskCategory() != null) {
                createCell(row, columnCount++, riskModelReportDTO.getRiskCategory(), style);
            }
            else
                createCell(row, columnCount++, "", style);
        }
    }

    public void export(HttpServletResponse response) throws IOException  {

        //this.filterOutput();

        writeHeaderLine();
        try {
            writeDataLines();
        } catch (ParseException p){
            System.out.println(p.toString());
        }

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }


}
