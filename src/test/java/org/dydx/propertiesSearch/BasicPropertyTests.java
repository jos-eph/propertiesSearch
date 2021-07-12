package org.dydx.propertiesSearch;
import org.dydx.propertiesSearch.model.BasicProperty;
import org.junit.*;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BasicPropertyTests {
    @Test
    public void test_demo_basicproperty_constructor()
    {
        List<BasicProperty> testPropertyList = new ArrayList<>();

        String[] owner1Data = {"SMITH JILL", "SMITHSON JACK","GOLDSMITH JOHN","SMITH SMITH","SMITHS BO"};
        String[] owner2Data = {"OTHERSON JP", "OTHER RJ", "COOWNER AZ", "TESTERSON TEST", "DATA PICARD"};
        String[] houseNumberData = {"1234","3456","7891","1020","2142"};
        String[] streetDirectionData = {"E","W",null,"S","N"};
        String[] streetNameData = {"HONEYSUCKLE","ELM","NOCCIOLA","TEST","ANYPLACE"};
        String[] streetDesignation = {"LANE","ST","AVE","ST","ST"};
        String[] zipCodeData = {"19102", "19103","19104","19105","19106"};
        BigDecimal[] valueData = {new BigDecimal("10000"), new BigDecimal("20000"),
        new BigDecimal("21210"),new BigDecimal("123151"), new BigDecimal("231341")};

        for (int i = 0; i < owner1Data.length; i++)
        {
            BasicProperty addThis = new BasicProperty(owner1Data[i],owner2Data[i],houseNumberData[i],
                    streetDirectionData[i],streetNameData[i],streetDesignation[i], zipCodeData[i],
                    valueData[i]);
            testPropertyList.add(addThis);
        }

        for (BasicProperty property : testPropertyList )
        {
            System.out.println(property);
        }
    }
}
