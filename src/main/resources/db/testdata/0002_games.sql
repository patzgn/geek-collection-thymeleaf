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
    ('The Legend of Zelda: Breath of the Wild', '2017-03-03', 'Forget everything you know about The Legend of Zelda games. Step into a world of discovery, exploration, and adventure in The Legend of Zelda: Breath of the Wild, a boundary-breaking new game in the acclaimed series. Travel across vast fields, through forests, and to mountain peaks as you discover what has become of the kingdom of Hyrule in this stunning Open-Air Adventure. Now on Nintendo Switch, your journey is freer and more open than ever. Take your system anywhere, and adventure as Link any way you like.', 'the_legend_of_zelda_breath_of_the_wild.jpg'),
    -- 5
    ('Animal Crossing New Horizons', '2020-03-20', 'Nook Inc. invites you to create your personal island paradise on a deserted island brimming with possibility.', 'animal_crossing_new_horizons.jpg'),
    -- 6
    ('Astral Chain', '2019-08-30', 'The Ark: A massive, prosperous, multicultural city. But disaster strikes when mysterious dimensional gates appear, bringing dangerous alien creatures to the Ark to attack the people and corrupt the land. The Ark police form a special task force, known as Neuron, to face the alien threat head-on. Humanity’s last chance against invasion is a special living weapon called the Legion. As a rookie Neuron officer, you and your Legion will work together to solve cases and save humankind.', 'astral_chain.jpg'),
    -- 7
    ('Bayonetta', '2010-01-08', 'Blurring the borders of good and evil, this cinematic and stylized adventure stars Bayonetta, a heroine bent on sending supernatural forces to the depths of hell. Armed with her four enchanted guns known as Scarborough Fair, she battles both monstrous behemoths and angelic enemies. By combining special magic attacks, summoning primal forces and unleashing devastating weaponry, she impressively punishes anyone who gets in her way. From its fluid and intuitive combat system to its gripping story line, Bayonetta is one action thriller that won''t disappoint.', 'bayonetta.jpg'),
    -- 8
    ('Bayonetta 2', '2014-10-24', 'In this climactic sequel to the critically acclaimed BAYONETTA action game, players will be on the edge of their seats from start to finish. Brimming with epic, gorgeous cut scenes and battles that are more exhilarating than ever, this game never lets up on the action. Fight on top of a jet as it soars through a downtown city. Duke it out against a giant angel, who bears a whip for an arm, on top of a speeding train. And take to the skies in a fight against a demonic monster while ascending to the top of a skyscraper.', 'bayonetta_2.jpg'),
    -- 9
    ('Luigi''s Mansion 3', '2019-10-31', 'Luigi’s invited to the towering Last Resort hotel, but when Mario and friends go missing, our green-clad hero will have to conquer his fears to save them! Slam, blow away, and vacuum up ghosts with the all-new Poltergust G-00, and join forces with Gooigi to overcome the puzzling contraptions and mischievous boss on each themed floor. And that’s just the Last Resort. Enter the ScareScraper for 8-player local wireless** or online*** co-op gameplay. See if you can defeat all the ghosts, rescue all the toads, or clear other objectives before time runs out…in the ScareScraper! And for more mini-game madness, compete on teams at the ScreamPark! Whether you play with friends or wander the hotel alone, you’ll be sucked in by the atmospheric music and ghoulish décor of every cobwebby corner you', 'luigis_mansion_3.jpg'),
    -- 10
    ('New Pokemon Snap', '2021-04-30', 'Seek out and take in-game photographs of Pokémon in their native environments in New Pokémon Snap! You''ll even discover behaviors and expressions you''ve never seen before when you encounter and research lively wild Pokémon. You might see them patrolling their territory, playing, or lurking in out-of-the-way spots. Travel to the islands that make up the Lental region. In this region, some of the Pokémon and vegetation will appear to have a special glow. Research these Pokémon alongside Professor Mirror as you explore dense jungles, vast deserts, and more! Your observations of Pokémon thriving in the wild may help unravel the truth behind the Illumina phenomenon. The Pokémon pictures you take will be used to build your very own Pokémon Photodex!', 'new_pokemon_snap.jpg');

insert into
    game_genre(game_id, genre_id)
values
    (1, 1), (1, 2),
    (2, 3),
    (3, 1), (3, 2),
    (4, 1), (4, 4),
    (5, 5),
    (6, 1),
    (7, 1), (7, 6),
    (8, 1), (8, 6),
    (9, 1), (9, 4),
    (10, 5);

insert into
    game_platform
values
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1), (7, 2), (7, 3), (7, 4), (7, 5), (7, 6), (7, 7),
    (8, 1), (8, 5),
    (9, 1),
    (10, 1);