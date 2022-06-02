package MethodClasses;

import Handlers.BottleHandler;
import Handlers.BottleListsHandler;
import POJOs.BottleList;
import POJOs.BottleProfile;

import java.util.*;

import static Handlers.BottleHandler.userMenus;

public class LocateBottle {
    BottleList bottleList;
    BottleProfile correctBottle;
    int displayedIndex;
    Scanner sc = new Scanner(System.in);

    public void userChooseLocateMethod(BottleList bottleList) { // make return correct bottle
        System.out.println("""
                Locate bottle :
                1 : by entering part of the name
                2 : by selecting it from this list""");
        int nextChoice = sc.nextInt();

        while (nextChoice != 1 && nextChoice != 2) {
            System.out.println("\n\nPlease try again");
            nextChoice = sc.nextInt();
        }
        if ((sc.nextInt() == 1)) { userInputLocateBottleByWords(bottleList, 3); }
        userInputLocateBottleByIndexNumber(bottleList);
    }

    private void userInputLocateBottleByIndexNumber(BottleList bottleList) {
        new DisplayBottlesTable(bottleList);
        System.out.println("Enter the number on this list of the exact bottle you are looking for -> ");
        int i = sc.nextInt();
        BottleProfile correctBottle = bottleList.getBottleProfilesList().get(i);
        System.out.print(correctBottle);

        userNextChoice(this.bottleList,correctBottle);
    }

    private void userInputLocateBottleByWords(BottleList bottleList, int maxAttempts) {
        this.bottleList = bottleList;
        System.out.println("Try entering in a word(s) in the bottle name you are looking for -> ");
        String name = sc.nextLine();

        List<BottleProfile> resultsList = LocateBottle.locateBottleByNameMultiItemReturnList(bottleList, name);
        if (resultsList.isEmpty()) {
            while (maxAttempts > 0) { System.out.println("Let's try that again");
                userInputLocateBottleByWords(bottleList, maxAttempts--);
            }
            userInputLocateBottleByIndexNumber(bottleList);
        }
        userInputLocateBottleByIndexNumber((BottleList) resultsList);
    }

    private static List<BottleProfile> locateBottleByNameMultiItemReturnList(BottleList bottleList, String nameAttempt) {
        List<BottleProfile> searchList = new ArrayList<>();

        for (BottleProfile bottleProfile : bottleList.getBottleProfilesList()) {
            if (bottleProfile.getName().toLowerCase().contains(nameAttempt.toLowerCase())) {
                searchList.add(bottleProfile);
            }
        }
        return searchList;
    }

    private static void highlightBottleInTempList(BottleList bottleList, BottleProfile bottleProfile) {
        String stars = "*****************************************************************************";
        String sortOrder = "6352140";
        SortBottleList sortACellarList = new SortBottleList();
        sortACellarList.passedInListSort(bottleList, sortOrder);

        Iterator<BottleProfile> iterator = bottleList.getBottleProfilesList().iterator();
        while (iterator.hasNext()) {
            BottleProfile b = iterator.next();
            System.out.println(b);
            if (b == bottleProfile) {
                System.out.println(stars);
                System.out.println(b); iterator.next();
                System.out.println(stars);
            }
            System.out.println(b);
        }
        userMenus.mainMenu();
    }

    private void addLocatedBottleToAnotherList(BottleProfile bottleProfile) {
        BottleListsHandler bottleListsHandler = new BottleListsHandler();
        BottleList listToAddBottleTo = bottleListsHandler.userSelectBottleList();
        bottleListsHandler.addBottleToThisList(listToAddBottleTo, bottleProfile);

        bottleListsHandler.userManageBottleList(listToAddBottleTo);
    }

    private void userNextChoice(BottleList bottleList, BottleProfile bottleProfile) {
        this.bottleList = bottleList;
        this.correctBottle = bottleProfile;

        if (!bottleList.isAddableView()) { userSwitchForViewOnlyListNextChoice(); }
        userSwitchForAddableViewListNextChoice();
    }

    private void userSwitchForViewOnlyListNextChoice() {
        int nextChoice = -1;
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n1 : View this bottle highlited in context of other bottles in " + this.bottleList.getName());
        System.out.println("\n2 : Re-enter Your Serverless Cellar main gateway\n");

        nextChoice = sc.nextInt();
        switch (nextChoice) {
            case 1 -> highlightBottleInTempList(this.bottleList, this.correctBottle);
            case 2 -> userMenus.mainMenu();
            default -> userNextChoice(this.bottleList, this.correctBottle);
        }
    }

    private void userSwitchForAddableViewListNextChoice() {// make block string
        int nextChoice = -1;
        System.out.println("\nnWould you like to update this bottle or see it in a sorted list?");
        System.out.println("\n1 : View this bottle highlited in context of other bottles in " + this.bottleList.getName());
        System.out.println("\n2 : Re-enter Your Serverless Cellar main gateway\n");
        System.out.println("\n3 : Update " + this.correctBottle.getName());
        System.out.println("\n4 : Add " + this.correctBottle.getName() + " to another list you've created");
        System.out.println("\n5 : Remove " + this.correctBottle.getName() + " from " + this.bottleList.getName());

        nextChoice = sc.nextInt();
        switch (nextChoice) {
            case 1 -> highlightBottleInTempList(this.bottleList, this.correctBottle);
            case 2 -> userMenus.mainMenu();
            case 3 -> BottleHandler.userSwitchSelectAttributeToSet(this.bottleList, this.correctBottle);
            case 4 -> addLocatedBottleToAnotherList(this.correctBottle);
            case 5 -> new BottleListsHandler(bottleList).userRemoveBottleFromThisList(bottleList, correctBottle);
            default -> userNextChoice(this.bottleList, this.correctBottle);
        }
    }
}