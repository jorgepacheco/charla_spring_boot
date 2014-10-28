. Septimo ejemplo con Spring Boot: Aplicacion WEB con Thymeleaf + Seguridad Personalizada + Spring DATA + Actuator

. CRUD de Cursos, persitencia en BBDD(embebida)

. usuario/password: user/user admin/admin

. Actuator


. mvn spring-boot:run --> Ejecutar

. mvn clean package --> Junto con el plugin de Maven genera un jar autoejecutable

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

  . Ejecutar el jar java -jar target/ejemplo1-spring-boot-initial-0.0.1-SNAPSHOT.jar
  
  . Acceder http://localhost:8080/
  
  . Acceder a Actuator:
  
  		http://localhost:8080/admin/info
  		http://localhost:8080/admin/health
  		http://localhost:8080/admin/metrics
  		http://localhost:8080/admin/trace
  		.......