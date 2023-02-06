.PHONY: all
all: build

.PHONY: up
up:
	@docker-compose up -d

.PHONY: build
build:
	@./gradlew build --warning-mode all

.PHONY: run-tests
run-tests:
	@./gradlew test --warning-mode all

.PHONY: run-rmm-backend
run-rmm-backend:
	@./gradlew bootRun --args='rmm_backend server'

.PHONY: run-rmmcustomers-backend
run-rmmcustomers-backend:
	@./gradlew bootRun --args='rmmcustomers_backend server'

