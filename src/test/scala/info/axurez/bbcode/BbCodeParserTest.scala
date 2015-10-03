package info.axurez.bbcode

import info.axurez.bbcode.BbCodeParser._;

/**
 * Created by zhenghu on 2015-10-03.
 */
object BbCodeParserTest {
  def testWhiteSpace(input: String) {
    val a: String = input
    printf("The input is %s\n", a)
    parse(whitespace, a) match {
      //      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => printf("Whitespace Parse Ended, got %s.\n", bbcode)
      case Failure(message, _) => {
        println(message)
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def testText(input: String) {
    val a: String = input
    printf("The input is %s\n", a)
    parse(innerText ,a ) match {
      //      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => printf("Text Parse Ended, got %s.\n", bbcode.value)
      case Failure(message, _) => {
        println(message)
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def testPunctuation(input: String) {
    val a: String = input
    printf("The input is %s\n", a)
    parse(punctuation, a) match {
      //      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => printf("\"Punctuation Parse Ended, got %s.\n", bbcode)
      case Failure(message, _) => {
        println(message + "Fucked")
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def testBbStart(input: String) {
    val a: String = input
    printf("The input is %s\n", a)
    parse(bbcodeStartTag, a) match {
      //      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => {
        printf("Start Tag Parse Ended, got %s.\n", bbcode)
      }
      case Failure(message, _) => {
        println(message)
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def testBbEnd(input: String, tagName: String) {
    val a: String = input
    printf("The input is %s\n", a)
    parse(bbCodeEndTag(tagName), a) match {
      //      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => {
        printf("Start End Parse Ended, got %s.\n", bbcode)
      }
      case Failure(message, _) => {
        println(message)
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def testBbCode(input: String) {
    val a: String = input
    printf("The input is %s\n", a)
    parse(bbcode, a) match {
      //      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => {
        println("BbCode Parse Ended, got\n)")
        printBbCode(bbcode, 0)
      }
      case Failure(message, _) => {
        println(message)
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def main(args: Array[String]) {
    //    testWhiteSpace("   ")
    testPunctuation("A")
    testText("fdsfdsfdsfds")

    testBbStart("[s]")
    testBbEnd("[/s]", "s")
//    testBbStart("[s]but[/s]")
    testBbCode("[s]but[/s]")

  }
}
