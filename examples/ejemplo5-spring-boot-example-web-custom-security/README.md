. Quinto ejemplo con Spring Boot: Aplicacion WEB con Thymeleaf + Seguridad Personalizada

. CRUD de Cursos, persitencia en memoria, se añade seguridad personalizada

. usuario/password: user/user admin/admin


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