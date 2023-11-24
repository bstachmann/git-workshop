FROM gitpod/workspace-full

USER gitpod

RUN bash -lc "gem install bundler"

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 21-ms && \
    sdk default java 21-ms && \
    sdk install kotlin 1.9.20"
    
RUN echo "PS1='\W \$ '" >> /home/gitpod/.bashrc \
    && git config --global pull.rebase false \
    && git config --global merge.conflictStyle diff3 \
    && git config --global init.defaultBranch main \
    && git config --global protocol.file.allow always

WORKDIR /home/gitpod



