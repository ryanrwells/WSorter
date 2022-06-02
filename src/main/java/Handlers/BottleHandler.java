package Handlers;

import POJOs.*;

import java.util.Scanner;

import static POJOs.PrimaryBottleLists.*;

public class BottleHandler {
    public static UserMenus userMenus  = UserMenus.getInstance();
    private final static Scanner sc = new Scanner(System.in);

    public static void nextUpdateRequest(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println(bottleProfile);
        System.out.println("\n1 : Set another attribute of this bottle, or");
        System.out.println("\n2 : Re-enter Your Serverless Cellar main gateway");
        int nextRequest = sc.nextInt();
        switch (nextRequest) {
            case 1 -> userSwitchSelectAttributeToSet(bottleList, bottleProfile);
            case 2 -> userMenus.mainMenu();
            default -> nextUpdateRequest(bottleList, bottleProfile);
        }
    }

    private static void userUpdateBottleName(BottleList bottleList, BottleProfile bottleProfile) {
            System.out.println("\n\nEnter the name of this bottle for Your Serverless Cellar -->");
            String bottleNameUpdate = sc.nextLine();
            bottleProfile.setName(bottleNameUpdate);
            System.out.println("\nYour bottle has been updated to " + bottleNameUpdate + " in list " + bottleList.getName());
            nextUpdateRequest(bottleList, bottleProfile);
    }

