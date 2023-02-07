USE rrm;
CREATE TABLE IF NOT EXISTS services (
    id       CHAR(36)     NOT NULL,
    name     VARCHAR(255) NOT NULL,
    service_costs   JSON    NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS service_costs (
    id       CHAR(36)     NOT NULL,
    service_id       CHAR(36)     NOT NULL,
    device_type     VARCHAR(255) NOT NULL,
    cost   DOUBLE    NOT NULL,
    PRIMARY KEY (id),
    KEY (service_id),
    FOREIGN KEY (service_id) REFERENCES services(id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
