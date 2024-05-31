CREATE SCHEMA IF NOT EXISTS SE2222_22070006085;
USE SE2222_22070006085;

-- Actors
CREATE TABLE IF NOT EXISTS actors (
    actor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender ENUM('Male', 'Female', 'Other'),
    date_of_birth DATE
);

-- Directors
CREATE TABLE IF NOT EXISTS directors (
    director_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender ENUM('Male', 'Female', 'Other'),
    date_of_birth DATE
);

-- Movies
CREATE TABLE IF NOT EXISTS movies (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE,
    duration_minutes INT
);

-- Junction table for Movies and Directors
CREATE TABLE IF NOT EXISTS movie_directors (
    movie_id INT,
    director_id INT,
    PRIMARY KEY (movie_id, director_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (director_id) REFERENCES directors(director_id)
);

-- Junction table for Movie and Actors
CREATE TABLE IF NOT EXISTS movie_actors (
    movie_id INT,
    actor_id INT,
    PRIMARY KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (actor_id) REFERENCES actors(actor_id)
);

-- customers
CREATE TABLE IF NOT EXISTS customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255),
    phone_number VARCHAR(20)
);

-- Table for storing information about reviews
CREATE TABLE IF NOT EXISTS reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    customer_id INT,
    rating DECIMAL(3,1),
    comment TEXT,
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


-- buildings
CREATE TABLE IF NOT EXISTS buildings (
    building_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(255)
);

-- Table to store information about auditoriums within buildings
CREATE TABLE IF NOT EXISTS auditoriums (
    auditorium_id VARCHAR(10) PRIMARY KEY,
    format ENUM('2D', '3D'),
    type ENUM('Standard', 'IMAX', '4DX'),
    seat_count INT,
    building_id INT,
    FOREIGN KEY (building_id) REFERENCES buildings(building_id)
);

