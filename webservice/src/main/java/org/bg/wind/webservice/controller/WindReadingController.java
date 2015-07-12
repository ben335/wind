package org.bg.wind.webservice.controller;

import org.bg.wind.webservice.domain.WindReading;
import org.bg.wind.webservice.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Controller
public class WindReadingController {
	
	@Autowired
	private WindService windService;

	@RequestMapping(value = "/windreadings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<WindReading>> getAllWindData() {
		
		Collection<WindReading> windReadings = windService.getAllWindData();
		List<Resource<WindReading>> resources = new ArrayList<Resource<WindReading>>();
		for (WindReading windReading : windReadings) {
			resources.add(getWindDataResource(windReading));
		}
		return resources;
		
	}

	@RequestMapping(value = "/windreading/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<WindReading> getWindReading(@PathVariable(value = "id") String id) {
		WindReading windReading = windService.getWindReading(id);
		return getWindDataResource(windReading);
	}

	private Resource<WindReading> getWindDataResource(WindReading windReading) {

		Resource<WindReading> resource = new Resource<WindReading>(windReading);

		// Link to Album
		resource.add(linkTo(methodOn(WindReadingController.class).getWindReading(Integer.toString(windReading.getReadingId()))).withSelfRel());

		return resource;
	}
}
