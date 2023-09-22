# Spring-boot-2

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