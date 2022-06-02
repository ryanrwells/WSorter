package Handlers;

import POJOs.BottleList;
import POJOs.BottleProfile;
import POJOs.PrimaryBottleLists;

import java.util.ArrayList;
import java.util.List;

public class TheListOfLists {
    private static final TheListOfLists instance = new TheListOfLists();
    private final List<BottleList> primaryLists = new ArrayList<>(getPrimaryLists());
    private final List<BottleList> customLists = new ArrayList<>(getCustomLists());
    private final List<BottleList> viewOnlyLists = new ArrayList<>(getViewOnlyLists());
    private final List<BottleList> allTheLists = new ArrayList<>();


    private TheListOfLists() {
        setPrimaryListsToEnums();

        List<List<BottleList>> theListOfLists = new ArrayList<List<BottleList>>();
        theListOfLists.add(primaryLists);
        theListOfLists.add(customLists);
        theListOfLists.add(viewOnlyLists);

        allTheLists.addAll(getPrimaryLists());
        allTheLists.addAll(getCustomLists());
        allTheLists.addAll(getViewOnlyLists());
    }

    public static TheListOfLists getInstance() {
        return instance;
    }

    private void setPrimaryListsToEnums() {
        primaryLists.add(PrimaryBottleLists.getInstanceRED_BOTTLES());
        primaryLists.add(PrimaryBottleLists.getInstanceWHITE_BOTTLES());
        primaryLists.add(PrimaryBottleLists.getInstanceROSE_BOTTLES());
    }

//    public void addListToTheListOfLists(BottleList bList) {
//        if (bList.isPrimaryList()) { primaryLists.add(bList); }
//        if (!bList.isAddableView()) { viewOnlyLists.add(bList); }
//        if (bList.isAddableView() && !bList.isPrimaryList()) { customLists.add(bList); }
//    }

    public BottleList getBottleListByName(String listName) {
        BottleList bottleList1 = new BottleList();
        for (BottleList bList : allTheLists ) {
            if (bList.getName().equals(listName)) {
                bottleList1 = bList;
            }
        }
        return bottleList1;
    }

    public List<BottleList> getPrimaryLists() { return primaryLists; }

    public List<BottleList> getCustomLists() { return customLists; }

    public List<BottleList> getViewOnlyLists() { return viewOnlyLists; }

    public void addToPrimaryLists(BottleList bottleList) { primaryLists.add(bottleList); }

    public void addToCustomLists(BottleList bottleList) { customLists.add(bottleList); }

    public void addToViewOnlyLists(BottleList bottleList) { viewOnlyLists.add(bottleList); }

    public List<BottleList> getAllListsAsFlatList() { return allTheLists; }

    public List<String> getAllListsByName() {
        List<String> allListNames = new ArrayList<>();
        allTheLists.forEach(bottleList -> { allListNames.add(
                bottleList.getName()); }
        );
        return allListNames;
    }

    public void setSubListsOfTheListOfLists(List<BottleList> allTheLists) { //decide if this is datfile object to replace
        allTheLists.forEach(list -> {
            if (list.isPrimaryList()) { addToPrimaryLists(list); }
            if (!list.isPrimaryList() && list.isAddableView()) { addToCustomLists(list);}
            if (!list.isAddableView()) { addToViewOnlyLists(list); }
        });
    }

    public List<BottleList> getAllAffectableLists() {
        List<BottleList> listsForUserToAffect = new ArrayList<>();
        listsForUserToAffect.addAll(getPrimaryLists());
        listsForUserToAffect.addAll(getCustomLists());

        return listsForUserToAffect;
    }

    public List<String> removeBottleFromAllLists(BottleProfile bottleProfile) {
        List<String> listsRemovedFrom = new ArrayList<>();
        TheListOfLists.getInstance().getAllAffectableLists().forEach(list -> {
            if (list.getBottleProfilesList().contains(bottleProfile) && list.isAddableView()) {
                list.removeBottleProfile(bottleProfile);
                listsRemovedFrom.add(list.getName());
            }
        });

        return listsRemovedFrom;
    }

    public void displayAllLists() {
        List<BottleList> allTheLists = getAllListsAsFlatList();
        allTheLists.forEach(bList -> {
            int i = allTheLists.indexOf(bList);
            if ( bList.isPrimaryList()) { System.out.println(i + " : Primary List :  " + bList.getName()); }
            if (!bList.isAddableView()) { System.out.println(i + " : Follow List  :  " + bList.getName()); }
            if (bList.isAddableView() && !bList.isPrimaryList()) {
                System.out.println(i + " : Custom List  :  " + bList.getName());}
        });
    }

    public void displayPrimaryLists() {
        List<BottleList> bLists = getPrimaryLists();
        bLists.forEach(bList -> {
            int i = bLists.indexOf(bList);
            System.out.println(i + " : Primary List : " + bList.getName());
        });
    }

    public void updateAllListsWithServerlessCellarDataBase() {

    }

//    public void displayAllAffectableLists() {
//        for (BottleList bList : getAllAffectableLists()) {
//            int i = getAllAffectableLists().indexOf(bList);
//            if( bList.isPrimaryList()) { System.out.println(i + " : Primary List : " + bList.getName()); }
//            if(!bList.isPrimaryList()) { System.out.println(i + " : Custom List  : " + bList.getName()); }

//        }

//    }
//    public void displayViewOnlyLists() {
//        List<BottleList> vLists = getViewOnlyLists();
//        vLists.forEach(bList ->  { int i = vLists.indexOf(bList);
//            System.out.println(i + " : Follow List  :  " + bList.getName());
//        });

//    }

}
//    public void postTheListOfLists() { // will need to parse back out to List<BottleList>
//        listOfBottleListsToJson = new ListOfBottleListsToJson(instance);
//
//    }

//    public List<List<BottleList>> getTheListOfLists() { // will need to parse back out to List<BottleList>
//
//        return theListOfLists;
//    }