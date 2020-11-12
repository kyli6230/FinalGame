
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;

public class obstacle {
    private Image obstacle;
    private Rectangle hitbox;
    
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    
    public obstacle (int x, int y) throws SlickException{
        obstacle = new Image ("images/test.png");
        hitbox = new Rectangle (x,y, obstacle.getWidth(), obstacle.getHeight());
    }
    
    public Rectangle getHitBox(){
        return hitbox;
    }
    
    public static void setGameSize(int x, int y){
        GAME_HEIGHT=y;
        GAME_WIDTH=x;
    }
    
    public boolean hit (Rectangle x){
        if (hitbox.intersects(x)) return true;
        else return false;
    }
    
    public void move(){
        hitbox.setX(hitbox.getX() + 2);
        
        //go back to start
        if (hitbox.getX() >= 800)
            hitbox.setX(-150);
    }
    
    public void draw(){
        obstacle.draw(hitbox.getX(),hitbox.getY());
        
    }
}
