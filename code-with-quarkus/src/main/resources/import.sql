create table usuarios (
       id bigint auto_increment,
       name varchar(255),
       last_name varchar(255),
       dni varchar(255),
       localidad varchar(255),
       primary key (id)
    );

INSERT INTO items (name, last_name, dni, localidad) VALUES ('Jorge', 'Rodriguez', '31568945', 'CABA');
INSERT INTO items (name, last_name, dni, localidad) VALUES ('Santiago', 'Gimenez', '30865234', 'Cba');
INSERT INTO items (name, last_name, dni, localidad) VALUES ('Maria', 'Ianuchi', '34892736', 'Neuquen');
INSERT INTO items (name, last_name, dni, localidad) VALUES ('Pedro', 'Caropreso', '32637734', 'CABA');
INSERT INTO items (name, last_name, dni, localidad) VALUES ('Lorena', 'Revilio', '34892736', 'Neuquen');