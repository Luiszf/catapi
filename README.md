# catapi
basic crud implementation in spring with image support
## data models

### Post

| content | string    |
|---|---|
| image  | File\blob |
| likes  | integer   |

## working endpoints

| Method | url | description |
|---|---|---|
| GET | /api/v1/posts | lists all posts |
| GET | /api/v1/posts/{id} | find post by id |
| POST | /api/v1/posts | insert a post in the database |
| DELETE | /api/v1/posts/{id} | remove a post from the database |
| GET | /api/v1/image/{id} | find a image by id |
| POST | /api/v1/image | insert a image/png in the database |  

## runnig in your machine

- install [docker compose](https://docs.docker.com/compose/install/)
- ``` git clone https://github.com/Luiszf/catapi/ ```
- ``` cd catapi ```
- ``` docker-compose up ```
- default root url ```127.0.0.1:8000/```
