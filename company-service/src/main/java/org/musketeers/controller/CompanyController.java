package org.musketeers.controller;

import lombok.RequiredArgsConstructor;
import static org.musketeers.constant.EndPoints.*;

import org.musketeers.dto.request.*;
import org.musketeers.dto.response.GetCompanyDetailedInfoResponseDto;
import org.musketeers.dto.response.GetCompanySummaryInfoResponseDto;
import org.musketeers.mapper.ICompanyMapper;
import org.musketeers.repository.entity.Company;
import org.musketeers.service.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ROOT+COMPANY)
@RequiredArgsConstructor
@CrossOrigin
public class CompanyController {

    private final CompanyService companyService;
    private final DepartmentService departmentService;
    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final HolidayService holidayService;
    private final ICompanyMapper companyMapper;

//    @PostMapping(SAVE)
//    public boolean save(@RequestBody Company company) {
//        return companyService.createCompany(company);
//    }

    @GetMapping(FINDALL)
    public List<Company> findAll(){
        return companyService.findAll();
    }

    @GetMapping(FINDCOMPANYBYSUPERVISORTOKEN + "/{token}")
    public Company findByCompanyId(@PathVariable String token){
        return companyService.findByCompanyId(token);
    }

    @PutMapping(value = UPDATE_FOR_THE_FIRST_TIME, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateCompanyForFirstTime(@ModelAttribute CompanyUpdateRequestDTO dto){
        return ResponseEntity.ok(companyService.updateCompanyForFirstTime(dto));
    }

    @PostMapping(SOFT_DELETE)
    public ResponseEntity<Boolean> softDelete(String companyName){
        return ResponseEntity.ok(companyService.softDelete(companyName));
    }

    @PostMapping(HARD_DELETE)
    public ResponseEntity<Boolean> hardDelete(String companyName){
        return ResponseEntity.ok(companyService.hardDelete(companyName));
    }

    @PostMapping(ADD_INCOME)
    public ResponseEntity<Boolean> addIncome(@RequestBody AddIncomeRequestDto dto){
        return ResponseEntity.ok(incomeService.saveIncome(dto));
    }

//    @PostMapping(ADD_EXPENSE)
//    public ResponseEntity<Boolean> addExpense(@RequestBody AddExpenseRequestDto dto){
//        return ResponseEntity.ok(expenseService.saveExpense(dto));
//    }

    @PostMapping(ADD_HOLIDAY)
    public ResponseEntity<Boolean> addHoliday(@RequestBody AddHolidayRequestDto dto){
        return ResponseEntity.ok(holidayService.saveHoliday(dto));
    }

//    @PostMapping(ADD_HRINFO)
//    public ResponseEntity<Boolean> addHRInfo(AddHolidayRequestDto dto){
//        return ResponseEntity.ok(holidayService.saveHoliday(companyMapper.addHolidayRequestDtoToHoliday(dto)));
//    }

    @PostMapping(ADD_DEPARTMENT)
    public ResponseEntity<Boolean> addDepartment(@RequestBody AddDepartmentRequestDto dto){
        return ResponseEntity.ok(departmentService.saveDepartment(dto));
    }

    @GetMapping(GET_COMPANY_SUMMARY_INFO_FOR_GUEST + "/{companyName}")
    public ResponseEntity<List<GetCompanySummaryInfoResponseDto>> getCompanySummaryInfo(@PathVariable String companyName){
        return ResponseEntity.ok(companyService.getCompanySummaryInfo(companyName));
    }

    @GetMapping(GET_COMPANY_DETAILED_INFO_FOR_GUEST + "/{companyId}")
    public ResponseEntity<GetCompanyDetailedInfoResponseDto> getCompanyDetailedInfo(@PathVariable String companyId) {
        return ResponseEntity.ok(companyService.getCompanyDetailedInfoById(companyId));
    }

}
