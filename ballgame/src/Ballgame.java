import java.awt.*;
import javax.swing.*;
public class Ballgame extends JFrame {
    Image ball= Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk= Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x=100;
    double y=100;
    boolean right=true; //true向右
    //画窗口
    public void paint(Graphics g) {
        System.out.println("画窗口");
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
    //窗口加载
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);
        //redraw
        while (true){
            repaint();
            try{
                Thread.sleep(16);//1秒60次（约）
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("小球游戏");
        Ballgame game = new Ballgame();
        game.launchFrame();
    }
}

