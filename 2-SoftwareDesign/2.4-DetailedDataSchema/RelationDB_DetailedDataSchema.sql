CREATE TABLE User_n( -- опис користувача
  full_name VARCHAR(100), -- ПІБ користувача
  date_of_birth DATE, -- Дата народження користувача
  gender VARCHAR(50), -- Стать користувача
  email VARCHAR(100), -- email користувача
);

CREATE TABLE Request_light_condition( -- опис запиту на стан освіщення
  location_n VARCHAR(100), -- місце проведення вимірювань
  request_time DATE, -- час надсилання запиту
  request_status VARCHAR(50), -- статус запиту
  user_id INT,  -- номер користувача, який надсилає запит
  FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE Answer_on_request(
    measured_light_condition FLOAT, -- опис стану освіщення
    answer_time DATE, -- час відповіді
    answer_status VARCHAR(50), -- статус відповіді
    light_condition_id INT, -- номер запиту
    safeLight_bot_id INT, -- номер бота
    FOREIGN KEY (requestlight_condition_id) REFERENCES Request_light_condition(requestlight_condition_id),
    FOREIGN KEY (safeLight_bot_id) REFERENCES SafeLight_bot(safeLight_bot_id)
);

CREATE TABLE SafeLight_bot( -- опис бота
  safeLight_bot_id INT PRIMARY KEY, -- номер бота
  analyze_light FLOAT, -- аналізований рівень освітленності
  provide_recommendation VARCHAR(100), -- рекомендація 
  user_id INT,  -- номер користувача, взаємодіє з ботом,
  FOREIGN KEY (user_id) REFERENCES User_n(user_id)
);

ALTER TABLE User_n ADD (
    user_id INT PRIMARY KEY
);

ALTER TABLE Request_ait_level ADD (
    light_condition_id INT PRIMARY KEY
);

    -- Додавання нового стовпця до таблиці User_n
ALTER TABLE User_n 
  ADD mobile_phone CHAR(14);

 -- Додавання обмеження до стовпця
ALTER TABLE User_n 
  ADD CONSTRAINT mobile_format_check 
  CHECK (REGEXP_LIKE(mobile_phone, '^(\([0-9]{3}\))?[0-9]{3}-[0-9]{4}$'));

  ALTER TABLE User_n 
  ADD CONSTRAINT email_check 
  CHECK (REGEXP_LIKE(email, '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$'));


