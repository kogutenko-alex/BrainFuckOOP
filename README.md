# Brainfuck
## Используя ООП методы

Я использовал такие команды языка: "+", "-", "<", ">", "[", "]", "." 

В начале я создаю строку на языке Brainfuck. 
Передаю ее в [EditorArray](https://github.com/kogutenko-alex/TeamDevTesting/blob/master/src/ua/kogutenko/Brainfuck/editor/EditorArray.java) (спец класс в которм будет начало работы) с помощью контейнера для команд [Memory](https://github.com/kogutenko-alex/TeamDevTesting/blob/master/src/ua/kogutenko/Brainfuck/memory/Memory.java) и с помощью мктода init() запускаю все.

> Для справки сам массив хранится статически в отдельном классе [ContainerForArray](https://github.com/kogutenko-alex/TeamDevTesting/blob/master/src/ua/kogutenko/Brainfuck/array/ContainerForArray.java).

Цель заключается в том что б создать не процедурный метод обработки входной команды а ООПшный. То есть каждую команду расфасовать по объектам. Я использовал паттерн Сommand (interface [Command](https://github.com/kogutenko-alex/TeamDevTesting/blob/master/src/ua/kogutenko/Brainfuck/command/Command.java)). И под каждую команду реализовал свой класс в котором есть метод execute() в котором уже выполняются манипуляции над массивом (см. [тут](https://github.com/kogutenko-alex/TeamDevTesting/tree/master/src/ua/kogutenko/Brainfuck/command)).  

И так как мы не будем знать в [анализаторе](https://github.com/kogutenko-alex/TeamDevTesting/blob/master/src/ua/kogutenko/Brainfuck/analizator/Analyzer.java) знать какая конкретно реализция нам нужна будет создал некий [класс контейнер](https://github.com/kogutenko-alex/TeamDevTesting/blob/master/src/ua/kogutenko/Brainfuck/operationalCode/operationalCode.java) для кадждой команды что б можно было пользоватся через интерфейс. 

В итоге мы загружаем все в ArrayList и проходимся по всем командам манипулируя массивом.

P.S. Я уже при оформлении рэдмишки понял что я не совсем верно реализовал циклы для Brainfuck. 
