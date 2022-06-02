package Enums;

import POJOs.BottleList;

public enum VARIETALS {
//    STYLES, OAKING, WHITES, REDS, ROSES;


    public enum RED {

        AGLIANICO___ITA,
        AZAL_TINTO_AMARAL___PRT,
        BARBERA___ITA,
        CABERNET_FRANC_FRABOR_USACA___FRA,
        CABERNET_SAUVIGNON_FRABOR_USACA___FRA,
        CAINO_TINTO_ESP_BORRACAL___PRT,
        CANAIOLO___ITA,
        CARIGNAN_FRA___ESP,
        CARMENERE_CHL___FRA,
        CINSAULT_FRA_MAR_DZA_LBN___FRA,
        CORVINA___ITA,
        CORVINONE___ITA,
        CROATINA___ITA,
        GAMAY___FRA,
        GRENACHE__GRENACHA_FRA_ESP___ESP,
        GROLLEAU_NOIR___FRA,
        MALBEC_ARG_CHL_FRA_USACA_FRA___FRA,
        MERLOT_FRABOR_USACA_AUS___FRA,
        MONTEPULCIANO_ITA__ABRUZZO___ITA,
        MOURVEDRE__MONASTRELL_FRA_ESP_USACA_AUS___ESP,
        NEBBIOLO_ITA__BOROLO__BARBARESCO___ITA,
        NEGRARA___ITA,
        NEGROAMARA_ITA__PUGLIA___ITA,
        NERO_DAVALO_ITA__SICILIA___ITA,
        PETITE_SYRAH_USACA_AUS_FRA_ISR___FRA,
        PETITE_VERDOT_FRA_USACA_AUS___FRA,
        PINOT_NOIR_FRABRG_USAOR_USACA_ZAF_AUS___FRA,
        RODINELLO_ITA__VENETO___ITA,
        SANGIOVESE_ITA__TOSCANA___ITA,
        SANGIOVESE_GROSSO__BRUNELLO_MONTALCINO___ITA,
        SEZAO___PRT,
        SUSAMANIELLO_ITA__PUGLIA___ITA,
        SYRAH__SHIRAZ_FRARHO_AUSBOR_AUSMCL___FRA,
        TEMPRANILLO__TINTO_FINO_ESP_ARG_USATX___ESP,
        UVA_DI_TROIA_ITA__PUGLIA___ITA,
        VALPOLICELLA_LOCAL_BLEND___ITA,
        ZINFANDEL__PRIMITIVO_USACA_PUGLIA_HRV___HRV,

    }

    public enum WHITES {

        ALVARINHO_ALBARINO__ESP_PRT__ESP,
        ARINTO__PRT,
        BOURBOULENC__FRA,
        CHARDONNAY__FRA,
        CHENIN_BLANC_ZAF_FRA__FRA,
        COLOMBARD_FRA_ZAF_USA__FRA,
        GEWURTSTRAMINER_FRA_DEU_USA_AUS__FRA,
        GRENACHE_BLANC_FRA_ESP__ESP,
        GRUNER_VELTLINER_AST_CZE_SVK__AST,
        KERNER__DEU,
        LOUREIRO_ESP_PRT__PRT,
        MALVASIA_USACA_MEDITERRANEAN__GRC,
        MARSANNE_FRA_USACA_AUS__FRA,
        MELON_DE_BOURGOGNE_FRA_USAOR_USAWA_CAN__FRA,
        MOSCATO__MUSCAT_BLANC_ITA_FRA__GRC,
        MULLER_THURGAU_DEU_CHE_AUT__DEA_CHE,
        PINOT_GRIS_GRIGIO__UKR_ITA_USA_FRA_DEU__FRA,
        RIESLING_DEU_FRA__DEU,
        VERMENTINO_ROLLE__ITA,
        ROUSANNE_FRARHO_USACA__FRA,
        SAUVIGNON_BLANC_FRABOR_FRALOR_NZL_USACA__FRA,
        SEMILLON_FRA_AUS_ZAF_NZL_ARG_CHL__FRA,
        SILVANER__DEU,
        GRUNER_SILVANE_DEU_FRA_AST__AST,
        TRAJADURA__TREIXADURA__PRT,
        TREBBIANO_UGNI_BLANC__ITA_FRA_AUS_BGR__ITA,
        VINHO_VERDE_NATIVE_BLEND__PRT,
        VIOGNIER_FRARHO_USACA_AUSYAL_CHL_ARG__FRA,
        WHITE_BLEND,
    }

    // https://www.iban.com/country-codes

    public enum STYLES {

