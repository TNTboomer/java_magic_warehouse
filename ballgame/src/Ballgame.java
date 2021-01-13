import java.awt.*;
import javax.swing.*;
public class Ballgame extends JFrame {
    Image ball= Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk= Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x=100;
    double y=100;
    boolean right=true; //true向右
    ////window drawing
    public void paint(Graphics g) {
        System.out.println("window drawing");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);
        if (right) {
            x = x + 10;
        } else {
            x = x - 10;
        }
        if (x > 856-40-30) {
            right = false;
        }
        if (x < 40) {
            right = true;
        }
    }
    ////window loading
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);
        //redraw
        while (true){
            repaint();
            try{
                Thread.sleep(16);////window will be redraw about per 16 ms, 1000ms/16ms is 62.5 FPS.
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Ballgame");
        Ballgame game = new Ballgame();
        game.launchFrame();
    }
}

