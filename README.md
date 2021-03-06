# MusicGame
Side project made in Java to train some Java Swing knowledges aquired.

The game consists of a set of 10 different questions with a background music to help the player answer.

Uses both Object File Reading and XML File loading.

The XML file has the following structure:

```xml
<question>
    <text></text>
		<opt1></opt1>
		<opt2></opt2>
		<opt3></opt3>
		<opt4></opt4>
		<file></file>
		<correct></correct>
		<genre></genre>		
		<score></score>
</question>
```
The element score has the following restrictions:
* 5 for Hard
* 3 for Medium
* 1 for Easy

Currently there are 21 songs, you can find them in the integrity here: [Music Folder](https://drive.google.com/folderview?id=0B7jXRoARU1FzfjJPMXJZQjhHQTM4dmNDZnAtOUVjV3dRRG5ZVlEzYnRDSjBIVVQ0RFVGSTg&usp=sharing "Music Game Data"). Additionaly feel free to add [here](https://drive.google.com/folderview?id=0B7jXRoARU1FzflhTVUc4VzV1c0lqTjJDTFk3M3Z2VzJjUjd4MHhqQVdXdjJBXzVZWWxBa2c&usp=sharing "Music Game Data") new musics and questions, there's a XML there, I'll check regularly to add to the XML kept in the repository.

The program's state is saved when the user logs out.
## Program screenshots:
### Login/Register Screen
This is the moment when the user can login or register. The button below the text fields allows to change from Login mode (by default) to Register mode, working as a toggle button.

![alt text](http://i.imgur.com/IfBCv4V.png "Login/Register Screen")

### Main Screen
Here the user can do three diferent things:
* Play a New Game and will be redirected to the Game Selection Screen;
* See the Rankings from all the players, being redirected to the Rankings Screen;
* Logout the game. By clicking here the current program state is saved to an object file (data.obj).

![alt text](http://i.imgur.com/FOIsj60.png "Main Screen")

### Game Selection Screen
Here the user can choose the kind of game to play. Having the Toggle Button "Click to choose a genre" pressed allows the user to choose a music genre. By default it's set to start a game with ten random questions from all genres.

![alt text](http://i.imgur.com/Dbt89KE.png "Game selection Screen")

### In Game Screen
Here is the in game screen. It's shown the genre of the song, the question text, the four options and the song playing in the background. When the user presses "Submit", the song stops playing, the next question is generated and loaded. 

![alt text](http://i.imgur.com/dxk1Ub7.png "In Game Screen")

### Rankings Screen
Here we have the Rankings screen. It consists of a List with all the best scores.

![alt text](http://i.imgur.com/1j8nvJY.png "Rankings Screen")

The music is accessed from the /music folder and is played using the javazoom.jlgui.basicplayer libraries.

Currently the main focus of the program development is turned to expand its question quantity, quality and diversity (of genres).



