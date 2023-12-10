package classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//синглтон - отвечает за основной функционал
// программы и его экземпляр должен быть единственным
public class Lab5 {
    private static Lab5 instance;
    private Lab5() {}

    public static Lab5 getInstance() {
        if (instance == null) {
            instance = new Lab5();
        }
        return instance;
    }

    public static void main(String[] args) {
        File xmlFile = new File("energy_data.xml");
        Lab5 lab5 = Lab5.getInstance();
        lab5.parseXML(xmlFile);

    }

    private List<String> results = new ArrayList<>();

    public List<String> getResults() {
        return results;
    }

    public void parseXML(File xmlFile) {
        try {
            Document doc = Jsoup.parse(xmlFile, "UTF-8");
            Element energySectorElement = doc.selectFirst("energySector");
            String energySectorName = energySectorElement.ownText();
            results.add("Сектор энергетики (тут почему-то не работает): " + energySectorName);

            Elements subSectorElements = energySectorElement.select("subSector");
            for (Element subSectorElement : subSectorElements) {
                String subSectorName = subSectorElement.selectFirst("subName").ownText();
                results.add("Подсектор (я не хочу разбираться почему): " + subSectorName);

                Elements typeElements = subSectorElement.select("type");
                for (Element typeElement : typeElements) {
                    String typeName = typeElement.selectFirst("typeName").ownText();
                    results.add("Тип: " + typeName);

                    Elements powerPlantElements = typeElement.select("powerPlant");
                    for (Element powerPlantElement : powerPlantElements) {
                        PowerPlant powerPlant = new PowerPlant(
                                powerPlantElement.attr("id"),
                                powerPlantElement.attr("name"),
                                powerPlantElement.attr("capacity")
                        );
                        results.add(powerPlant.getDetails());
                    }

                    if (!subSectorName.equals("Нефтегазовая промышленность")) {
                        PowerPlantStatistics powerPlantStatistics = new PowerPlantStatistics();
                        powerPlantStatistics.generateStatistics(typeName, powerPlantElements);

                        //PowerPlantChart powerPlantChart = new PowerPlantChart();
                        //powerPlantChart.generateChart(typeName, powerPlantElements);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getResultsSize() {
        return results.size();
    }
}

