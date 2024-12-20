/**
* Name: Eric Moon
* Pennkey: ericmoon
* Recitation: 216
*
* A class that represents the target Blocks to be hit in the BrickBreaker game.
**/

public class Block {
    
    // Private variables for screen width, screen height, xPos, yPos, width, height
    private double screenWidth, screenHeight, xPos, yPos, width, height;
    
    // Private variable for amount of hit points the block has
    private int hitPoints;
    
    // Track if block has been hit by the ball
    private boolean hitThisShot;
    
    /*
    * Given a screen width, screen height, xPos, yPos, width, height, and hit points
    * construct a block.
    */
    public Block(double screenWidth, double screenHeight, double xPos, double yPos, 
    double width, double height, int hitPoints) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.hitPoints = hitPoints;
        hitThisShot = false;
        
    }
    
    /*
    * Draw the target blocks based off the number of lives the block has remaining.
    * If the block has 3 lives, color the block green.
    * If the block has 2 lives, color the block yellow.
    * If the block has 1 lives, color the block red.
    */
    public void draw() {
        if (hitPoints == 3) {
            PennDraw.setPenColor(5, 102, 8);
            PennDraw.filledRectangle(xPos, yPos, width, height);
        }
        
        if (hitPoints == 2) {
            PennDraw.setPenColor(255, 195, 11);
            PennDraw.filledRectangle(xPos, yPos, width, height);
        }
        
        if (hitPoints == 1) {
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledRectangle(xPos, yPos, width, height);
        }
    }
    
    /**
    * Inputs: N/A
    * Outputs: N/A
    * Description: Decrement the target's hit points by 1.
    */
    public void decreaseHP() {
        --hitPoints;
    }
    
    /**
    * Inputs: A boolean hit
    * Outputs: N/A
    * Description: A setter function for whether or not a block was hit this round
    */
    public void setHitThisShot(boolean hit) {
        hitThisShot = hit;
    }
    
    /**
    * Inputs: N/A
    * Outputs: a boolean variable that returns T/F depending on if the block was hit
    * Description: A getter function that returns whether block is hit
    */
    public boolean isHit() {
        return hitThisShot;
    }
    
    /**
    * Inputs: N/A
    * Outputs: returns an int value representing the number of block hitpoints
    * Description: a getter function that returns the hitpoints of block
    */
    public int getHitPoints() {
        return hitPoints;
    }
    
    /**
    * Inputs: N/A
    * Outputs: returns a double value that represents x center of the block
    * Description: a getter function that returns the xCenter of block
    */
    public double getXpos() {
        return xPos;
    }
    
    /**
    * Inputs: N/A
    * Outputs: returns a double value that represents y center of the block
    * Description: a getter function that returns the yCenter of block
    */
    public double getYpos() {
        return yPos;
    }
    
    /**
    * Inputs: N/A
    * Outputs: returns a double value that represents half width of the block
    * Description: a getter function that returns half width of the block
    */
    public double getWidth() {
        return width;
    }
    
    /**
    * Inputs: N/A
    * Outputs: returns a double value that represents half height of the block
    * Description: a getter function that returns half height of the block
    */
    public double getHeight() {
        return height;
    }
}
