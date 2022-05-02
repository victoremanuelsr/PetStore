# Tema 06: PetStore - Docker 
## Steps to run the application:
### 1º - Build the project. 
### 2º -  Build docker image file
`docker image build -t your-name/image-name ./`
### 3º - Creating and running a container
`docker container run -it --publish 8080:8080 your-name/image-name`


##  Available services:

###  Add Pet

- Add a new pet, with Id, Name, Type, Breed and Age.

- Method: POST

- EX: http://localhost:8080/PetStore/pet?id=1&name=bob&type=dog&breed=pitbull&age=3

*- *Note: All attributes are mandatory, non-compliance will generate an error page.**

###  Remove Pet

- Remove the pet by Id.

- Method: Delete

- EX: http://localhost:8080/PetStore/pet?id=1

*- *Note: It is only possible to remove a pet that has been added. Otherwise, an error page will be generated.**

###  Search by Age

- Method: GET

- EX: http://localhost:8080/PetStore/pet?age=3

*- Note: It will generate a list of all pets of that age. If not, it will generate an empty list.*

###  Bathe the Pet

- with or without perfume

- With water or dry

- Method: POST

- EX: http://localhost:8080/PetStore/bath?id=1&perfume=false&with=DRY

*- Note: For bath with perfume, set true in the parameter.*

###  Haircut

- long or short cut

- Method: POST

- EX: http://localhost:8080/PetStore/haircut?id=1&type=LONG

###  Service history of a pet:

- Method: GET

- EX: http://localhost:8080/PetStore/historic?id=1

*- Note: If the pet has not done any service, it will generate an empty list.*

###  List of the 10 pets that spend the most in the Pet Store.

- Method: GET

- EX: http://localhost:8080/PetStore/top10

---
