FROM debian:bookworm

RUN apt update
RUN apt -qq -y install curl wget unzip zip jq openjdk-18-jdk
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

RUN curl -s -L `curl -s https://api.github.com/repos/skiller-whale/learnersync/releases/latest | jq -r -c '.assets[] | .browser_download_url' | grep .jar` >/usr/local/bin/SkillerWhaleSync.jar

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && java -jar /usr/local/bin/SkillerWhaleSync.jar
