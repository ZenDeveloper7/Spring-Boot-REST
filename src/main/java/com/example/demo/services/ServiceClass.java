package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;

@Service
public class ServiceClass {

	List<Person> database = new ArrayList<Person>();

	public List<Person> getAllData() {
		return database;
	}

	public boolean addPerson(Person model) {
		if (model.getAge() == 0 || model.getId() == 0)
			return false;
		else if ((model.getName() == null || model.getGender() == null) && (model.getName().isEmpty() || model.getGender().isEmpty()))
			return false;
		else {
			for (Person single : getAllData()) {
				if (single.getId() == model.getId())
					return false;
			}
			database.add(model);
			return true;
		}
	}

	public boolean isModelPresent(Person model) {
		for (Person single : getAllData()) {
			if (single.getId() == model.getId())
				return true;
			else if (single.getAge() == model.getAge())
				return true;
			else if (single.getName().equalsIgnoreCase(model.getName()))
				return true;
			else if (single.getGender().equalsIgnoreCase(model.getGender()))
				return true;
		}
		return false;
	}

	public List<Person> getDataByModel(Person model) {
		List<Person> result = new ArrayList<Person>();
		if (model.getId() != 0 && model.getName() != null) {
			for (Person single : getAllData()) {
				if (single.getId() == model.getId() && single.getName().equalsIgnoreCase(model.getName()))
					result.add(single);
			}
			return result;
		} else {
			for (Person single : getAllData()) {
				if (single.getId() == model.getId())
					result.add(single);
				else if (single.getAge() == model.getAge())
					result.add(single);
				else if (single.getName().equalsIgnoreCase(model.getName()))
					result.add(single);
				else if (single.getGender().equalsIgnoreCase(model.getGender()))
					result.add(single);
			}
			return result;
		}
	}

	public Person getPersonByID(int id) {
		for (Person single : getAllData()) {
			if (single.getId() == id)
				return single;
		}
		return null;
	}
}
