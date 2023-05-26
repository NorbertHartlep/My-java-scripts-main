import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomWalk extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int SIZE = 600; // rozmiar okna
    private static final int STEPS = 1000; // liczba kroków
    private static final int STEP_SIZE = 4; // długość kroku
    private static final int DELAY = 10; // opóźnienie między krokami
    private int x, y; // pozycja początkowa

    public RandomWalk() {
        Random rand = new Random();
        x = rand.nextInt(SIZE);
        y = rand.nextInt(SIZE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 5, 5);
    }

    public void simulate() throws InterruptedException {
        Random rand = new Random();
        for (int i = 0; i < STEPS; i++) {
            int direction = rand.nextInt(4); // losowy kierunek
            switch (direction) {
                case 0:
                    x += STEP_SIZE; // prawo
                    break;
                case 1:
                    x -= STEP_SIZE; // lewo
                    break;
                case 2:
                    y += STEP_SIZE; // dół
                    break;
                case 3:
                    y -= STEP_SIZE; // góra
                    break;
            }
            if (x < 0 || x > SIZE || y < 0 || y > SIZE) { // sprawdzenie granic
                x = SIZE / 2;
                y = SIZE / 2;
            }
            repaint(); // odrysowanie punktu
            Thread.sleep(DELAY); // opóźnienie
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Random Walk");
        RandomWalk walk = new RandomWalk();
        frame.add(walk);
        frame.setSize(SIZE, SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        walk.simulate();
    }
}