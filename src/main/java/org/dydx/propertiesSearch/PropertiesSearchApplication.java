package org.dydx.propertiesSearch;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
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
	private ConsoleService consoleService;

	private static final String SIMPLE_OWNER_SEARCH = "Simple owner name search";
	private static final String EXIT_PROGRAM = "Exit program";
	private static final String[] MAIN_MENU_OPTIONS = {SIMPLE_OWNER_SEARCH,EXIT_PROGRAM};

	private void simpleOwnernameSearch()
	{
		BasicPropertyService basicPropertyService = new BasicPropertyService(SQLstrings.baseQueryURL);
		String nameToSearch = consoleService.getSqlParamSafeUserInput("Enter an owner name to search by");

		List<BasicProperty> basicPropertyList = basicPropertyService.getPropertiesByAnyOwnerName(nameToSearch);

		System.out.println();

		for (BasicProperty basicProperty : basicPropertyList)
		{
			System.out.println(basicProperty);
		}

		System.out.println();
	}

	private void mainMenu()
	{
		while(true)
		{
			String choice = (String) consoleService.getChoiceFromUserInput(MAIN_MENU_OPTIONS);
			if (SIMPLE_OWNER_SEARCH.equals(choice))
			{ simpleOwnernameSearch();}
			else {
				exitProgram();
			}
		}
	}

	public PropertiesSearchApplication(ConsoleService consoleService)
	{
		this.consoleService = consoleService;
	}

	public static void main(String[] args) {
		// SpringApplication.run(PropertiesSearchApplication.class, args);
		PropertiesSearchApplication app = new PropertiesSearchApplication(new ConsoleService(System.in, System.out));
		app.run();
	}

	private void run()
	{
		System.out.println("PropertiesSearch");
		System.out.println(".~.~.~.~.~.~.~.~.~.~");
		System.out.println();
		mainMenu();
	}

	private void exitProgram() {
		System.exit(0);
	}
}

