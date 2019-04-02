
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
 * Tomcat >8 
 