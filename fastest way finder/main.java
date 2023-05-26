import java.util.*;
import javax.swing.JFrame;

public class main {

    private static class Node {
        int x, y;
        int g;
        int h; // heurystyka - szacowany koszt do celu
        int f; // f = g + h - całkowity koszt do celu
        Node parent; // pole, z którego przyszliśmy

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            g = 0;
            h = 0;
            f = 0;
            parent = null;
        }

        // metoda obliczająca heurystykę - odległość euklidesowa
        int calcH(Node end) {
            return (int) Math.sqrt((end.x - x) * (end.x - x) + (end.y - y) * (end.y - y));
        }
    }

    private Node[][] grid; // siatka pól na planszy
    private Set<Node> openSet; // lista otwarta
    private Set<Node> closedSet; // lista zamknięta
    private List<Node> path; // znaleziona droga

    // konstruktor
    public main(int[][] map, int startX, int startY, int endX, int endY) {
        int rows = map.length;
        int cols = map[0].length;
        grid = new Node[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Node(i, j);
            }
        }

        // ustawienie kosztów pól i niedostępnych pól
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 1) {
                    grid[i][j] = null; // pole niedostępne
                } else {
                    grid[i][j].g = Integer.MAX_VALUE;
                }
            }
        }

        // ustawienie punktu startowego i końcowego
        Node start = grid[startX][startY];
        Node end = grid[endX][endY];

        start.g = 0;
        start.h = start.calcH(end);
        start.f = start.g + start.h;

        openSet = new HashSet<>();
        closedSet = new HashSet<>();
        path = new ArrayList<>();

        openSet.add(start);

        // algorytm A*
        while (!openSet.isEmpty()) {
            // wybieranie pola o najniższej wartości f
            Node current = openSet.stream().min(Comparator.comparingInt(n -> n.f)).get();

            if (current == end) {
                // znaleziono cel - odtwarzanie drogi
                Node node = end;
                while (node != null) {
                    path.add(node);
                    node = node.parent;
                }
                Collections.reverse(path);
                break;
            }

            openSet.remove(current);
            closedSet.add(current);

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int x = current.x + i;
                    int y = current.y + j;
                    if (x < 0 || x >= rows || y < 0 || y >= cols)
                        continue;
                    Node neighbor = grid[x][y];
                    if (neighbor == null)
                        continue;
                    if (closedSet.contains(neighbor))
                        continue;
                    int tentativeG = current.g + calcG(current, neighbor);
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    } else if (tentativeG >= neighbor.g) {
                        continue;
                    }
                    neighbor.parent = current;
                    neighbor.g = tentativeG;
                    neighbor.h = neighbor.calcH(end);
                    neighbor.f = neighbor.g + neighbor.h;
                }
            }
        }
    }

    // metoda obliczająca koszt przejścia z jednego pola na drugie
    private int calcG(Node from, Node to) {
        int dx = Math.abs(from.x - to.x);
        int dy = Math.abs(from.y - to.y);
        return dx + dy;
    }

    // droga
    public List<Node> getPath() {
        return path;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // tutaj sa predefiniowane przeszkody
        // ustaw je zeby byly losowo
        int[][] map = {
                { 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0 }
        };
        int[][] cells = {};
        main astar = new main(map, 0, 0, 4, 4);
        List<main.Node> path = astar.getPath();
        for (main.Node node : path) {
            System.out.println(node.x + "," + node.y);
            map[node.x][node.y] = 2;
        }
        MapGrid mapGrid = new MapGrid(map, cells);
    }

}
