/*  
*  Name: Eric Moon
*  PennKey: ericmoon
*  Recitation: 216
*
*  A class that represents the arena in which the brick breaker game takes place.
*  Keeps track of the Ball, Blocks, and Platform and receives player input to
*  control the platform.
*
*/
public class Arena {
    // The width and height of the PennDraw screen
    private double screenWidth, screenHeight;
    
    // The blocks in the arena
    private Block[] blocks;
    
    // The platform used in the game
    private Platform platform;
    
    // The ball used in the game
    private Ball ball;
    
    // Whether the game is currently listening for the player's mouse input
    private boolean mouseListeningMode;
    private boolean mouseWasPressedLastUpdate;


    /**
    * Given a file that describes the contents of the
    * Arena, parse the file and initialize all member
    * variables of the Arena.
    * The file will be in the following format:
    * numBlocks screenWidth screenHeight
    * block0.xPos block0.yPos block0.width block0.height block0.hitPoints
    * block1.xPos... etc.
    */
    
    public Arena(String filename) {
        //parses given file and init all member variables.
        In in = new In(filename);
        int numBlocks = in.readInt();
        screenWidth = in.readDouble();
        screenHeight = in.readDouble();
        blocks = new Block[numBlocks];
        
        //Create new block objects and places them in the corresponding array entry
        for (int i = 0; i < numBlocks; i++) {
            Block object = new Block(screenWidth, screenHeight,
            in.readDouble(), in.readDouble(), in.readDouble(), 
            in.readDouble(), in.readInt());
            
            blocks[i] = object;
        }
        
        // Set canvas scale to the screen width and height
        PennDraw.setXscale(0, screenWidth);
        PennDraw.setYscale(0, screenHeight);
        
        /*
        * Initialize platform with given parameters
        */
        platform = new Platform(5, 0.5, .8, 0.075);
        
        /*
        * Initialize ball with given parameters
        */
        ball = new Ball(5, 0.675, 0.1, 0.1, 0.1, 3);
        
        in.close();
        
        mouseListeningMode = true;
        mouseWasPressedLastUpdate = false;
    }
    
    /**
    * Returns true when all targets' hit points are 0.
    * Returns false in any other scenario.
    */
    private boolean didPlayerWin() {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i].getHitPoints() > 0) {
                return false;
            }
        }
        return true;
        
    }
    
    /**
    * Returns true when the balls's lives remaining is 0
    * Returns false in any other scenario.
    */
    private boolean didPlayerLose() {
        if (ball.getLivesRemaining() == 0) {
            return true;
        }
        
        return false;
    }
    
    /**
    * Returns true when either the win or lose
    * condition is fulfilled.
    * Win: All blocks' hit points are 0.
    * Lose: The ball's remaining lives reaches 0.
    */
    public boolean gameOver() {
        if (didPlayerWin() || didPlayerLose()) {
            return true;
        }
        
        return false;
    }
    
    char recentKey = ' ';
    
    /**
    * Update each of the entities within the arena.
    */
    public void update() {

        if (mouseListeningMode) {
            /**
            * If the mouse is currently pressed, then
            * set mouseWasPressedLastUpdate to true
            */
            if (PennDraw.mousePressed()) {
                mouseWasPressedLastUpdate = true;
            }

            /**
            * If the mouse is NOT currently pressed, AND
            * mouseWasPressedLastUpdate is currently true,
            * that means the player has just released the
            * mouse button, and the game should begin
            */
            else if (!PennDraw.mousePressed() && mouseWasPressedLastUpdate) {
                mouseWasPressedLastUpdate = false;
                mouseListeningMode = false;
            }
        }
        
        else {
            //Manage the movement of the platform
            if (PennDraw.hasNextKeyTyped()) {
                char nextKey = PennDraw.nextKeyTyped();
                recentKey = nextKey;
                
                //If player presses d key the platform moves right
                if (recentKey == 'd' && 
                platform.getXpos() + platform.getWidth() < 10) {
                    platform.moveRight();
                }
                
                //If player presses a key the platform moves left
                if (recentKey == 'a' && 
                platform.getXpos() - platform.getWidth() > 0) {
                    platform.moveLeft();
                }
            }

            ball.update();
            ball.testAndHandleCollision(platform);
            
            for (int i = 0; i < blocks.length; i++) {
                ball.testAndHandleCollision(blocks[i]);
            }

            //If block is hit then decrease HP
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i].isHit()) {
                    blocks[i].decreaseHP();
                    blocks[i].setHitThisShot(false);
                }
            }

            /* If ball goes off the bottom of screen reset back to initialized
            *  start position
            */
            if (missBall()) {
                ball.reset();
                ball.decreaseLives();
                platform.reset();
                mouseListeningMode = true;
                
            }
        }
        
    }
    
    /**
    * Inputs: n/a
    * Outputs: returns a boolean value
    * Description: Returns true if the ball falls through the bottom of the screen
    */
    public boolean missBall() {
        return ball.getYpos() + ball.getRadius() <= 0;
    }
    
    /**
    * 1. Clear the screen
    * 2. Draw each block
    * 3. Draw the platform
    * 5. Draw the ball
    * 5. Advance PennDraw.
    */
    public void draw() {
        PennDraw.clear();
        
        for (int i = 0; i < blocks.length; i++) {
            blocks[i].draw();
        }
        
        platform.draw();
        
        ball.draw();
        
        PennDraw.advance();
        
    }
    
    /**
    * Draws either the victory or loss screen.
    * If all targets have 0 hit points, the player has won.
    * Otherwise they have lost.
    * Also displays a play again prompt.
    */
    public void drawGameCompleteScreen() {
        PennDraw.clear();
        PennDraw.setPenColor(PennDraw.BLACK);
        
        //Asks the player if they would like to play again
        PennDraw.text(5, screenHeight / 2, "Press 'r' key to play again!");

        //Draws victory if player wins
        if (didPlayerWin()) {
            PennDraw.text(screenWidth / 2, 2.4, "You Win!");
        }
        
        //Draws defeat screen in player loses
        else if (didPlayerLose()) {
            PennDraw.text(screenWidth / 2, 2.4, "You have lost...");
        }
        
        PennDraw.advance();
    }
    
}
