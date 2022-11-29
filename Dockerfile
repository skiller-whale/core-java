FROM debian:bookworm

RUN apt update && apt -qq -y install curl
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

RUN curl -s -L https://github.com/skiller-whale/learnersync/releases/latest/download/SkillerWhaleSync-linux-amd64 >/usr/local/bin/SkillerWhaleSync && chmod +x /usr/local/bin/SkillerWhaleSync
# in development: COPY SkillerWhaleSync-linux-amd64 /usr/local/bin/SkillerWhaleSync

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && SkillerWhaleSync
