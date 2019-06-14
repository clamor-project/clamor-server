set schema 'clamor';

insert into "user" (username, "password", email, date_of_birth)
values ('johndoe', 'pass', 'jd@jd.com', '2000-01-01'), ('jacqueliny', 'pass', 'jm@jm.com', '2000-01-01'),
('everlyn', 'pass', 'en@en.com', '2000-01-01'), ('kamrano', 'pass', 'ko@ko.com', '2000-01-01'),
('demileightf', 'pass', 'df@df.com', '2000-01-01'), ('akeelg', 'pass', 'ag@ag.com', '2000-01-01'),
('unah', 'pass', 'uh@uh.com', '2000-01-01'), ('raidenm', 'pass', 'rm@rm.com', '2000-01-01'),
('reof', 'pass', 'rf@rf.com', '2000-01-01'), ('elenab', 'pass', 'eb@eb.com', '2000-01-01'),
('sida', 'pass', 'sa@sa.com', '2000-01-01'), ('kyrond', 'pass', 'kd@kd.com', '2000-01-01');

insert into "group" ("name", description)
values ('Competative Tic-Tac-Toe','The host for the most competative, intense tic-tac-toe matches this world has ever seen!'),
('Sack-hop Racing','The city will know of our sack hopping!'),
('Online Hearts Club','Get your online hearts needs seen to in this increadible club!');

insert into user_group (user_id, group_id, "role")
values (1, 1, 1), (2, 1, 1), (3, 1, 2), (4, 1, 2), (5, 1, 2), (6, 1, 2),
(7, 1, 3), (8, 1, 4), (9, 2, 1), (10, 2, 2), (11, 2, 2), (12, 2, 2), (1, 2, 3),
(2, 2, 4), (3, 2, 4), (4, 3, 1), (5, 3, 1), (6, 3, 2), (7, 3, 2), (8, 3, 2), (9, 3, 4),
(10, 3, 4);

insert into group_message (author, "content")
values (1, 'Welcome to the tictactoe group!'), (2, 'yes, please dont leave'), (3, 'yall noobs suck at tictactoe'),
(4, 'rude'), (5, 'tictactoe is really hard!'), (6, 'true dat'), (7, 'tictactoe sux! join online hearts!'),
(8, 'Im bored, does this club do anything fun?'), (9, 'Hello sack hop enthusiasts!'),
(10, 'hello'), (11, 'Im really glad I joined. When is first race?'), (12, 'anyone have any snacks?'),
(13, 'sackhop < tictactoe'), (14, 'doctor says cast will be on for a while :('), (15, 'thanks for all the great races'),
(16, 'this is online hearts. Were glad youre here.'), (17, 'I am also glad youre here'), (18, 'when do we do the thing?'),
(19, 'someone should make a version for more players'), (20, 'why wont anyone play with me?'),
(21, 'im out, like bridge better'), (22, 'sorry too busy with sackhopping');

insert into "event" (creator, group_id, description, date_of) values
(2, 1, 'Our anual sudden death tic-tac-toe matchoff!', '2019-06-28'),
(9, 2, 'finals in central city. Parking unavailable, please jog in.', '2019-07-01'),
(16, 3, 'heats meetup online. Must bring your own virtual deck', '2019-06-15');

insert into friending (user_1, user_2) values
(1,5), (5,1), (2,6), (6,2), (10,11), (11,10),
(2,8), (3,4), (5,9), (10,12), (12,1), (11,3);

insert into direct_message (friends, "content") values
(2, 'I think my milk went bad'), (1, 'I dissagree'), (3, 'hows it going'), (4, 'stop asking me that'),
(5, 'congradulations, youve cleared the stack for direct messages!'), (6, 'what is that supposed to mean?'),
(8, 'when you get this, tell me'), (11, 'hey Im sorry about what I said about tictactoe');

insert into invitation ("host", subject) values
(1, 9), (1, 10), (1, 12);

insert into rsvp (attendee, event_id) values
(1, 1), (2, 1), (9, 2), (16, 3);


