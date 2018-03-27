DROP TABLE calculator_history IF EXISTS ;

CREATE TABLE calculator_history (
  id         INTEGER auto_increment PRIMARY KEY,
  value1 INTEGER,
  operation  VARCHAR(50),
  value2 INTEGER,
  result INTEGER
);