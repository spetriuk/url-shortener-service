## url-shortener Performance test

### How to use it
To run the test execute the command from the root of the project, for example

```shell
mvn gatling:test -DstartUsers=1 -DendUsers=100 -Dtime=60  -Dhost="http://localhost:8080/api/url" -Dgatling.simulationClass=com.petriuk.simulations.UrlShorteningSimulation
```

Where:
 - `-DstartUsers` - number of users on the lowest load
 - `-DendUsers` - number of users on the highest load
 - `-Drecords` - number of records to add (for UrlShorteningSimulation)
 - `-Dtime` - time of the test
 - `-Dhost` - the base api url
 - `-Dgatling.simulationClass` - the simulation to run

The test will increase the number of users (requests per second) during the specified time

### Simulations order

In order to create enough data for the get url performance testing, we should create some data running `UrlShorteningSimulation` first, after that we run the main simulation `GetUrlSimulation`, and after that `DataRemoveSimulation` (optional), it will remove the data from db and tmp tests cache.

1. Ensure that db is empty:
    ```shell
    mvn gatling:test -Dhost="http://localhost:8080/api/url" -Dgatling.simulationClass=com.petriuk.simulations.DataRemoveSimulation
    ```
2. Add some data:
    ```shell
    mvn gatling:test -Drecords=1000 -Dhost="http://localhost:8080/api/url" -Dgatling.simulationClass=com.petriuk.simulations.UrlShorteningSimulation
    ```
3. Test GET API:
    ```shell
    mvn gatling:test -DstartUsers=100 -DendUsers=1000 -Dtime=30 -Dhost="http://localhost:8080/api/url" -Dgatling.simulationClass=com.petriuk.simulations.GetUrlSimulation
    ```    
4. Cleanup:
    ```shell
    mvn gatling:test -Dhost="http://localhost:8080/api/url" -Dgatling.simulationClass=com.petriuk.simulations.DataRemoveSimulation
    ```