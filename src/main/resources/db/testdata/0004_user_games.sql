insert into
    game_list (name, user_id)
values ('lista1', 1), -- 1
       ('wishlist1', 1); -- 2

insert into
    game_list_item (status, game_id, game_list_id)
values
    ('Completed', 1, 1),
    ('Playing', 5, 1),
    ('Backlog', 3, 2);
