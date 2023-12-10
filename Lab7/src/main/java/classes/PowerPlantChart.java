package classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class PowerPlantChart implements ChartGenerator {
    public void generateChart(String typeName, Elements powerPlantElements) {
        System.out.println("Генерация диаграммы для типа: " + typeName);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Element powerPlantElement : powerPlantElements) {
            String powerPlantName = powerPlantElement.attr("name");
            String powerPlantCapacity = powerPlantElement.attr("capacity");
            dataset.addValue(Integer.parseInt(powerPlantCapacity), "Мощность", powerPlantName);
        }
        //Observer (возможно, использование JFreeChart): (поведенческий)
        // визуальные компоненты JFreeChart могут использовать
        // паттерн Observer для обновления графика при изменении данных
        JFreeChart chart = ChartFactory.createBarChart(
                "Мощность электростанций - " + typeName,
                "Электростанция", "Мощность (МВт)",
                dataset
        );

        ChartFrame frame = new ChartFrame("Диагрaмма электростанций", chart);
        frame.setSize(500, 400);
        frame.setVisible(true);
        System.out.println();
    }
}
