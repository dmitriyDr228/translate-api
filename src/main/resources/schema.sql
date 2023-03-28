CREATE TABLE Response(
                       ID BIGINT  PRIMARY KEY AUTO_INCREMENT,
                       translate_params VARCHAR(255),
                       text VARCHAR(255),
                       ip_address VARCHAR(255),
                       date VARCHAR(255)
);
CREATE TABLE Request(
                         ID BIGINT  PRIMARY KEY AUTO_INCREMENT,
                         language VARCHAR(255),
                         text VARCHAR(255)
);