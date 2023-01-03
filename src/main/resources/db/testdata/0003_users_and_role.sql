insert into
    users (email, name, password)
values ('admin@example.com', 'admin', '{noop}adminpass'), -- 1
       ('user@example.com', 'user', '{noop}userpass');    -- 2

insert into
    user_role (name)
values
    ('ADMIN'), -- 1
    ('USER');  -- 2

insert into
    user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2);
