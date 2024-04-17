-- 1. Write a function that calculates the GDP per capita for a given country code. The GDP per capita is calculated as the Gross National Product (GNP) divided by the population of the country.
DELIMITER //
CREATE FUNCTION GDP_Per_Capita_Country(country_code CHAR(3))
RETURNS FLOAT 
DETERMINISTIC
BEGIN
  DECLARE gnp FLOAT;
  DECLARE population INT;
  SELECT GNP, Population INTO gnp, population
  FROM country
  WHERE Code = country_code;
  RETURN gnp / population;
END;
DELIMITER ;
-- 2. Write a function that returns the name of the capital city for a specified country code.
DELIMITER //
CREATE FUNCTION Capital_City_Name(country_code CHAR(3))
RETURNS CHAR(35)
DETERMINISTIC
BEGIN
  DECLARE capital_id INT;
  DECLARE capital_name CHAR(35);
  SELECT Capital INTO capital_id
  FROM country
  WHERE Code = country_code;
  SELECT Name INTO capital_name
  FROM city
  WHERE ID = capital_id;
  RETURN capital_name;
END;
DELIMITER;
-- 3. Write a function that returns the total surface area in a given continent
DELIMITER //
CREATE FUNCTION Total_Surface_Area_Continent(continent_name ENUM('Asia','Europe','North America','Africa','Oceania','Antarctica','South America'))
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
  DECLARE total_surface_area DECIMAL(10,2);
  
  SELECT SUM(SurfaceArea) INTO total_surface_area
  FROM country
  WHERE Continent = continent_name;
  
  RETURN total_surface_area;
END//
DELIMITER ;
-- 4. Write a function that sums up the population of all countries in a given government form.
DELIMITER //
CREATE FUNCTION Total_Population_Government_Form(government_form CHAR(45))
RETURNS INT 
DETERMINISTIC
BEGIN
  DECLARE total_population INT;
  SELECT SUM(Population) INTO total_population
  FROM country
  WHERE GovernmentForm = government_form;
  RETURN total_population;
END//
DELIMITER ;
-- 5. Write a function that returns the largest country in a given continent.
DELIMITER //
CREATE FUNCTION Largest_Country_Continent(continent_name ENUM('Asia','Europe','North America','Africa','Oceania','Antarctica','South America'))
RETURNS CHAR(52)
DETERMINISTIC
BEGIN
  DECLARE largest_country CHAR(52);
  SELECT Name INTO largest_country
  FROM country
  WHERE Continent = continent_name
  ORDER BY SurfaceArea DESC
  LIMIT 1;
  RETURN largest_country;
END//
DELIMITER ;
-- 6. Write a procedure that updates the population of a specific city. The procedure takes a city id and new population as parameters.
DELIMITER //
CREATE PROCEDURE Update_City_Population(city_id INT, new_population INT)
BEGIN
  UPDATE city
  SET Population = new_population
  WHERE ID = city_id;
END//
DELIMITER ;
-- 7
DELIMITER //
CREATE TRIGGER Update_Country_Population
AFTER UPDATE ON city
FOR EACH ROW
BEGIN
  DECLARE country_population INT;
  SELECT SUM(Population) INTO country_population
  FROM city
  WHERE CountryCode = NEW.CountryCode;
  UPDATE country
  SET Population = country_population
  WHERE Code = NEW.CountryCode;
END//
DELIMITER ;

-- 8. Call the previously written procedure to update a city’s population in Turkey.
CALL Update_City_Population(3359, 9000000);
-- 9. Write a trigger that increases the GNP of a country by 5% in the country table whenever a new city is added to that country in the city table.
DELIMITER //
CREATE TRIGGER Increase_GNP_After_City_Insert
AFTER INSERT ON city
FOR EACH ROW
BEGIN
  UPDATE country
  SET GNP = GNP * 1.05
  WHERE Code = NEW.CountryCode;
END//
DELIMITER ;
-- 10. Write a trigger that prevents the deletion of a country from the country table if there are still cities associated with it in the city table.
DELIMITER //
CREATE TRIGGER Prevent_Country_Deletion
BEFORE DELETE ON country
FOR EACH ROW
BEGIN
  DECLARE city_count INT;
  SELECT COUNT(*) INTO city_count
  FROM city
  WHERE CountryCode = OLD.Code;
  IF city_count > 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Cannot delete.';
  END IF;
END//
DELIMITER ;
