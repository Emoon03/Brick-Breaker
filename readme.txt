/**********************************************************************
Instructions for how to run program 
(which class to run, any command line arguments)                
 **********************************************************************/

In order to run the program:
1. Compile
2. Run the "Game.java" file
3. Use "blocks.txt" in the command line argument

compile -> java Game blocks.txt

/**********************************************************************
A brief description of each file and its purpose                                  
 **********************************************************************/

Ball.java:  
            Contains all the necessary code needed to create the brick breaker ball
            that interacts with the platform, blocks, and arena. Determines if the
            ball collides with any of the game elements.
Block.java: 
            Contains all the code needed to create the target blocks that the player
            tries to destroy in order to win the game. Contains instructions on 
            how the blocks are affected if hit by the ball.
Platform.java: 
            Contains the code needed to create the platform in which the player
            moves around and hits the ball with to keep the ball in play
Arena.java: 
            Contains the code needed to create the arena in which the brick breaker 
            game takes place. Keeps track of the Ball, Blocks, and Platform and 
            receives player input to control the platform. Basically where all the
            classes work together.
Game.java:
            Contains the code needed to run the BrickBreaker game. Sets the
            frame rate, size of canvas, and checks to see if the game is over.
blocks.txt:
            A text file that contains all the values needed to initialize the various
            game elements such as block position, ball velocity, etc.
