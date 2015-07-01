/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.BusinessFacade;
import Business.User;
import java.net.MalformedURLException;
import java.net.URL;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Pedro Cunha
 */
public class MusicGame {
    private static BusinessFacade facade=new BusinessFacade();
    private static BasicPlayer player = new BasicPlayer();
    private static User user = null;
    private static Menu menuLogin, mainMenu, menuGenres, menuInGame;
    
    public static void playSong(String filename) {
        String songName = filename;
        String pathToMp3 = System.getProperty("user.dir") + "/music/" + songName;
        MusicGame.player = new BasicPlayer();
        try {
            MusicGame.player.open(new URL("file:///" + pathToMp3));
            MusicGame.player.play();
        } catch (BasicPlayerException | MalformedURLException e) {
        }
    }

    public static void stopSong() throws BasicPlayerException {
        MusicGame.player.stop();
    }
    
    public static void CarregaMenus() {
        String opLogin[] = {"Login", "Register"};
        String mainMenuOP[] = {"Start General Game", "Choose a Genre", "Show General Rankings","Choose a genre to show ranknigs"};


        MusicGame.menuLogin = new Menu(opLogin);
        MusicGame.mainMenu = new Menu(mainMenuOP);

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MusicGame.CarregaMenus();
        // TODO code application logic here
        
    }

}
