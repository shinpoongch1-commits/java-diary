package com.hospital.dailyreport.patient;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PatientController {
	
	@GetMapping("/patients")
	public String list(Model p) {
		List<PatientCount> patients = List.of (
				new PatientCount("의료보험신규", 71),
				new PatientCount("의료보험재진", 20),
				new PatientCount("일반", 4),
				new PatientCount("보호", 4)
				);
		p.addAttribute("patients", patients);
		 return "patients/list";
	}
}

