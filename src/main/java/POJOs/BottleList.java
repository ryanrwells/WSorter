package POJOs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BottleList {
    private String name = "";
    private String listKey = "";
    private final List<BottleProfile> bottleProfilesList = new ArrayList<>(); // get by binary
    private boolean addableView = false; // set to false if made sharable
    private boolean isPrimaryList = false;

    public BottleList() {
    }

    public void removeBottleProfile(BottleProfile bottleProfile) {
        bottleProfilesList.remove(bottleProfile);
    }

    public void addBottleProfile(BottleProfile bottleProfile) { bottleProfilesList.add(bottleProfile); }

    public void addMultipleBottlesFromAnotherList(List<BottleProfile> bottleProfilesToAdd) {
        this.bottleProfilesList.addAll(bottleProfilesToAdd);
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.listKey = name.concat(UUID.randomUUID().toString());
        this.name = name;
    }

    public String getListKey() { return listKey; }

    public List<BottleProfile> getBottleProfilesList() {
        return bottleProfilesList; }

    public boolean isAddableView() { return addableView; }

    public void setAddableView(boolean addableView) { this.addableView = addableView; }

    public boolean isPrimaryList() { return isPrimaryList; }

    public void setIsPrimitiveListToTrue() {
        this.isPrimaryList = true;
    }



//    @Override
//    public String toString() {
//        return "BottleList{" +
//                "list : " + name + '\'';
//                for(BottleProfile bottleProfile : bottleProfilesList) {
//                    System.out.println(bottleProfile);
//                '}';
//    }


}