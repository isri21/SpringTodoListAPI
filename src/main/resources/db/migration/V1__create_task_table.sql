CREATE TABLE TASK (
	id SERIAL PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	description TEXT,
	due_date DATE NOT NULL,
	status VARCHAR(10),
	created_at DATE DEFAULT NOW()
);