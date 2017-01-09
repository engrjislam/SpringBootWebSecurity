
INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO `user` (`id`, `user_name`, `password`, `enabled`) VALUES
(1, 'johir1', '12345', true),
(2, 'johir2', '12345', true);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 1),
(2, 2);
