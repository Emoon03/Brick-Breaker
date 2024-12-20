/*  Name: Eric Moon
*  PennKey: ericmoon
*  Recitation: 216
*
*  Execution: java Game [filename]
*
*  Represents the brick breaker game. Takes a level
*  description text file and initializes a game arena
*  with that data, then runs the game until the player
*  wins or loses.
*
*/
public class Game {
    
    public static void main(String[] args) {
        // set width and height
        PennDraw.setCanvasSize(1000, 500);
        // The game runs at 30 frames per second
        PennDraw.enableAnimation(30);
        /* Instantiate an Arena provided with the
        *  name of a level description file, e.g.
        *  blocks.txt
        */
        Arena arena = new Arena(args[0]);
        /* While the player has neither won nor lost,
        *  keep running the game.
        */
        while (!arena.gameOver()) {
            arena.draw();
            arena.update();
        }
        /* When the while loop has finished, the game is
        *  over. The arena will draw either a victory screen
        *  or a defeat screen.
        */
        arena.drawGameCompleteScreen();
        
        //When the game is over, restart the game if the player presses the 'r' key
        while (arena.gameOver()) {

            char recentKey = ' ';

            if (PennDraw.hasNextKeyTyped()) {
                char nextKey = PennDraw.nextKeyTyped();
                recentKey = nextKey;
                
                if ((recentKey == 'r') && arena.gameOver()) {
                    arena = new Arena(args[0]);
                    while (!arena.gameOver()) {
                        arena.draw();
                        arena.update();
                    }
                    
                    arena.drawGameCompleteScreen();
                }
            }
        }
    }
}
