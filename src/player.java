
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class player {

    private Image rocket, rocket2, active;
    private Rectangle hitbox;
    private int controls;

    public player(int x, int y, int c) throws SlickException {
        rocket = new Image("images/player.png");
        rocket2 = new Image("images/player2.png");
        hitbox = new Rectangle(x, y, rocket.getWidth(), rocket.getHeight());
        //active = rocket2;
        controls = c;
    }

    public Rectangle getHitBox() {
        return hitbox;
    }

    public boolean hit(Rectangle x) {
        if (hitbox.intersects(x)) { //detecting hits
            return true;
        } else {
            return false;
        }
    }

    public void move(GameContainer gc) {
        Input in = gc.getInput(); //recives information from keyboard and mouse
        if (controls == 1) {
            //active = rocket;
            if (in.isKeyDown(Input.KEY_RIGHT) && (hitbox.getX() <= 765)) {
                hitbox.setX(hitbox.getX() + 2);
            }
            if (in.isKeyDown(Input.KEY_LEFT) && (hitbox.getX() >= 10)) {
                hitbox.setX(hitbox.getX() - 2);
            }
            if (in.isKeyDown(Input.KEY_UP)) {
                hitbox.setY(hitbox.getY() - 2);
            }
            if (in.isKeyDown(Input.KEY_DOWN)&& (hitbox.getY() <= 565)) {
                hitbox.setY(hitbox.getY() + 2);
            }
        }
        
         if (controls == 0) {
             //active = rocket2;
            if (in.isKeyDown(Input.KEY_D)&& (hitbox.getX() <= 765)) {
                hitbox.setX(hitbox.getX() + 2);
            }
            if (in.isKeyDown(Input.KEY_A)&& (hitbox.getX() >= 10)) {
                hitbox.setX(hitbox.getX() - 2);
            }
            if (in.isKeyDown(Input.KEY_W)) {
                hitbox.setY(hitbox.getY() - 2);
            }
            if (in.isKeyDown(Input.KEY_S) && (hitbox.getY() <= 565)) {
                hitbox.setY(hitbox.getY() + 2);
            }
        }
    }
    
    public void move(int x,int y){
        hitbox.setX(x);
        hitbox.setY(y);
    }

    public void draw(int p) {
        if (p==0)
            rocket.draw(hitbox.getX(), hitbox.getY());
        else
            rocket2.draw(hitbox.getX(), hitbox.getY());
    }
    
    public float getY(){
        return hitbox.getY();
    }
}
