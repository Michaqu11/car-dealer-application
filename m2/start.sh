nginx &
nohup java -jar /server/car.jar &
nohup java -jar /server/salon.jar &
nohup java -jar /server/gateway.jar &
tail -f /dev/null