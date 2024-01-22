# department_manager

Это небольшой микросервис с 3-мя сущностями (Department, Employee, Task).

### Основной целью проекта было освоение следующих технологий:
* Spring Framework(boot, web, data, security).
* PostgreSQL и Liquebase.
* Apache Kafka
* Docker / Docker compose

### В проекте из интересного присутствуют такие детали:

1. Использование Schedule для напоминания сотрудникам о скором наступлении "Dead-line" задачи
(Отсчёт введётся в cron).
2. Сотрудники из предыдущего пункта отправляются в топик "task-remind"
Apache Kafka.
3. Настроен Spring Security одной из последних версий, работающий с Access и Refresh Token.
Присутствует логика login, register и Refresh Access токен с помощью Refresh токена.
4. Приложение можно запустить через Docker compose,
который самостоятельно настроет Postgres, Apache Kafka и Zookeeper (Нужен для работы Kafka).

Чтобы запустить приложение через Docker compose необходимо
в папке docker создать файл .env и переместить тута всё,
что находится в файле example.txt.

### Спасибо за прочтение. 
