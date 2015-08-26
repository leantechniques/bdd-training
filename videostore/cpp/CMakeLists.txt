cmake_minimum_required(VERSION 2.8.4)
project(videostore)

include_directories($ENV{GMOCK_HOME}/include $ENV{GMOCK_HOME}/gtest/include)
link_directories($ENV{GMOCK_HOME}/mybuild $ENV{GMOCK_HOME}/gtest/mybuild)
add_definitions(-std=c++0x)
set(CMAKE_CXX_FLAGS "${CMAXE_CXX_FLAGS} -Wall")

include_directories(src)

set(sources
    src/main.cpp
    src/Customer.cpp
    src/Customer.h
    src/Movie.cpp
    src/Movie.h
    src/Rental.cpp
    src/Rental.h
    )

set(testSources
    tests/VideoStoreTest.cpp)

add_executable(test ${testSources} ${sources})
target_link_libraries(test pthread)
target_link_libraries(test gmock)
target_link_libraries(test gtest)
