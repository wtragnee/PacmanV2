/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanv2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author William
 */
public class PacmanV2 {

    /**
     * @param args the command line arguments
     */
    static String constantsFileName = "constants.json";
    static int jFrameWidth = 500;
    static int jFrameHeight = 500;
    static int boxWidth = 20;
    static int boxHeight = 20;
    static Color colorBorderUserBox = Color.green;
    static Color colorNormalBackground = Color.blue;
    static Color colorWallBackground = Color.black;
    static String jFrameTitle = "PacmanV2";
    // Continue

    public static void main(String[] args) {
        // loadConstants();
        // saveConstants();
        createJFrame();
    }

    public static void loadConstants() {
        String answer = "";
        try {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(constantsFileName)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    answer += line + "\n";
                }
                if (!"".equals(answer)) {
                    setJSONToConstants(answer);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void saveConstants() {
        try {
            String constants = setConstantsToJSON();
            try (PrintWriter fichierSortie = new PrintWriter(
                    new BufferedWriter(new FileWriter(constantsFileName)))) {
                fichierSortie.println(constants);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void setJSONToConstants(String jsonString) throws JSONException {
        JSONObject json = new JSONObject(jsonString);
        jFrameWidth = (int) json.get("jFrameWidth");
        jFrameHeight = (int) json.get("jFrameHeight");
        boxWidth = (int) json.get("boxWidth");
        boxHeight = (int) json.get("boxHeight");
        jFrameTitle = (String) json.get("jFrameTitle");
        if(getColorFromJSON(json, "colorBorderUserBox") != null) {
            colorBorderUserBox = getColorFromJSON(json, "colorBorderUserBox");
        }
        if(getColorFromJSON(json, "colorNormalBackground") != null) {
            colorNormalBackground = getColorFromJSON(json, "colorNormalBackground");
        }
        if(getColorFromJSON(json, "colorWallBackground") != null) {
            colorWallBackground = getColorFromJSON(json, "colorWallBackground");
        }
    }
    
    public static Color getColorFromJSON(JSONObject json, String key) throws JSONException {
        Color color = null;
        JSONArray jsonArray = (JSONArray) json.get(key);
        if(jsonArray.length() == 3 ) {
            int[] rgb = new int[jsonArray.length()];
            for(int i = 0; i < jsonArray.length(); i++) {
                rgb[i] = jsonArray.getInt(i);
            }
            color = new Color(rgb[0],rgb[1], rgb[2]);
        }
        return color;
    }

    public static String setConstantsToJSON() throws Exception {
        JSONObject constants = new JSONObject();
        constants.put("jFrameWidth", jFrameWidth);
        constants.put("jFrameHeight", jFrameHeight);
        constants.put("boxWidth", boxWidth);
        constants.put("boxHeight", boxHeight);
        constants.put("colorBorderUserBox",
                new JSONArray().put(colorBorderUserBox.getRed()).put(colorBorderUserBox.getGreen()).put(colorBorderUserBox.getBlue()));
        constants.put("colorNormalBackground",
                new JSONArray().put(colorNormalBackground.getRed()).put(colorNormalBackground.getGreen()).put(colorNormalBackground.getBlue()));
        constants.put("colorWallBackground",
                new JSONArray().put(colorWallBackground.getRed()).put(colorWallBackground.getGreen()).put(colorWallBackground.getBlue()));
        constants.put("jFrameTitle", jFrameTitle);
        return constants.toString();
    }

    public static void createJFrame() {
        JFrame window = new JFrame();
        window.setLayout(null);
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle(jFrameTitle);
        /*JPanel background = new JPanel();
        background.setSize(jFrameWidth, jFrameHeight);
        background.setBackground(colorNormalBackground);
        window.add(background);*/
        window.setSize(jFrameWidth, jFrameHeight);
        MapContent mapContent = new MapContent(window);
        window.setVisible(true);

    }

}
