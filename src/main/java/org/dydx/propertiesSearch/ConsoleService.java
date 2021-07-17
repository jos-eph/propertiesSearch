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

    public String getSqlParamSafeUserInput(String prompt) {
        return safeParamsSQL(getUserInput(prompt));
    }

    public String getUserInput(String prompt) {
        out.print(prompt + ": ");
        out.flush();
        return in.nextLine();
    }

    public Integer getUserInputInteger(String prompt)
    {
        Integer chosenInteger = null;
        while (chosenInteger==null)
        {
            String input=getUserInput(prompt);
            try
            { chosenInteger = Integer.parseInt(input);}
            catch (NumberFormatException ex)
            {
                System.err.println("Not an integer. Just enter -1 for valid input" +
                        " if you got here by mistake. ");
                out.flush();
            }
            catch (Exception ex)
            { System.err.println(ex.getMessage());; }
        }
        return chosenInteger;
    }

    public void displayMenuOptions(Object[] arrayOfChoices)
    {
        if (arrayOfChoices==null) { return;}
        for (int i = 1; i <= arrayOfChoices.length; i++)
        {
            String optionString = arrayOfChoices[i-1].toString();
            String output = Integer.toString(i) + ") " + optionString;
            out.println(output);
        }

        System.out.println();

        return;

    }

    public Object getChoiceFromUserInput(Object[] arrayOfChoices) {
        Object chosenObject = null;
        displayMenuOptions(arrayOfChoices);
        Integer chosen = getUserInputInteger("Select an option") - 1;
        if (chosen >= 0 && chosen < arrayOfChoices.length) {
            chosenObject = arrayOfChoices[chosen];
        }

        return chosenObject;

    }





}
