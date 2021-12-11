# Vinoshipper Assignment
Here are the results of my take home assignment for vinoshipper. An effort was made to strictly follow the instructions. The template was used with minimal modification. 

## Notes
The java class LocalDate is used to provide ISO 8601 date parsing, and other methods are used as needed with other classes from java.time.* Only GET requests are used because other request types do not fit our use cases.

## Assumptioms

* People born on a leap day are of legal drinking age on the day following the leap day (Feb 29th -> March 1st)
* Default current system time/timezone is good enough
* This solution does not require production ready automated testing.
  * A production implementation should use dependency injection for stateful/impure functions like LocalDate.now(), should have integration tests with a full webserver and client requests, and should test error handling.
* Hours are calculated inclusive of the start day and the end day
* All Weekdays will be counted, no weekdays are considered holidays
* Each weekday contains 8 hours of work


## Running The Application
```bash
./gradlew bootRun
```

## Testing The Application
```bash
./gradlew test
```

## Sample curl commands

### Age Validation for someone born on March 25th 1990

```bash
curl http://localhost:8080/validate-age?birthday=1990-03-25
```

### Count Business Hours in December 2021

```bash
curl "http://localhost:8080/hours?start=2021-12-01&end=2021-12-31"
```

