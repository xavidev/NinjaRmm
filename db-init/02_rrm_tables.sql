USE rrm;
CREATE TABLE IF NOT EXISTS services (
    id       CHAR(36)     NOT NULL,
    name     VARCHAR(255) NOT NULL,
    cost     DOUBLE,
    service_costs   JSON    NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS devices (
    id       CHAR(36)     NOT NULL,
    type     VARCHAR(255) NOT NULL,
    cost     DOUBLE,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


