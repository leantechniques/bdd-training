gmock=`cd ../../lib/gmock-1.7.0/; pwd`
export GMOCK_HOME=$gmock

# Clean gmock and gmock test
rm -rf $GMOCK_HOME/build/

rm -rf build/
