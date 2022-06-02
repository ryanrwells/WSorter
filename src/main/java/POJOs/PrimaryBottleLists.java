package POJOs;

public class PrimaryBottleLists extends BottleList {
    private static BottleList RED_BOTTLES = getInstanceRED_BOTTLES();
    private static BottleList WHITE_BOTTLES = getInstanceWHITE_BOTTLES();
    private static BottleList ROSE_BOTTLES = getInstanceROSE_BOTTLES();

    private PrimaryBottleLists() {
    }

    public static BottleList getInstanceRED_BOTTLES() {
        PrimaryBottleLists.RED_BOTTLES = new BottleList();
        PrimaryBottleLists.RED_BOTTLES.setName("REDS");
        PrimaryBottleLists.RED_BOTTLES.setIsPrimitiveListToTrue();
        return RED_BOTTLES; }

    public static BottleList getInstanceWHITE_BOTTLES() {
        PrimaryBottleLists.WHITE_BOTTLES = new BottleList();
        PrimaryBottleLists.WHITE_BOTTLES.setName("WHITES");
        PrimaryBottleLists.WHITE_BOTTLES.setIsPrimitiveListToTrue();
        return WHITE_BOTTLES; }

    public static BottleList getInstanceROSE_BOTTLES() {
        PrimaryBottleLists.ROSE_BOTTLES = new BottleList();
        PrimaryBottleLists.ROSE_BOTTLES.setName("Rosés");
        PrimaryBottleLists.ROSE_BOTTLES.setIsPrimitiveListToTrue();
        return ROSE_BOTTLES; }

    public static BottleList getPrimaryBottleListByName(String name) {
        if (name.equals(getInstanceRED_BOTTLES().getName())) { return getInstanceRED_BOTTLES(); }
        if (name.equals(getInstanceWHITE_BOTTLES().getName())) { return getInstanceWHITE_BOTTLES(); }
        return getInstanceROSE_BOTTLES();
    }
}

