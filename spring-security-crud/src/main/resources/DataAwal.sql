CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into t_role(id, type) values(uuid_generate_v4(), 'USERS');
insert into t_role(id, type) values(uuid_generate_v4(), 'ADMIN');
insert into t_role(id, type) values(uuid_generate_v4(), 'DBA');

insert into t_users(id, username, password, first_name, last_name, email, active)
values(uuid_generate_v4(), 'admin', 'admin123', 'Bambang', 'Nurdiman', 'admin@aplikasi.com', true);

insert into user_role(user_id, role_id)
values('06464df7-3bb0-4947-b2dd-65b728464f5a', '231ebbad-95a3-46b3-970b-39cda9a868e7');