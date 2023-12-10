package classes;

import org.jsoup.select.Elements;

//Strategy (интерфейсы StatisticsGenerator и ChartGenerator): (поведенческий)
//используется для реализации генерации графиков.
interface ChartGenerator {
    //Template Method : предоставляют общий шаблон для генерации диаграммы,
    // а конкретная реализация делегируется классам-потомкам. (поведенческий)
    void generateChart(String typeName, Elements powerPlantElements);
}
