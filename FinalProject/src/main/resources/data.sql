INSERT INTO user (id, gender, name, note)
VALUES
    (1, 'UNKNOWN', 'hua', 'no smoke'),
    (2, 'UNKNOWN', 'jia', 'smoke please'),
    (3, 'UNKNOWN', 'irene', ''),
    (4, 'UNKNOWN', 'zijun', ''),
    (5, 'UNKNOWN', 'bruce', '');

INSERT INTO car (id, make, model, num_seats, num_luggage, color, license_plate)
VALUES
    (1, 'toyota', 'corolla', '4', '0', 'black', '9CVT417'),
    (2, 'nissan', 'sentra', '3', '2', 'blue', 'sese'),
    (3, 'tesla', 'model3', '2', '1', 'grey', 'huang');

INSERT INTO car_car_features (car_id, car_features)
VALUES
    (1, '0'),
    (1, '1'),
    (1, '2'),
    (1, '3'),
    (2, '1'),
    (2, '2'),
    (2, '3');

INSERT INTO driver (id, car_id, destination_address, arrival_time)
VALUES
    (2, 1, 'NEU', '2022-12-03T20:20:30'),
    (3, 2, 'NEU', '2022-12-03T10:20:30'),
    (5, 3, 'sanjose', '2022-12-03T10:20:30');

INSERT INTO passenger (id, num_of_people)
VALUES
    (1, 2),
    (4, 1);

INSERT INTO passenger_car_preferences (passenger_id, car_preferences)
VALUES
    (1, 'HAS_AC'),
    (1, 'PET_ALLOWED');

INSERT INTO schedule (id, passenger_id, driver_id, pickup_time, arrival_time, destination_address, pickup_address)
VALUES
    (1, 1, 2, '2022-12-03T09:20:30', '2022-12-03T10:20:30', 'NEU', 'sanjose'),
    (2, 4, 2, '2022-12-03T09:20:30', '2022-12-03T10:20:30', 'NEU', 'sanjose');
