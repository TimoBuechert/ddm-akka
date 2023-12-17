# ddm-akka
Akka example and homework code for the "Big Data Systems" lecture.

## Requirements
- Java 9 >=
- Maven Compiler Version 3.1.8 >=

## Getting started
1. Clone repo
  ```
  git clone https://github.com/UMR-Big-Data-Analytics/ddm-akka.git
  ```
        
2. Decompress test data
  ```
  cd ddm-akka/data
  unzip TPCH.zip
  ```

3. Build project with maven
  ```
  cd ..
  mvn package
  ```

4. Run master
  ```
  java -jar target/ddm-akka-1.0.jar master -h 192.168.178.25
  ```

5. Run worker

  ```
    java -jar target/ddm-akka-1.0.jar worker -mh 192.168.178.25 -mp 7877
  ```
