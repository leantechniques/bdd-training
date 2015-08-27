gmock=`cd ../../lib/gmock-1.7.0/; pwd`
export GMOCK_HOME=$gmock

if [ -z $1 ]
  then
    echo "No arguments supplied"
    cmake .
  else
    echo "Build using generator" + $1
    cmake . -G "$1"
fi
make all

./testApp
