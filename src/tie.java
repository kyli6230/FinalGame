import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class tie extends BasicGameState {

    Image img;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       img = new Image("images/tiegame.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       //img.draw(0,0);
       g.setColor(Color.red);
       g.drawString("you tie", 100, 200);
    }
    
    public int getID() {
       return 5;  //this id will be different for each screen
    }

    
}