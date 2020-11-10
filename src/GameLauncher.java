import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameLauncher extends StateBasedGame {

    
    public GameLauncher(String title) {
        super(title);
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
       //list other screens in here - first one is opening screen
       this.addState(new startScreen());
       this.addState(new instScreen());
       this.addState( new mainGame());
       this.addState( new player1wins());
       this.addState( new player2wins());
       this.addState( new tie());
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("Space Race");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}