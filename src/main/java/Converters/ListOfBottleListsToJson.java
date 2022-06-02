package Converters;

import Handlers.TheListOfLists;
import POJOs.BottleList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfBottleListsToJson implements Runnable {
    public static ObjectMapper obj = new ObjectMapper();
//submits/gets from data
StringBuffer sb = new StringBuffer();
    public static String getStringOfTheListOfLists(){
        String jsonOfTheListsOfLists;
        try {

            sb.
            jsonOfTheListsOfLists = obj.writeValueAsString(TheListOfLists.getInstance());
            System.out.println("success in mapping object data to String");
        }
        catch (IOException e) {
         e.printStackTrace();
        }
        return jsonOfTheListsOfLists;
    }

    public static List<BottleList> getTheListOfListsFromJsonDatabase(){
        obj.readValue(jsonOfAllThisUsersLists or from URL or from File, TheListOfLists.getInstance());


        List<BottleList> allTheListsObjectFromJson = new ArrayList<>();
        return allTheListsObjectFromJson;
    }

    public void syncWithListsDatabase() {

    }

//    JSObject allUserLists = new JSObject();
//    JSObject allFollowedLists = new JSObject();
//

//    FileWriter fileAllUserLists = new FileWriter("C:\\Users\\ryanr\\Documents\\WSorter\\src\\main\\FileAllFollowableLists");
//    FileWriter fileAllFollowedLists = new FileWriter("C:\\Users\\ryanr\\Documents\\WSorter\\src\\main\\FileAllFollowedLists");
//

    @Override
    public void run() {
        syncWithListsDatabase();
    }

    // addableView = false; // set to false if made sharable and UUID distinct

    //    public void mapBottleListAndSendToServelssCellar(BottleList theBottleList) {
        ObjectMapper objectMapper = new ObjectMapper();
//        String serializedCharacter = objectMapper.writeValueAsString(character);
//    }

//Gradle: com.fasterxml.jackson.core:jackson-annotations:2.12.6
//        Gradle: com.fasterxml.jackson.core:jackson-core:2.12.6
//        Gradle: com.fasterxml.jackson.core:jackson-databind:2.12.6.1
//        Gradle: com.fasterxml.jackson.dataformat:jackson-dataformat-cbor:2.12.6
}
