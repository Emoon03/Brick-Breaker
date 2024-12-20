/**********************************************************************
 *  readme BrickBreaker
 **********************************************************************/

Name: Eric Moon 
PennKey: ericmoon
Recitation: 216
Hours to complete assignment (optional):



/**********************************************************************
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/

I did not receive any help outside of TA office hours.  I
did not collaborate with anyone, and I did not use any
resources beyond the standard course materials.

/**********************************************************************
 *  Did you find this assignment helpful in reinforcing concepts related
 *  to Object Oriented Programming? Please provide feedback/suggestions!
 *  Please note that this is a graded question!
 **********************************************************************/

Yes, I learned how to use getter and setter functions to work around private
instance variables. It also helped get more experience working with objects that
span their implementation across multiple classes.


/**********************************************************************
Instructions for how to run your program 
(which class to run, any command line arguments)                
 **********************************************************************/

compile -> java Game blocks.txt

In order to run the program:
1. Compile
2. Run the "Game.java" file
3. Use "blocks.txt" in the command line argument


/**********************************************************************
Any additional features you added beyond the assignment specifications
 *********************************************************************/

n/a


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