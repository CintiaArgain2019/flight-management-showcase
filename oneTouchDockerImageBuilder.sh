#!/bin/bash
#############################################
# Script to build all required docker images.
#############################################

remove_fligh_images(){
    echo "Enter name of image to delete"
    IMAGE_TO_REMOVE='flight'
    echo "Removing: "$IMAGE_TO_REMOVE

    echo "Removing images " $IMAGE_TO_REMOVE
    docker images -a | grep "$IMAGE_TO_REMOVE" | awk '{print $3}' | xargs docker rmi -f

}

startContainers(){
#   docker-compose build
   docker-compose up -d
}

echo 'Deleting images...'
remove_fligh_images
mvn clean install -DskipTests
startContainers


