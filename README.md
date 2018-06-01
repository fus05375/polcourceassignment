# Assignment

Assignment for PolSource internship

## Getting Started

To get you started you need to install dependencies, clone the repository, deploy and run the application with your favorite IDE.

### Prerequisites

To properly working you need to have: git client to clone the repositor, h2 database to store the data, maven to build the application and it is expected that you will use IDE to build and deploy :)


### Installing

1. Clone the repository using git:

    ```
    git clone https://github.com/fus05375/polcourceassignment.git
    ```

1. Use your favorite IDE to deploy and run the application. Particularly, for this project were used IntelliJ IDEA.

## API Endpoints
There are two main services, **notes** and **tags**

The routes for these are

http://localhost:8080

- /notes/all
- /tags/all

### Access to database

You can access database using

```
http://localhost:8080/h2
```


### List notes/tags
You can list all users notes/tags a GET request to ```/notes/all``` or ```/tags/all```

### Create note/tag
You can create an new note/tag making a POST request to ```/notes/create``` or ```/tags/create``` with the following parameters
```
{ "title": "New note", "content": "What a beautiful day " }
```

```
{ "title": "UrgentXXXXXXXXXXXXXX" }
```

### Delete note/tag
You can delete an existing note/tag making a DELETE request to  ```/notes/delete/{id}``` or ```/tags/delete/{id}``` 

### Update note
You can update an existing user making a PUT request to ```/notes/update/{id}``` with the following parameters
```
{ "title": "Update note", "content": "What a lovely day " }
```
### Set tag to notes
You can set tag for a specific note, making a PUT request to ```/notes/update/{id}/addTag/{id}```

### Remove tag from note
You can remove tag from a specific note, making a PUT request to ```/notes/update/{id}/delTag/{id}```



@author:  fus05375@gmail.com
