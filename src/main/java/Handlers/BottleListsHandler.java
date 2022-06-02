package Handlers;

import MethodClasses.DisplayBottlesTable;
import MethodClasses.SortBottleList;
import MethodClasses.LocateBottle;
import POJOs.BottleList;
import POJOs.BottleProfile;

import java.util.List;
import java.util.Scanner;

public class BottleListsHandler {
    TheListOfLists theListOfLists = TheListOfLists.getInstance();
    UserMenus userMenus  = UserMenus.getInstance();
    BottleList bottleList;
    LocateBottle findBottle;
    SortBottleList sort;
    Scanner sc = new Scanner(System.in);

    public BottleListsHandler() {
    }

    public BottleListsHandler(BottleList bottleList) {
        this.bottleList = bottleList;
    }
    
    public void userManageBottleList(BottleList bottleList) {
        this.bottleList = bottleList;
        if (!this.bottleList.isAddableView() ) { userSwitchForViewOnlyList(this.bottleList); }
        if (!this.bottleList.isPrimaryList() ) { userSwitchForAffectableList(this.bottleList); }
        userSwitchForPrimaryList(this.bottleList);
    }

    public BottleList userSelectBottleList() {
        System.out.println("\nCurrent Lists in Your Serverless Cellar");
        TheListOfLists.getInstance().displayAllLists();
        System.out.println("\nSelect a list by number -->");
        int i = sc.nextInt();
        return bottleList = TheListOfLists.getInstance().getAllListsAsFlatList().get(i);
    }

    public BottleList userSelectPrimaryBottleList() {
        System.out.println("\nSelect a Primary List where bottles are safe from deletion as you modify your custom lists");
        TheListOfLists.getInstance().displayPrimaryLists();
        System.out.println("\nSelect a list by number -->");
        int i = sc.nextInt();
        return bottleList = TheListOfLists.getInstance().getPrimaryLists().get(i);
    }

    public void userCreateCustomList() {
        bottleList = new BottleList();
        bottleList.setAddableView(true);
        System.out.println("What is the name of this new list -->");
        bottleList.setName(sc.nextLine());
        theListOfLists.addToCustomLists(bottleList);
        System.out.println("The new updatable list " + bottleList.getName() + " has been added to Your Serverless Cellar");

        userSwitchForAffectableList(this.bottleList);
    }

    public void userAddBottleFromAnotherList(BottleList toThisBottleList) {
        this.bottleList = toThisBottleList;
        BottleList listToAddFrom = userGetListToAddFrom();
        new DisplayBottlesTable(listToAddFrom);
        System.out.println("\n Now add bottle number from " + listToAddFrom.getName() + " list for to add into " + this.bottleList);
        int i = sc.nextInt();
        addBottleToThisList(this.bottleList, listToAddFrom.getBottleProfilesList().get(i));

        userManageBottleList(this.bottleList);
    }

    public void addBottleToThisList(BottleList bottleList, BottleProfile bottleProfile) {
        this.bottleList = bottleList;
        if (!bottleList.isPrimaryList()) { userSelectPrimaryBottleList().addBottleProfile(bottleProfile); }
        this.bottleList.addBottleProfile(bottleProfile);
        System.out.println("You have successfully set " + bottleProfile.getName() + " to " + bottleList.getName());
    }

    public void userAddMultipleBottlesFromAnotherList(BottleList bottleList) {
        this.bottleList = bottleList;
        BottleList listToAddFrom = userGetListToAddFrom();
        List<BottleProfile> bottlesToAdd = null;
        new DisplayBottlesTable(listToAddFrom);
        this.bottleList.addMultipleBottlesFromAnotherList(userRecursiveMakeBottlesToAddList(listToAddFrom, bottlesToAdd));
        System.out.println("All bottles have been added");

        userManageBottleList(this.bottleList);
    }

