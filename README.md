# Spring-boot-2
Here are some key Spring annotations related to beans:

- @Component: This annotation is a generic stereotype for any Spring-managed component. Beans annotated with @Component are candidates for auto-detection and auto-configuration when using component scanning.

- @Controller: This annotation marks a class as a Spring MVC controller. It is used to handle HTTP requests and generate HTTP responses. Controllers are a type of bean.

- @Service: The @Service annotation is used to indicate that a class is a Spring service. Service classes typically contain business logic. They are also considered beans.

- @Repository: The @Repository annotation is used to indicate that a class is a Spring Data repository. Repositories are responsible for database access and are also considered beans.

- @Configuration: This annotation identifies a class as a source of bean definitions. Beans defined in a @Configuration class are created and configured based on the methods annotated with @Bean. These methods produce bean instances.

- @Bean: The @Bean annotation is used to define individual beans within a @Configuration class. It allows you to explicitly specify the creation and configuration of a bean.

- @Autowired: While not a bean annotation itself, @Autowired is used to inject dependencies into beans. It's commonly used alongside the above annotations to wire dependencies between beans.

- @Value: This annotation is used to inject values from properties files or environment variables into bean properties.
# Docker :

```

docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres

docker exec -it some-postgres bash
psql -U postgres

CREATE USER nafisa WITH PASSWORD 'nafisa123';
```
# Postgres 
- sudo -u postgres psql
- \l
- \c customer ----> connected to db
  
- INSERT INTO customer(id,name,email,age)
customer-# VALUES (nextval('customer_id_Sequence'),'Alex','alex@gmail.com',22);

# IntellijIDEA
cd /path/to/your/intellij-idea/bin
./idea.sh
