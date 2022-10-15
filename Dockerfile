FROM openjdk:11.0.16
EXPOSE 8999 
ADD target/Complaint_Box-0.0.1-SNAPSHOT.war Complaint_Box-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/Complaint_Box-0.0.1-SNAPSHOT.war"]