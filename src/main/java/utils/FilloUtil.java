package utils;

import com.codoid.products.fillo.*;

import java.util.HashMap;
import java.util.Map;

public class FilloUtil {

    public static Map<String, String> getLoginData() throws Exception {
        Map<String, String> data = new HashMap<>();

        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("src/test/resources/testdata.xlsx");
        String query = "SELECT Username,Password FROM Sheet1";
        Recordset recordset = connection.executeQuery(query);
        while (recordset.next()) {
            data.put("Username", recordset.getField("Username"));
            data.put("Password", recordset.getField("Password"));
        }
        recordset.close();
        connection.close();
        return data;
    }
}