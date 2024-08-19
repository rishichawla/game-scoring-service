# Game Scoring Service

## ER Diagram:

![ER Diagram](/assets/ER%20Diagram.png)

## Tech Stack Used:

* Java 17
* Spring Boot
* Apache Kafka
* Cassandra (DB)
* JUnit

## Assumptions Made:

* A score would belong to a particular game.
* Top Scores would be needed for a particular game only.
* Writes would be much more than reads.
* There are separate services that handles games and players data.
* This is a REST API that returns a JSON response.

## Future Improvements:

* Caching can be implemented for getting players and games.
* A global exception handler can be added that catches all the exceptions and returns appropriate HTTP status codes.
* Minimum and maximum scores can be put in config.
* Integration tests can be written that can mock (or create a dummy) db and kafka.

Please note that in order to run this project, you need to have kafka and cassandra running locally and pass in their
corresponding configs in application.yml file