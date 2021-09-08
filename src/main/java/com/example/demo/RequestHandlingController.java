package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Person;
import com.example.demo.model.SuccessModel;
import com.example.demo.services.ServiceClass;

@RestController
public class RequestHandlingController {

	@Autowired
	ServiceClass serviceClass;

	@GetMapping("/all")
	public ResponseEntity<Object> getCompleteList() {
		Map<String, List<Person>> result = new HashMap<String, List<Person>>();
		result.put("details", serviceClass.getAllData());
		if (serviceClass.getAllData().isEmpty())
			return new ResponseEntity<Object>(
					new SuccessModel(HttpStatus.OK.value(), "No Records are Present!", result), HttpStatus.OK);
		else
			return new ResponseEntity<Object>(
					new SuccessModel(HttpStatus.OK.value(), "Fetched Records Successfully!", result), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addPerson(@RequestBody Person model) {
		if (serviceClass.addPerson(model))
			return new ResponseEntity<Object>(new SuccessModel(HttpStatus.OK.value(), "Created Successfully!",
					serviceClass.getPersonByID(model.getId())), HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Fail", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/get")
	public ResponseEntity<Object> getPerson(@RequestBody Person model) {
		if (serviceClass.isModelPresent(model))
			return new ResponseEntity<Object>(
					new SuccessModel(HttpStatus.OK.value(), "Success", serviceClass.getDataByModel(model)),
					HttpStatus.OK);
		else
			return new ResponseEntity<Object>(
					new SuccessModel(HttpStatus.OK.value(), "No Records Found", new ArrayList()), HttpStatus.OK);
	}
}
