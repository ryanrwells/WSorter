import Handlers.UserMenus;
import POJOs.BottleProfile;

public class Main {

    public static void main(String[] args) {
        //run TheListofLists to get list from caching DTO === pulled from Json


        System.out.println("ListImport thread started.");
        //startImportThread(TheListOfLists.importLists());
        //run import thread before getInstance
        UserMenus.getInstance().mainMenu();
    }

    BottleProfile g = new BottleProfile();

}


