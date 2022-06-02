package POJOs;


public class VarietalPercentagePair {
    private String varietal = "";
    private int percentage = 0;

    public VarietalPercentagePair() {
    }

    public VarietalPercentagePair(String varietal, int percentage) {
        this.varietal = varietal;
        this.percentage = percentage;
    }

    public String getVareitalInCompositionPair() {
        return varietal;
    }

    public void setVarietalInCompositionPair(String varietal) {
        this.varietal = varietal; // one-time use to upload sample sets
    }

    public double getVarietalPercentageInCompositionPair() {
        return percentage;
    }

    public String getVarietalPercentageAsString() {
        if (percentage > 9 && percentage != 100) {
            return percentage + "%%";
        } else if (percentage == 0 || percentage == 100) {
            return "--%%";
        }
        return percentage + "0%%";
    }

    public void setVarietalPercentageInCompositionPair(int percentage) {
        this.percentage = percentage;
    }

    public void setVarietalAndPercentageInCompositionPair(String varietal, int percentage) {
        this.varietal = varietal;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        if (percentage > 9 && percentage != 100) {
            return varietal + " : " + percentage + "%%";
        } else if (percentage == 0 || percentage == 100) {
            return varietal + " : " + "--%%";
        }
        return varietal + " : 0" + percentage + "%%";
    }

}

