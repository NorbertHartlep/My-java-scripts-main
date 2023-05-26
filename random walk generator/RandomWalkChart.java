import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RandomWalkChart extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int SIZE = 600;
    private static final int STEPS = 1000;
    private static final int STEP_SIZE = 4;
    private static final int DELAY = 10;
    private XYSeries series;
    private int x, y;

    public RandomWalkChart() {
        super("Random Walk Chart");
        series = new XYSeries("Random Walk");
        Random rand = new Random();
        x = rand.nextInt(SIZE);
        y = rand.nextInt(SIZE);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Random Walk Chart", "X", "Y", dataset);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesShapesVisible(0, false);
        plot.setRenderer(renderer);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
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
                default:
                    break;
            }
            series.add(x, y);
            Thread.sleep(DELAY);
        }
    }

    public void showChart() {
        EventQueue.invokeLater(() -> {
            XYDataset dataset = createDataset();
            JFreeChart chart = createChart(dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(SIZE, SIZE));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setContentPane(chartPanel);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        });
    }

    public static void main(String[] args) throws InterruptedException {
        RandomWalkChart chart = new RandomWalkChart();
        chart.simulate();
        chart.showChart();
    }
}