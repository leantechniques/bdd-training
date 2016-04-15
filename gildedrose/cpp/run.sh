gmock=`cd ../../lib/gmock-1.7.0/; pwd`
export GMOCK_HOME=$gmock

# Make gmock and gmock test
mkdir -p $GMOCK_HOME/build
cd $GMOCK_HOME/build
cmake ..
make all

# Make project
cd -
mkdir build
cd build
cmake ..
make all

# Run the tests
./testApp
