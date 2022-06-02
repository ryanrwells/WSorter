package POJOs;

import Enums.ORIGIN;
import Handlers.BottleHandler;

import java.util.Arrays;
import java.util.Scanner;

public class OriginTree {
    public BottleList bottleList;
    public BottleProfile bottleProfile;

    public OriginTree() {
    }

    public OriginTree(BottleList bottleList, BottleProfile bottleProfile) {
        this.bottleList = bottleList;
        this.bottleProfile = bottleProfile;
    }

    public void userSetOriginTree() {
        Scanner sc = new Scanner(System.in);
        Arrays.stream(ORIGIN.COUNTRIES.values()).forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
        System.out.println("\n\n Enter the number of the corresponding country of Origin from the list above.");
        int countryCode = sc.nextInt();

        switch (countryCode) {
            case 0 -> {
                Arrays.stream(ORIGIN.AREGENTINA_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String argRegion = String.valueOf(ORIGIN.AREGENTINA_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(argRegion);
                System.out.println("\nYou have updated Origin to " + argRegion);
            }
            case 1 -> {
                Arrays.stream(ORIGIN.AUSTRIA_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String astRegion = String.valueOf(ORIGIN.AUSTRIA_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(astRegion);
                System.out.println("\nYou have updated Origin to " + astRegion);
            }
            case 2 -> {
                Arrays.stream(ORIGIN.AUSTRALIA_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String ausRegion = String.valueOf(ORIGIN.AUSTRALIA_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(ausRegion);
                System.out.println("\nYou have updated Origin to " + ausRegion);
            }
            case 3 -> {
                Arrays.stream(ORIGIN.CANADA_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String canRegion = String.valueOf(ORIGIN.CANADA_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(canRegion);
                System.out.println("\nYou have updated Origin to " + canRegion);
            }
            case 4 -> {
                Arrays.stream(ORIGIN.CHILE_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String chiRegions = String.valueOf(ORIGIN.CHILE_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(chiRegions);
                System.out.println("\nYou have updated Origin to " + chiRegions);
            }
            case 5 -> {
                Arrays.stream(ORIGIN.SPAIN_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String espRegion = String.valueOf(ORIGIN.SPAIN_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(espRegion);
                System.out.println("\nYou have updated Origin to " + espRegion);
            }
            case 6 -> {
                Arrays.stream(ORIGIN.FRANCE_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String fraRegion = String.valueOf(ORIGIN.FRANCE_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(fraRegion);
                System.out.println("\nYou have updated Origin to " + fraRegion);
            }
            case 7 -> {
                Arrays.stream(ORIGIN.GERMANY_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String deuRegion = String.valueOf(ORIGIN.GERMANY_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(deuRegion);
                System.out.println("\nYou have updated Origin to " + deuRegion);
            }
            case 8 -> {
                Arrays.stream(ORIGIN.HUNGARY_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String hunRegion = String.valueOf(ORIGIN.HUNGARY_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(hunRegion);
                System.out.println("\nYou have updated Origin to " + hunRegion);
            }
            case 9 -> {
                Arrays.stream(ORIGIN.ITALY_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String itaRegion = String.valueOf(ORIGIN.ITALY_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(itaRegion);
                System.out.println("\nYou have updated Origin to " + itaRegion);
            }
            case 10 -> {
                Arrays.stream(ORIGIN.NEW_ZEALAND_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String nzlRegion = String.valueOf(ORIGIN.NEW_ZEALAND_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(nzlRegion);
                System.out.println("\nYou have updated Origin to " + nzlRegion);
            }
            case 11 -> {
                Arrays.stream(ORIGIN.PORTUGAL_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String prtRegion = String.valueOf(ORIGIN.PORTUGAL_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(prtRegion);
                System.out.println("\nYou have updated Origin to " + prtRegion);
            }
            case 12 -> {
                Arrays.stream(ORIGIN.SOUTH_AFRICA_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String zafRegion = String.valueOf(ORIGIN.SOUTH_AFRICA_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(zafRegion);
                System.out.println("\nYou have updated Origin to " + zafRegion);
            }
            case 13 -> {
                Arrays.stream(ORIGIN.USA_REGIONS.values()).
                        forEach(origin -> System.out.println(origin.ordinal() + " : " + origin));
                System.out.println("\n\nEnter the number for the most accurate Origin of " + bottleProfile.getName());
                String usaRegion = String.valueOf(ORIGIN.USA_REGIONS.values()[sc.nextInt()]);
                bottleProfile.setOriginTree(usaRegion);
                System.out.println("\nYou have updated Origin to " + usaRegion);
            }
            default -> {
                System.out.println("This is not a valid number... try again");
                userSetOriginTree();
            }
        }
        BottleHandler.nextUpdateRequest(bottleList, bottleProfile);
    }

}





