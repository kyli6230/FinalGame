
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class mainGame extends BasicGameState {
    int tik = 300;
    ArrayList<obstacle> rocks;
    int timer, score1 = 0, score2 = 0;
    Color pink;
    player one, two;
    Countdown c;
    Sounder s, d;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       //music and sounds
        s = new Sounder("backgroundmusic.wav");
        d = new Sounder("crash.wav");
        s.play();
        
        //
        rocks = new ArrayList();
        timer = 2000;
        obstacle.setGameSize(800, 600);
        one = new player(200,525,0);
        two = new player(600,525,1);
        c = new Countdown();
        pink = new org.newdawn.slick.Color (196, 0, 151);
        
        //locations of the rocks
        int rockloc[][] = {
            {-480, 50},
            {-65, 100},
            {-270, 50},
            {-430, 100},
            {-165, 150},
            
            {-480, 460},
            {-270, 460},
            {-165, 460},
            
            {-145, 190},
            {-125, 280},
            {-330, 370},
            {-350, 100},
            {-490, 190},
            {-310, 280},
            {-100, 370},
            {-680, 100},
            {-660, 190},
            {-605, 280},
            {-735, 370},
            
            {-795, 190},
            {-805, 280},
            {-800, 370},
            {-835, 100},
            {-835, 190},
            {-795, 370},
            {-880, 100}};
        
        //placing the locations to the rocks
        for (int i = 0; i < rockloc.length; i++) {
            rocks.add(new obstacle(rockloc[i][0],rockloc[i][1]));
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        for (obstacle a : rocks) {
            a.move();
        }
        
        //did it crash
        for (obstacle a : rocks) {
            if (a.hit(one.getHitBox())) {
                d.play();
                one.move(200,525);
                d.reset();
            }
        }
        for (obstacle a : rocks) {
            if (a.hit(two.getHitBox())) {
                d.play();
                two.move(600,525);
                d.reset();
            }
        }
        
        //can't move until countdown is finished
        if (c.getTime() == 0)
            one.move(gc);
        if (c.getTime() == 0)
            two.move(gc);
        
        //once they get to the end - come back to start
        if (one.getY() <= 20){
            one.move(200,525);
            score1++;
        }
        if (two.getY() <= 20){
            two.move(600,525);
            score2++;
        }
        
        //end of game: who won?
        if (timer==0){
            if (score1>score2)
                sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
            else if (score2>score1)
                sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
            else
                sbg.enterState(5, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        if (c.getTime() == 0) //once countdown is done
            timer--;
        for (obstacle a : rocks) {
            a.draw();
        }
        
        one.draw(0);
        two.draw(1);
        
        //score board
        g.setColor (pink);
        g.fill(new Rectangle (0,0,800,40));
        g.setColor(Color.yellow);
        g.drawString("Time: " + timer/100, 10, 10);
        g.drawString("Player 1 Score: " + score1, 400, 10);
        g.drawString("Player 2 Score: " + score2, 590, 10);
        c.draw();
    }

    public int getID() {
        return 2;  //this id will be different for each screen
    }

}
