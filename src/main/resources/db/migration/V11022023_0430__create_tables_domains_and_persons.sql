create table domains(
    id integer primary key,
    domain varchar(256) not null
);

create table persons(
    id integer primary key,
    nick_name varchar(256) not null,
    phone_number varchar(256) not null,
    address varchar(1024)
);

create table domains_persons(
    id integer primary key,
    person_id integer references persons(id) on DELETE cascade on UPDATE cascade,
    domain_id integer references domains(id) on DELETE cascade on UPDATE cascade
);

create table person_info(
    id integer primary key,
    additional_information varchar(1024),
    person_id integer references persons(id) on DELETE cascade on UPDATE cascade
);