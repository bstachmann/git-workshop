sudo ln -s /usr/lib/git-core/git-subtree /usr/local/libexec/git-core/
sudo ln -s /usr/bin/echo /usr/local/bin/say

sudo git config --system pull.rebase false 
sudo git config --system merge.conflictStyle diff3 
sudo git config --system init.defaultBranch main  
sudo git config --system protocol.file.allow always

mkdir -p _log


git submodule update --init revealjs

echo "Build website"
./run-website-build.sh 


echo "Run web server"
gradle run  &


echo run progress server
gradle progress &


echo "Build website & Webserver on 4000"
./run-website-build.sh 
./run-server.sh &
echo "Übungen"
mkdir -p build/git-uebungen/aufgaben 
cd build/git-uebungen/aufgaben 
ls
