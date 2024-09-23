# messaging-observability


## Dev Install

1. Génération des protobuff :

   - Pour Java (subscriber)

   ```bash
   protoc -I=./protobuff --java_out=./subscriber/src/main/java orientation.proto
   ```
     
   - Pour .Net (consumer)
   
   ```bash
   protoc -I=./protobuff --csharp_out=./consumer/src/ orientation.proto
   ```
2. Lancer la stack technique

    ```bash
    docker compose up -d
    ```

3. Lancer le subscriber (Java Quarkus)

    ```bash
    cd subscriber
    ./gradlew quarkusDev
    ```

4. Lancer le consumer (.Net)
    
    ```bash
    ???
    ```

## Jouer avec le proto

Lancer les requetes HTTP dans `http/orientation.http`.

La premiere crée une orientation dans le subscriber qui va le passer via le bus au consumer qui l'enrichira avec un CER et qui renverra l'orientation au subscriber.

La seconde requête permet de récupérer l'orientation créée et de voir qu'elle a été enrichie par son CER.

TODO visualisation de l'observability

