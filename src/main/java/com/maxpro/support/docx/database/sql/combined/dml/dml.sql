
INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO `user` (`id`, `user_name`, `password`, `enabled`) VALUES
(1, 'johir1', '$2a$04$eBeQuarnz9CFAAQP/XSjGO3CRP6B.UFlXu7Yxmi1QDA3PozXfbIwO', true),
(2, 'johir2', '$2a$04$5d0qf5HzPgAZssncob95aekq.O0ddJlJfe6dy8xHhBER6RN0PC99S', true);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 1),
(2, 2);