-- Junction table to link auditoriums and movies being screened
CREATE TABLE auditorium_movie (
    auditorium_id VARCHAR(10),
    movie_id INT,
    FOREIGN KEY (auditorium_id) REFERENCES auditoriums(auditorium_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

-- Table to store auditorium booking information
CREATE TABLE IF NOT EXISTS auditorium_bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    auditorium_id VARCHAR(10),
    occupancy_date DATE,
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (auditorium_id) REFERENCES auditoriums(auditorium_id)
);

-- table to store purchased tickets for bookings
CREATE TABLE IF NOT EXISTS tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    auditorium_booking_id INT,
    customer_id INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (auditorium_booking_id) REFERENCES auditorium_bookings(booking_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO actors (name, gender, date_of_birth) VALUES
-- 1
('Tom Hanks', 'Male', '1956-07-09'),          -- Cast in Saving Private Ryan, Catch Me If You Can, etc.
-- 2
('Leonardo DiCaprio', 'Male', '1974-11-11'), -- Cast in Catch Me If You Can, The Revenant (not listed but prominent)
-- 3
('Denzel Washington', 'Male', '1954-12-28'), -- Cast in Philadelphia
-- 4
('Christian Bale', 'Male', '1974-01-30'),    -- Cast in The Prestige, The Dark Knight Rises
-- 5
('Tom Cruise', 'Male', '1962-07-03'),        -- Cast in Minority Report
-- 6
('Fionn Whitehead', 'Male', '1997-07-18'),   -- Cast in Dunkirk
-- 7
('Guy Pearce', 'Male', '1967-10-05'),        -- Cast in Memento
-- 8
('Robin Williams', 'Male', '1951-07-21'),    -- Cast in Insomnia (considered although not in your original movie list)
-- 9
('Al Pacino', 'Male', '1940-04-25'),         -- Cast in Insomnia
-- 10
('Gary Oldman', 'Male', '1958-03-21'),       -- Cast in Bram Stoker's Dracula
-- 11
('Marlon Brando', 'Male', '1924-04-03'),     -- Cast in Apocalypse Now, The Godfather (for completeness)
-- 12
('Robert Duvall', 'Male', '1931-01-05'),     -- Cast in Apocalypse Now, The Godfather
-- 13
('Martin Sheen', 'Male', '1940-08-03'),      -- Cast in Apocalypse Now
-- 14
('Harrison Ford', 'Male', '1942-07-13'),     -- Cast in Apocalypse Now (minor role, for completeness)
-- 15
('Gene Hackman', 'Male', '1930-01-30'),      -- Cast in The Conversation
-- 16
('Meryl Streep', 'Female', '1949-06-22'),    -- Cast in The Devil Wears Prada, Sophie's Choice
-- 17
('Sandra Bullock', 'Female', '1964-07-26'),    -- Cast in Gravity, The Blind Side
-- 18
('Nicole Kidman', 'Female', '1967-06-20'),    -- Cast in Moulin Rouge!, The Hours
-- 19
('Julia Roberts', 'Female', '1967-10-28'),    -- Cast in Pretty Woman, Erin Brockovich
-- 20
('Brad Pitt', 'Male', '1963-12-18'),              -- Cast in  Fight Club, Once Upon a Time in Hollywood
-- 21
('George Clooney', 'Male', '1961-05-06'),         -- Cast in Ocean's Eleven, Up in the Air
-- 22
('Matt Damon', 'Male', '1970-10-08'),             -- Cast in The Martian, Good Will Hunting
-- 23
('Morgan Freeman', 'Male', '1937-06-01'),         -- Cast in The Shawshank Redemption, Million Dollar Baby
-- 24
('Cate Blanchett', 'Female', '1969-05-14'),       -- Cast in Blue Jasmine, The Aviator
-- 25
('Ian McKellen', 'Male', '1939-05-25'),    		  -- Cast in The Lord of the Rings, X-Men
-- 26
('Emma Stone', 'Female', '1988-11-06'),           -- Cast in La La Land, Birdman
-- 27
('Ryan Gosling', 'Male', '1980-11-12'),           -- Cast in La La Land, Drive
-- 28
('Jennifer Lawrence', 'Female', '1990-08-15'),    -- Cast in Silver Linings Playbook, The Hunger Games
-- 29
('Chris Hemsworth', 'Male', '1983-08-11'),        -- Cast in Thor, The Avengers
-- 30
('Scarlett Johansson', 'Female', '1984-11-22'),   -- Cast in Lost in Translation, The Avengers
-- 31
('Mark Ruffalo', 'Male', '1967-11-22'),           -- Cast in Spotlight, The Avengers
-- 32
('Benedict Cumberbatch', 'Male', '1976-07-19'),   -- Cast in Doctor Strange
-- 33
('Chadwick Boseman', 'Male', '1976-11-29'),       -- Cast in Black Panther, 42
-- 34
('Brie Larson', 'Female', '1989-10-01'),          -- Cast in Room, Captain Marvel
-- 35
('Tom Holland', 'Male', '1996-06-01'),            -- Cast in Spider-Man: Homecoming, The Impossible
-- 36
('Samuel L. Jackson', 'Male', '1948-12-21'),      -- Cast in Pulp Fiction, The Avengers
-- 37
('Charlize Theron', 'Female', '1975-08-07'),      -- Cast in Monster, Mad Max: Fury Road
-- 38
('Johnny Depp', 'Male', '1963-06-09'),            -- Cast in Pirates of the Caribbean, Edward Scissorhands
-- 39
('Helena Bonham Carter', 'Female', '1966-05-26'), -- Cast in Fight Club, The King's Speech
-- 40
('Daniel Day-Lewis', 'Male', '1957-04-29'),       -- Cast in There Will Be Blood, Lincoln
-- 41
('Kate Winslet', 'Female', '1975-10-05'),         -- Cast in Titanic, Eternal Sunshine of the Spotless Mind
-- 42
('Joaquin Phoenix', 'Male', '1974-10-28'),        -- Cast in Joker, Walk the Line
-- 43
('Russell Crowe', 'Male', '1964-04-07'),          -- Cast in Gladiator, A Beautiful Mind
-- 44
('Anne Hathaway', 'Female', '1982-11-12'),        -- Cast in Les Misérables, The Devil Wears Prada
-- 45
('Will Smith', 'Male', '1968-09-25'),             -- Cast in The Pursuit of Happyness, Men in Black
-- 46
('Angelina Jolie', 'Female', '1975-06-04'),       -- Cast in Girl, Interrupted, Mr. & Mrs. Smith
-- 47
('Robert De Niro', 'Male', '1987-05-01'),      	  -- Cast in Taxi Driver,Goodfellas
-- 48
('Jessica Chastain', 'Female', '1977-03-24'),     -- Cast in Zero Dark Thirty, The Help
-- 49
('Ethan Hawke', 'Male', '1970-11-06'),            -- Cast in Gattaca, Before Sunrise
-- 50
('Emma Watson', 'Female', '1990-04-15'),          -- Cast in Harry Potter series, The Perks of Being a Wallflower
-- 51
('Keanu Reeves', 'Male', '1964-09-02'),           -- Cast in The Matrix, John Wick
-- 52
('Robert Downey Jr.', 'Male', '1965-04-04'),      -- Cast in Iron Man, Sherlock Holmes
-- 53
('Hugh Jackman', 'Male', '1968-10-12'),           -- Cast in The Wolverine, Les Misérables
-- 54
('Margot Robbie', 'Female', '1990-07-02');        -- Cast in The Wolf of Wall Street, Suicide Squad



INSERT INTO directors (name, gender, date_of_birth) VALUES
-- 1
('Steven Spielberg', 'Male', '1946-12-18'), -- movies: Saving Private Ryan, Catch Me If You Can, Minority Report
-- 2
('Alejandro González Iñárritu', 'Male', '1963-08-15'), -- movies: The Revenant
-- 3
('Jonathan Demme', 'Male', '1944-02-22'), -- movies: Philadelphia
-- 4
('Christopher Nolan', 'Male', '1970-07-30'), -- movies: The Prestige, The Dark Knight Rises, Dunkirk, Memento, Insomnia
-- 5
('Francis Ford Coppola', 'Male', '1939-04-07'), -- movies: Bram Stoker's Dracula, Apocalypse Now, The Godfather
-- 6
('Francis Ford Coppola', 'Male', '1939-04-07'), -- movies: The Conversation
-- 7
('David Frankel', 'Male', '1959-04-02'), -- movies: The Devil Wears Prada
-- 8
('Alan J. Pakula', 'Male', '1928-04-07'), -- movies: Sophie's Choice
-- 9
('Alfonso Cuarón', 'Male', '1961-11-28'), -- movies: Gravity
-- 10
('John Lee Hancock', 'Male', '1956-12-15'), -- movies: The Blind Side
-- 11
('Baz Luhrmann', 'Male', '1962-09-17'), -- movies: Moulin Rouge!
-- 12
('Stephen Daldry', 'Male', '1960-05-02'), -- movies: The Hours
-- 13
('Garry Marshall', 'Male', '1934-11-13'), -- movies: Pretty Woman
-- 14
('Steven Soderbergh', 'Male', '1963-01-14'), -- movies: Erin Brockovich, Ocean's Eleven
-- 15
('David Fincher', 'Male', '1962-08-28'), -- movies: Fight Club
-- 16
('Quentin Tarantino', 'Male', '1963-03-27'), -- movies: Pulp Fiction
-- 17
('George Miller', 'Male', '1945-03-03'), -- movies: Mad Max: Fury Road
-- 18
('Gore Verbinski', 'Male', '1964-03-16'), -- movies: Pirates of the Caribbean
-- 19
('Tom Hooper', 'Male', '1972-10-05'), -- movies: The King's Speech, Les Misérables
-- 20
('Paul Thomas Anderson', 'Male', '1970-06-26'), -- movies: There Will Be Blood
-- 21
('James Cameron', 'Male', '1954-08-16'), -- movies: Titanic
-- 22
('Todd Phillips', 'Male', '1970-12-20'), -- movies: Joker
-- 23
('Ridley Scott', 'Male', '1937-11-30'), -- movies: Gladiator
-- 24
('Ron Howard', 'Male', '1954-03-01'), -- movies: A Beautiful Mind
-- 25
('Gabriele Muccino', 'Male', '1967-05-20'), -- movies: The Pursuit of Happyness
-- 26
('Doug Liman', 'Male', '1965-07-24'), -- movies: Mr. & Mrs. Smith
-- 27
('Martin Scorsese', 'Male', '1942-11-17'), -- movies: Taxi Driver, Goodfellas
-- 28
('Kathryn Bigelow', 'Male', '1951-11-27'), -- movies: Zero Dark Thirty
-- 29
('Andrew Niccol', 'Male', '1964-06-10'), -- movies: Gattaca
-- 30
('Chris Columbus', 'Male', '1958-09-10'), -- movies: Harry Potter series
-- 31
('Lana Wachowski', 'Female', '1965-06-21'), -- movies: The Matrix
-- 32
('Chad Stahelski', 'Male', '1968-09-20'), -- movies: John Wick
-- 33
('Jon Favreau', 'Male', '1966-10-19'), -- movies: Iron Man
-- 34
('Guy Ritchie', 'Male', '1968-09-10'), -- movies: Sherlock Holmes
-- 35
('Ryan Coogler', 'Male', '1986-05-23'), -- movies: Black Panther
-- 36
('Lenny Abrahamson', 'Male', '1966-11-30'), -- movies: Room
-- 37
('Anna Boden', 'Female', '1976-09-20'), -- movies: Captain Marvel
-- 38
('J.A. Bayona', 'Male', '1975-05-09'), -- movies: The Impossible
-- 39
('Ryan Fleck', 'Male', '1976-09-20'); -- movies: Captain Marvel


INSERT INTO movies (title, release_date, duration_minutes) VALUES
-- 1
('Saving Private Ryan', '1998-07-24', 169),
-- 2
('Catch Me If You Can', '2002-12-25', 141),
-- 3
('Minority Report', '2002-06-21', 145),
-- 4
('The Revenant', '2015-12-25', 156),
-- 5
('Philadelphia', '1993-12-22', 125),
-- 6
('The Prestige', '2006-10-20', 130),
-- 7
('The Dark Knight Rises', '2012-07-20', 164),
-- 8
('Dunkirk', '2017-07-21', 106),
-- 9
('Memento', '2000-10-11', 113),
-- 10
('Insomnia', '2002-05-24', 118),
-- 11
('Bram Stokers Dracula', '1992-11-13', 128),
-- 12
('Apocalypse Now', '1979-08-15', 147),
-- 13
('The Godfather', '1972-03-24', 175),
-- 14
('The Devil Wears Prada', '2006-06-30', 109),
-- 15
('Sophies Choice', '1982-12-08', 150),
-- 16
('Gravity', '2013-10-04', 91),
-- 17
('The Blind Side', '2009-11-20', 129),
-- 18
('Moulin Rouge!', '2001-05-18', 127),
-- 19
('The Hours', '2002-12-27', 114),
-- 20
('Pretty Woman', '1990-03-23', 119),
-- 21
('Erin Brockovich', '2000-03-17', 131),
-- 22
('Oceans Eleven', '2001-12-07', 116),
-- 23
('Fight Club', '1999-10-15', 139),
-- 24
('Pulp Fiction', '1994-10-14', 154),
-- 25
('Mad Max: Fury Road', '2015-05-15', 120),
-- 26
('Pirates of the Caribbean', '2003-07-09', 143),
-- 27
('The King s Speech', '2010-12-24', 118),
-- 28
('Les Misérables', '2012-12-25', 158),
-- 29
('There Will Be Blood', '2007-12-26', 158),
-- 30
('Titanic', '1997-12-19', 195),
-- 31
('Joker', '2019-10-04', 122),
-- 32
('Gladiator', '2000-05-05', 155),
-- 33
('A Beautiful Mind', '2001-12-21', 135),
-- 34
('The Pursuit of Happyness', '2006-12-15', 117),
-- 35
('Mr. & Mrs. Smith', '2005-06-10', 120),
-- 36
('Taxi Driver', '1976-02-08', 114),
-- 37
('Goodfellas', '1990-09-19', 146),
-- 38
('Zero Dark Thirty', '2012-12-19', 157),
-- 39
('Gattaca', '1997-10-24', 106),
-- 40
('Harry Potter series', '2001-11-16', 152),
-- 41
('The Matrix', '1999-03-31', 136),
-- 42
('John Wick', '2014-10-24', 101),
-- 43
('Iron Man', '2008-05-02', 126),
-- 44
('Sherlock Holmes', '2009-12-25', 128),
-- 45
('Black Panther', '2018-02-16', 134),
-- 46
('Room', '2015-10-16', 118),
-- 47
('Captain Marvel', '2019-03-08', 123),
-- 48
('The Impossible', '2012-10-11', 114);



INSERT INTO movie_directors (movie_id, director_id) VALUES
-- Saving Private Ryan
(1, 1),
-- Catch Me If You Can
(2, 1),
-- Minority Report
(3, 1),
-- The Revenant
(4, 2),
-- Philadelphia
(5, 3),
-- The Prestige
(6, 4),
-- The Dark Knight Rises
(7, 4),
-- Dunkirk
(8, 4),
-- Memento
(9, 4),
-- Insomnia
(10, 4),
-- Bram Stokers Dracula
(11, 5),
-- Apocalypse Now
(12, 5),
(12, 6),
(12, 7),
-- The Godfather
(13, 5),
(13, 6),
(13, 7),
-- The Devil Wears Prada
(14, 7),
-- Sophies Choice
(15, 8),
-- Gravity
(16, 9),
-- The Blind Side
(17, 10),
-- Moulin Rouge!
(18, 11),
-- The Hours
(19, 12),
-- Pretty Woman
(20, 13),
-- Erin Brockovich
(21, 14),
-- Oceans Eleven
(22, 14),
-- Fight Club
(23, 15),
-- Pulp Fiction
(24, 16),
-- Mad Max: Fury Road
(25, 17),
-- Pirates of the Caribbean
(26, 18),
-- The King s Speech
(27, 19),
-- Les Misérables
(28, 19),
-- There Will Be Blood
(29, 20),
-- Titanic
(30, 21),
-- Joker
(31, 22),
-- Gladiator
(32, 23),
-- A Beautiful Mind
(33, 24),
-- The Pursuit of Happyness
(34, 25),
-- Mr. & Mrs. Smith
(35, 26),
-- Taxi Driver
(36, 27),
-- Goodfellas
(37, 27),
-- Zero Dark Thirty
(38, 28),
-- Gattaca
(39, 29),
-- Harry Potter series
(40, 30),
-- The Matrix
(41, 31),
-- John Wick
(42, 32),
-- Iron Man
(43, 33),
-- Sherlock Holmes
(44, 34),
-- Black Panther
(45, 35),
-- Room
(46, 36),
-- Captain Marvel
(47, 37),
-- The Impossible
(48, 38);


INSERT INTO movie_actors (movie_id, actor_id) VALUES
-- Saving Private Ryan (movie_id = 1)
(1, 1), -- Tom Hanks
-- Catch Me If You Can (movie_id = 2)
(2, 1), -- Tom Hanks
(2, 2), -- Leonardo DiCaprio
-- Minority Report (movie_id = 3)
(3, 5), -- Tom Cruise
-- The Revenant (movie_id = 4)
(4, 2), -- Leonardo DiCaprio
-- Philadelphia (movie_id = 5)
(5, 3), -- Denzel Washington
(5, 1), -- Tom Hanks
-- The Prestige (movie_id = 6)
(6, 4), -- Christian Bale
-- The Dark Knight Rises (movie_id = 7)
(7, 4), -- Christian Bale
-- Dunkirk (movie_id = 8)
(8, 6), -- Fionn Whitehead
-- Memento (movie_id = 9)
(9, 7), -- Guy Pearce
-- Insomnia (movie_id = 10)
(10, 8), -- Robin Williams
(10, 9), -- Al Pacino
-- Bram Stokers Dracula (movie_id = 11)
(11, 10), -- Gary Oldman
-- Apocalypse Now (movie_id = 12)
(12, 11), -- Marlon Brando
(12, 12), -- Robert Duvall
(12, 13), -- Martin Sheen
(12, 14), -- Harrison Ford
-- The Godfather (movie_id = 13)
(13, 11), -- Marlon Brando
(13, 12), -- Robert Duvall
-- The Devil Wears Prada (movie_id = 14)
(14, 16), -- Meryl Streep
(14, 44), -- Anne Hathaway
-- Sophie's Choice (movie_id = 15)
(15, 16), -- Meryl Streep
-- Gravity (movie_id = 16)
(16, 17), -- Sandra Bullock
-- The Blind Side (movie_id = 17)
(17, 17), -- Sandra Bullock
-- Moulin Rouge! (movie_id = 18)
(18, 18), -- Nicole Kidman
-- The Hours (movie_id = 19)
(19, 18), -- Nicole Kidman
-- Pretty Woman (movie_id = 20)
(20, 19), -- Julia Roberts
-- Erin Brockovich (movie_id = 21)
(21, 19), -- Julia Roberts
-- Ocean's Eleven (movie_id = 22)
(22, 21), -- George Clooney
(22, 22), -- Matt Damon
(22, 20), -- Brad Pitt
-- Fight Club (movie_id = 23)
(23, 20), -- Brad Pitt
-- Pulp Fiction (movie_id = 24)
(24, 36), -- Samuel L. Jackson
-- Mad Max: Fury Road (movie_id = 25)
(25, 37), -- Charlize Theron
-- Pirates of the Caribbean (movie_id = 26)
(26, 38), -- Johnny Depp
-- The King s Speech (movie_id = 27)
(27, 39), -- Helena Bonham Carter
-- Les Misérables (movie_id = 28)
(28, 44), -- Anne Hathaway
(28, 53), -- Hugh Jackman
-- There Will Be Blood (movie_id = 29)
(29, 40), -- Daniel Day-Lewis
-- Titanic (movie_id = 30)
(30, 41), -- Kate Winslet
-- Joker (movie_id = 31)
(31, 42), -- Joaquin Phoenix
-- Gladiator (movie_id = 32)
(32, 43), -- Russell Crowe
-- A Beautiful Mind (movie_id = 33)
(33, 43), -- Russell Crowe
-- The Pursuit of Happyness (movie_id = 34)
(34, 45), -- Will Smith
-- Mr. & Mrs. Smith (movie_id = 35)
(35, 46), -- Angelina Jolie
-- Taxi Driver (movie_id = 36)
(36, 47), -- Robert De Niro
-- Goodfellas (movie_id = 37)
(37, 47), -- Robert De Niro
-- Zero Dark Thirty (movie_id = 38)
(38, 48), -- Jessica Chastain
-- Gattaca (movie_id = 39)
(39, 49), -- Ethan Hawke
-- Harry Potter series (movie_id = 40)
(40, 50), -- Emma Watson
-- The Matrix (movie_id = 41)
(41, 51), -- Keanu Reeves
-- John Wick (movie_id = 42)
(42, 51), -- Keanu Reeves
-- Iron Man (movie_id = 43)
(43, 52), -- Robert Downey Jr.
-- Sherlock Holmes (movie_id = 44)
(44, 52), -- Robert Downey Jr.
-- Black Panther (movie_id = 45)
(45, 33), -- Chadwick Boseman
-- Room (movie_id = 46)
(46, 34), -- Brie Larson
-- Captain Marvel (movie_id = 47)
(47, 34), -- Brie Larson
-- The Impossible (movie_id = 48)
(48, 35); -- Tom Holland


INSERT INTO customers (name, email, phone_number) VALUES
('Michael Thompson', 'michael.thompson@example.com', '457-789-0123'),
('Sarah Parker', 'sarah.parker@example.com', '458-789-0124'),
('Olivia Jones', 'olivia.jones@example.com', '459-789-0125'),
('David Wilson', 'david.wilson@example.com', '460-789-0126'),
('Emma Johnson', 'emma.johnson@example.com', '461-789-0127'),
('Chris Green', 'chris.green@example.com', '462-789-0128'),
('Lisa White', 'lisa.white@example.com', '463-789-0129'),
('Ethan Brown', 'ethan.brown@example.com', '464-789-0130'),
('Sophia Taylor', 'sophia.taylor@example.com', '465-789-0131'),
('James Davis', 'james.davis@example.com', '466-789-0132'),
('Isabella Martinez', 'isabella.martinez@example.com', '467-789-0133'),
('Alexander Garcia', 'alexander.garcia@example.com', '468-789-0134'),
('Mia Rodriguez', 'mia.rodriguez@example.com', '469-789-0135'),
('William Hernandez', 'william.hernandez@example.com', '470-789-0136'),
('Ava Anderson', 'ava.anderson@example.com', '471-789-0137'),
('Jacob Lewis', 'jacob.lewis@example.com', '472-789-0138'),
('Charlotte Lee', 'charlotte.lee@example.com', '473-789-0139'),
('Benjamin Walker', 'benjamin.walker@example.com', '474-789-0140'),
('Mason Hall', 'mason.hall@example.com', '475-789-0141'),
('Ella Young', 'ella.young@example.com', '476-789-0142'),
('Lucas Allen', 'lucas.allen@example.com', '477-789-0143'),
('Amelia Wright', 'amelia.wright@example.com', '478-789-0144'),
('Elijah King', 'elijah.king@example.com', '479-789-0145'),
('Abigail Scott', 'abigail.scott@example.com', '480-789-0146'),
('Nathan Turner', 'nathan.turner@example.com', '481-789-0147');


INSERT INTO reviews (movie_id, customer_id, rating, comment) VALUES
(1, 15, 10.0, 'An epic portrayal of WWII. Spielberg’s direction and Hanks’ performance are outstanding.'),
(4, 11, 9.0, 'A harsh and visceral survival story with stunning cinematography and a powerful lead performance by DiCaprio.'),
(6, 13, 8.5, 'A thrilling tale of obsession and rivalry with brilliant twists and turns.'),
(8, 19, 9.5, 'Nolan masterfully captures the sheer chaos and terror of war in this tightly edited, immersive experience.'),
(13, 20, 10.0, 'A masterpiece of American cinema, perfectly capturing the corruption of power and the complexity of family loyalty.'),
(18, 6, 7.5, 'A dazzling spectacle of music and romance, though the style might not appeal to everyone.'),
(20, 7, 8.0, 'A charming Cinderella story for the modern age with memorable performances from Roberts and Gere.'),
(23, 2, 9.0, 'A dark and provocative exploration of consumerism and identity, with a shocking twist.'),
(25, 17, 9.5, 'A relentless post-apocalyptic action thriller that is visually spectacular and adrenaline-pumping.'),
(30, 1, 8.5, 'An iconic love story set against the tragic backdrop of the historic sinking, spectacularly produced.'),
(32, 5, 9.0, 'A gripping ancient epic with strong performances and impressive battle scenes.'),
(33, 12, 8.0, 'An inspiring story of genius and resilience, with a touching portrayal by Crowe.'),
(34, 4, 9.0, 'An emotionally powerful film that highlights the struggles and triumphs of chasing the American dream.'),
(38, 3, 8.5, 'A compelling and meticulously detailed account of the hunt for Osama bin Laden.'),
(41, 9, 10.0, 'A groundbreaking sci-fi action film that challenges perceptions of reality with its innovative visuals and deep philosophical questions.'),
(45, 14, 9.0, 'A culturally significant and visually stunning superhero film with a profound narrative.'),
(40, 16, 8.5, 'A magical and enchanting series that captures the wonder of the wizarding world and its adventures.'),
(43, 8, 8.5, 'A fun and fast-paced introduction to the Marvel Cinematic Universe with a charismatic performance by Downey Jr.'),
(48, 10, 9.0, 'An intense and emotional survival drama about a family caught in a devastating tsunami.'),
(27, 18, 9.0, 'A brilliant portrayal of King George VI’s struggle to overcome his stammer, led by an excellent cast.'),
(22, 20, 8.0, 'A stylish and witty heist movie with a star-studded ensemble cast.'),
(46, 15, 9.0, 'A deeply emotional and powerful exploration of love and survival, anchored by incredible performances.'),
(21, 19, 8.5, 'Roberts delivers a fiery performance in this inspiring true story of an underdog taking on a corporate giant.'),
(44, 13, 8.0, 'A clever and entertaining reimagining of the classic detective, with a standout performance by Downey Jr.'),
(13,2,4,'test_function1'),
(13,3,5,'test_function2'),
(13,4,7,'test_function3');

INSERT INTO buildings (name, location) VALUES
('Cinema Complex Main', '123 Movie Blvd, Movietown'),
('Cinema Complex East', '456 Cinema St, Eastside'),
('Downtown Cinema', '789 Downtown Ave, City Center');

INSERT INTO auditoriums (auditorium_id, format, type, seat_count, building_id) VALUES
-- Building 1 - Cinema Complex Main
('A1', '2D', 'Standard', 120, 1),
('A2', '3D', 'IMAX', 150, 1),
('A3', '2D', '4DX', 100, 1),
('A4', '3D', 'Standard', 150, 1),
('A5', '2D', 'IMAX', 200, 1),
('A6', '2D', 'Standard', 120, 1),
('A7', '3D', '4DX', 110, 1),
('A8', '2D', 'Standard', 180, 1),
('A9', '3D', 'IMAX', 160, 1),
('A10', '2D', '4DX', 140, 1),

-- Building 2 - Cinema Complex East
('B1', '2D', 'Standard', 120, 2),
('B2', '3D', 'IMAX', 150, 2),
('B3', '2D', '4DX', 100, 2),
('B4', '3D', 'Standard', 150, 2),
('B5', '2D', 'IMAX', 200, 2),
('B6', '2D', 'Standard', 120, 2),
('B7', '3D', '4DX', 110, 2),
('B8', '2D', 'Standard', 180, 2),
('B9', '3D', 'IMAX', 160, 2),
('B10', '2D', '4DX', 140, 2),

-- Building 3 - Downtown Cinema
('C1', '2D', 'Standard', 120, 3),
('C2', '3D', 'IMAX', 150, 3),
('C3', '2D', '4DX', 100, 3),
('C4', '3D', 'Standard', 150, 3),
('C5', '2D', 'IMAX', 200, 3);


INSERT INTO auditorium_movie (auditorium_id, movie_id) VALUES
-- Building 1 - Cinema Complex Main
('A1', 1), -- Saving Private Ryan
('A1', 2), -- Catch Me If You Can
('A2', 3), -- Minority Report
('A3', 4), -- The Revenant
('A4', 5), -- Philadelphia
('A5', 6), -- The Prestige
('A6', 7), -- The Dark Knight Rises
('A7', 8), -- Dunkirk
('A8', 9), -- Memento
('A9', 10), -- Insomnia
('A10', 11), -- Bram Stokers Dracula

-- Building 2 - Cinema Complex East
('B1', 12), -- Apocalypse Now
('B2', 13), -- The Godfather
('B3', 14), -- The Devil Wears Prada
('B4', 15), -- Sophies Choice
('B5', 16), -- Gravity
('B6', 17), -- The Blind Side
('B7', 18), -- Moulin Rouge!

-- Building 3 - Downtown Cinema
('C1', 19);


INSERT INTO auditorium_bookings (auditorium_id, occupancy_date, start_time, end_time) VALUES
-- Building 1 - Cinema Complex Main
('A1', '2024-05-05', '09:00:00', '11:00:00'),
('A1', '2024-05-05', '12:00:00', '14:00:00'),
('A1', '2024-05-06', '15:00:00', '17:00:00'),

('A2', '2024-05-06', '09:00:00', '11:00:00'),
('A2', '2024-05-06', '12:00:00', '14:00:00'),
('A2', '2024-05-07', '15:00:00', '17:00:00'),

('A3', '2024-05-07', '09:00:00', '11:00:00'),
('A3', '2024-05-07', '12:00:00', '14:00:00'),
('A3', '2024-05-08', '15:00:00', '17:00:00'),

('A4', '2024-05-08', '09:00:00', '11:00:00'),
('A4', '2024-05-08', '12:00:00', '14:00:00'),
('A4', '2024-05-09', '15:00:00', '17:00:00'),

('A5', '2024-05-09', '09:00:00', '11:00:00'),
('A5', '2024-05-09', '12:00:00', '14:00:00'),
('A5', '2024-05-10', '15:00:00', '17:00:00'),

('A6', '2024-05-10', '09:00:00', '11:00:00'),
('A6', '2024-05-10', '12:00:00', '14:00:00'),
('A6', '2024-05-11', '15:00:00', '17:00:00'),

('A7', '2024-05-11', '09:00:00', '11:00:00'),
('A7', '2024-05-11', '12:00:00', '14:00:00'),
('A7', '2024-05-12', '15:00:00', '17:00:00'),

('A8', '2024-05-12', '09:00:00', '11:00:00'),
('A8', '2024-05-12', '12:00:00', '14:00:00'),
('A8', '2024-05-13', '15:00:00', '17:00:00'),

('A9', '2024-05-13', '09:00:00', '11:00:00'),
('A9', '2024-05-13', '12:00:00', '14:00:00'),
('A9', '2024-05-14', '15:00:00', '17:00:00'),

('A10', '2024-05-14', '09:00:00', '11:00:00'),
('A10', '2024-05-14', '12:00:00', '14:00:00'),
('A10', '2024-05-15', '15:00:00', '17:00:00'),

-- Building 2 - Cinema Complex East
('B1', '2024-05-05', '09:00:00', '11:00:00'),
('B1', '2024-05-05', '12:00:00', '14:00:00'),
('B1', '2024-05-06', '15:00:00', '17:00:00'),

('B2', '2024-05-06', '09:00:00', '11:00:00'),
('B2', '2024-05-06', '12:00:00', '14:00:00'),
('B2', '2024-05-07', '15:00:00', '17:00:00'),

('B3', '2024-05-07', '09:00:00', '11:00:00'),
('B3', '2024-05-07', '12:00:00', '14:00:00'),
('B3', '2024-05-08', '15:00:00', '17:00:00'),

('B4', '2024-05-08', '09:00:00', '11:00:00'),
('B4', '2024-05-08', '12:00:00', '14:00:00'),
('B4', '2024-05-09', '15:00:00', '17:00:00'),

('B5', '2024-05-09', '09:00:00', '11:00:00'),
('B5', '2024-05-09', '12:00:00', '14:00:00'),
('B5', '2024-05-10', '15:00:00', '17:00:00'),

('B6', '2024-05-10', '09:00:00', '11:00:00'),
('B6', '2024-05-10', '12:00:00', '14:00:00'),
('B6', '2024-05-11', '15:00:00', '17:00:00'),

('B7', '2024-05-11', '09:00:00', '11:00:00'),
('B7', '2024-05-11', '12:00:00', '14:00:00'),
('B7', '2024-05-12', '15:00:00', '17:00:00'),

('B8', '2024-05-12', '09:00:00', '11:00:00'),
('B8', '2024-05-12', '12:00:00', '14:00:00'),
('B8', '2024-05-13', '15:00:00', '17:00:00'),

('B9', '2024-05-13', '09:00:00', '11:00:00'),
('B9', '2024-05-13', '12:00:00', '14:00:00'),
('B9', '2024-05-14', '15:00:00', '17:00:00'),

('B10', '2024-05-14', '09:00:00', '11:00:00'),
('B10', '2024-05-14', '12:00:00', '14:00:00'),
('B10', '2024-05-15', '15:00:00', '17:00:00'),

-- Building 3 - Downtown Cinema
('C1', '2024-05-05', '09:00:00', '11:00:00'),
('C1', '2024-05-05', '12:00:00', '14:00:00'),
('C1', '2024-05-06', '15:00:00', '17:00:00'),

('C2', '2024-05-06', '09:00:00', '11:00:00'),
('C2', '2024-05-06', '12:00:00', '14:00:00'),
('C2', '2024-05-07', '15:00:00', '17:00:00'),

('C3', '2024-05-07', '09:00:00', '11:00:00'),
('C3', '2024-05-07', '12:00:00', '14:00:00'),
('C3', '2024-05-08', '15:00:00', '17:00:00'),

('C4', '2024-05-08', '09:00:00', '11:00:00'),
('C4', '2024-05-08', '12:00:00', '14:00:00'),
('C4', '2024-05-09', '15:00:00', '17:00:00'),

('C5', '2024-05-09', '09:00:00', '11:00:00'),
('C5', '2024-05-09', '12:00:00', '14:00:00'),
('C5', '2024-05-10', '15:00:00', '17:00:00');


INSERT INTO tickets (auditorium_booking_id, customer_id, price) VALUES
(4, 5, 14.50),   -- Booking ID 4, Customer ID 5, Price $14.50
(5, 6, 16.00),   -- Booking ID 5, Customer ID 6, Price $16.00
(6, 7, 13.75),   -- Booking ID 6, Customer ID 7, Price $13.75
(7, 8, 17.25),   -- Booking ID 7, Customer ID 8, Price $17.25
(8, 9, 15.50),   -- Booking ID 8, Customer ID 9, Price $15.50
(9, 10, 12.00),  -- Booking ID 9, Customer ID 10, Price $12.00
(10, 11, 14.75), -- Booking ID 10, Customer ID 11, Price $14.75
(11, 12, 16.50), -- Booking ID 11, Customer ID 12, Price $16.50
(12, 13, 13.00), -- Booking ID 12, Customer ID 13, Price $13.00
(13, 14, 15.25), -- Booking ID 13, Customer ID 14, Price $15.25
(14, 15, 17.00), -- Booking ID 14, Customer ID 15, Price $17.00
(15, 16, 14.25), -- Booking ID 15, Customer ID 16, Price $14.25
(16, 17, 16.75), -- Booking ID 16, Customer ID 17, Price $16.75
(17, 18, 12.50), -- Booking ID 17, Customer ID 18, Price $12.50
(18, 19, 15.75), -- Booking ID 18, Customer ID 19, Price $15.75
(19, 20, 17.50), -- Booking ID 19, Customer ID 20, Price $17.50
(20, 21, 13.50), -- Booking ID 20, Customer ID 21, Price $13.50
(21, 22, 15.00), -- Booking ID 21, Customer ID 22, Price $15.00
(22, 23, 18.25), -- Booking ID 22, Customer ID 23, Price $18.25
(23, 24, 14.75); -- Booking ID 23, Customer ID 24, Price $14.75

################################################################################ 1 1 1 1 1 1 1

-- 1. Query: calculates the total number of reviews and the average rating for each director's movies, and lists directors with more than one movie.
-- requirements: joins two or more tables, includes group functions, uses alias
SELECT d.name AS Director_Name, COUNT(DISTINCT m.movie_id) AS Total_Movies, COUNT(r.review_id) AS Total_Reviews, AVG(r.rating) AS Average_Rating
FROM directors d
JOIN movie_directors md ON d.director_id = md.director_id
JOIN movies m ON md.movie_id = m.movie_id
JOIN reviews r ON m.movie_id = r.movie_id
GROUP BY d.name
HAVING COUNT(DISTINCT m.movie_id) > 1;

################################################################################ 2 2 2 2 2 2 2 
-- 2. Query: increase the seat count by 10% for all auditoriums showing movies directed by Christopher Nolan with an average rating above 7.5
-- requirements: delete/update, include arithmetic functions, one or more sub-query(es)
-- test before
SELECT * FROM auditoriums order by seat_count desc;
SET SQL_SAFE_UPDATES = 0;

UPDATE auditoriums a
JOIN auditorium_movie am ON a.auditorium_id = am.auditorium_id
JOIN movies m ON am.movie_id = m.movie_id
JOIN movie_directors md ON m.movie_id = md.movie_id
JOIN directors d ON md.director_id = d.director_id
SET a.seat_count = ROUND(a.seat_count * 1.10)
WHERE d.name = 'Christopher Nolan'
AND m.movie_id IN (
    SELECT r.movie_id
    FROM reviews r
    GROUP BY r.movie_id
    HAVING AVG(r.rating) > 7.5
);
SET SQL_SAFE_UPDATES = 1;
-- see after
SELECT * FROM auditoriums order by seat_count desc;

################################################################################ 3 3 3 3 3 3 3 3 
-- 3. Function: calculate the average rating for a given movie
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION calculate_average_rating(movieID INT) 
RETURNS DECIMAL(3,1)
BEGIN
    DECLARE avgRating DECIMAL(3,1);
    SELECT AVG(r.rating) INTO avgRating
    FROM reviews r
    WHERE r.movie_id = movieID;
    RETURN avgRating;
END $$
DELIMITER ;
SET GLOBAL log_bin_trust_function_creators = 0;


################################################################################ 4 4 4 4 4 4 4

-- 4. Trigger: update the seat count of the auditorium by decreasing it by 1 each time a new ticket is inserted into the tickets table.
DELIMITER $$
CREATE TRIGGER decrease_seat_count_on_ticket_purchase
AFTER INSERT ON tickets
FOR EACH ROW
BEGIN
    DECLARE audID VARCHAR(10);
    
    -- Find the auditorium ID associated with the new ticket purchase
    SELECT ab.auditorium_id INTO audID
    FROM auditorium_bookings ab
    WHERE ab.booking_id = NEW.auditorium_booking_id;
    
    -- Decrease the seat count of the corresponding auditorium by 1
    UPDATE auditoriums
    SET seat_count = seat_count - 1
    WHERE auditorium_id = audID;
END$$
DELIMITER $$

################################################################################ 5 5 5 5 5 5 5 5
-- 5. procedure: Retrieves movie titles along with the name of their respective directors and the list of actors who acted in each movie.
DELIMITER $$
CREATE PROCEDURE get_movies_with_directors_and_actors()
BEGIN
    SELECT m.title AS Movie_Title, 
           d.name AS Director_Name, 
           GROUP_CONCAT(a.name SEPARATOR ', ') AS Actor_Names
    FROM movies m
    JOIN movie_directors md ON m.movie_id = md.movie_id
    JOIN directors d ON md.director_id = d.director_id
    JOIN movie_actors ma ON m.movie_id = ma.movie_id
    JOIN actors a ON ma.actor_id = a.actor_id
    GROUP BY m.title, d.name;
END$$
DELIMITER $$

-- testing the function
SELECT calculate_average_rating(13) AS Average_Rating;

-- testing the trigger by inserting a new ticket
SELECT * FROM auditoriums WHERE auditorium_id = 'A1';
INSERT INTO tickets (auditorium_booking_id, customer_id, price) VALUES (1, 1, 12.50);
SELECT * FROM auditoriums WHERE auditorium_id = 'A1';

-- calling the procedure
CALL get_movies_with_directors_and_actors();