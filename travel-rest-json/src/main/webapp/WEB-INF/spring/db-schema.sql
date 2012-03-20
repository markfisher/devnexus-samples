create table itineraries(
  id integer not null generated always as identity (start with 1, increment by 1) constraint itineraries_pk primary key,
  username varchar(100),
  startDate varchar(8),
  endDate varchar(8)
);

create table flight_reservations(
  itinerary_id integer NOT NULL,
  flight_number varchar(100),
  seat_number varchar(100)
);

create table hotel_reservations(
  itinerary_id integer not null,
  room_number varchar(100),
  hotel_name varchar(100)
);

create table car_reservations(
  itinerary_id integer not null,
  car_size varchar(100),
  rental_agency varchar(100)
);
