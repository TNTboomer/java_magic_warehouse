import java.awt.*;
import javax.swing.*;
public class ballgame3 extends JFrame {
    Image ball= Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk= Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x=100;
    double y=100;
    double degree=3.14/3; //arch
    //������
    public void paint(Graphics g) {
        System.out.println("������");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        x=x+10*Math.cos(degree);
        y=y+10*Math.sin(degree);

        if (y>500){
            degree=-degree;
        }

    }
    //���ڼ���
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);
        //redraw
        while (true){
            repaint();
            try{
                Thread.sleep(16);//1��60�Σ�Լ��
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("С����Ϸ");
        ballgame3 game = new ballgame3();
        game.launchFrame();
    }
}

