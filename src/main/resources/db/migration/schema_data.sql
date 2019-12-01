create table pengguna (
  id bigint(20) not null,
  username varchar(25) not null,
  password varchar(75) not null,
  age int(2) not null,
  primary key (id)
);

insert into tbl_user (id, username, password, salary, age) values (1, 'coderjava', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 24);
insert into tbl_user (id, username, password, salary, age) values (2, 'coderkotlin', '$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK', 22);

-- coderjava / password
-- coderkotlin / password
-- naruto / password
-- sakura / password

create table oauth_access_token (
    authentication_id varchar(255) not null primary key,
    token_id varchar(255) not null,
    token bytea,
    user_name varchar(255),
    client_id varchar(255),
    authentication bytea,
    refresh_token varchar(255)
);

create table oauth_refresh_token (
    token_id varchar(255) not null,
    token bytea,
    authentication bytea
);