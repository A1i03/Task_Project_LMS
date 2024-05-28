package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public String findAllCompanies(Model model) {
        model.addAttribute("allCompanies", companyService.getAllCompany());
        return "companies";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("newCompany", new Company());
        return "create";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @DeleteMapping("/{companyId}/delete")
    public String deleteCompany(@PathVariable("companyId") Long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/{id}/updateCompany")
    public String getById(@PathVariable("id") Long companyId, Model model) {
        model.addAttribute("upCompany", companyService.getByIdCompany(companyId));
        return "/updateCompany";

    }

        @PostMapping("/{id}/updateCompany")
        public String updateCompany(@PathVariable("id") Long id, @ModelAttribute("upCompany") Company company) {
            companyService.updateCompany(id, company);
            return "redirect:/companies";
        }

}
