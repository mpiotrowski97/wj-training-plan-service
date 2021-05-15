create table training_plans
(
    id          varchar(36) not null
        primary key,
    description varchar(255) null,
    name        varchar(255) null,
    user        varchar(255) null
);

