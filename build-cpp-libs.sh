# Change to directory of this script
cd "$( dirname "${BASH_SOURCE[0]}" )"
gmock=`cd lib/gmock-1.7.0/; pwd`
export GMOCK_HOME=$gmock

# Make gmock
cd $GMOCK_HOME
mkdir mybuild
cd mybuild
cmake ..
make

# Make gtest
cd $GMOCK_HOME/gtest
mkdir mybuild
cd mybuild
cmake ..
make
