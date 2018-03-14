CREATE SCHEMA rugby;

CREATE TABLE rugby.EVENTS(
  ID         SERIAL          not null,
  EVENT_TYPE text        not null,
  EVENT      jsonb       not null,
  primary key (id)
);