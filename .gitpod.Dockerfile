FROM gitpod/workspace-full

USER gitpod

RUN bash -lc "gem install bundler"

RUN brew install kotlin 

RUN echo "PS1='\W \$ '" >> /home/gitpod/.bashrc \
    && git config --global pull.rebase false \
    && git config --global merge.conflictStyle diff3 \
    && git config --global init.defaultBranch main

WORKDIR /home/gitpod



