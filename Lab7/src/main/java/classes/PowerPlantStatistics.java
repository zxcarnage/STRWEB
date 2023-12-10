package classes;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PowerPlantStatistics implements StatisticsGenerator {
    public void generateStatistics(String typeName, Elements powerPlantElements) {
        int totalPowerPlants = powerPlantElements.size();
        System.out.println("Генерация статистики для типа: " + typeName);
        System.out.println("Количество электростанций: " + totalPowerPlants);

        int totalCapacity = 0;
        for (Element powerPlantElement : powerPlantElements) {
            String powerPlantCapacity = powerPlantElement.attr("capacity");
            totalCapacity += Integer.parseInt(powerPlantCapacity);
        }

        System.out.println("Общая мощность: " + totalCapacity + " МВт");

        double averageCapacity = (double) totalCapacity / totalPowerPlants;
        System.out.println("Средняя мощность: " + averageCapacity + " МВт");
        System.out.println();
    }
}
