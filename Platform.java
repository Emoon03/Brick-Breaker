/**
* Name: Eric Moon
* Pennkey: ericmoon
* Recitation: 216
*
* A class that represents the platform in which the player controls to keep the
* ball in play.
**/
public class Platform {
    
    /* Private variables that contain the x and y center of the platform and the
    *  the half width and half height of the platform
    */
    private double xPos, yPos, width, height;
    
    /**
    * Using the given parameters construct a platform
    */
    public Platform(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }
    
    // Draw a rectangular platform
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void draw() {
        PennDraw.setPenColor(PennDraw.BOOK_LIGHT_BLUE);
        PennDraw.filledRectangle(xPos, yPos, width, height);
    }
    
    /**
    * Set xPos to 5
    * set yPos to 0.5
    * Reset the position of the platform when the player loses a life
    */
    public void reset() {
        xPos = 5.0;
        yPos = 0.5;
    }
    
    // Function that moves the platform right
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void moveRight() {
        xPos = xPos + 1;
    }
    
    // Function that moves the platform left
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void moveLeft() {
        xPos = xPos - 1;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the x center of the platform
    * Description: A getter function that gets the xCenter of the platform
    */
    public double getXpos() {
        return xPos;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the y center of the platform
    * Description: A getter function that gets the yCenter of the platform
    */
    public double getYpos() {
        return yPos;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the half width of the platform
    * Description: a getter function that returns the half width of the platform
    */
    public double getWidth() {
        return width;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the half height of the platform
    * Description: a getter function that returns the half height of the platform
    */
    public double getHeight() {
        return height;
    }
    
}
