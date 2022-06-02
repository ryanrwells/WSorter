package MethodClasses;

import POJOs.BottleList;
import POJOs.BottleProfile;

public class DisplayBottlesTable {
    private final BottleList bottleList;

    public DisplayBottlesTable(BottleList bottleList) {
        this.bottleList = bottleList;
        displayBottleTable();
    }

    public DisplayBottlesTable(BottleProfile bottleProfile) { //to display single bottle as table format
        this.bottleList = new BottleList();
        bottleList.addBottleProfile(bottleProfile);
        displayBottleTable();
    }

    private void displayBottleTable(){
        System.out.println("_____________________________________________________________________________");
        System.out.printf("%3s %3s %6s %44s %40s %8s %40s %4s %18s %44s %18s %44s %4s %44s %4s %44s %4s %44s %4s %44s %4s",
                "#", "AS", "LIST", "PRIMARY VARIETAL", "NAME", "VINTAGE", "WINERY", "ABV", "IMPRESSION / DATE",
                "STYLE", "OAKING",
                "VARIETAL 1", "%", "VARIETAL 2", "%", "VARIETAL 3", "%", "VARIETAL 4", "%","VARIETAL 5", "%" + "Notes");
        System.out.println("_____________________________________________________________________________");
        for(BottleProfile b : this.bottleList.getBottleProfilesList()){
            System.out.format("%3s %3s %6s %44s %40s %8s %40s %4s %18s %44s %18s %44s %4s %44s %4s %44s %4s %44s %4s %44s %4s",
                    bottleList.getBottleProfilesList().indexOf(b),
                    "|" + b.getAvailabilityStatus(),
                    "|" + b.getPrimaryList(),
                    "|" + b.getPrimaryVarietal(),
                    "|" + b.getName(),
                    "|" + b.getVintage(),
                    "|" + b.getWineryName(),
                    "|" + b.getAbv(),
                    "|" + b.getImpression().toString(),
                    "|" + b.getStyleAndOaking().getStyle(),
                    "|" + b.getStyleAndOaking().getOaking(),
                    "|" + b.getComposition().getVarietalPercentagePair1().getVareitalInCompositionPair(),
                    b.getComposition().getVarietalPercentagePair1().getVarietalPercentageAsString(),
                    "|" + b.getComposition().getVarietalPercentagePair2().getVareitalInCompositionPair(),
                    b.getComposition().getVarietalPercentagePair2().getVarietalPercentageAsString(),
                    "|" + b.getComposition().getVarietalPercentagePair3().getVareitalInCompositionPair(),
                    b.getComposition().getVarietalPercentagePair3().getVarietalPercentageAsString(),
                    "|" + b.getComposition().getVarietalPercentagePair4().getVareitalInCompositionPair(),
                    b.getComposition().getVarietalPercentagePair4().getVarietalPercentageAsString(),
                    "|" + b.getComposition().getVarietalPercentagePair5().getVareitalInCompositionPair(),
                    b.getComposition().getVarietalPercentagePair5().getVarietalPercentageAsString()
                    + "|" + b.getNotes());
            System.out.println("_____________________________________________________________________________");
        }
    }
}
