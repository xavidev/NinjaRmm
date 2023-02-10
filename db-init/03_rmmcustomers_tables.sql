USE rrmcustomers;
CREATE TABLE IF NOT EXISTS customer_devices (
    id       CHAR(36)     NOT NULL,
    deviceId       CHAR(36)     NOT NULL,
    customerId       CHAR(36)     NOT NULL,
    systemName     VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS customer_services (
    id       CHAR(36)     NOT NULL,
    deviceId       CHAR(36)     NOT NULL,
    deviceId       CHAR(36)     NOT NULL,
    customerId       CHAR(36)     NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS customer_services (
    id       CHAR(36)     NOT NULL,
    deviceId       CHAR(36)     NOT NULL,
    deviceId       CHAR(36)     NOT NULL,
    customerId       CHAR(36)     NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
