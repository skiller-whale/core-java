FROM debian

RUN apt update
RUN apt -qq -y install curl wget unzip zip jq
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

RUN curl https://get.sdkman.io/ | bash

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install java 18.0.2-open && \
    yes | sdk install gradle && \
    rm -rf $HOME/.sdkman/archives/* && \
    rm -rf $HOME/.sdkman/tmp/*"

RUN curl -s -L `curl -s https://api.github.com/repos/skiller-whale/learnersync/releases/latest | jq -r -c '.assets[] | .browser_download_url' | grep ubuntu` >download.zip
RUN unzip -q download.zip SkillerWhaleSync -d /usr/local/bin
RUN chmod +x /usr/local/bin/SkillerWhaleSync

# Set the working directory to be the exercises dir (when sh is run)
WORKDIR /app/exercises
RUN ln -s /root/.ash_history /app/.command_history

# Clear the history on startup, and run the sync
CMD > /root/.ash_history && SkillerWhaleSync