    private List<BottleProfile> userRecursiveMakeBottlesToAddList(BottleList donorList, List<BottleProfile> bottlesToAdd) {
        System.out.println("\n1 : Add a bottle number from " + donorList.getName() + " list, for to add into " + this.bottleList);
        System.out.println("\n2 : Finished loading bottles from " + donorList.getName());
        if (sc.nextInt() != 2) {
            System.out.println("Enter a bottle number from the above list, " + donorList.getName());
            int bottle = sc.nextInt();
            bottlesToAdd.add(donorList.getBottleProfilesList().get(bottle));
            userRecursiveMakeBottlesToAddList(donorList, bottlesToAdd);
        }

        return bottlesToAdd;
    }

    public void userRemoveBottleFromThisList(BottleList bottleList, BottleProfile bottleProfile) {
        this.bottleList = bottleList;
        if (!this.bottleList.isPrimaryList()) { removeFromCustomLists(bottleProfile);
        } else { removeFromAllLists(bottleProfile); }

        userManageBottleList(this.bottleList);
    }

    private void removeFromAllLists(BottleProfile bottleProfile) {
        List<String> removedFrom = theListOfLists.removeBottleFromAllLists(bottleProfile);
        System.out.println("You have successfully removed "+ bottleProfile.getName() +
                " from lists " + removedFrom);
    }

    private void removeFromCustomLists(BottleProfile bottleProfile) {
        bottleList.removeBottleProfile(bottleProfile);
        System.out.println("You have successfully removed "+ bottleProfile.getName() +
                " from " + bottleList.getName());
        System.out.println("\nThis bottle is still accessible in "+ bottleProfile.getPrimaryList());
    }

    public BottleList userGetListToAddFrom() {
        System.out.println("Select a bottle list to add bottles FROM and into " + this.bottleList.getName());
        System.out.println(TheListOfLists.getInstance().getAllAffectableLists());
        int nextInt = sc.nextInt();

        return TheListOfLists.getInstance().getAllAffectableLists().get(nextInt);
    }

    private void userSwitchForViewOnlyList(BottleList bottleList) {
        System.out.println("""
                
                What would you like to do with this list?
                1 : Sort and view this shared list
                2 : Return to Your Serverless Cellar gateway""");
        int nextRequest = sc.nextInt();
        switch (nextRequest) {
            case 1 -> sort.userInputListSort(this.bottleList);
            case 2 -> userMenus.mainMenu();
            default -> userManageBottleList(bottleList);
        }
    }

    private void userSwitchForAffectableList(BottleList bottleList) {
        System.out.println(""" 
                                
                What would you like to do with this list?
                1 : Sort and view
                2 : Add new bottle
                3 : Update or Remove an existing bottle from this list
                4 : View profile of an existing bottle in this list
                5 : Add one bottle to this list from another one of your lists
                6 : Add multiple bottles to this list from another one of your lists
                7 : Select or create another list for Your Serverles Cellar
                8 : Re-enter Your Serverless Cellar
                Enter the number -->""");
        int nextRequest = sc.nextInt();
        switch (nextRequest) {
            case 1 -> sort.userInputListSort(this.bottleList);
            case 2 -> BottleHandler.addNewBottleIntro(this.bottleList);
            case 3, 4 -> this.findBottle.userChooseLocateMethod(this.bottleList);
            case 5 -> userAddBottleFromAnotherList(this.bottleList);
            case 6 -> userAddMultipleBottlesFromAnotherList(this.bottleList);
            case 7 -> userSelectBottleList();
            case 8 -> userMenus.mainMenu();
            default -> userManageBottleList(bottleList);
        }
    }

    private void userSwitchForPrimaryList(BottleList bottleList) {
        System.out.println(""" 
                
                What would you like to do with this list?
                1 : Sort and view
                2 : Add new bottle
                3 : Update or decommission an existing bottle in this list
                4 : View profile on an existing bottle in this list
                5 : Select or create another list from your Cellar
                6 : Re-enter Your Serverless Cellar
                Enter the number -->""");
        int nextRequest = sc.nextInt();
        switch (nextRequest) {
            case 1 -> sort.userInputListSort(this.bottleList);
            case 2 -> BottleHandler.addNewBottleIntro(this.bottleList);
            case 3, 4 -> this.findBottle.userChooseLocateMethod(this.bottleList);
            case 5 -> userSelectBottleList();
            case 6 -> userMenus.mainMenu();
            default -> userManageBottleList(bottleList);
        }
    }
}



