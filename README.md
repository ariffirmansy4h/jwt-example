# jwt-example

>> EXAMPLE REQUEST AUTH
curl -v -X POST http://localhost:8080/login -d '{username:admin, password:admin}' --header Content-Type: application/json

>> EXAMPLE GET URL WITH AUTH
curl -v -X GET http://localhost:8080/ --header Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTQ5ODMxMDgwNH0.YPZ3xaeSRz0Tpwpots0ZBX-cnu8FQTXRj78Am_D3JEx70OV-xTHj2DwhKbB-c2rTESsCe1mnh-YBo56B4w4dnw
