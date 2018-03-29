CREATE DATABASE heroes_repository encoding='UTF8';

\c heroes_repository;

CREATE SCHEMA heroes_storage;

CREATE TABLE heroes_storage.ability (
  id SERIAL PRIMARY KEY,
  name CHARACTER VARYING (64) NOT NULL UNIQUE
);

CREATE TABLE heroes_storage.hero (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(64) NOT NULL UNIQUE,
  identity VARCHAR(128) NOT NULL UNIQUE,
  age INTEGER NOT NULL,
  gender CHARACTER VARYING (16) NOT NULL,
  ability_id INTEGER NOT NULL REFERENCES heroes_storage.ability (id)
);

INSERT INTO heroes_storage.ability (name)
VALUES
  ('Полёт'),
  ('Сверхсила'),
  ('Телепатия'),
  ('Невидимость'),
  ('Регенерация'),
  ('Управление стихией'),
  ('Сверхскорость'),
  ('Богатство');

INSERT INTO heroes_storage.hero (name, identity, age, gender, ability_id)
VALUES
  ('Супермэн', 'Кларк Кент', 40, 'MALE', (SELECT id FROM heroes_storage.ability WHERE name = 'Полёт')),
  ('Женщина-невидимка', 'Сьюзан Шторм', 30, 'FEMALE', (SELECT id FROM heroes_storage.ability WHERE name = 'Невидимость'));