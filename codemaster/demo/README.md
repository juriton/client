
## Resources

* Git repository - https://github.com/juriton/client.git

### Build and Run

Checkout
```bash 
git clone 
```
Build
```bash 
gradle build

Run
```bash 
gradle bootRun -Dspring.profiles.active=H2
```

By default the "H2" profile is used, that uses in-memory H2 database and runs at http://localhost:9002

Generate idea project
 ```bash 
gradlew idea
 ``` 
 
 ### Requirements
 
 * JDK 8 installed and in PATH
 * PostgreSQL >8
 * Tomcat >8 (optional, if not running as a Linux service as instructed in the next main chapter)
 
 Create PostrgeSQL database and database user like this:
 
 ```sql
 create user personadbuser with password 'personaddbpwd';
 create database persona;
 grant all privileges on database persona to personadbuser;
 ```
 NB! change database name, username and password.