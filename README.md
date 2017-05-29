# VoyagerSearch | Code | Challenge

Please create a new GitHub repo and commit your code there. Also, adding a unit test or 2, using Mockito would be nice.

Required tools: Java, Spring, Gradle, Solr (if you like something like Scala, Groovy, Kotlin etc to increase your productivity, feel free)

Question 1:

Our front end calls are tightly coupled to Solr. This presents problems when the next solr version is released with breaking changes, or
we wanted a different implementation, like Elastic Search.

Create a REST api, using Spring boot, that's an abstraction layer, a generic interface for querying (not tied to any backend). The first
iteration will just support queries where I can pass the filter criteria for my query, and the ability to pass in the fields I want 
returned. Things like sorting, chunking/limiting (paging), would be a bonus.
