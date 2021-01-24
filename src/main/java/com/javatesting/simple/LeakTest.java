package com.javatesting.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class LeakTest {

    private final List<EntryHolder> holdersCache = new ArrayList<>();
    private static final int MAP_SIZE = 100_000;

    public void run() {
        // create 500 entries each holding a reference to an Entry of a TreeMap
        IntStream.range(0, 500).forEach(value -> {
            // create map
            final Map<String, Integer> map = pseudoQueryDatabase();

            final int index = new Random().nextInt(MAP_SIZE);

            // get random entry from map
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(index)) {
                    holdersCache.add(new EntryHolder(entry));
                    break;
                }
            }
            // to observe behavior in visualvm
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public static Map<String, Integer> pseudoQueryDatabase() {
        final Map<String, Integer> map = new TreeMap<>();
        IntStream.range(0, MAP_SIZE).forEach(i -> map.put(String.valueOf(i), i));
        return map;
    }

    public static void main(String[] args) throws Exception {
        new LeakTest().run();
    }
}

class EntryHolder {
    Map.Entry<String, Integer> entry;

    EntryHolder(Map.Entry<String, Integer> entry) {
        this.entry = entry;
    }
}