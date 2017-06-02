package Yahnenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dront on 11.03.17.
 */
public class GameHelper {
    public static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCelss = new ArrayList<String>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attemps = 0;
        boolean succes = false;
        int location = 0;
        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }
        while (!succes & attemps++ < 200) {
            location = (int) (Math.random() * gridSize);
            System.out.println("пробуем " + location);
            int x = 0;
            succes = true;
            while (succes && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize){
                        succes = false;
                    }
                    if ( x > 0 && (location % gridLength == 0)){
                        succes = false;
                    }
                }else {
                    System.out.println("используется"+location);
                    succes = false;
                }
            }
        }
        int x = 0;
        int row = 0;
        int colomn = 0;
        System.out.println("\n");
        while (x < comSize){
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridLength);
            colomn = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(colomn));
            alphaCelss.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println("cord "+x+" = "+alphaCelss.get(x-1));
        }
        System.out.println("\n");
        return alphaCelss;
    }
}