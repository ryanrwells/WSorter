package POJOs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CompositionList {
    private List<VarietalPercentagePair> varietalPercentagePairsList = new ArrayList<>();
    VarietalPercentagePair varietalPercentagePair1 = new VarietalPercentagePair();
    VarietalPercentagePair varietalPercentagePair2 = new VarietalPercentagePair();
    VarietalPercentagePair varietalPercentagePair3 = new VarietalPercentagePair();
    VarietalPercentagePair varietalPercentagePair4 = new VarietalPercentagePair();
    VarietalPercentagePair varietalPercentagePair5 = new VarietalPercentagePair();

    public CompositionList(){
    }

    public CompositionList(VarietalPercentagePair p1,
                           VarietalPercentagePair p2,
                           VarietalPercentagePair p3,
                           VarietalPercentagePair p4,
                           VarietalPercentagePair p5) {
        varietalPercentagePairsList.add(p1);
        varietalPercentagePairsList.add(p2);
        varietalPercentagePairsList.add(p3);
        varietalPercentagePairsList.add(p4);
        varietalPercentagePairsList.add(p5);
    }

    public CompositionList(List<VarietalPercentagePair> varietalPercentagePairsList) {
        this.varietalPercentagePairsList = varietalPercentagePairsList;
    }

    public List<VarietalPercentagePair> getVarietalPercentagePairsList() {
        return varietalPercentagePairsList;
    }

    public void setVarietalPercentagePairsList(List<VarietalPercentagePair> varietalPercentagePairsList) {
        this.varietalPercentagePairsList = varietalPercentagePairsList;
    }

    private void addVarietalPercentagePair(VarietalPercentagePair varietalPercentagePair) {
        varietalPercentagePairsList.add(varietalPercentagePair);
        if (varietalPercentagePair.getVarietalPercentageInCompositionPair() != 0) {

            Comparator<VarietalPercentagePair> varietalPercentageComparator =
                    Comparator.comparing(VarietalPercentagePair::getVarietalPercentageInCompositionPair, Comparator.reverseOrder());
            varietalPercentagePairsList.sort(varietalPercentageComparator);
        }
    }

    public void addAllVarietalPercentagePairs(VarietalPercentagePair p1, // one time use
                                              VarietalPercentagePair p2,
                                              VarietalPercentagePair p3,
                                              VarietalPercentagePair p4,
                                              VarietalPercentagePair p5) {
        varietalPercentagePairsList.add(p1);
        varietalPercentagePairsList.add(p2);
        varietalPercentagePairsList.add(p3);
        varietalPercentagePairsList.add(p4);
        varietalPercentagePairsList.add(p5);
    }

    public VarietalPercentagePair getVarietalPercentagePair1() {
        return varietalPercentagePair1;
    }

    public void setVarietalPercentagePair1(VarietalPercentagePair varietalPercentagePair1) {
        this.varietalPercentagePair1 = varietalPercentagePair1;
    }

    public VarietalPercentagePair getVarietalPercentagePair2() {
        return varietalPercentagePair2;
    }

    public void setVarietalPercentagePair2(VarietalPercentagePair varietalPercentagePair2) {
        this.varietalPercentagePair2 = varietalPercentagePair2;
    }

    public VarietalPercentagePair getVarietalPercentagePair3() {
        return varietalPercentagePair3;
    }

    public void setVarietalPercentagePair3(VarietalPercentagePair varietalPercentagePair3) {
        this.varietalPercentagePair3 = varietalPercentagePair3;
    }

    public VarietalPercentagePair getVarietalPercentagePair4() {
        return varietalPercentagePair4;
    }

    public void setVarietalPercentagePair4(VarietalPercentagePair varietalPercentagePair4) {
        this.varietalPercentagePair4 = varietalPercentagePair4;
    }

    public VarietalPercentagePair getVarietalPercentagePair5() {
        return varietalPercentagePair5;
    }

    public void setVarietalPercentagePair5(VarietalPercentagePair varietalPercentagePair5) {
        this.varietalPercentagePair5 = varietalPercentagePair5;
    }

    @Override
    public String toString() {
        return varietalPercentagePairsList.toString();
    }
}
