import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<String, Integer> RESISTANCE;

    static {
        RESISTANCE = new HashMap<>();
        RESISTANCE.put("black", 1);
        RESISTANCE.put("brown", 10);
        RESISTANCE.put("red", 100);
        RESISTANCE.put("orange", 1000);
        RESISTANCE.put("yellow", 10000);
        RESISTANCE.put("green", 100000);
        RESISTANCE.put("blue", 1000000);
        RESISTANCE.put("violet", 10000000);
        RESISTANCE.put("grey", 100000000);
        RESISTANCE.put("white", 1000000000);
    }
    
    public static void main(String[] args) throws IOException {
        long value = 0;
        value += (long) Math.log10(RESISTANCE.get(BR.readLine())) * 10 + (long) Math.log10(RESISTANCE.get(BR.readLine()));
        value *= RESISTANCE.get(BR.readLine());
        System.out.println(value);
    }
}
