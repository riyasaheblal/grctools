package org.kc.rg.GrcToolApplication.Controller;


import org.kc.rg.GrcToolApplication.Model.Compliance;
import org.kc.rg.GrcToolApplication.Model.Risk;
import org.kc.rg.GrcToolApplication.Repository.ComplianceRepository;
import org.kc.rg.GrcToolApplication.Repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GrcController {

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private ComplianceRepository complianceRepository;

    @GetMapping("/")
    public String test() {
    	return "home";
    }
    
    @GetMapping("/addrisk")
    public String addriskdata(Model model) {
    	model.addAttribute("risk", riskRepository.findAll());
    	return "addrisk";
    }
    @PostMapping("/add-risk")
    public String addRisk(@RequestParam String title, @RequestParam String description) {
    	Risk risk=new Risk();
        risk.setTitle(title);
        risk.setDescription(description);
        riskRepository.save(risk);
        return "redirect:/addrisk";
    }
    
   
    @GetMapping("/addcompliance")
    public String addcompliancedata(Model model) {
    	model.addAttribute("compliances", complianceRepository.findAll());
    	return "addcompliance";
    }
    @RequestMapping("/test")
    public String index(Model model) {
        model.addAttribute("risks", riskRepository.findAll());
        model.addAttribute("compliances", complianceRepository.findAll());
        return "index";
    }

    @GetMapping("/button")
    public String buttontest() {
    	return "button";
    }
    

    @PostMapping("/add-compliance")
    public String addCompliance(@RequestParam String title, @RequestParam String description) {
        Compliance compliance = new Compliance();
        compliance.setTitle(title);
        compliance.setDescription(description);
        complianceRepository.save(compliance);
        return "redirect:/addcompliance";
    }
}
