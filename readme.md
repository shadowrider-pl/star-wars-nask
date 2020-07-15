# Star Wars
Zadanie polega na przygotowaniu usługi REST która zwróci:
- stronicowaną listę bohaterów Gwiezdnych Wojen
- szczegóły poszczególnych bohaterów.

API powinno wystawiać dwie końcówki:
```sh
GET /characters?page=x
{
"count": 82,
"pages": 9,
"elements": [
{
"id": 1,
"name": "Luke Skywalker",
"height": "172",
"mass": "77",
"hairColor": "blond",
"skinColor": "fair",
"eyeColor": "blue",
"birthYear": "19BBY",
"gender": "male",
"homeworld": {
"name": "Tatooine",
"rotationPeriod": "23",
"orbitalPeriod": "304",
"diameter": "10465",
"climate": "arid",
"gravity": "1 standard",
"terrain": "desert",
"surfaceWater": "1",
"population": "200000"
},
"starships": [
{
"name": "X-wing",
"model": "T-65 X-wing",
"manufacturer": "Incom Corporation",
"costInCredits": "149999",
"length": "12.5",
"maxAtmosphericSpeed": "1050",
"crew": "1",
"passengers": "0",
"cargoCapacity": "110",
"consumables": "1 week",
"hyperdriveRating": "1.0",
"mglt": "100",
"starshipClass": "Starfighter"
},
{
"name": "Imperial shuttle",
"model": "Lambda-class T-4a shuttle",
"manufacturer": "Sienar Fleet Systems",
"costInCredits": "240000",
"length": "20",
"maxAtmosphericSpeed": "850",
"crew": "6",
"passengers": "20",
"cargoCapacity": "80000",
"consumables": "2 months",
"hyperdriveRating": "1.0",
"mglt": "50",
"starshipClass": "Armed government transport"
}
]
}
]
}


GET /characters/{id}
{
"id": 1,
"name": "Luke Skywalker",
"height": "172",
"mass": "77",
"hairColor": "blond",
"skinColor": "fair",
"eyeColor": "blue",
"birthYear": "19BBY",
"gender": "male",
"homeworld": {
"name": "Tatooine",
"rotationPeriod": "23",
"orbitalPeriod": "304",
"diameter": "10465",
"climate": "arid",
"gravity": "1 standard",
"terrain": "desert",
"surfaceWater": "1",
"population": "200000"
},
"starships": [
{
"name": "X-wing",
"model": "T-65 X-wing",
"manufacturer": "Incom Corporation",
"costInCredits": "149999",
"length": "12.5",
"maxAtmosphericSpeed": "1050",
"crew": "1",
"passengers": "0",
"cargoCapacity": "110",
"consumables": "1 week",
"hyperdriveRating": "1.0",
"mglt": "100",
"starshipClass": "Starfighter"
},
{
"name": "Imperial shuttle",
"model": "Lambda-class T-4a shuttle",
"manufacturer": "Sienar Fleet Systems",
"costInCredits": "240000",
"length": "20",
"maxAtmosphericSpeed": "850",
"crew": "6",
"passengers": "20",
"cargoCapacity": "80000",
"consumables": "2 months",
"hyperdriveRating": "1.0",
"mglt": "50",
"starshipClass": "Armed government transport"
}
]
}
```

## Wymagania
### Wymagania poza funkcjonalne

- powinna być w stanie obsłużyć 20 zapytań na sekundę (nie powinna zawierać oczywistych
wąskich gardeł)
- pełny zestaw testów uruchamiany wraz z narzędziem budującym (Maven lub Gradle)
- dobry projekt i jakość kodu
### Dodatkowe wymagania
- obsługa i logowanie błędów
- konfiguracja Swagger UI
- dokeryzacja aplikacji
- przygotowanie do monitorowania przy pomocy Prometheus

## Technologie
### Wymagane technologie
- Java 11


# Rozwiązanie

Została stworzona aplikacja SpringBoot wystawiająca zadane endpointy.
Uruchomienie aplikacji [linux]:
```sh
./mvnw clean package
cd target
java -jar star-wars-nask-0.0.1-SNAPSHOT.jar

```
Dostęp lokalny:

http://localhost:8080/characters?page=0

http://localhost:8080/characters/1


Źródłem danych jest baza H2, która jest zapełniana w momencie startu aplikacji. Ładowane są wtedy pliki sql określone w src/main/resources/application.properties.

Testy są wykonywane podczas polecenia
```sh
./mvnw clean package
```


Logi aplikacji są zapisywane w katalogu logs poprzez mechanizm logback. Konfiguracja jest w pliku src/main/resources/logback-spring.xml.

Swagger jest udostępniony pod adresem http://localhost:8080/swagger-ui.html .

Obraz dockerowy aplikacji jest tworzony poleceniem
```sh
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=starwars
```

Aplikacja wystawia metryki dla Prometheus za pomocą aktuatora [http://localhost:8080/actuator].





