import org.newdawn.slick.*;

public class protoType extends BasicGame {

public protoType (String title) {
super(title);
}

public void init(GameContainer gc) throws SlickException {

}

public void update(GameContainer gc, int i) throws SlickException {

}

public void render(GameContainer gc, Graphics g) throws SlickException {
    g.setColor(Color.red);
    g.drawString("This is the main game", 100, 200);
}

public static void main(String args[]) throws SlickException {
  protoType game = new protoType("Testing Game");
  AppGameContainer app = new AppGameContainer(game);
  app.setDisplayMode(800, 600, false);
  app.setShowFPS(false);
  app.setTargetFrameRate(100);
  app.start();
}

}