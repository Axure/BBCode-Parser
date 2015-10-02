#define BOOST_TEST_MODULE BbCodeTest
#include <boost/test/included/unit_test.hpp>
#include <boost/log/trivial.hpp>

#include "../../../src/main/cpp/bbcode/BbCodeGenerator.h"
#include "../../../src/main/cpp/bbcode/BbCodeParser.h"

using namespace boost::unit_test;
namespace logging = boost::log;

using namespace axurez;

BOOST_AUTO_TEST_CASE( BbCodeTest )
/* Compare with void free_test_function() */
{
  BOOST_LOG_TRIVIAL(info) << "Start testing.";
  BOOST_CHECK_EQUAL( true, false /* test assertion */ );

  BbCodeParser testBbCodeParser = BbCodeParser();
  BOOST_LOG_TRIVIAL(info) << "BbCodeParser instance created.";

  BOOST_LOG_TRIVIAL(info) << "Test finisehd.";
}