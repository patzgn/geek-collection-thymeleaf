insert into
    game (title, release_date, description, poster)
values
    -- 1
    ('Kirby and The Forgotten Land', '2022-03-25', 'Float off on an all-new adventure as the powerful puffball, Kirby. Explore in 3D stages as you discover a mysterious world with abandoned structures from a past civilization—like a shopping mall?! Copy enemies’ abilities like the new Drill and Ranger and use them to attack, explore your surroundings, and save the kidnapped Waddle Dees from the ferocious Beast Pack alongside the mysterious Elfilin. Hope you’re hungry for an unforgettable adventure!', 'kirby_and_the_forgotten_land.jpg'),
    -- 2
    ('Mario Kart 8 Deluxe', '2017-04-28', 'Hit the road with the definitive version of Mario Kart 8 and play anytime, anywhere! Race your friends or battle them in a revised battle mode on new and returning battle courses. Play locally in up to 4-player multiplayer in 1080p while playing in TV Mode. Every track from the Wii U version, including DLC, makes a glorious return. Plus, the Inklings appear as all-new guest characters, along with returning favorites, such as King Boo, Dry Bones, and Bowser Jr.!', 'mario_kart_8_deluxe.jpg'),
    -- 3
    ('Super Mario Odyssey', '2017-10-27', 'Mario embarks on a new journey through unknown worlds, running and jumping through huge 3D worlds in the first sandbox-style Mario game since Super Mario 64 and Super Mario Sunshine. Set sail between expansive worlds aboard an airship, and perform all-new actions, such as throwing Mario''s cap.', 'super_mario_odyssey.jpg'),
    -- 4
    ('The Legend of Zelda: Breath of the Wild', '2017-03-03', 'Forget everything you know about The Legend of Zelda games. Step into a world of discovery, exploration, and adventure in The Legend of Zelda: Breath of the Wild, a boundary-breaking new game in the acclaimed series. Travel across vast fields, through forests, and to mountain peaks as you discover what has become of the kingdom of Hyrule in this stunning Open-Air Adventure. Now on Nintendo Switch, your journey is freer and more open than ever. Take your system anywhere, and adventure as Link any way you like.', 'the_legend_of_zelda_breath_of_the_wild.jpg');

insert into
    game_genre(game_id, genre_id)
values
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 1),
    (3, 2),
    (4, 1),
    (4, 4);

insert into
    game_platform
values
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1);