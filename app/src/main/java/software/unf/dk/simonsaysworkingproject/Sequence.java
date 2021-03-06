package software.unf.dk.simonsaysworkingproject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by deltager on 06-07-17.
 */

public class Sequence {
    ArrayList<Integer> sequence = new ArrayList<>();
    Random generator;

    public Sequence(int something, int j) {
        generator = new Random();
        for (int i = 0; i < something; i++) {
            sequence.add(generator.nextInt(j));
        }

    }

    public int length () {
        return sequence.size();
    }

    public void add (int k) {
        sequence.add(generator.nextInt(k));
    }

    public int get (int i) {
        return sequence.get(i);
    }

    public void restart () { sequence.clear();}
}
