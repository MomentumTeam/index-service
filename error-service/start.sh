ruuningFlag="0"

while true; do
    currenttime=$(date +%H:%M:%S)
    #start
    if [[ ("$currenttime" == "10:32:30"  &&  "$ruuningFlag" == "0") ]];
        then
        ruuningFlag="1"
        docker run -d --name lihi 530 #run the image
    fi
    #stop
    if [[ ("$currenttime" == "10:33:00"  &&  "$ruuningFlag" == "1") ]]; then
        ruuningFlag="0"
        docker stop lihi #stop the image
        docker logs lihi --tail 1000
        docker rm lihi #delete the image
    fi

doney
