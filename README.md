# catapi
a api for a social network about cute animals

## working endpoints

| Method | url | description |
|---|---|---|
| GET | /api/v1/posts | lists all posts |
| GET | /api/v1/posts/{id} | find post by id |
| POST | /api/v1/posts | insert a post in the database |
| DELETE | /api/v1/posts/{id} | remove a post from the database |

## runnig in your machine

- install [docker compose](https://docs.docker.com/compose/install/)
- ``` git clone https://github.com/Luiszf/catapi/ ```
- ``` cd catapi ```
- ``` docker-compose up ``` 
