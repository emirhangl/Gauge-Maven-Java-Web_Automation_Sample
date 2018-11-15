package Mapping;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.IOException;

public class Mapper {
    public By getElementFromJson (String element){

        By elementFound = null;
        JSONParser parser = new JSONParser();
        Object object = null;


        try {
            object = parser.parse(new FileReader("./mapJSON/ObjectRepository.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println("Object: "+object);

        JSONObject jsonObject = (JSONObject) object;
        //System.out.println("JSON Object: "+jsonObject);

        String obj = jsonObject.get(element).toString();
        System.out.println(element+" locator: "+obj);

        String key = obj.split(":")[0];
        key = key.replaceAll("\"","");
        key = key.replaceAll("\\{","");
        key = key.toLowerCase();

        String value = obj.split(":")[1];
        value = value.replaceAll("\"","");
        value = value.replaceAll("}","");

        System.out.println(element+" Key "+key);
        System.out.println(element+" Value "+value);

        //elementFound =  generateByElement(key,value);
        System.out.println("elementFound "+elementFound);
        return elementFound;
    }

//    public By generateByElement(String byType, String byValue)
//    {
//        switch (byType)
//        {
//            case "id":
//                return By.id(byValue);
//            case  "cssselector":
//                return By.cssSelector(byValue);
//            case "xpath":
//                return By.xpath(byValue);
//            case "classname":
//                return By.className(byValue);
//            case "linktext":
//                return  By.linkText(byValue);
//            case "name":
//                return By.name(byValue);
//            default:
//                return null;
//        }
//    }
}
