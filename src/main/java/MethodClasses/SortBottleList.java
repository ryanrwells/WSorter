package MethodClasses;

import POJOs.BottleList;
import POJOs.BottleProfile;

import java.util.*;

import static Handlers.BottleHandler.userMenus;

public class SortBottleList {
    private BottleList bottleList;
    Scanner sc = new Scanner(System.in);

    public SortBottleList() {
    }

//    public CellarSort(BottleList bottleList) {
//        this.bottleList = bottleList;
//    }

    private void userSortNext(){
        System.out.println("1 : Sort this list another way");
        System.out.println("2 : Re-enter Your Serverless Cellar main gateway\n");
        int nextRequest = sc.nextInt();

        switch (nextRequest) {
            case 1 -> userInputListSort(this.bottleList);
            case 2 -> userMenus.mainMenu();
            default -> userSortNext();
        }
    }

    public void userInputListSort(BottleList bottleList) { // select bottle method
        System.out.println("""

                Prioritize your sort by entering a list of attributes from priority to last.
                
                0 : Bottle name (the name of the bottle)
                1 : Winery (the Winery/Château/Producer bringing you this bottle)
                2 : Style (the style is a distinct production method, terroir, or composition of grapes)
                3 : abv (alcohol by volume)
                4 : Varietal composition (the grapes making this wine, in descending order of volume contirbution)
                5 : OriginTree (the wine region of production, from country to local terroir)
                6 : My Rating (your Impression rating)

                You shall have all 6 numbers represented and 0.
                popular cellar sorts include:\s
                   by Varietal : 4256130 ;
                   by Region   : 5634120 ;
                   by Winery   : 1045623""");
        passedInListSort(bottleList, sc.nextLine());
        System.out.println(this.bottleList + "\n\n");

        userSortNext();
    }

    public void passedInListSort(BottleList bottleList, String sortOrder) {
        LinkedList<Character> reverseOrder = new LinkedList<>();
        for (char ch : sortOrder.toCharArray()) { reverseOrder.addFirst(ch); }

        char[] charSet = {'0', '1', '2', '3', '4', '5', '6'};
        if (reverseOrder.contains(charSet) && reverseOrder.size() == 7) {//verify
            this.bottleList = decommissionSort(prioritizedSort(bottleList, reverseOrder));
        }
        userInputListSort(this.bottleList);
    }

    private BottleList decommissionSort(BottleList bottleList) {
        this.bottleList = bottleList;
        Comparator<BottleProfile> decommissionedLast = Comparator.comparing(BottleProfile::getAvailabilityStatus);
        this.bottleList.getBottleProfilesList().sort(decommissionedLast);
        return this.bottleList;
    }

    private BottleList prioritizedSort(BottleList bottleList, LinkedList<Character> order) {
        Character[] newOrder = order.toArray(order.toArray(new Character[0]));
        for (char c : newOrder) {
            switch (c) {
                case '0' -> {
                    Comparator<BottleProfile> bottleNameComparator = Comparator.comparing(BottleProfile::getName);
                    this.bottleList.getBottleProfilesList().sort(bottleNameComparator);
                }
                case '1' -> {
                    Comparator<BottleProfile> wineryComparator = Comparator.comparing(BottleProfile::getWineryName);
                    this.bottleList.getBottleProfilesList().sort(wineryComparator);
                }
                case '2' -> {
                    Comparator<BottleProfile> vintageComparator = Comparator.comparing(BottleProfile::getVintage,
                            Comparator.reverseOrder());
                    this.bottleList.getBottleProfilesList().sort(vintageComparator);
                }
                case '3' -> {
                    Comparator<BottleProfile> styleComparator = Comparator.comparing(BottleProfile::getStyle);
                    this.bottleList.getBottleProfilesList().sort(styleComparator);
                }
                case '4' -> {
                    Comparator<BottleProfile> abvComparator = Comparator.comparing(BottleProfile::getAbv,
                            Comparator.reverseOrder());
                    this.bottleList.getBottleProfilesList().sort(abvComparator);
                }
                case '5' -> {
                    Comparator<BottleProfile> varietalComparator = Comparator.comparing(BottleProfile::getPrimaryVarietal);
                    this.bottleList.getBottleProfilesList().sort(varietalComparator);
                }
                case '6' -> {
                    Comparator<BottleProfile> impressionComparator = Comparator.comparing(BottleProfile::getImpressionRatingOnly,
                            Comparator.reverseOrder());
                    this.bottleList.getBottleProfilesList().sort(impressionComparator);
                }
            }
        }
        return bottleList;
    }
}




