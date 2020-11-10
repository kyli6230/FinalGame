
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class player {

    private Image rocket;
    private Rectangle hitbox;
    private int controls;

    public player(int x, int y, int c) throws SlickException {
        rocket = new Image("images/player.png");
        hitbox = new Rectangle(x, y, rocket.getWidth(), rocket.getHeight());
        controls = c;
    }

    public Rectangle getHitBox() {
        return hitbox;
    }

    public boolean hit(Rectangle x) {
        if (hitbox.intersects(x)) {
            return true;
        } else {
            return false;
        }
    }

    public void move(GameContainer gc) {
        Input in = gc.getInput(); //recives information from keyboard and mouse
        if (controls == 1) {
            if (in.isKeyDown(Input.KEY_RIGHT) && (hitbox.getX() <= 765)) {
                hitbox.setX(hitbox.getX() + 2);
            }
            if (in.isKeyDown(Input.KEY_LEFT) && (hitbox.getX() >= 35)) {
                hitbox.setX(hitbox.getX() - 2);
            }
            if (in.isKeyDown(Input.KEY_UP)) {
                hitbox.setY(hitbox.getY() - 2);
            }
            if (in.isKeyDown(Input.KEY_DOWN)) {
                hitbox.setY(hitbox.getY() + 2);
            }
        }
        
         if (controls == 0) {
            if (in.isKeyDown(Input.KEY_D)&& (hitbox.getX() <= 765)) {
                hitbox.setX(hitbox.getX() + 2);
            }
            if (in.isKeyDown(Input.KEY_A)) {
                hitbox.setX(hitbox.getX() - 2);
            }
            if (in.isKeyDown(Input.KEY_W) && (hitbox.getX() >= 35)) {
                hitbox.setY(hitbox.getY() - 2);
            }
            if (in.isKeyDown(Input.KEY_S)) {
                hitbox.setY(hitbox.getY() + 2);
            }
        }
    }
    
    public void move(int x,int y){
        hitbox.setX(x);
        hitbox.setY(y);
    }

    public void draw() {
        rocket.draw(hitbox.getX(), hitbox.getY());

    }
    
    public float getY(){
        return hitbox.getY();
    }
    

}
