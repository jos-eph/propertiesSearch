package org.dydx.propertiesSearch;

import org.dydx.propertiesSearch.model.BasicProperty;
import org.dydx.propertiesSearch.model.CartoResponse;
import org.dydx.propertiesSearch.services.BasicPropertyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Basic;
import java.util.List;

@SpringBootApplication
public class PropertiesSearchApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PropertiesSearchApplication.class, args);
		BasicPropertyService propertyService = new BasicPropertyService(SQLstrings.baseQueryURL);
		List<BasicProperty> basicPropertyList = propertyService.getPropertiesByAnyOwnerName("MIRARCHI");
		for (BasicProperty basicProperty : basicPropertyList)
		{
			System.out.println(basicProperty);
		}


	}
}
