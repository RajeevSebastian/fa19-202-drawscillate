package drawscillate;

import controlP5.CColor;
import controlP5.ControlP5;
import controlP5.ScrollableList;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.sound.SinOsc;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Drawscillate extends PApplet {
    private SinOsc[] sineWaves; // Array of sines
    private float[] sineFreq; // Array of frequencies
    private int numSines = 5; // Number of oscillators to use
    private ControlP5 cp5;
    private String dropDownSelection = "";
    int redColor = 0;
    int greenColor = 0;
    int blueColor = 0;
    int[] pixelsFrame;
    float red;
    float green;
    float blue;
    boolean gameOver = false;
    boolean startPointRecorded = false;
    int startPointX;
    int startPointY;
    int shapeChosen = 0;
    int [][] starCheckPoints;
    int [][] heartCheckPoints;
    private PGraphics graphics;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        background(255);
        graphics = createGraphics(500, 500);
        sineWaves = new SinOsc[numSines]; // Initialize the oscillators
        sineFreq = new float[numSines]; // Initialize array for Frequencies

        for (int i = 0; i < numSines; i++) {
            // Calculate the amplitude for each oscillator
            double sineVolume = (1.0 / numSines) / (i + 1);
            // Create the oscillators
            sineWaves[i] = new SinOsc(this);
            // Start Oscillators
            sineWaves[i].play();
            // Set the amplitudes for all oscillators
            sineWaves[i].amp((float) sineVolume);
        }

        // Drop Down
        cp5 = new ControlP5(this);
        List l = Arrays.asList("Star", "Rectangle", "Heart", "Circle");
        /* add a ScrollableList, by default it behaves like a DropdownList */
        cp5.addScrollableList("dropdown")
                .setPosition(100, 100)
                .setSize(200, 100)
                .setBarHeight(20)
                .setItemHeight(20)
                .addItems(l);
    }

    private void drawStar() {
        graphics.beginDraw();
        graphics.background(51);
        graphics.fill(102);
        graphics.stroke(255);
        graphics.strokeWeight(10);
        graphics.beginShape();
        starCheckPoints = new int[10][3];
        int startX = 550 / 2 - 47 / 2;
        int startY = 160 / 2 - 45 / 2;
        graphics.vertex(startX, startY);
        insertCheckPoint(startX,startY,0);
        graphics.vertex(startX + 60, startY + 140);
        insertCheckPoint(startX +60,startY+ 140,1);
        graphics.vertex(startX + 230, startY + 150);
        insertCheckPoint(startX + 230,startY +150,2);
        graphics.vertex(startX + 100, startY + 240);
        insertCheckPoint(startX+100,startY +240,3);
        graphics.vertex(startX + 180, startY + 380);
        insertCheckPoint(startX +180,startY + 380,4);
        graphics.vertex(startX, startY + 300);
        insertCheckPoint(startX,startY +300,5);
        graphics.vertex(startX - 180, startY + 380);
        insertCheckPoint(startX- 180,startY +380,6);
        graphics.vertex(startX - 100, startY + 240);
        insertCheckPoint(startX -100,startY +240,7);
        graphics.vertex(startX - 230, startY + 150);
        insertCheckPoint(startX -230,startY +150,8);
        graphics.vertex(startX - 60, startY + 140);
        insertCheckPoint(startX -60,startY +140,9);
        graphics.endShape(CLOSE);
        graphics.endDraw();
        shapeChosen = 1;
        startPointRecorded =false;
        image(graphics, 0, 0);
    }

    /**
    * 
    * Function name - insertCheckPoint
    * Description   - 
    * @param     - 
    * @return        - void
    */
    private void insertCheckPoint(int startX, int startY, int i) {
        starCheckPoints[i][0] =startX;
        starCheckPoints[i][1] =startY;
        starCheckPoints[i][2] =0;  
    }

    private void drawHeart() {
        graphics.beginDraw();
        graphics.background(51);
        graphics.fill(102);
        graphics.stroke(255);
        graphics.strokeWeight(10);
        graphics.beginShape();
        heartCheckPoints = new int [5][3];
        final int x1 = width / 2;
        final int halfHeartWidth = 500;
        final int y1 = 100;
        final int y2 = -50;
        final int y3 = 5;
        final int y4 = 485;
        graphics.vertex(x1, y1);
        graphics.bezierVertex(x1, y2, x1 + halfHeartWidth, y3, x1, y4);
        graphics.bezierVertex(x1 - halfHeartWidth, y3, x1, y2, x1, y1);
        graphics.endShape();
        graphics.endDraw();
        insertHeartCheckPoints(249,93,0);
        insertHeartCheckPoints(29,157,1);
        insertHeartCheckPoints(474,158,2);
        insertHeartCheckPoints(252,481,3);
        insertHeartCheckPoints(47,219,4);
        shapeChosen = 1;
        startPointRecorded =false;
        image(graphics, 0, 0);
    }

    /**
    * 
    * Function name - insertHeartCheckPoints
    * Description   - 
    * @param     - 
    * @return        - void
    */
    private void insertHeartCheckPoints(int x1, int y1, int i) {
        heartCheckPoints[i][0] =x1;
        heartCheckPoints[i][1] =y1;
        heartCheckPoints[i][2] =0;
    }

    public void draw() {
        // Map mouseY from 0 to 1
        float yoffset = map(mouseY, 0, height, 0, 1);
        // Map mouseY logarithmically to 150 - 1150 to create a base frequency range
        float frequency = pow(1000, yoffset) + 150;
        // Use mouseX mapped from -0.5 to 0.5 as a detune argument
        float detune = map(mouseX, 0, width, -0.5f, 0.5f);

        for (int i = 0; i < numSines; i++) {
            sineFreq[i] = frequency * (i + 1 * detune);
            // Set the frequencies for all oscillators
            sineWaves[i].freq(sineFreq[i]);
        }

        if (mousePressed) {
            stroke(redColor, greenColor, blueColor);
            strokeWeight(5);
            
            if (!gameOver)
                line(mouseX, mouseY, pmouseX, pmouseY);
                hasLineReachedCheckPoint(mouseX,mouseY);
                if(startPointRecorded == false) {
                    startPointX =mouseX;
                    startPointY =mouseY; 
                    startPointRecorded = true;
                    System.out.println("Start x :"+ startPointX);
                    System.out.println("Start y :" +startPointY);
                }

            if (shapeChosen == 1) {
                pixelsFrame = graphics.get().pixels;
                red = red(pixelsFrame[mouseX + mouseY * width]);
                green = green(pixelsFrame[mouseX + mouseY * width]);
                blue = blue(pixelsFrame[mouseX + mouseY * width]);
                if (red != 255.0 && blue != 255.0 && green != 255) {
                    gameOver = true;
                }
            }
        }
        if(allCheckPointsReached() && startReached()) {
            System.out.println("Game successfully completed");
        }

        if (keyPressed) {
            switch (key) {
            case 'r':
                changeCursorAndColor("apple.png", 255, 0, 0);
                break;
            case 'b':
                changeCursorAndColor("water.png", 0, 0, 255);
                break;
            case 'g':
                changeCursorAndColor("grapes.png", 0, 255, 0);
                break;
            case ' ':
                changeCursorAndColor(null, 0, 0, 0);
                break;
            case 'o':
                changeCursorAndColor("orange.png", 255, 165, 0);
                break;
            case 'p':
                changeCursorAndColor("eggplant.png", 147, 112, 219);
                break;
            case 'y':
                changeCursorAndColor("banana.png", 255, 255, 51);
                break;
            }
        }
    }
    
    

    /**
    * 
    * Function name - startReached
    * Description   - 
    * @param     - 
    * @return        - boolean
    */
    private boolean startReached() {
        if(isPointInCircle(startPointX, startPointY, mouseX, mouseY) == 1) {
           return true; 
        }
        return false;
    }

    /**
    * 
    * Function name - allCheckPointsReached
    * Description   - 
    * @param     - 
    * @return        - boolean
    */
    private boolean allCheckPointsReached() {
        if(dropDownSelection.equals("Star")) {
            for(int i =0;i<10;i++) {
                if(starCheckPoints[i][2] !=1) {
                    return false;
                }
            }
        }else  if(dropDownSelection.equals("Heart")) {
            for(int i =0;i<5;i++) {
                if(heartCheckPoints[i][2] !=1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
    * 
    * Function name - hasLineReachedCheckPoint
    * Description   - 
    * @param     - 
    * @return        - void
    */
    private void hasLineReachedCheckPoint(int mouseX, int mouseY) {
       if(dropDownSelection == "Star") {
           for(int i =0 ;i <10 ;i++) {
              if(starCheckPoints[i][2] != 1) { 
               starCheckPoints[i][2] = isPointInCircle(starCheckPoints[i][0],starCheckPoints[i][1],mouseX,mouseY);
              }
           }
       } else  if(dropDownSelection == "Heart") {
           for(int i =0 ;i <5 ;i++) {
               if(heartCheckPoints[i][2] != 1) { 
                   heartCheckPoints[i][2] = isPointInCircle(heartCheckPoints[i][0],heartCheckPoints[i][1],mouseX,mouseY);
               }
            }
        }
        
    }

    /**
    * 
    * Function name - isPointInCircle
    * Description   - 
    * @param     - 
    * @return        - int
    */
    private int isPointInCircle(int i, int j, int mouseX, int mouseY) {
       int distance = (i-mouseX)*(i-mouseX)+(j-mouseY)*(j-mouseY); 
           if(distance <= 100) {
               return 1;
           }
        return 0;
    }

    private void changeCursorAndColor(String resourceName, int redColor, int greenColor, int blueColor) {
        final Optional<PImage> imageOptional =
            Optional
                .ofNullable(resourceName)
                .map("/"::concat)
                .map(getClass()::getResource)
                .map(URL::getFile)
                .map(this::loadImage);
        if (imageOptional.isPresent()) {
            cursor(imageOptional.get());
        } else {
            cursor(HAND);
        }
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
    }

    public void dropdown(int n) {
        /* request the selected item based on index n */
        cursor(HAND);
        CColor c = new CColor();
        c.setBackground(color(255, 0, 0));
        dropDownSelection = cp5.get(ScrollableList.class, "dropdown").getItem(n).get("name").toString();
        System.out.println(dropDownSelection);
        cp5.get(ScrollableList.class, "dropdown").hide();
        switch (dropDownSelection) {

        case "Heart":
            drawHeart();
            break;
        case "Star":
            drawStar();
            break;
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = { "MySketch" };
        Drawscillate mySketch = new Drawscillate();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
