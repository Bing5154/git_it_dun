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


### Instructions
1. Get one friend to play this game with you.
2. Open the terminal and type javac Woo.java --> java Woo
3. Read the rules carefully.
4. Decide who will be red (red always starts first)
5. Choose the coordinate of your intended piece, one coordinate at a time
6. Choose the movement of your intended piece (fl, fr, br, bl)
7. Please do not ignore error messages
8. Switch side so your friend can play
9. You may check the score board when the game is over. 
8. Enjoy your time!



 


