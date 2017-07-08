package software.unf.dk.simonsaysworkingproject;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by deltager on 08-07-17.
 */

public class Save {
    public static void savePoints (long score, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("points", score);
    }

    public static long load (Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject"), Context.MODE_PRIVATE);
        return sharedPref.getLong("points", 0);
    }
}
