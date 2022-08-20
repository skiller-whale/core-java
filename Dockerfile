FROM debian

RUN apt update
RUN apt -qq -y install curl wget unzip zip
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

# temporarily install go for sync script
RUN curl -L https://go.dev/dl/go1.19.linux-amd64.tar.gz | tar xz -C /usr/local
RUN ln -s /usr/local/go/bin/go /usr/local/bin/

RUN curl https://get.sdkman.io/ | bash

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install java 18.0.2-open && \
    yes | sdk install gradle && \
    rm -rf $HOME/.sdkman/archives/* && \
    rm -rf $HOME/.sdkman/tmp/*"

# Copy files for the sync script
#COPY SkillerWhaleSync.java /app/sync/
#WORKDIR /app/sync

# Copy files for the sync script
COPY _sync /app/sync
WORKDIR /app/sync
RUN go mod download
RUN go build sync.go

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && /app/sync/sync
