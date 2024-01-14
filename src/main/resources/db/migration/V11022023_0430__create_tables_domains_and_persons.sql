create table if not exists domains (
    id serial primary key,
    domain varchar(256) not null
);

create table if not exists persons(
    id serial primary key,
    nick_name varchar(256) not null,
    phone_number varchar(256) not null,
    address varchar(1024)
);

create table if not exists domains_persons(
    id serial primary key,
    person_id integer references persons(id) on DELETE cascade on UPDATE cascade,
    domain_id integer references domains(id) on DELETE cascade on UPDATE cascade
);

create table if not exists person_info(
    id serial primary key,
    additional_information varchar(1024),
    person_id integer references persons(id) on DELETE cascade on UPDATE cascade
);