USE cx_db;

--
-- Storing data for table `user`
--

INSERT INTO `user` (`name`, `password`, `display_name`, `create_time`, `update_time`) VALUES ('admin', 'root管理员', '123', NOW(), NOW());

--
-- Storing data for table `role`
--

INSERT INTO `role` (`id`, `name`, `display_name`) VALUES (1, 'root', '超级管理员'), (2, 'sysadmin', '管理员'), (3, 'contentadmin', '内容管理员'), (4, 'editor', '编辑');

--
-- Storing data for table `permission`
--

INSERT INTO `permission` (`id`,`name`) VALUES (1, 'adduser'), (2, 'deleteuser'), (3, 'updateuser'), (4, 'searchuser'), (5, 'addvideo'), (6, 'deletevideo'), (7, 'updatevideo'), (8, 'searchvideo'), (9, 'addcategory'), (10, 'deletecategory'), (11, 'updatecategory'), (12, 'searchcategory'), (13, 'addtag'), (14, 'deletetag'), (15, 'updatetag'), (16, 'searchtag'), (17, 'addarea'), (18, 'deletearea'), (19, 'updatearea'), (20, 'searcharea'), (21, 'addeditor'), (22, 'deleteeditor'), (23, 'updateeditor'), (24, 'searcheditor');

--
-- Storing data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);

--
-- Storing data for table `role_permission`
--

INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20), (1, 21), (1, 22), (1, 23), (1, 24);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (2, 4), (2, 5), (2, 6), (2, 7), (2, 8), (2, 9), (2, 10), (2, 11), (2, 12), (2, 13), (2, 14), (2, 15), (2, 16), (2, 17), (2, 18), (2, 19), (2, 20), (2, 21), (2, 22), (2, 23), (2, 24);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (3, 5), (3, 6), (3, 7), (3, 8), (3, 9), (3, 10), (3, 11), (3, 12), (3, 13), (3, 14), (3, 15), (3, 16), (3, 17), (3, 18), (3, 19), (3, 20);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (4, 5), (4, 6), (4, 7), (4, 8);

--
-- Storing data for table `category`
--

INSERT INTO `category` (`name`) VALUES ('film'), ('tv'), ('cartoon'), ('variety');

--
-- Storing data for table `area`
--

INSERT INTO `area` (`name`) VALUES ('大陆'), ('港台'), ('欧美'), ('日韩'), ('东南亚'), ('印度');

--
-- Storing data for table `tag`
--

INSERT INTO `tag` (`name`) VALUES ('喜剧'), ('爱情'), ('科幻'), ('悬疑'), ('动作'), ('魔幻'), ('古装'), ('灾难'), ('冒险'), ('武侠');
