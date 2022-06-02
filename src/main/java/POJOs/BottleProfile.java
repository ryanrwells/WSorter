package POJOs;

import Handlers.BottleListsHandler;

public class BottleProfile {
    private String bodyStructure;
    private String primitiveList = ""; //RWE
    private String name = "";
    private String wineryName = "";
    private StyleAndOakingPair styleAndOak;
    private String vintage = "";
    private double abv = 0.0;
    private CompositionList composition = new CompositionList();
    private String originTree;
    private Impression impression;
    private String notes = "";
    private String availability = "C";
    private String primaryVarietal = "";

    public BottleProfile() {
    }

    public BottleProfile(String primitiveList,
                         String name,
                         String wineryName,
                         String style,
                         String oaking,
                         String vintage,
                         double abv,
                         String regionOfOrigin,
                         double rating,
                         String time,
                         String varietal1,
                         int percentage1,
                         String varietal2,
                         int percentage2,
                         String varietal3,
                         int percentage3,
                         String varietal4,
                         int percentage4,
                         String varietal5,
                         int percentage5,
                         String notes) {
        this.primitiveList = primitiveList;
        this.name = name;
        this.wineryName = wineryName;
        this.styleAndOak = new StyleAndOakingPair(style, oaking);
        this.vintage = vintage;
        this.abv = abv;
        this.originTree = regionOfOrigin;
        this.impression = new Impression(rating, time); // one time
        VarietalPercentagePair p1 = new VarietalPercentagePair(varietal1, percentage1);
        VarietalPercentagePair p2 = new VarietalPercentagePair(varietal2, percentage2);
        VarietalPercentagePair p3 = new VarietalPercentagePair(varietal3, percentage3);
        VarietalPercentagePair p4 = new VarietalPercentagePair(varietal4, percentage4);
        VarietalPercentagePair p5 = new VarietalPercentagePair(varietal5, percentage5);
        assert false;
        this.composition.addAllVarietalPercentagePairs(p1,p2,p3,p4,p5);
        this.notes = notes;
        this.primaryVarietal = this.getPrimaryVarietal();
        BottleListsHandler bottleListsHandler = new BottleListsHandler();
        bottleListsHandler.addBottleToThisList(PrimaryBottleLists.getPrimaryBottleListByName(primitiveList),this);

    }

    public BottleProfile(BottleProfile priorVintage, String newVintage) { // used for copy to new vintage
        this.primitiveList = priorVintage.getPrimaryList();
        this.name = priorVintage.getName();
        this.wineryName = priorVintage.getWineryName();
        this.styleAndOak = priorVintage.getStyleAndOaking();
        this.vintage = newVintage;
        this.abv = priorVintage.getAbv();
        this.composition = priorVintage.getComposition();
        this.originTree = priorVintage.getOriginTree();
        // impression default to uninstantiated
        this.notes = ""; // notes set to empty
        // availability default to Current
        if (this.getPrimaryVarietal() != null) {
            this.primaryVarietal = priorVintage.getPrimaryVarietal();
        }
    }

    public String getPrimaryList() {
        return primitiveList;
    }

    public void setPrimaryList(BottleList bottleList) {
        if (bottleList.isPrimaryList()) {
            this.primitiveList = bottleList.getName();
        }
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getWineryName() { return wineryName; }

    public void setWineryName(String wineryName) { this.wineryName = wineryName; }

    public Integer getVintage() { return Integer.getInteger(vintage); }

    public void setVintage(Integer vintage) { this.vintage = vintage.toString(); }

    public StyleAndOakingPair getStyleAndOaking() { return styleAndOak; }

    public void setStyleAndOaking(StyleAndOakingPair styleAndOak) { this.styleAndOak = styleAndOak; }

    public String getStyle() { return styleAndOak.getStyle(); }

    public double getAbv() { return abv; }

    public void setAbv(double abv) { this.abv = abv; }

    public CompositionList getComposition() { return composition; }

    public void setComposition(CompositionList composition) { this.composition = composition; }

    public String getPrimaryVarietal() { return composition.getVarietalPercentagePairsList().get(0).getVareitalInCompositionPair(); }

    public String getOriginTree() { return originTree; }

    public void setOriginTree(String originTree) { this.originTree = originTree; }

    public Impression getImpression() { return impression; }

    public double getImpressionRatingOnly() { return impression.getRating(); }

    public void setImpression(Impression impression) { this.impression = impression; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }

    public String getAvailabilityStatus() { return availability;}

    public void setAvailabilityStatus(String decommissioned) {
        if (decommissioned.equalsIgnoreCase("C")) {
            availability = "";
        }
        if (decommissioned.equalsIgnoreCase("d")) {
            availability = "d";
        }
    }

    @Override
    public String toString() {
        return "BottleProfile{\n" +
                availability + " " + name + " " + vintage + '\n' +
                " primary list     : " + primitiveList + '\n' +
                " winery           : " + wineryName + '\n' +
                " style            : " + styleAndOak + '\n' +
                " primary varietal : " + primaryVarietal + '\n' +
                " abv              : " + abv + '\n' +
                " region           : " + originTree + '\n' +
                " composition      : " + composition + '\n' +
                " Impression       : " + impression + '\n' +
                " notes :\n" + notes + '\n' +
                '}';
    }
}
