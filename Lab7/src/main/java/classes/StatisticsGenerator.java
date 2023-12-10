package classes;

import org.jsoup.select.Elements;

//Strategy - используется для реализации различных
// алгоритмов обработки данных.
// Эти алгоритмы могут быть легко заменены или добавлены новые.
interface StatisticsGenerator {
    //Template Method : предоставляют общий шаблон для генерации отчета,
    // а конкретная реализация делегируется классу-потомку.
    void generateStatistics(String typeName, Elements powerPlantElements);
}
