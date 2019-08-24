Spring Boot Coding Dojo
---

This is the Solution for the Spring Boot Coding Dojo by Guillermo Frias

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. The current implementation has quite a few problems making it a non-production ready product.

### The task

As the new engineer leading this project, your first task is to make it production-grade, feel free to refactor any piece
necessary to achieve the goal.

### Installation

1) Clone this repository
2) This project uses `postgresql 9` as the database. You can install a docker image with it by running `cd postgresql-docker && docker-compose up -d` and then creating the db: `./create-db.sh`
3) Since it's a bad practice to save keys in plain text in a public repo, my OpenWeather key was not commited. You can add a valid one in `application-dev.yml` file under `openWeather.appId`. If you wish to run the tests, repeat this procedure for `application.yml` in the `test/` directory
4) Run `./mvnw clean install`. This will also run the tests (to skip them, add `-Dmaven.test.skip=true`).
5) To run the project from the command line, `./mvnw spring-boot:run -Dspring.profiles.active=dev`. The last parameter is important since there are a few configuration values that are only set on an environment basis (even though the `dev` one was the only created)
6) This will start a Tomcat Application WebServer by in default in localhost, port 8080. [Example request for Amsterdam](localhost:8080/weather?city=amsterdam)
7) To cleanup the docker container from step 2), you can stop it and remove its volume with the command: `./remove-db.sh`
