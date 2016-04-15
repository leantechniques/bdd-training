gmock=`cd ../../lib/gmock-1.7.0/; pwd`
export GMOCK_HOME=$gmock

# Make gmock and gmock test
cd $GMOCK_HOME
cmake .
make all

# Make project
cd -
cmake .
make all

# Run the tests
./testApp
