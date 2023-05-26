import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapGrid extends JFrame {

    private int[][] map;
    private int[][] cells;

    public MapGrid(int[][] map, int[][] cells) {
        this.map = map;
        this.cells = cells;

        setTitle("Map Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int rows = map.length;
                int cols = map[0].length;
                int gridSize = 30;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        int x = j * gridSize;
                        int y = i * gridSize;
                        if (map[i][j] == 0) {
                            g.setColor(Color.WHITE);
                            // index mapy to 0 i index cells istnieje tu
                        } else if (map[i][j] == 2) {
                            g.setColor(Color.GREEN);
                        } else {
                            g.setColor(Color.RED);
                        }
                        g.fillRect(x, y, gridSize, gridSize);
                    }
                }
            }

        };

        int rows = map.length;
        int cols = map[0].length;
        int gridSize = 30;
        int width = cols * gridSize;
        int height = rows * gridSize;
        gridPanel.setPreferredSize(new Dimension(width, height));
        gridPanel.setBackground(Color.BLACK);
        gridPanel.setLayout(null);

        getContentPane().add(gridPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

    }
}