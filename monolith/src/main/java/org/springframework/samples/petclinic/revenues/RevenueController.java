package org.springframework.samples.petclinic.revenues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping("/management/revenue")
    public String showRevenue(Map<String, Object> model) {
        model.put("revenues", revenueService.listYearlyRevenue());
        return "management/showRevenue";
    }

}
