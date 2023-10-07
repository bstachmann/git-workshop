sudo ln -s /usr/lib/git-core/git-subtree /usr/local/libexec/git-core/

#git config --global --add safe.directory /workspaces/git-workshop
git config --global pull.rebase false 
git config --global merge.conflictStyle diff3 
git config --global init.defaultBranch main  
git config --global protocol.file.allow always


echo "Build exercise files and progress server"
gradle clean 
gradle distuebungenMarkdown


echo "Run eweb server"
gradle build run &

echo run progress server
gradle progress &

echo "Build website & Webserver on 4000"
./run-website-build.sh
./run-server.sh &

echo "Übungen"
mkdir -p build/git-uebungen/aufgaben 
cd build/git-uebungen/aufgaben 
ls
