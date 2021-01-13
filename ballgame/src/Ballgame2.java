import java.awt.*;
import javax.swing.*;
public class Ballgame2 extends JFrame {
    Image ball= Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk= Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
    double s=10;
    double x=100;
    double y=100;
    double degree=3.14/3; //arch
    //画窗口
    public void paint(Graphics g) {
        System.out.println("画窗口");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        x = x - s * Math.cos(degree);
        y = y - s * Math.sin(degree);

        if (y > 500 - 30 - 40 || y < 80) {
            degree = -degree;
        }
        if (x < 40 || x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }
        if (s >= 0) {
            s=s - 0.03;
        }else s=0;
    }
    //窗口加载
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);
        //redraw
        while (true&&s>=0){
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
        Ballgame2 game = new Ballgame2();
        game.launchFrame();
    }
}

