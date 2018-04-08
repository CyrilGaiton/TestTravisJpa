FROM java:8
ADD target/jpa-1.0-SNAPSHOT-jar-with-dependencies.jar /
CMD java -jar jpa-1.0-SNAPSHOT-jar-with-dependencies.jar
