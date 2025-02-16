import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallCollisionGame extends JPanel implements ActionListener {
    private Timer timer;
    private Ball ball1, ball2;

    public BallCollisionGame() {
        ball1 = new Ball(50, 50, 20, 2, 3, Color.RED);
        ball2 = new Ball(200, 200, 20, -3, -2, Color.BLUE);
        timer = new Timer(10, this);
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball1.draw(g);
        ball2.draw(g);
    }
    public void actionPerformed(ActionEvent e) {
        ball1.move(getWidth(), getHeight());
        ball2.move(getWidth(), getHeight());
        checkCollision();
        repaint();
    }
}

class Ball {
    int x, y, radius;
    double vx, vy;
    Color color;

    public Ball(int x, int y, int radius, double vx, double vy, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }

    public void move(int width, int height) {
        x += vx;
        y += vy;

        if (x - radius < 0 || x + radius > width) {
            vx = -vx;
        }
        if (y - radius < 0 || y + radius > height) {
            vy = -vy;
        }
    }
}

