package org.dydx.propertiesSearch;

import org.junit.*;
import static org.junit.Assert.*;


public class ConsoleServiceTests {
    ConsoleService consoleService;

    @Before
    public void init() {
        consoleService = new ConsoleService(System.in, System.out);
    }

    @Test
    public void test_safe_Params_SQL()
    {
        Character doubleQuote = '"';
        Character backSlash = (char) 92;
        String backSlashString = backSlash.toString();
        String input1 = "O'Leary";
        String input2 = doubleQuote.toString();
        String input3 = backSlashString;
        String input4 = backSlashString + "dot";
        String expected1 = "O\\\'Leary";
        String expected2 = "";
        String expected3 = "";
        String expected4 = "dot";

        String result1 = consoleService.safeParamsSQL(input1);
        String result2 = consoleService.safeParamsSQL(input2);
        String result3 = consoleService.safeParamsSQL(input3);
        String result4 = consoleService.safeParamsSQL(input4);

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2,result2);
        Assert.assertEquals(expected3,result3);
        Assert.assertEquals(expected4,result4);

    }
}
