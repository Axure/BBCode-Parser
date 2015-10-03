package info.axurez.bbcode

import info.axurez.basic.RegexpParser

import scala.util.matching.Regex
import scala.util.parsing.combinator.syntactical._;
import scala.util.parsing.combinator._

sealed trait BbCodeNode
case class TextNode(val value: String) extends BbCodeNode
case class StructureNode(val name: String, val childNodes: Seq[BbCodeNode]) extends BbCodeNode

class BbCodeGrammar extends RegexpParser{

//  lexical.delimiters ++= List("[", "]", "[/")
//  lexical.reserved += ("b", "i", "s")

  lazy val node: Parser[BbCodeNode] = innerText | bbcode
  
  val whitespace: Parser[String] = (" " | "\t" | "\n").* ^^ {
    case a: List[String] => a.mkString("")
  }

//  val punctuation : Parser[String] = ("." | ",") ^^ {_.toString}
val punctuation : Parser[String] = "A"

//  val text: Parser[TextNode] = (whitespace | ident | punctuation).* ^^ {case a: List[String] => TextNode(a.mkString(""))}
  val innerText: Parser[TextNode] = """([^\[\]]+)""".r ^^ {
  a: String => TextNode(a)
}

  val ident: Parser[String] = """(\w+)""".r
//  val text: Parser[TextNode] = ident ^^ ( a => TextNode(a))

  val bbcodeStartTag: Parser[String] = "[" ~ ident ~ "]" ^^ {
    case "[" ~ tagName ~ "]" => tagName
  }

  def bbCodeEndTag(name: String): Parser[String] = "[/" ~ name ~ "]" ^^ {
    case "[/" ~ tagName ~ "]" => tagName
  }

  val bbcode: Parser[StructureNode] =
    bbcodeStartTag.flatMap {
      case (tagName) =>
        rep(node) <~ bbCodeEndTag(tagName) ^^ (children => StructureNode(tagName, children))
    }

//  def doParse(input: String): Option[BbCodeNode] {
//
//  }
}

object BbCodeParser extends BbCodeGrammar {
  def main (args: Array[String]) {
    val a: String = readLine()
    printf("The input is %s\n", a)

    parse(whitespace, a) match {
//      case Success(bbcode, _) => printBbCode(bbcode, 0)
      case Success(bbcode, _) => println("Ended")
      case Failure(message, _) => {
        println(message)
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
      }
    }
  }

  def printBbCode(bbCode: BbCodeNode, level: Int): Unit = {
    bbCode match {
      case node: TextNode => println(" " * level + node.value)
      case node: StructureNode => {
        println(" " * level + "Tag is: " + node.name)
        for (child <- node.childNodes) {
          printBbCode(child, level + 1)
        }
      }
    }
  }
}