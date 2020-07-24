SELECT
	d.id,
	d.local_date_time,
	d.status,
	pa.root_threshold,
	pa.rotor_speed,
	pa.slack
FROM devices AS d
	JOIN params AS pa ON pa.id = d.param_id
ORDER BY d.id;