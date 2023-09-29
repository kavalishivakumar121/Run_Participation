package com.iFinish.controller;


import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.iFinish.entity.RaceParticipationRegisterEntity;
import com.iFinish.model.CountryCode;
import com.iFinish.service.RaceParticipationService;

@Controller
public class RaceParticipationControll {

	@Autowired
	private RaceParticipationService raceParticipationService;
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String showRacepartregister(Model model) {
		countryCodes(model);
		model.addAttribute("register",new RaceParticipationRegisterEntity());
		return "Register";
	}

	@PostMapping("/create_participate")
	public String saveRacepartregister(@ModelAttribute("register") RaceParticipationRegisterEntity register,  Model model) {

		String message = raceParticipationService.createParticipate(register);
		Integer id=register.getParticipantId();
		
		model.addAttribute("msg",message+" with :"+id);
		model.addAttribute("register",new RaceParticipationRegisterEntity());
		countryCodes(model);
		return "Register";
	}

	private void countryCodes(Model model) {
		String[] countryCodes = Locale.getISOCountries();
		
List<String> countryName=new ArrayList<>();
List<String> phCodes=new ArrayList<>();

/*
 * List<CountryCode> showCountryDetails = showCountryDetails();
 * 
 * for (CountryCode countryCode : showCountryDetails) {
 * RaceParticipationRegisterEntity entity=new RaceParticipationRegisterEntity();
 * entity.setCountry(countryCode.getName());
 * entity.setCountyCode(countryCode.getDial_code()); String
 * name=entity.getCountry(); String countryPh=entity.getCountyCode();
 * countryName.add(name); phCodes.add(countryPh); }
 */
		for (String countryCode : countryCodes) {
			Locale locale = new Locale("", countryCode);
			String name = locale.getDisplayCountry();
			countryName.add(name);
		}
		model.addAttribute("countryName",countryName);
		model.addAttribute("phCodes",phCodes);
	}
	
	public List<CountryCode> showCountryDetails() {
	    String url="https://gist.githubusercontent.com/Goles/3196253/raw/9ca4e7e62ea5ad935bb3580dc0a07d9df033b451/CountryCodes.json";
	    
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); HttpEntity
		 * <String> entity = new HttpEntity<String>(headers);
		 */
	    
	    
	    ResponseEntity<List<CountryCode>> responseEntity = restTemplate.exchange(
	    		url,
	    	    HttpMethod.GET,
	    	    null,
	    	    new ParameterizedTypeReference<List<CountryCode>>(){});
	    	  
	    	List<CountryCode> CountryCodes = responseEntity.getBody();
	    	return CountryCodes;
	}
	
	

}
