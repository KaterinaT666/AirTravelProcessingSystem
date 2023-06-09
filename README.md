# Разработка системы обработки авиаперелётов :airplane:
--------------
## :bulb: *Техническое задание*
--------------
Имеется некая система, которая обрабатывает авиаперелёты.
 Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками.
 ### Необходимо:
* Написать небольшой модуль, который будет заниматься фильтрацией набора перелётов согласно различным правилам.
    * Т. е. перелёт можно представить как набор из одного или нескольких элементарных перемещений, называемых сегментами. 
 Сегмент — это атомарная перевозка, которую для простоты будем характеризовать всего двумя атрибутами: дата/время вылета и дата/время прилёта.
 * Продумать структуру модуля
 * Весь код необходимо поместить в пакет com.gridnine.testing
 * Создать необходимые классы и интерфейсы 
 * Покрыть код тестами при помощи библиотеки JUnit (Пользовательский интерфейс не рассматривать)
 * Проверка работоспособности приложения осуществляется при помощи вывода информации в консоль через класс Main c методом main() 
 * Получить тестовый набор нужно методом FlightBuilder.createFlights()
 *  Исключить из тестового набора перелёты по следующим правилам (по каждому правилу нужен отдельный вывод списка перелётов):
       * вылет до текущего момента времени
       * имеются сегменты с датой прилёта раньше даты вылета
       * общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
 -------------------------------
 ### Примечания:
Дан файл TestClasses.java, который содержит упрощённые модельные классы и фабрику для получения тестовых образцов.