FROM debian:bookworm

RUN apt update && apt -qq -y install curl openjdk-17-jre
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

RUN curl -s -L https://github.com/skiller-whale/learnersync/releases/latest/download/SkillerWhaleSync.jar >SkillerWhaleSync.jar >/usr/local/bin/SkillerWhaleSync.jar

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && java -jar /usr/local/bin/SkillerWhaleSync.jar
