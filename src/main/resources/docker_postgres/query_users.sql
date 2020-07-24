SELECT * FROM users;
SELECT * FROM roles;
SELECT * FROM "privileges";
SELECT * FROM users_roles;
SELECT * FROM roles_privileges;

-- SELECT JOIN
SELECT
	u.id,
	u.user_name,
	u.password,
	u.enabled,
	r.name AS role_name,
	string_agg("p".name, '/') AS user_privileges
FROM users AS u
	JOIN users_roles AS ur ON (ur.user_id = u.id)
	JOIN roles AS r ON (r.id = ur.role_id)
	JOIN roles_privileges AS rp ON (rp.role_id = r.id)
	JOIN "privileges" AS "p" ON ("p".id = rp.privilege_id)
GROUP BY u.id, r.id
ORDER BY u.id ASC;

-- INSERT
INSERT INTO users (id, email, enabled, password, user_name)
VALUES (3, 'paula@gmail.com', true, '$2y$12$V2LZGXmlHsR95aZMG5DReeP5Ro1aPY0ZfL38zvnSf/gUaKi4XI9/u', 'Paula');
INSERT INTO users_roles (user_id, role_id)
VALUES (3, 1);
-- DELETE
DELETE FROM users_roles WHERE user_id = 3;
DELETE FROM users WHERE id = 3;
