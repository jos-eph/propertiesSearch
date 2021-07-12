package org.dydx.propertiesSearch;

import org.dydx.propertiesSearch.model.BasicProperty;
import org.dydx.propertiesSearch.model.BasicPropertyCarto;
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
		ConsoleService consoleService = new ConsoleService(System.in, System.out);
		BasicPropertyService propertyService = new BasicPropertyService(SQLstrings.baseQueryURL);

		String nameToSearch = consoleService.getSqlParamSafeUserInput("Enter an owner name to search by");

		List<BasicProperty> basicPropertyList = propertyService.getPropertiesByAnyOwnerName(nameToSearch);
		for (BasicProperty basicProperty : basicPropertyList)
		{
			System.out.println(basicProperty);
		}

	}
}
