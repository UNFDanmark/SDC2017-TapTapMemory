package software.unf.dk.simonsaysworkingproject;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by deltager on 08-07-17.
 */

public class Save {
    public static void savePoints(long points, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("points", points);
        editor.commit();
    }

    public static long load(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        return sharedPref.getLong("points", 0);
    }

    public static void saveLevel2(boolean isBought, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("level2Bought", isBought);
        editor.commit();
    }

    public static boolean loadLevel2(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        return sharedPref.getBoolean("level2Bought", false);
    }

    public static void saveLevel3(boolean isBought, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("level3Bought", isBought);
        editor.commit();
    }

    public static boolean loadLevel3(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        return sharedPref.getBoolean("level3Bought", false);
    }

    public static void saveHighScore(int isBought, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("HighScore1", isBought);
        editor.commit();
    }

    public static int loadHighScore(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        return sharedPref.getInt("HighScore1", 0);
    }
    public static void saveHighScore2(int isBought, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("HighScore2", isBought);
        editor.commit();
    }

    public static int loadHighScore2(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        return sharedPref.getInt("HighScore2", 0);
    }
    public static void saveHighScore3(int isBought, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("HighScore3", isBought);
        editor.commit();
    }

    public static int loadHighScore3(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf("software.unf.dk.simonsaysworkingproject.prefs"), Context.MODE_PRIVATE);
        return sharedPref.getInt("HighScore3", 0);
    }

}
