/**
 * Interface where the abstract method names to be implemented in implementation 
 * classes are defined
 */

package com.solrsearch.demo.service;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Service;


public interface SearchSolrService{

	List<String> getResults(String searchCriteria, List<String> viewResults);
}

