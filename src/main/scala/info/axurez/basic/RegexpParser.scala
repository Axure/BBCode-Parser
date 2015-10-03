package info.axurez.basic

import scala.util.parsing.combinator.RegexParsers

trait RegexpParser extends RegexParsers {
  def text: Parser[String] = """[a-z\w]+""".r ^^ {_.toString}
}