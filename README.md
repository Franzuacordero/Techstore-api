\## Docker Swarm



\### Inicializar el clúster

```powershell

docker swarm init

```



\### Construir la imagen

```powershell

docker build -t techstore-api:latest .

```



\### Desplegar servicios en Swarm

```powershell

docker stack deploy -c docker-compose.swarm.yml techstore

```



\### Ver servicios corriendo

```powershell

docker stack services techstore

```



\### Escalar el microservicio

```powershell

docker service scale techstore\_microservicio=3

```



\### Reducir réplicas

```powershell

docker service scale techstore\_microservicio=1

```

