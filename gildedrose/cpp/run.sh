gmock=`cd ../../lib/gmock-1.7.0/; pwd`
export GMOCK_HOME=$gmock
cmake .
make all

./testApp
