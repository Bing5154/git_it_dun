# git_it_dun
## APCS1 Final Project
### Team member: Angela Tom, Brandon Chong, Bing Li

### Project Description 
Our game will represent a two person checkerboard game. Each of the two players can choose either the black checkers or the red checkers. Both types of checkers have 12 pieces and obey the following rules:
* **Movement**: The basic movement is to move a checker one space diagonally forward.
* **Jump**: If one of your opponent’s checkers is on a forward diagonal next to one of your checkers, and the next space beyond the opponent’s checker is empty, then your checker must jump the opponent’s checker and land in the space beyond. Your opponent’s checker is captured and removed from the board.
  * **Forced capture**: If a jump is available for one of your pieces, you must make that jump (cannot move other pieces). If more jumps are available with that same piece, you must continue to jump with it until it can jump no more.
* **Crowning**: When one of your checkers reaches the opposite side of the board, it is crowned and becomes a King.
  * A King can move backward as well as forward along the diagonals. It can only move a distance of one space.
  * A King can also jump backward and forward. It must jump when possible, and it must take all jumps that are available to it.
  * Except for the fact that it can move backward one diagonal space, it follows the same rule as regular checker
* **Victory**: The game ends when one side capture all the opponent’s checkers, or you’ve surrounded your opponent’s checkers so that they have no available moves


### User Experience
Two players are required to play checkers: one will be red with “r” pieces and the other will be black with “b” pieces. The program will print out a prompt to ask for each player to choose their side. Red always starts first. Then our program ask the player to type coordinates of the checker piece they want to move.  After the player made their choice, the player will be prompted to enter “fr” (forward right) or “fl” (forward left) to move the checker piece one space diagonally or jump over the opponent’s checkers.  Forced jump takes higher priority than regular forward movement, meaning that the user must make a capture if there is an opponent checker piece one space diagonally forward on either side of their piece.  If the regular move (‘fl” and ‘fr’) is invalid due to a force jump for a different checker piece, then a message will be displayed. If multiple jumps are a possibility, then they will be executed automatically by our program.  When a checker piece that is not already a king reaches the end of the opponent’s side, it will become a king, which is represented with a capital “B” or “R” on the board. Then the players are given the choices of “fr” and “fl” as well as “br” (backward right) and “bl” (backward left) on the command prompt.  Red and black will continue taking turns until there is a victor, marking the end.  That can occur in two ways: either of the sides do not have any valid moves or a side does not have any checkers left. The winner with the least number of moves will appear in the scoreboard. 
 


