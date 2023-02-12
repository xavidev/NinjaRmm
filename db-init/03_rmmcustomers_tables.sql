USE rmmcustomers;
CREATE TABLE IF NOT EXISTS customer_devices (
    id       CHAR(36)     NOT NULL,
    system_name     VARCHAR(255) NOT NULL,
    device_type     VARCHAR(255) NOT NULL,
    device_services   JSON    NOT NULL,
    device_cost     NUMERIC,
    total_cost     NUMERIC,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
