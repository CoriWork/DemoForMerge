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

    private void checkCollision() {
        double dx = ball1.x - ball2.x;
        double dy = ball1.y - ball2.y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < ball1.radius + ball2.radius) {
            double angle = Math.atan2(dy, dx);
            double targetX = ball2.x + Math.cos(angle) * (ball1.radius + ball2.radius);
            double targetY = ball2.y + Math.sin(angle) * (ball1.radius + ball2.radius);
            double ax = (targetX - ball1.x) * 0.05;
            double ay = (targetY - ball1.y) * 0.05;

            ball1.vx -= ax;
            ball1.vy -= ay;
            ball2.vx += ax;
            ball2.vy += ay;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Collision Game");
        BallCollisionGame game = new BallCollisionGame();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}

