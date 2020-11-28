# Third party service

This service provide function of getting a new voucher code for other banking or financial system.
### Installation

Run ```mvn clean package``` to build a jar file.


Run ```docker build -t nab/third-party .``` to build an image for this service

### Running service


Run ```docker run --name voucher-service-1 --hostname voucher-service-1 -a nab/third-party``` to create and start a new container with running instance of this service.

Run ```docker run --name {container_name} --hostname {host_name} -a nab/third-party``` several times to create more instances

Configure IP addresses of all instances into haproxy.cfg for load balancing and routing.
For example:

```
frontend http
  	bind *:80
  	mode http
  	use_backend api_servers if { path_beg /third-party/ }
  	default_backend api_servers

backend api_servers
   	balance roundrobin
   	server voucher-service-1 172.17.0.4:8081 check
   	server voucher-service-2 172.17.0.5:8081 check
```

Then run ``` sudo systemctl restart haproxy ``` to restart haproxy

### CURL
##### Getting voucher code
curl --request GET {hostname_of_haproxy}/third-party/api/v1/code?slow={true or false}&error={true or false}

1. slow: if this's true, a request will take a long time to receive the response.
2. error: if this's true, a request will be failed, otherwise it will be successful.

Example: curl --request GET "http://192.168.71.128/third-party/api/v1/code?slow=false&error=false"

