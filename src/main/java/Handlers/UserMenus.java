package Handlers;

import MethodClasses.SortBottleList;
import MethodClasses.LocateBottle;
import POJOs.*;

import java.util.Scanner;

public class UserMenus {
    private String mainPrompts = "";
    private final String compositionPrompts = "";
    private final String originPrompts = "";
    private BottleProfile bottleProfile;
    private BottleList bottleList;
    private BottleListsHandler bottleListstHandler;
    private LocateBottle findBottle;
    private static UserMenus instance = new UserMenus();
    private Scanner sc = new Scanner(System.in);


    private UserMenus() {
    }

    public static UserMenus getInstance() {
        return instance;
    }

    public void mainMenu() {
        System.out.println("                                Enter Your ServerLess Cellar by Number");
        System.out.println("           wWWWw            ");
        System.out.println("         wWW***WWw          1 : sort, view, or create a cellar list");
        System.out.println("        wWW*****WWw         ");
        System.out.println("         wWW***WWw          2 : add another bottle to your cellar");
        System.out.println("           wW*Ww            ");
        System.out.println("          wWw*wWw           3 : find or update a bottle");
        System.out.println("         wWW***WWw          ");
        System.out.println("        Www*****wwW         4 : decommission a bottle in your cellar");
        System.out.println("______________________________________________________________________");
        System.out.println("exit your cellar activities by entering 5");


        int activity = sc.nextInt();
        if (activity < 1 || activity > 5) {
            System.out.println("\nPlease try again");
            System.out.println(mainPrompts);
        }
// activity control
        switch (activity) {
            case 1 -> {
                int next = sc.nextInt();
                System.out.println("1 : sort existing list, or\n" +
                                   "2 : create a new list");
                while (next != 1 && next != 2) {
                       next = sc.nextInt();
                       System.out.println("\nPlease try again");
                }

                if (next == 1) {
                    this.bottleList = bottleListstHandler.userSelectBottleList();
                    new SortBottleList().userInputListSort(bottleList);
                }

                if (next == 2) { bottleListstHandler.userCreateCustomList(); }
            }
            case 2 -> {
                this.bottleList = bottleListstHandler.userSelectBottleList();
                if (!this.bottleList.isAddableView()) {
                    BottleHandler.addNewBottleIntro(bottleList);
                }
                System.out.println("Add bottles to your private cellar lists only\n\n");
                mainMenu();
            }
            case 3 -> {
                this.bottleList = bottleListstHandler.userSelectBottleList();
                if (!this.bottleList.isAddableView()) {
                    this.findBottle.userChooseLocateMethod(this.bottleList);
                }
                System.out.println("\n*bottle profiles from third-party lists are viewable but not updatable");
                this.findBottle.userChooseLocateMethod(this.bottleList);
            }
            case 4 -> {
                this.bottleList = bottleListstHandler.userSelectBottleList();
                if (this.bottleList.isAddableView()) {
                    this.findBottle.userChooseLocateMethod(this.bottleList);
                }
                System.out.println("You may only decommission bottles from lists of your created cellar\n\n");
                mainMenu();
            }
            case 5 -> {
                sc.close();

                //mapper action update three lists

                System.out.println("For your convienience, all updates have been set into your Serveless Cellar ");
            }
        }
    }
}





