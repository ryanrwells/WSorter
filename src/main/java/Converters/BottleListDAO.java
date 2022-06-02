package Converters;

import Handlers.TheListOfLists;
import POJOs.BottleList;

import java.util.List;

public class BottleListDAO {

    private BottleListDAO(){
    }

    public TheListOfLists getTheListOfLists() {
        return (TheListOfLists) ListOfBottleListsToJson.getTheListOfListsFromJsonDatabase();
    }

    public List<BottleList> getAllListsAsFlatList() {
        return getTheListOfLists().getAllListsAsFlatList(); // convert this to Json with userId
    }
}
