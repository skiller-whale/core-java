FROM debian

RUN apt update
RUN apt -qq -y install curl wget unzip zip
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

RUN curl https://get.sdkman.io/ | bash

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install java 18.0.2-open && \
    yes | sdk install gradle && \
    rm -rf $HOME/.sdkman/archives/* && \
    rm -rf $HOME/.sdkman/tmp/*"

COPY _sync/ /app/_sync
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && cd /app/_sync && gradle build"

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && /root/.sdkman/candidates/java/current/bin/java -jar /app/_sync/build/libs/SkillerWhaleSync.jar