    private static void userUpdateWinery(BottleList bottleList, BottleProfile bottleProfile) {
        //system out print the bottles
        System.out.println("""

                Enter the name of the parent Winery, Château, or Producer\s
                (e.g. Prisoner Wine Co., Château Haut-Brion, Trader Joes) -->""");
        String wineryUpdate = sc.nextLine();
        bottleProfile.setWineryName(wineryUpdate);
        System.out.println("\nYour Winery has been set to " + wineryUpdate + " for " + bottleProfile.getName());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    private static void userUpdateVintageOrAddAsNewBottle(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("""
                                
                Enter what you would like to do next :
                1 : Add a new vintage of this existing bottle, with new notes and a new Impression rating
                2 : Update the existing bottle to the correct vintage""");
        int next = sc.nextInt();

        switch (next) {
            case 1 -> userSetVintageNewBottle(bottleList, bottleProfile);
            case 2 -> userUpdateVintage(bottleList, bottleProfile);
            default -> nextUpdateRequest(bottleList, bottleProfile);
        }
    }

    private static void userUpdateVintage(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("\n\nEnter the four digit year for the bottle you are updating -->");
        Integer yearUpdate = sc.nextInt();
        bottleProfile.setVintage(yearUpdate);
        System.out.println("\nYou have set the vintage to " + yearUpdate + " for " + bottleProfile.getName());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    private static void userUpdateStyle(BottleList bottleList, BottleProfile bottleProfile) {
        new StyleAndOakingPair().userInputStyleAndOakingPair(bottleList, bottleProfile);
    }

    private static void userUpdateAbv(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("\n\nEnter the abv % number for the bottle you are updating (ex. 11.1) -->");
        double abvUpdate = sc.nextDouble();
        bottleProfile.setAbv(abvUpdate);
        System.out.println("\nYou have set the abv to " + abvUpdate + "% for " + bottleProfile.getName());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    public static void userUpdateComposition(BottleList bottleList, BottleProfile bottleProfile) {
        new CompositionUserBuilder(bottleList, bottleProfile).userBuildCompositionList();
    }

    private static void userUpdateOrginTree(BottleList bottleList, BottleProfile bottleProfile) {
        new OriginTree(bottleList, bottleProfile).userSetOriginTree();
    }

    private static void userUpdateImpressionRating(BottleList bottleList, BottleProfile bottleProfile) {
        if (bottleProfile.getImpression().getRating() == 0.0) { userSetFirstImpressionNewBottle(bottleList, bottleProfile); }

        System.out.println("You may update your rating, and the initial add-in date will remain the same");
        double impressionRating = sc.nextDouble();
        bottleProfile.getImpression().setNewRating(impressionRating); // defensive copy
        System.out.println("\nYou have updated the Impression Rating to " + impressionRating + " out of 5.0 for "
                + bottleProfile.getName());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    private static void userUpdateNotes(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("\n\nUpdate your notes for this bottle -->");
        String notes = sc.nextLine();
        bottleProfile.setNotes(notes);
        System.out.println("\nYou have updated your notes for " + bottleProfile.getName());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    private static void userUpdateAvailabilityStatus(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("""
                
                All bottles are defaulted to 'Current' status, though you may want a bottle to be'decommissioned'
                because it is no longer accessible or is otherwise to be decidedly 'de-prioritized' when looking
                through your Serverless Cellar lists
                 Enter a 'C' for current or a 'd' for now decommissioned -->""");
        String current = "C", decommissioned = "d";
        String isDcomd = sc.nextLine();
        if (!isDcomd.equalsIgnoreCase(current) && !isDcomd.equalsIgnoreCase(decommissioned)) {
            System.out.println("\n let's try that again, you can always update this again later");
            userUpdateAvailabilityStatus(bottleList, bottleProfile);
        }

        bottleProfile.setAvailabilityStatus(isDcomd);
        String status = isDcomd.equalsIgnoreCase("C") ? current : decommissioned;
        System.out.println("\nYou have set availability status to '" + status + "' for " + bottleProfile.getName());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    public static void addNewBottleIntro(BottleList bottleList) { //will add to list when complete
        BottleProfile newBottle = new BottleProfile();
        System.out.println("\n\nA new bottle must have at least a name, vintage, Impression rating, and primary list.");
        userSetBottleNameNewBottle(bottleList, newBottle);
    }

    private static void userSetBottleNameNewBottle(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("\n\nEnter the name of this bottle to add to Your Serverless Cellar -->");
        String nameForNewBottle = sc.nextLine();
        bottleProfile.setName(nameForNewBottle);
        System.out.println("\nYour bottle has been set to " + nameForNewBottle + " in list " + bottleList.getName());
        userSetVintageNewBottle(bottleList, bottleProfile);
    }

    private static void userSetVintageNewBottle(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("\n\nEnter the four digit year for the vintage you are adding -->");
        Integer yearUpdate = sc.nextInt();
        bottleProfile.setVintage(yearUpdate);
        System.out.println("\nYou have the vintage " + yearUpdate + " for " + bottleProfile.getName());
        userSetFirstImpressionNewBottle(bottleList, bottleProfile);
    }

    private static void userSetFirstImpressionNewBottle(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.println("""

                Set the Impression Rating for this bottle, from 0.0 to 5.0 (with one decimal place)
                 *if the score is too low, it may not be worth adding to your Cellar, a 5.0 being perfection -->""");
        double impressionRating = sc.nextDouble();
        if (impressionRating < 0.0 || impressionRating > 5.0) {
            System.out.println("let's try that again");
            userSetFirstImpressionNewBottle(bottleList, bottleProfile);
        }

        Impression impression = new Impression(impressionRating);
        bottleProfile.setImpression(impression);
        System.out.println("\nYou have updated the Impression Rating to " + impressionRating + " out of 5.0 for "
                + bottleProfile.getName());
        userSetPrimaryListNewBottle(bottleList, bottleProfile);
    }

    private static void userSetPrimaryListNewBottle(BottleList bottleList, BottleProfile bottleProfile) {
        if (bottleList.isPrimaryList()) { bottleProfile.setPrimaryList(bottleList); }
        if (!bottleProfile.getPrimaryList().isEmpty()) { addBottlesToLists(bottleList, bottleProfile); }

        BottleList primaryList = new BottleList();
        System.out.println("""

                This bottle list is a custom list, assign also this bottle to a primary list :\s
                1 : REDS
                2 : WHITES
                3 : Rosés""");
        int primeInt = sc.nextInt();
        switch (primeInt) {
            case 1 -> primaryList = getInstanceRED_BOTTLES();
            case 2 -> primaryList = getInstanceWHITE_BOTTLES();
            case 3 -> primaryList = getInstanceROSE_BOTTLES();
            default -> userSetPrimaryListNewBottle(bottleList, bottleProfile);
        }
        bottleProfile.setPrimaryList(primaryList);
        addBottlesToLists(bottleList, bottleProfile);
    }

    private static void addBottlesToLists(BottleList bottleList, BottleProfile bottleProfile) {
        bottleList.addBottleProfile(bottleProfile);
        if(bottleList.isPrimaryList()) {
            System.out.println("Your bottle has been successfuly added to primary list " + bottleList.getName());
            nextUpdateRequest(bottleList, bottleProfile);
        }

        PrimaryBottleLists.getPrimaryBottleListByName(bottleList.getName()).addBottleProfile(bottleProfile);
        System.out.println("\nYour bottle " + bottleProfile.getName() + " has been added to " + bottleList.getName() +
                " primary list " + bottleProfile.getPrimaryList() + ". You may update, add, or remove it from your" +
                " custom lists without affecting your primary list, " + bottleProfile.getPrimaryList());
        nextUpdateRequest(bottleList, bottleProfile);
    }

    public static void userSwitchSelectAttributeToSet(BottleList bottleList, BottleProfile bottleProfile) {
        System.out.print("""
                              
                1  : NAME       -> update the Name of your bottle" + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                2  : WINERY     -> update the Winery name for " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                3  : VINTAGE    -> update the Vintage of " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                4  : STYLE      -> update the 'Style' of " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                5  : ABV        -> update the ABV of " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                6  : COMPOSITON -> update the varietal Composition of " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                7  : REGION     -> update the Region of origin for " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                8  : RATE IT    -> update your current Impression Rating for " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                9  : NOTES      -> update your Notes on " + bottleProfile.getName() + " " + bottleProfile.getVintage() +
                10 : Decommission this bottle's availability status""");
        System.out.println("\n\nEnter the attribute number to update");
        int nextRequest = sc.nextInt();
        switch(nextRequest) {
            case 1 -> userUpdateBottleName(bottleList, bottleProfile);
            case 2 -> userUpdateWinery(bottleList, bottleProfile);
            case 3 -> userUpdateVintageOrAddAsNewBottle(bottleList, bottleProfile);
            case 4 -> userUpdateStyle(bottleList, bottleProfile);
            case 5 -> userUpdateAbv(bottleList, bottleProfile);
            case 6 -> userUpdateComposition(bottleList, bottleProfile);
            case 7 -> userUpdateOrginTree(bottleList, bottleProfile);
            case 8 -> userUpdateImpressionRating(bottleList, bottleProfile);
            case 9 -> userUpdateNotes(bottleList, bottleProfile);
            case 10 -> userUpdateAvailabilityStatus(bottleList, bottleProfile);
            default -> nextUpdateRequest(bottleList, bottleProfile);
        }
    }
}

