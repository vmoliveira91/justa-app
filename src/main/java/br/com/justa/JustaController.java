package br.com.justa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONObject;

@RestController
public class JustaController {

	@GetMapping("/units/si")
	public String convertUnits(@RequestParam(value = "units") String units) {
		return ConvertUnits.convertUnits(units);
	}

}