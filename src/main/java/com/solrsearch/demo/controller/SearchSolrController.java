/**
 * Controller which routes the incoming request to the service layer and then retrieves the 
 * response from service layer and responds back to client
 */

package com.solrsearch.demo.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.solrsearch.demo.service.SearchSolrService;

@RestController
@RequestMapping("/solr")
public class SearchSolrController {
	
	@Autowired
	SearchSolrService searchSolrService;
	
	@RequestMapping(method=RequestMethod.GET, value="/search",produces = MediaType.APPLICATION_JSON_VALUE) 
	public ArrayList<String> getResults(@PathVariable String searchCriteria,@RequestBody ArrayList<String> viewFields) {		
		ArrayList<String> results = new ArrayList<>();
		results = (ArrayList<String>) searchSolrService.getResults(searchCriteria, viewFields);

		return results;
	}
}
