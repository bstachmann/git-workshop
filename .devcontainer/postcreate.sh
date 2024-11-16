sudo ln -s /usr/lib/git-core/git-subtree /usr/local/libexec/git-core/

sudo git config --global pull.rebase false 
sudo git config --global merge.conflictStyle diff3 
sudo git config --global init.defaultBranch main  
sudo git config --global protocol.file.allow always

mkdir -p _log

echo "Build exercise files and progress server"
gradle clean distuebungenMarkdown 


echo "Run web server"
gradle run &


echo run progress server
gradle progress &


echo "Build website & Webserver on 4000"
./run-website-build.sh 
./run-server.sh &
echo "Übungen"
mkdir -p build/git-uebungen/aufgaben 
cd build/git-uebungen/aufgaben 
ls
