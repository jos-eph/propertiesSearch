package org.dydx.propertiesSearch;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SQLstrings {
    public static final String baseQueryURL = "https://phl.carto.com/api/v2/sql?q=";
    public static final String selectBasicProperty =
           "SELECT owner_1, owner_2, house_number, street_direction, street_name, street_designation, zip_code, market_value, unit, cartodb_id, pwd_parcel_id, parcel_number, registry_number FROM opa_properties_public ";

    public static final String whereOwnerLike =
            "WHERE owner_1 ILIKE '%?%' OR owner_2 ILIKE '%?%' LIMIT 10";

    private static String buildStringFormatterFromSQLtemplate(String buildQuery) {
        String returnString = "";

        for (int i = 0, j = 1; i<buildQuery.length(); i++)
        {
            String charToAdd = "";
            String charAtPosition = buildQuery.substring(i,i+1);
            if (charAtPosition.equals("?"))
            {
                charToAdd = "%" + Integer.toString(j) + "$s";
                j += 1;
            }
            else if (charAtPosition.equals("%"))
            {
                charToAdd = "%%"; // percent character must be escaped out for string format
            }
            else { charToAdd = charAtPosition;}

            returnString += charToAdd;

        }

        return returnString;
    }
    
    
    public static String parameterizeAndReturnQuery(String sqlWithSubsNeeded, Object... parameters)
            /* make sure that the input that reaches this point does not have any characters that would have to
             be escaped in SQL, like ' */
    {
        String paramsFilledIn = "";
        try {
            String formatterFriendlyString = buildStringFormatterFromSQLtemplate(sqlWithSubsNeeded);
            paramsFilledIn = String.format(formatterFriendlyString, parameters);
        } catch (Exception ex)
        {
            System.err.println("Something unexpected happened when formatting the URL.");
            ex.printStackTrace(System.out);
        }
        return paramsFilledIn;

    }

}


