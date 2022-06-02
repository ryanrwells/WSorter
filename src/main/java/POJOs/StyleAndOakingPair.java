package POJOs;

import Enums.VARIETALS;
import Handlers.BottleHandler;

import java.util.Arrays;
import java.util.Scanner;

public class StyleAndOakingPair {
    public String style;
    public String oaking;

    public StyleAndOakingPair() {
    }

    public StyleAndOakingPair(String style, String oaking) {
    }

    public void userInputStyleAndOakingPair(BottleList bottleList, BottleProfile bottleProfile) {
        Scanner sc = new Scanner(System.in);
//        VARIETALS.STYLES.stylesDisplay();
        Arrays.stream(VARIETALS.STYLES.values()).forEach(style -> System.out.println(style.ordinal() + " : " + style));
        System.out.println("\n\n Enter the number for the update Style -->");
        this.style = String.valueOf(VARIETALS.STYLES.values()[sc.nextInt()]);

//        VARIETALS.OAKING.oakingDisplay();
        Arrays.stream(VARIETALS.OAKING.values()).forEach(oaking -> System.out.println(oaking.ordinal() + " : " + oaking));
        System.out.println("\n\n Enter the number to add Oaking influences -->");
        this.oaking = String.valueOf(VARIETALS.OAKING.values()[sc.nextInt()]);

        bottleProfile.setStyleAndOaking(this);
        BottleHandler.nextUpdateRequest(bottleList, bottleProfile);
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getOaking() {
        return oaking;
    }

    public void setOaking(String oaking) {
        this.oaking = oaking;
    }
}
