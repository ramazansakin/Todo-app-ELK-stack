-- Table Schemas
DROP TABLE IF EXISTS todo;

CREATE TABLE todo(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    headline VARCHAR(50) NOT NULL,
    details VARCHAR(250),
    user_id INT
);

INSERT INTO todo (headline, details, user_id) VALUES    ('Refactor', 'I need to make a refactor on my todo-app', 1),
                                                        ('Buy something in morning', null, 1),
                                                        ('Call mom', 'I have to call momy at wednesday', 1),
                                                        ('Test ToDo 1', null, 2),
                                                        ('Test TODO 2', 'Test TODO 2 Details', 1),
                                                        ('Test ToDo 3', null, 2),
                                                        ('Test TODO 4', 'Test TODO 4 Details', 1),
                                                        ('Test ToDo 5', null, 3),
                                                        ('Test TODO 6', 'Test TODO 6 Details', 3),
                                                        ('Test ToDo 7', null, 3),
                                                        ('Test TODO 8', 'Test TODO 8 Details', 3),
                                                        ('Test ToDo 9', null, 1),
                                                        ('Test TODO 10', 'Test TODO 10 Details', 2),
                                                        ('Test ToDo 11', null, 1),
                                                        ('Test TODO 12', 'Test TODO 12 Details', 2),
                                                        ('Test ToDo 13', null, 3),
                                                        ('Test TODO 14', 'Test TODO 14 Details', 1),
                                                        ('Test ToDo 15', null, 3),
                                                        ('Test TODO 16', 'Test TODO 16 Details', 2),
                                                        ('Visit the site', 'The site may be really useful for me , www.blablabla.com', 2);
