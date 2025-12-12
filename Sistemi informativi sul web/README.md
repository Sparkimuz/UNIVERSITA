# Progetto Spring Boot per Gestione Immobiliare

Questo README fornisce istruzioni dettagliate per l'inserimento dei file generati in un progetto Spring Boot.

## Struttura del Progetto

Il progetto segue la struttura standard di Spring Boot:

```
realestate-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── realestate/
│   │   │           └── app/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               ├── security/
│   │   │               ├── validation/
│   │   │               └── config/
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       ├── templates/
│   │       │   ├── admin/
│   │       │   ├── agent/
│   │       │   ├── auth/
│   │       │   ├── fragments/
│   │       │   └── public/
│   │       └── application.properties
```

## Dipendenze Necessarie

Assicurati che il tuo file `pom.xml` includa le seguenti dipendenze:

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.thymeleaf.extras</groupId>
        <artifactId>thymeleaf-extras-springsecurity5</artifactId>
    </dependency>
    
    <!-- Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- MySQL Driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    
    <!-- Lombok (opzionale) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## Istruzioni per l'Inserimento dei File

1. **Crea un nuovo progetto Spring Boot** (se non ne hai già uno):
   - Usa Spring Initializr (https://start.spring.io/)
   - Seleziona le dipendenze: Web, JPA, Security, Thymeleaf, Validation, MySQL
   - Scarica e estrai il progetto

2. **Copia i file generati** nelle rispettive directory del tuo progetto:
   - Tutti i file in `model/` vanno in `src/main/java/com/realestate/app/model/`
   - Tutti i file in `repository/` vanno in `src/main/java/com/realestate/app/repository/`
   - Tutti i file in `service/` vanno in `src/main/java/com/realestate/app/service/`
   - Tutti i file in `controller/` vanno in `src/main/java/com/realestate/app/controller/`
   - Tutti i file in `security/` vanno in `src/main/java/com/realestate/app/security/`
   - Tutti i file in `validation/` vanno in `src/main/java/com/realestate/app/validation/`
   - Tutti i file in `config/` vanno in `src/main/java/com/realestate/app/config/`
   - I file HTML in `templates/` vanno in `src/main/resources/templates/`
   - I file CSS in `static/css/` vanno in `src/main/resources/static/css/`
   - Il file `application.properties` va in `src/main/resources/`

3. **Configura il database**:
   - Crea un database MySQL chiamato `realestate_db`
   - Modifica il file `application.properties` con le tue credenziali di database

4. **Crea la classe principale dell'applicazione** (se non esiste già):
   ```java
   package com.realestate.app;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   @SpringBootApplication
   public class RealEstateApplication {
   
       public static void main(String[] args) {
           SpringApplication.run(RealEstateApplication.class, args);
       }
   }
   ```

5. **Aggiungi le cartelle mancanti per le immagini**:
   - Crea la directory `src/main/resources/static/images/`
   - Aggiungi immagini placeholder per proprietà e agenti

6. **Aggiungi Bootstrap**:
   - Scarica Bootstrap da https://getbootstrap.com/
   - Copia i file CSS in `src/main/resources/static/css/bootstrap.min.css`
   - Copia i file JS in `src/main/resources/static/js/bootstrap.bundle.min.js`
   - Scarica jQuery e salvalo in `src/main/resources/static/js/jquery-3.5.1.min.js`

7. **Esegui l'applicazione**:
   - Avvia l'applicazione con `mvn spring-boot:run` o dal tuo IDE
   - Accedi all'applicazione all'indirizzo `http://localhost:8080`

## Note Importanti

- L'applicazione utilizza Spring Security per l'autenticazione e l'autorizzazione
- Ci sono due ruoli definiti: ADMIN e AGENT
- Al primo avvio, potrebbe essere necessario creare manualmente un utente admin nel database
- Le password vengono codificate con BCrypt
- L'applicazione gestisce il caricamento di file immagine, ma la logica di salvataggio è commentata e deve essere implementata

## Personalizzazione

- Modifica il file `application.properties` per configurare il database e altre impostazioni
- Personalizza i template HTML e i file CSS secondo le tue esigenze
- Aggiungi ulteriori funzionalità estendendo i controller e i service esistenti
