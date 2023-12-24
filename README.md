# department_manager

Данный учебный проект представляет собой маленький микросервис,
который взаимодействует с 3 сущностями (Department, Employee, Task),
связанными в БД между собой вторичными ключами.

### Основной целью проекта было освоение следующих технологий:
* Spring Framework(boot, web, data, security).
* PostgreSQL и Liquebase.
* Apache Kafka (Реактивная)
* Docker / Docker compose

### Также в проекте присутствует несколько интересных особенностей:

1. Реализован функционал напоминания за определённое время до завершения задач
сотрудникам определённого департамента с помощью Schedule (Отсчёт введётся в cron).
2. Сотрудники из предыдущего пункта отправляются в топик "task-remind"
Apache Kafka.
3. Приложение можно запустить через Docker compose,
который самостоятельно настроет Postgres, Apache Kafka и Zookeeper (Нужен для работы Kafka).

Чтобы зарустить через Docker compose необходимо
в папке docker создать файл .env, в котором будут прописаны необходимые для запуска переменные

### Ниже представлен пример .env файла:
HOST=localhost
POSTGRES_DATABASE=department_manager
POSTGRES_PORT=5437
POSTGRES_SCHEMA=department_manager
POSTGRES_USERNAME=postgres
POSTGRES_PASSWORD=password

SPRING_LOCAL_PORT=8080
SPRING_DOCKER_PORT=8080
MYSQLDB_LOCAL_PORT=5439
MYSQLDB_DOCKER_PORT=5432

JWT_SECRET=ZnVtb2Z1bW9mdW1vZnVtb2Z1bW9mdW1vZnVtbw==

KAFKA_BOOTSTRAP_SERVERS=kafka:9092
KAFKA_SUBSCRIBED_TOPICS=task-remind

KAFKA_BROKER_ID=1
DEBEZIUM_KAFKA_BROKER_ID=2
KAFKA_ZOOKEEPER_CONNECT="zookeeper:2181"
KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092
KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1
KAFKA_KEY_SERIALIZER=org.apache.kafka.common.serialization.StringSerializer
KAFKA_VALUE_SERIALIZER=org.springframework.kafka.support.serializer.JsonSerializer

ZOOKEEPER_CLIENT_PORT=2181
ZOOKEEPER_TICK_TIME=2000

### Спасибо за прочтение. 