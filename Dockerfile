FROM debian:bookworm
RUN apt update && apt -qq -y install ca-certificates

ARG name=SkillerWhaleSync
# updates from https://github.com/skiller-whale/learnersync/releases/ when you need them
ARG version=0.1.2

# RUN apt update && apt -qq -y install curl
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

ADD https://github.com/skiller-whale/learnersync/releases/download/v${version}/${name}-linux-amd64 /usr/local/bin/
ADD https://github.com/skiller-whale/learnersync/releases/download/v${version}/${name}-linux-arm64 /usr/local/bin/
# We can't set this very dynamically, but this will do until images are done
RUN printf "#!/bin/sh\nexec ${name}-linux-arm64 $* || exec ${name}-linux-amd64 $*\n" >/usr/local/bin/SkillerWhaleSync
# in development: COPY SkillerWhaleSync-linux-amd64 /usr/local/bin/SkillerWhaleSync
RUN chmod +x /usr/local/bin/*

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && SkillerWhaleSync
