
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Countdown {
   private Image one, two, three, go, active; 
   private int timer;
   
   public Countdown () throws SlickException{
       //initializing the photos
        one = new Image ("images/one.png");
        two = new Image ("images/two.png");
        three = new Image ("images/three.png");
        go = new Image ("images/go.png");
        timer=400;
        active = three; //one active photo for the different images
    }
   
   public void draw(){
       timer = timer >0? timer-1: 0; //stop timer at 0
       
       //countdown changing the images
       if(timer >=300)
           active = three;
       else if(timer>=200)
           active=two;
       else if(timer>=100)
           active=one;
       else
           active = go;
       if(timer > 0 && active != go)
            active.draw(355,300);
       if (timer > 0 && active == go)
            active.draw(290,300);
   }
   
   public int getTime(){
       return timer;
   }
}
