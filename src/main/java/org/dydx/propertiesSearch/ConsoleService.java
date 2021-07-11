package org.dydx.propertiesSearch;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleService {
    private PrintWriter out;
    private Scanner in;
    Map<String,String> sqlSafeParams = new LinkedHashMap<>(); // important to replace characters in order, stripping backslashes first

    private void initializeSqlSafeParamMap() { // 1 - regex locate forbidden character, 2- String to replace with
        Character backSlash = (char) 92;
        String backSlashString= backSlash.toString();
        String backSlashRegex = backSlashString + backSlashString;
        sqlSafeParams.put(backSlashRegex,""); // backslash is an escape character for Postgres; we don't want users escaping out characters
        sqlSafeParams.put("'","''"); // You should be able to search for a name like "O'Leary". But, ' is the normal quote character.
        Character doubleQuote = '"';
        sqlSafeParams.put(doubleQuote.toString(),""); // there's no reason for a user to insert a quote character
    }

    public ConsoleService(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output, true);
        this.in = new Scanner(input);
        initializeSqlSafeParamMap();
    }

    public String safeParamsSQL(String input) {
        String output = input;
        for (Map.Entry<String, String> replaceValues : sqlSafeParams.entrySet())
        {
            String regExSearch = replaceValues.getKey();
            String replaceWithThisString = replaceValues.getValue();
            output = output.replaceAll(regExSearch, replaceWithThisString);
        }

        return output;

    }

    public String getUserInput(String prompt) {
        out.print(prompt + ": ");
        out.flush();
        return in.nextLine();
    }

    public String getSqlParamSafeUserInput(String prompt) {
        return safeParamsSQL(getUserInput(prompt));
    }


}