        RED_SINGLE                    ("r. Single RED"), // generally considered ... generally >= 90 %
        RED_SINGLE_BLENDED_REGIONS    ("r. Single RED : blended regions"), // limited ability to isolate terroir effects
        WHITE_SINGLE                  ("w. Single WHITE"),
        WHITE_SINGLE_BLENDED_REGIONS  ("w. Single WHITE : blended regions"),
        ROSE                          ("é. Rosé"),
        APPASSIMENTO_RIPASSO          ("r. Apassimento / Ripasso"),
        BEAUJOLAIS                    ("r. Beaujolais"),
        BEAUJOLAIS_NOUVEAU            ("r. Beaujolais Nouveau"),
        BOURGOGNE_ROUGE               ("r. Burgundy Red"),
        BOURGOGNE_BLANC               ("w. Burgundy White"),
        BRUNELLO                      ("r. Brunello di Montalcino"),
        CHABLIS                       ("w. Chablis"),
        CHAMPAGNE                     ("w. Champagne method"),
        CHATEAUNEUF_DU_PAPE           ("r. Châteauneuf-du-Pape"),
        CHIANTI                       ("r. Brunello di Montalcino"),
        LEFT_BANK_BORDEAUX            ("r. Left Bank Bordeaux : merlot first"),
        RIGHT_BANK_BORDEAUX           ("r. Right Bank Bordeaux : cab sauv first"),
        MARLBOROUGH_SAUVIGNON_BLANC   ("w. Marlborough : sauvignon blanc"),
        MERITAGE___BORDEAUX_INSPIRED  ("r. Meritage -> Bordeaux inspired"),
        MALOLACTIC_FERMENTATION       ("w. Malolactic Fermentation"),
        OLD_VINE_GRENACHA             ("r. Old Vine Grenacha"),
        POUILLY_FUME                  ("w. Pouilly-Fumé : sauvignon blanc"),
        PROSECCO                      ("w. Prosecco"),
        RED_BLEND                     ("r. Red Blend"),
        RED_BLEND_BLENDED_REGIONS     ("r. Red blend : blended regions"),
        WHITE_BLEND                   ("w. White Blend"),
        WHITE_BLEND_BLENDED_REGIONS   ("w. White blend : blended regions"),
        RHONE_STYLE_RED_BLEND__GSM    ("r. GSM or Rhone-styled blend"),
        RIBERA_DEL_DUERO              ("r. Ribera del Duero"),
        RIOJA                         ("r. Rioja"),
        SANCERRE                      ("w. Sancerre : sauvignon blanc"),
        TAVEL                         ("é. Tavel style rosé / G,S,M,cinsault"),
        TOSCANA_SUPER_TUSCAN          ("r. 'Super Tuscan' or Toscana"),
        VALPOLICELLA_RIPASSO          ("r. Amarone della Valpolicella ripasso"),
        VINHO_VERDE                   ("w. Vinho Verde"),
        VINO_NOBILE_MONTEPULCIANO     ("r. Vino Nobile Montepulciano"),
        VOUVRAY                       ("w. Vouvray");

        STYLES(String name) { // prepended with r, w, é(rosé) for sorting styles in combination view lists
        }

        @Override
        public String toString() {
            return name();
        }

    }

    public enum OAKING {
        NO_OAK_AGING_DETEDCTED  ("unknown"),
        AGED_IN_STEEL           ("Aged in steel"),
        OAK                     ("Oak apparent"),
        FRENCH_OAK              ("French oak"),
        AMERICAN_OAK            ("American oak"),
        SLOVENIAN_OAK           ("Slovenian oak"),
        COMBINATION_OAKS        ("Combination");

        OAKING(String name) {
        }

        @Override
        public String toString() { return name(); }

    }
    public enum ROSE {
        BOBAL__ESP                  ("Bobal"),
        CABERNET_FRANC__FRA         ("Cabernet Franc"),
        CABERNET_SAUVIGNON__FRA     ("Cabernet Sauvignon"),
        CARIGNAN_FRA__ESP           ("Carignan"),
        CINSAULT__FRA               ("Cinsault"),
        GRENACHE__GRENACHA__ESP     ("Grenache / Grenacha"),
        MOURVEDRE__MONASTRELL__ESP  ("Mourvedre / Monastrell"),
        SANGIOVESE__ITA             ("Sangiovese"),
        SYRAH__FRA                  ("Syrah");

        ROSE(String name) {
        }

        @Override
        public String toString() { return name(); }
    }
}

//https://www.w3schools.com/java/java_enums.asp