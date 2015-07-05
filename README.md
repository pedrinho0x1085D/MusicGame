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

Currently there are 12 songs, you can find them in the integrity here: [Music Folder](https://drive.google.com/folderview?id=0B7jXRoARU1FzfjJPMXJZQjhHQTM4dmNDZnAtOUVjV3dRRG5ZVlEzYnRDSjBIVVQ0RFVGSTg&usp=sharing "Music Game Data"). Additionaly feel free to add [here](https://drive.google.com/folderview?id=0B7jXRoARU1FzflhTVUc4VzV1c0lqTjJDTFk3M3Z2VzJjUjd4MHhqQVdXdjJBXzVZWWxBa2c&usp=sharing "Music Game Data") new musics and questions, there's a XML there, I'll check regularly to add to the XML kept in the repository.

The program's state is saved when the user logs out.
## Program screenshots:
![alt text](http://i.imgur.com/IfBCv4V.png "Login/Register Screen")

![alt text](http://i.imgur.com/FOIsj60.png "Main Screen")

![alt text](http://i.imgur.com/Dbt89KE.png "Game selection Screen")

![alt text](http://i.imgur.com/dxk1Ub7.png "In Game Screen")

![alt text](http://i.imgur.com/1j8nvJY.png "Rankings Screen")

The music is accessed from the /music folder and is played using the javazoom.jlgui.basicplayer libraries.





