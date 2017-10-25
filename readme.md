# Iata Api

This api contains 28k+ iata codes with basic information.

The Api endpoint are as follows : 

**ALL GET METHODS**

- /iata -> returns all the data in the api
- /iata/{id{ -> returns one iata by his id (JPA ID not iata code)
- /iata/name/{name} -> returns all the iatas matching name text (by airport name)
- /iata/code/{code} -> returns all the iatas matching code text (by iata code)

