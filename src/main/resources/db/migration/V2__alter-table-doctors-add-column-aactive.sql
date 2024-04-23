
alter table doctors add column active tinyint not null;

update doctors set active = 1;

