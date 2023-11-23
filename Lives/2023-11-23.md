## Database
Utilizzare il database [[2023-11-23 - DB Airport|db aeroporto]]

## Query
### Query su singola tabella

1- Selezionare tutti i passeggeri (1000)
```sql
SELECT *
FROM passengers;
```

2- Selezionare tutti i nomi degli aeroporti, ordinati per nome (100)
```sql
SELECT *
FROM airports
ORDER BY name;
```

3- Selezionare tutti i passeggeri che hanno come cognome 'Bartell' (2)
```sql
SELECT *
FROM passengers
WHERE lastname LIKE 'Bartell';
```

4- Selezionare tutti i passeggeri minorenni (considerando solo l'anno di nascita) (117 - nel 2022)
```sql
# versione 1
SELECT * 
FROM passengers 
WHERE YEAR(NOW()) - YEAR(date_of_birth);

# versione 2
SELECT *, YEAR(NOW()) - YEAR(date_of_birth) AS 'age'
FROM passengers
HAVING age < 18;
```

5- Selezionare tutti gli aerei che hanno più di 200 posti (84)
```sql
SELECT *
FROM airplanes
WHERE seating_capacity > 200;
```

6- Selezionare tutti gli aerei che hanno un numero di posti compreso tra 350 e 700 (30)
```sql
# versione 1
SELECT *
FROM airplanes
WHERE seating_capacity BETWEEN 350 AND 700;

# versione 2
SELECT *
FROM airplanes
WHERE seating_capacity > 350
    AND seating_capacity < 700;
```

7- Selezionare tutti gli ID dei dipendenti che hanno lasciato almeno una compagnia aerea (8939)
```sql
SELECT DISTINCT employee_id
FROM airline_employee
WHERE layoff_date IS NOT NULL;
```

8- Selezionare tutti gli ID dei dipendenti che hanno lasciato almeno una compagnia aerea prima del 2006 (445)
```sql
SELECT DISTINCT employee_id
FROM airline_employee
WHERE layoff_date IS NOT NULL 
    AND YEAR(layoff_date) < 2006;
```

9- Selezionare tutti i passeggeri il cui nome inizia con 'Al' (26)
```sql
SELECT *
FROM passengers
WHERE name LIKE 'al%';
```

10- Selezionare tutti i passeggeri nati nel 1960 (11)
```sql
SELECT *
FROM passengers
WHERE YEAR(date_of_birth) = 1960;
```

#### Bonus

11- contare tutti gli aeroporti la cui città inizia per 'East' (7)
```sql
SELECT COUNT(*)
FROM airports
WHERE city LIKE 'east%';
```

12- Contare quanti voli sono partiti il 4 luglio 2019 (3)
```sql
SELECT COUNT(*)
FROM flights
WHERE DATE(departure_datetime) = '2019-07-04';
```

### Query con group by

1- Contare quanti lavori di manutenzione ha eseguito ogni impiegato (dell'impiegato vogliamo solo l'ID) (1136)
```sql
SELECT employee_id, COUNT(*) as 'numeroManutenzioni'
FROM employee_maintenance_work
GROUP BY employee_id;
```

2- Contare quante volte ogni impiegato ha lasciato una compagnia aerea (non mostrare quelli che non hanno mai lasciato; dell'impiegato vogliamo solo l'ID) (8939)
```sql
SELECT employee_id, COUNT(*)
FROM airline_employee
WHERE layoff_date IS NOT null
GROUP BY employee_id;
```

3- Contare per ogni volo il numero di passeggeri (del volo vogliamo solo l'ID) (1000)
```sql
SELECT flight_id, COUNT(*)
FROM flight_passenger
GROUP BY flight_id;
```

4- Ordinare gli aerei per numero di manutenzioni ricevute (da quello che ne ha di piu'; dell'aereo vogliamo solo l'ID) (100)
```sql
SELECT airplane_id, COUNT(*) as 'numeroManutenzioni'
FROM maintenance_works
GROUP BY airplane_id
ORDER BY numeroManutenzioni DESC;
```

5- Contare quanti passeggeri sono nati nello stesso anno (61)
```sql
SELECT YEAR(date_of_birth), COUNT(*)
FROM passengers
GROUP BY YEAR(date_of_birth);
```

6- Contare quanti voli ci sono stati ogni anno (tenendo conto della data di partenza) (11)
```sql
SELECT YEAR(departure_datetime), COUNT(*)
FROM flights
GROUP BY YEAR(departure_datetime);
```

#### Bonus

7- Per ogni manufacturer, trovare l'aereo con maggior numero di posti a sedere (8)
```sql
SELECT manufacturer, model, MAX(seating_capacity)
FROM airplanes
GROUP BY manufacturer;
```

8- Contare quante manutenzioni ha ricevuto ciascun aereo nel 2021 (dell'aereo vogliamo solo l'ID) (36)
```sql
SELECT airplane_id, COUNT(*)
FROM maintenance_works
WHERE YEAR(datetime) = 2021
GROUP BY airplane_id;
```

9- Selezionare gli impiegati che non hanno mai cambiato compagnia aerea per cui lavorano (1061)
```sql
SELECT employee_id, COUNT(*) as total_hirings
FROM airline_employee
GROUP BY employee_id
HAVING total_hirings = 1;
```

### Query con join

1- Selezionare tutti i passeggeri del volo 70021493-2 (85)
```sql
SELECT passengers.*
FROM flights
    JOIN flight_passenger
        ON flights.id = flight_passenger.flight_id
    JOIN passengers
        ON flight_passenger.passenger_id = passengers.id
WHERE flights.number LIKE '70021493-2';
```

2- Selezionare i voli presi da 'Shirley Stokes' (61)
```sql
SELECT flights.*
FROM passengers
    JOIN flight_passenger
        ON passengers.id = flight_passenger.passenger_id
    JOIN flights
        ON flight_passenger.flight_id = flights.id
WHERE name LIKE 'Shirley'
    AND lastname LIKE 'Stokes';
```

3- Selezionare tutti i passeggeri che hanno usato come documento 'Passport'(775)
```sql
SELECT DISTINCT passengers.*
FROM passengers
    JOIN document_type_passenger
        ON passengers.id = document_type_passenger.passenger_id
    JOIN document_types
        ON document_type_passenger.document_type_id = document_types.id
WHERE document_types.name LIKE 'passport';
```

4- Selezionare tutti i voli con i relativi passeggeri (65296)
```sql
SELECT flights.number, passengers.name, passengers.lastname
FROM flights
    JOIN flight_passenger 
        ON flights.id = flight_passenger.flight_id
    JOIN passengers
        ON flight_passenger.passenger_id = passengers.id;
```

5- Selezionare tutti i voli che partono da 'Charleneland' e arrivano a 'Mauricestad' (3)
```sql
SELECT *
FROM flights
    JOIN airports departure
        ON flights.departure_airport_id = departure.id
    JOIN airports arrival
        ON flights.arrival_airport_id = arrival.id
WHERE departure.city LIKE 'Charleneland'
    AND arrival.city LIKE 'Mauricestad';
```

6- Selezionare tutti gli id dei voli che hanno almeno un passeggero il cui cognome inizia con 'L' (966)
```sql
SELECT DISTINCT flight_passenger.flight_id
FROM flight_passenger
    JOIN passengers
        ON flight_passenger.passenger_id = passengers.id
WHERE passengers.lastname LIKE 'l%';
```

7- Selezionare i dati delle compagnie dove almeno un impiegato è stato licenziato (286)
```sql
SELECT DISTINCT airlines.*
FROM airlines
    JOIN airline_employee
        ON airlines.id = airline_employee.airline_id
WHERE airline_employee.layoff_date IS NOT NULL;
```

8- Selezionare tutti gli aerei che sono partiti almeno una volta dalla città di 'Domingochester' (12)
```sql
SELECT DISTINCT airplanes.*
FROM airplanes
    JOIN flights
        ON airplanes.id = flights.airplane_id
    JOIN airports
        ON flights.departure_airport_id = airports.id
WHERE airports.city LIKE 'Domingochester';
```

9- Selezionare i dati dei tecnici e gli aerei ai quali questi hanno fatto almeno un intervento di manutenzione (1502)
```sql
SELECT DISTINCT employees.name, employees.lastname, airplanes.model, airplanes.manufacturer, airplanes.seating_capacity
FROM airplanes
    JOIN maintenance_works
        ON airplanes.id = maintenance_works.airplane_id
    JOIN employee_maintenance_work
        ON maintenance_works.id = employee_maintenance_work.maintenance_work_id
    JOIN employees
        ON employee_maintenance_work.employee_id = employees.id;
```

10- Selezionare tutti i piloti che hanno viaggiato nel 2021 dall'aeroporto di 'Abshireland' (4)
```sql
SELECT employees.name, employees.lastname, employees.role_id
FROM flights
    JOIN airports
        ON flights.departure_airport_id = airports.id
    JOIN employee_flight
        ON flights.id = employee_flight.flight_id
    JOIN employees
        ON employee_flight.employee_id = employees.id
    JOIN roles
        ON employees.role_id = roles.id
WHERE airports.city LIKE 'Abshireland'
    AND YEAR(flights.departure_datetime) = 2021
    AND roles.name LIKE 'pilot';
```