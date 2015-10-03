package info.axurez.bbcode

import info.axurez.basic.RegexpParser

import scala.util.matching.Regex
import scala.util.parsing.combinator.syntactical._;
import scala.util.parsing.combinator._

sealed trait BbCodeNode
case class Text(value: String) extends BbCodeNode
case class Structure(name: String, childNodes: List[BbCodeNode]) extends BbCodeNode

class BbCodeStructure {

}

class BbCodeGrammar extends StandardTokenParsers {

  lexical.delimiters ++= List("[", "]", "[/")
  lexical.reserved += ("value")

  def whitespace: Parser[String] = (" " | "\t" | "\n").* ^^ {_.toString}

  def punctuation : Parser[String] = "." | "," | ":" | "(" | ")" | "\""

  def text: Parser[String] = (whitespace | ident | punctuation).* ^^{_.toString}

  def bbcodeStartTag: Parser[String] = "[" ~ ident ~ "]" ^^ {
    case "[" ~ tagName ~ "]" => tagName
  }

  def bbCodeEndTag: Parser[String] = "[/" ~ ident ~ "]" ^^ {
    case "[/" ~ tagName ~ "]" => tagName
  }

  def bbcode: Parser[BbCodeStructure] =
    bbcodeStartTag ~> (text | bbcode).* ~> bbCodeEndTag ^^ {
      case start ~ middle ~ end => {

      }
    }

  def parse(input: String): Option[BbCodeStructure] {

  }
}

object BbCodeParser extends BbCodeGrammar {
  def main (args: Array[String]) {

  }
}