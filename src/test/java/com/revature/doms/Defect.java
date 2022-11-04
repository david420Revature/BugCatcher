package com.revature.doms;

public class Defect {
    public static String[] validStatuses = {
      "Accepted",
      "Rejected",
      "Fixed",
      "Declined",
      "Shelved"
    };

    public static String[] scale = {
        "low",
        "medium",
        "high"
    };

    // get it, its a pun!
    public static int weigh(String scaler) {
        for (int i = 0; i < scale.length; i++) {
            if (scaler.toLowerCase().equals(scale[i])) return i;
        }
        throw new Error("scaler not found!");
    }

}
