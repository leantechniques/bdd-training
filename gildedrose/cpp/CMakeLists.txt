cmake_minimum_required(VERSION 2.8.4)
project(gildedrose)

include_directories($ENV{GMOCK_HOME}/include $ENV{GMOCK_HOME}/gtest/include)
link_directories($ENV{GMOCK_HOME}/mybuild $ENV{GMOCK_HOME}/gtest/mybuild)
add_definitions(-std=c++0x)
set(CMAKE_CXX_FLAGS "${CMAXE_CXX_FLAGS} -Wall")

include_directories(src)

set(sources
    src/GildedRose.cpp
    src/GildedRose.h
   )

set(testSources
    tests/main.cpp
    tests/GildedRoseUnitTests.cpp
   )

add_executable(testApp ${sources} ${testSources})
target_link_libraries(testApp pthread)
target_link_libraries(testApp gmock)
target_link_libraries(testApp gtest)
