package Handlers;

import POJOs.BottleList;
import POJOs.BottleProfile;
import POJOs.CompositionList;
import POJOs.VarietalPercentagePair;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static Enums.VARIETALS.STYLES.*;

public class CompositionUserBuilder {
    public BottleList primitiveBottleList; // RWE
    public BottleProfile bottleProfile;
    public CompositionList compositionList;
    private List<VarietalPercentagePair> varietalPercentagePairsList;
    private final Scanner sc = new Scanner(System.in);

    public CompositionUserBuilder(BottleList bottleList, BottleProfile bottleProfile) {
        this.primitiveBottleList = bottleList;
        this.bottleProfile = bottleProfile;
    }

    public void userBuildCompositionList() {
        VarietalPercentagePair varietalPercentagePair = new VarietalPercentagePair();
        System.out.println("Enter the exact number of the varietals you will be assigning to this bottle profile" +
                "(up-to 5 vatietals total)");
        int maxVs = sc.nextInt();
        if (maxVs < 1) { maxVs = 1; }
        if (maxVs > 5) { maxVs = 5; }

        userPromptsFromStyle();

        System.out.println();
        // print varietal list

        while (maxVs > 0) {
            System.out.println(bottleProfile.getName() + " composition = " + varietalPercentagePairsList + " + ");
            System.out.println("""

                    Enter the number from the varietal list to add next -->\s
                     *you will be able to label up-tp five varietals, from greatest to least in volume contribution""");
            String varietal = sc.nextLine();
            System.out.println("\nEnter in the number percentage this varietal contributes (e.g. 90), if you don't know, " +
                    "but know this is in the wine, just enter 0 for now (with Varietals still entered in " +
                    "estimated order of greatest to least) --> ");
            int percentage = sc.nextInt();

            varietalPercentagePair.setVarietalPercentageInCompositionPair(percentage);
            varietalPercentagePair.setVarietalInCompositionPair(varietal);
            varietalPercentagePairsList.add(varietalPercentagePair);
            maxVs--;
        }
        userAutoSortListAndSet();
    }

    private void userAutoSortListAndSet() {
        if (varietalPercentagePairsList.get(0).getVarietalPercentageInCompositionPair() != 0) {
            Comparator<VarietalPercentagePair> varietalPercentage =
                    Comparator.comparing(VarietalPercentagePair::getVarietalPercentageInCompositionPair, Comparator.reverseOrder());
            varietalPercentagePairsList.sort(varietalPercentage);
        }

        this.compositionList.setVarietalPercentagePairsList(varietalPercentagePairsList);
        bottleProfile.setComposition(compositionList);
        System.out.print("Varietals have been set for " + bottleProfile.getName() + ": \n" + varietalPercentagePairsList);
        BottleHandler.nextUpdateRequest(primitiveBottleList, bottleProfile);
    }

    private void userPromptsFromStyle() { // change to Ordinals switch
        if (bottleProfile.getStyleAndOaking().getStyle().equals(LEFT_BANK_BORDEAUX.toString())) {
            System.out.println("Left Bank Bordeaux style SHALL be predominantly Merlot balanced with Cabernet " +
                    "Sauvignon... with probably also some of tertiary contributions by Cabernet Franc, Malbec, and " +
                    "Petit Verdot.");
        }

        if (bottleProfile.getStyleAndOaking().getStyle().equals(RIGHT_BANK_BORDEAUX.toString())) {
            System.out.println("Right Bank Bordeaux style SHALL be predominantly Cabernet Sauvignon balanced with " +
                    "Merlot... with probably also some of tertiary contributions by Cabernet Franc, Malbec, and " +
                    "Petit Verdot.");
        }

        if (bottleProfile.getStyleAndOaking().getStyle().equals(MERITAGE___BORDEAUX_INSPIRED.toString())) {
            System.out.println("'Meritage' is a loose declaration from California meaning 'a marriage of grapes in the " +
                    "heritage of Bordeaux'. Bordeaux laws strictly require a blend using 'the five noble grapes of " +
                    "Bordeaux' (Predominanatly Cabernet Sauvignon and Merlot, and balanced with Cabernet Franc, " +
                    "Malbec, Petit Verdot, or rarely Carménère)");
        }

        if (bottleProfile.getStyleAndOaking().getStyle().equals(BOURGOGNE_BLANC.toString())) {
            System.out.println("Most Brugandy White is predominantly Chardonnay, but this may be blended with, or rarely, " +
                    "predominantly be, Aligoté, Pinot Gris, or Pinot Blanc.");
        }

        if (bottleProfile.getStyleAndOaking().getStyle().equals(CHABLIS.toString())) {
            System.out.println("This Chablis bottle SHALL be be made exclusively with un-oaked Chardonnay.");
        }

        if (bottleProfile.getStyleAndOaking().getStyle().equals(BOURGOGNE_ROUGE.toString())) {
            System.out.println("This Burgandy will be either Pinot Noir or Gamay(generally Gamay only if from Beaujolais and " +
                    "would be classified as BEAUJOLAIS in Style, update Style again if necessary).");
        }

        if (bottleProfile.getStyleAndOaking().getStyle().equals(BEAUJOLAIS.toString())) {
            System.out.println("This Burgandy SHALL be of Gamay.");
        }
    }
}
