/*  
*  Name: Eric Moon
*  PennKey: ericmoon
*  Recitation: 216
*
*  A class that represents the ball projectile for the brick breaker game. 
*  Can update its own position based on its velocity and determines if it comes 
*  into contact with a block, platform, or walls of the arena.
*
*/
public class Ball {
    
    // Private variables that contain the position, velocity, and radius of the ball
    private double xPos, yPos, radius, xVel, yVel;

    // How many lives the player has remaining
    private int livesRemaining;

    /**
    * Construct the ball given the xpos, ypos, radius, xvel, yvel, 
    * and lives Remaining
    */
    public Ball(double xPos, double yPos, double radius, 
    double xVel, double yVel, int livesRemaining) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        this.xVel = xVel;
        this.yVel = yVel;
        this.livesRemaining = livesRemaining;
        
    }
    
    /**
    * Draws a filled circle centered at the ball's position
    * and the lives remaining text at the top right of the screen
    */

    public void draw() {
        // draw ball
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledCircle(xPos, yPos, radius);

        // draw lives remaining text at top right and also a top boundary
        PennDraw.setFontSize(15);
        PennDraw.text(8.75, 5.25, "Lives Remaining:" + this.getLivesRemaining());
        PennDraw.filledRectangle(5, 5.01, 5, .01);
        
    }
    
    /* 
    * Reset the position of the ball to the top of the platform when the player
    * loses a life.
    * Set the x and y velocity back to 0.1.
    */
    public void reset() {
        xPos = 5.0;
        yPos = 0.75;
        xVel = 0.1;
        yVel = 0.1;
    }
    
    /**
    * Update the position of the ball and determine if the ball hits
    * the top and side boundaries of the arena
    */
    public void update() {
        xPos = xPos + xVel;
        yPos = yPos + yVel;
        
        // The ball bounces off the sides of the arena
        if (xPos + radius >= 10 && xVel > 0 || xPos - radius <= 0 && xVel < 0) {
            xVel = -xVel;
        }
        
        // The ball bounces off the top of the arena
        if (yPos + radius >= 5 && yVel > 0) {
            yVel = -yVel;
        }
        
    }
    
    
    /**
    * Checks if the ball collides with a block if the block has more
    * than 0 hitpoints remaining. If the ball collides with the block then
    * decrease the Block's HP by one.
    */
    public void testAndHandleCollision(Block t) {
        // Check if block has more than 0 hp
        if (t.getHitPoints() > 0) {

            /* If ball hits BOTTOM of block then deflect ball with acceleration
            * and reduce a health point
            */
            if ((this.yPos + this.radius >= t.getYpos() - t.getHeight()) && 
            (this.xPos > t.getXpos() - t.getWidth()) && 
            (this.xPos < t.getXpos() + t.getWidth()) && 
            ((this.yPos <= t.getYpos() - t.getHeight() + 0.1))) {

                t.setHitThisShot(true);
                
                yVel = yVel * 1.01;
                xVel = xVel * 1.01;
                yVel = -Math.abs(yVel);

            }
            
            /* If ball hits TOP of block then deflect ball with acceleration
            * and reduce a health point
            */
            if ((this.yPos - this.radius <= t.getYpos() + t.getHeight()) && 
            (this.xPos > t.getXpos() - t.getWidth()) && 
            (this.xPos < t.getXpos() + t.getWidth()) && 
            ((this.yPos >= t.getYpos() + t.getHeight() - 0.1))) {

                t.setHitThisShot(true);
                
                yVel = yVel * 1.01;
                xVel = xVel * 1.01;
                yVel = Math.abs(yVel);
                
            }

            /* If ball hits RIGHT side of block then deflect ball with acceleration
            * and reduce a health point
            */            
            if ((this.xPos - this.radius <= t.getXpos() + t.getWidth()) && 
            (this.yPos < t.getYpos() + t.getHeight()) && 
            (this.yPos > t.getYpos() - t.getHeight()) && 
            (this.xPos >= t.getXpos() + t.getWidth() - 0.1)) {

                t.setHitThisShot(true);
                
                yVel = yVel * 1.01;
                xVel = xVel * 1.01;
                xVel = Math.abs(xVel);
                
            }

            /* If ball hits LEFT side of block then deflect ball with acceleration
            * and reduce a health point
            */                  
            if ((this.xPos + this.radius >= t.getXpos() - t.getWidth()) && 
            (this.yPos < t.getYpos() + t.getHeight()) && 
            (this.yPos > t.getYpos() - t.getHeight()) && 
            (this.xPos < t.getXpos() - t.getWidth() + 0.1)) {

                t.setHitThisShot(true);
                
                yVel = yVel * 1.01;
                xVel = xVel * 1.01;
                xVel = -Math.abs(xVel);
                
            }
            
        }
    }
    
    /**
    * Checks if the ball collides with the platform.
    * If the ball collides with the platform then deflect it.
    * If the ball hits the right half of the platform deflect it rightward.
    * If the ball hits the left half of the platform deflect it leftward.
    */
    public void testAndHandleCollision(Platform p) {

        /* If ball hits BOTTOM of platform then deflect ball upward
        * (this is to ensure that ball does not get stuck on the platform)
        */
        if ((this.yPos + this.radius >= p.getYpos() - p.getHeight()) && 
        (this.xPos > p.getXpos() - p.getWidth()) && 
        (this.xPos < p.getXpos() + p.getWidth()) && 
        ((this.yPos - this.radius <= p.getYpos() - p.getHeight() + 0.1))) {

            yVel = Math.abs(yVel);

        }

        // If ball hits the left half of platform then deflect ball upward and left

        if ((this.yPos - this.radius <= p.getYpos() + p.getHeight()) && 
        (this.yPos - this.radius >= p.getYpos() + p.getHeight() - 0.1) && 
        (this.xPos < p.getXpos()) && 
        (this.xPos > p.getXpos() - p.getWidth())) {

            xVel = xVel * 1.02;
            xVel = -Math.abs(xVel);
            yVel = Math.abs(yVel);

        }

        // If ball hits the right half of platform then deflect ball upward and right

        if ((this.yPos - this.radius <= p.getYpos() + p.getHeight()) && 
        (this.yPos - this.radius >= p.getYpos() + p.getHeight() - 0.1) && 
        (this.xPos > p.getXpos()) && 
        (this.xPos  < p.getXpos() + p.getWidth())) {

            xVel = xVel * 1.02;
            xVel = Math.abs(xVel);
            yVel = Math.abs(yVel);

        }
        
        /* If ball hits the right side of platform then deflect ball rightward
        *  with an accel
        */
        if ((this.xPos - this.radius <= p.getXpos() + p.getWidth()) && 
        (this.yPos < p.getYpos() + p.getHeight()) && 
        (this.yPos > p.getYpos() - p.getHeight()) && 
        (this.xPos >= p.getXpos() + p.getWidth() - 0.1)) {

            xVel = xVel * 1.02;
            xVel = Math.abs(xVel);
            
        }
        
        /* If ball hits the left side of platform then deflect ball leftward
        *  with an accel
        */
        if ((this.xPos + this.radius >= p.getXpos() - p.getWidth()) && 
        (this.yPos < p.getYpos() + p.getHeight()) && 
        (this.yPos > p.getYpos() - p.getHeight()) && 
        (this.xPos <= p.getXpos() - p.getWidth() + 0.1)) {

            xVel = xVel * 1.02;
            xVel = -Math.abs(xVel);

        }
        
    }
    
    /**
    * Inputs: N/A
    * Outputs: N/A
    * Description: Reduces livesRemaining by 1
    */
    public void decreaseLives() {
        livesRemaining = livesRemaining - 1;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the xCenter of the ball
    * Description: A getter function that gets the xCenter of the ball
    */
    public double getXpos() {
        return xPos;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the yCenter of the ball
    * Description: A getter function that gets the yCenter of the ball
    */
    public double getYpos() {
        return yPos;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the radius of the ball
    * Description: A getter function that gets the radius of the ball
    */
    public double getRadius() {
        return radius;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the xVelocity of the ball
    * Description: A getter function that gets the xVelocity of the ball
    */
    public double getXvel() {
        return xVel;
    }
    
    /**
    * Inputs: N/A
    * Outputs: A double value that represents the yVelocity of the ball
    * Description: A getter function that gets the yVelocity of the ball
    */
    public double getYvel() {
        return yVel;
    }
    
    /**
    * Inputs: N/A
    * Outputs: An int value that represents the lives remaining
    * Description: A getter function that gets the number of lives remaining
    */
    public int getLivesRemaining() {
        return livesRemaining;
    }
    
}
