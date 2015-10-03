package info.axurez.pair;

import info.axurez.basic.RegexpParser

import scala.util.parsing.combinator.syntactical._;

class PairGrammar extends StandardTokenParsers  {
  type Pair = (String, String);

  lexical.delimiters ++= List(":", "=")
  lexical.reserved += ("value")

  def text: Parser[Pair] = stringLit ~ ":" ~ stringLit ^^ {
    case attribute ~ ":" ~ value => (attribute, value)
  }

  def doParse(input: String): Option[Pair] = {
    text(new lexical.Scanner(input)) match {
      case Success(pair, _) => return Option(pair)
      case Failure(message, _) => {
        println(message)
        return None
      }
      case Error(message, _) => {
        printf("Error: %s\n", message)
        return None
      }
    }
  }

  def printPair(pair: Pair): Unit = {
    printf("%s, %s\n", pair._1, pair._2)
  }
}

object PairParser extends PairGrammar {
  def main (args: Array[String]) {
    val a: String = readLine()
    printf("The input is %s\n", a)
    doParse(a) match {
      case pair: Some[Pair] => printPair(pair.get)
      case None => println("Error!")
      case _ => println("WTF?")
    }
  }

}