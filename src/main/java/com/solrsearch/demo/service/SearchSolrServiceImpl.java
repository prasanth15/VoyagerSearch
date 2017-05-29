/**
 * Service layer where we establish connection to Solr server. Get the result 
 * filtering using searchCriteria and fields to be displayed and respond to the
 * controller layer
 */
package com.solrsearch.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SearchSolrServiceImpl implements SearchSolrService{

	@Override
	public List<String> getResults(String searchCriteria, List<String> viewFields) {
		
		List<String> results = new ArrayList<>();
		//Establishing connection to solrserver
		@SuppressWarnings("deprecation")
		HttpSolrServer server = new HttpSolrServer("solrURL");
		
		String[] fields = new String[viewFields.size()];
		for(int i = 0; i < viewFields.size(); i++) {
			fields[i] = viewFields.get(i);
		}
		
		SolrQuery query = new SolrQuery(searchCriteria);
		query.setQuery("*:*");
		query.setFilterQueries(searchCriteria);
		query.setFields(fields);
		
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList result = response.getResults();
			result.forEach(System.out::println);
			
			ObjectMapper om = new ObjectMapper();
			for(SolrDocument solrDoc:result) {
				  try {
					//convert java object to json
					results.add(om.writeValueAsString(solrDoc));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	

}
