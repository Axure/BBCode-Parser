cmake_minimum_required(VERSION 3.0)
project(BBCodeParser)

set(Boost_USE_STATIC_LIBS ON)
find_package(Boost 1.57.0 COMPONENTS log thread system REQUIRED)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES src/main/cpp/bbcode/BbCodeParser.cpp src/main/cpp/bbcode/BbCodeParser.h src/main/cpp/bbcode/BbCodeGenerator.cpp src/main/cpp/bbcode/BbCodeGenerator.h)

set(SOURCE_DIR src/main/cpp)

set(BBCODE_PARSER ${SOURCE_DIR}/bbcode/BbCodeParser.cpp ${SOURCE_DIR}/bbcode/BbCodeParser.h)
set(BBCODE_GENERATOR ${SOURCE_DIR}/bbcode/BbCodeGenerator.cpp ${SOURCE_DIR}/bbcode/BbCodeGenerator.h)

set(HTML_PARSER ${SOURCE_DIR}/html/HtmlParser.cpp ${SOURCE_DIR}/html/HtmlParser.h)
set(HTML_GENERATOR ${SOURCE_DIR}/html/HtmlGenerator.cpp ${SOURCE_DIR}/html/HtmlGenerator.h)


set(MARKDOWN_PARSER ${SOURCE_DIR}/markdown/MarkdownParser.cpp ${SOURCE_DIR}/markdown/MarkdownParser.h)
set(MARKDOWN_GENERATOR ${SOURCE_DIR}/markdown/MarkdownGenerator.cpp ${SOURCE_DIR}/markdown/MarkdownGenerator.h)

set(XML_PARSER ${SOURCE_DIR}/xml/XmlParser.cpp ${SOURCE_DIR}/xml/XmlParser.h)
set(XML_GENERATOR ${SOURCE_DIR}/xml/XmlGenerator.cpp ${SOURCE_DIR}/xml/XmlGenerator.h)


#add_executable(HtmlParser ${SOURCE_DIR}/)

add_executable(BbCodeParser ${BBCODE_PARSER})
add_executable(BbCodeGenerator ${BBCODE_GENERATOR})

add_executable(HtmlCodeParser ${HTML_PARSER})
add_executable(HtmlCodeGenerator ${HTML_GENERATOR})

add_executable(MarkdownCodeParser ${MARKDOWN_PARSER})
add_executable(MarkdownCodeGenerator ${MARKDOWN_GENERATOR})

add_executable(XmlCodeParser ${XML_PARSER})
add_executable(XmlCodeGenerator ${XML_GENERATOR})



add_executable(BBCodeParserTest src/test/cpp/BbCodeTest.cpp ${BBCODE_PARSER} ${BBCODE_GENERATOR})

target_link_libraries(BBCodeParserTest ${Boost_LIBRARIES})