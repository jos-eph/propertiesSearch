package org.dydx.propertiesSearch.services;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.dydx.propertiesSearch.SQLstrings;
import org.dydx.propertiesSearch.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;

import javax.websocket.RemoteEndpoint;
import java.util.List;

public class BasicPropertyService {
    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    BasicPropertyCarto listOfPropertiesFromCarto;

    public BasicPropertyService(String apiURL) {
        API_BASE_URL = apiURL;
    }

    public List<BasicProperty> getPropertiesByAnyOwnerName(String anyOwnerName) {

        String queryForDatabase =
                SQLstrings.parameterizeAndReturnQuery(
                        SQLstrings.selectBasicProperty +
                                SQLstrings.whereOwnerLike,
                anyOwnerName,anyOwnerName);

        CartoRequest request = new CartoRequest();
        request.setQ(queryForDatabase);

        // https://docs.oracle.com/javaee/7/api/javax/json/JsonObjectBuilder.html

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CartoRequest> entity = new HttpEntity<>(request,headers);

        try {
            listOfPropertiesFromCarto = restTemplate.postForObject(API_BASE_URL + "/post",entity,BasicPropertyCarto.class);
        }
        catch (RestClientResponseException ex)
        {
            ex.printStackTrace(System.err);
        } catch (ResourceAccessException ex)
        {
            ex.printStackTrace(System.err);
        }

        return listOfPropertiesFromCarto.getRows();


    }



}
